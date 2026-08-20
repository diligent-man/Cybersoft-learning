package com.ndt.spring.config.v2;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;


import lombok.RequiredArgsConstructor;

import org.jspecify.annotations.NonNull;

import com.zaxxer.hikari.HikariDataSource;


import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.bind.Bindable;

import org.springframework.core.ResolvableType;
import org.springframework.core.env.ConfigurableEnvironment;

import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;


@RequiredArgsConstructor
public class DynamicJpaBeanRegister implements BeanDefinitionRegistryPostProcessor {
    private final ConfigurableEnvironment environment;


    @Override
    public void postProcessBeanDefinitionRegistry(@NonNull BeanDefinitionRegistry registry) {
        Bindable<Map<String, DynamicDataSourceProperties.DbConfig>> bindable = Bindable.of(
            ResolvableType.forClassWithGenerics(
                Map.class,
                String.class,
                DynamicDataSourceProperties.DbConfig.class
            )
        );


        // bind spring.datasources.* the same way DynamicDataSourceProperties does
        Map<String, DynamicDataSourceProperties.DbConfig> datasources =
            Binder.get(environment)
                .bind("spring.datasources", bindable)
                .orElse(Map.of());

        datasources.forEach((key, rawConfig) -> {
            String emfBeanName = key + "EntityManagerFactory";
            String tmBeanName = key + "TransactionManager";

            registerDataSourceBean(registry, key, rawConfig);
            registerEmfBean(registry, emfBeanName, key, key, rawConfig);
            registerTxManagerBean(registry, tmBeanName, emfBeanName);
        });

        // auto route bean for @Transactional of Spring
        registerRoutingTransactionManager(registry, datasources.keySet());
    }


    private DynamicDataSourceProperties.DbConfig bindConfig(String key) {
        return Binder.get(environment)
            .bind("spring.datasources." + key, DynamicDataSourceProperties.DbConfig.class)
            .orElseThrow(() -> new RuntimeException("DataSource not found: " + key));
    }


    private void registerDataSourceBean(
        BeanDefinitionRegistry registry,
        String beanName,
        DynamicDataSourceProperties.DbConfig config
    ) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(HikariDataSource.class);
        builder.addPropertyValue("jdbcUrl", config.getUrl());
        builder.addPropertyValue("username", config.getUsername());
        builder.addPropertyValue("password", config.getPassword());
        registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
    }


    private void registerEmfBean(
        BeanDefinitionRegistry registry,
        String beanName,
        String dsBeanName,
        String key,
        DynamicDataSourceProperties.DbConfig config
    ) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder
            .genericBeanDefinition(LocalContainerEntityManagerFactoryBean.class);

        builder.addPropertyReference("dataSource", dsBeanName);
        builder.addPropertyValue("packagesToScan", packageForKey(key));
        builder.addPropertyValue("persistenceUnitName", key);

        // TODO: check jpa & hibernate for show-sql (currently JPA is run twice due to autoconfigure class)
        JpaVendorAdapter vendorAdapter = HibernateVendorAdapterFactory.create(buildJpaProperties(config));
        builder.addPropertyValue("jpaVendorAdapter", vendorAdapter);
        // builder.addPropertyValue("jpaPropertyMap", buildJpaProperties(config));
        registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
    }


    private void registerTxManagerBean(BeanDefinitionRegistry registry, String txBeanName, String emfBeanName) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(JpaTransactionManager.class);
        builder.addPropertyReference("entityManagerFactory", emfBeanName);
        registry.registerBeanDefinition(txBeanName, builder.getBeanDefinition());
    }


    private void registerRoutingTransactionManager(BeanDefinitionRegistry registry, Set<String> keys) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(RoutingTransactionManager.class);

        // ManagedMap để Spring tự resolve các reference lúc container khởi tạo
        ManagedMap<String, RuntimeBeanReference> managerRefs = new ManagedMap<>();

        for (String key : keys) {
            String txBeanName = key + "TransactionManager";
            managerRefs.put(txBeanName, new RuntimeBeanReference(txBeanName));
        }

        builder.addConstructorArgValue(managerRefs);

        // đặt tên "transactionManager" => Spring sẽ dùng bean này làm mặc định cho @Transactional không tham số
        registry.registerBeanDefinition("txManager", builder.getBeanDefinition());
    }


    private Map<String, String> buildJpaProperties(DynamicDataSourceProperties.DbConfig config) {
        Map<String, String> props = new HashMap<>(DefaultHibernateProperties.get());
        props.putAll(normalizeJpaKeys(config.getJpa()));
        return props;
    }


    private String packageForKey(String key) {
        // convention: key "bt-jpa1-q1" -> package "...entity.bt_jpa_1.q1"
        String[] keyParts = key.split("-");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < keyParts.length; i++) {
            stringBuilder.append(keyParts[i]);

            if (i < keyParts.length - 1)
                stringBuilder.append(i < keyParts.length - 2 ? "_" : ".");
        }

        // customize this mapping to fit your actual package layout
        return "com.ndt.spring.assignment.day_41.entity." + stringBuilder;
    }


    private Map<String, String> normalizeJpaKeys(Map<String, String> raw) {
        Map<String, String> normalized = new HashMap<>();
        raw.forEach((rawKey, value) -> {
            String key = rawKey;
            if (key.startsWith("properties.")) key = key.substring("properties.".length());
            if (!key.startsWith("hibernate.")) key = "hibernate." + key;
            key = key.replace('-', '_');
            normalized.put(key, value);
        });
        return normalized;
    }


    @Override
    public void postProcessBeanFactory(org.springframework.beans.factory.config.@NonNull ConfigurableListableBeanFactory beanFactory) {
        // no-op, required by interface
    }
}
