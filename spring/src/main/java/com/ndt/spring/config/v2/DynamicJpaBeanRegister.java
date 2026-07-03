package com.ndt.spring.config.v2;

import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Map;


@RequiredArgsConstructor
public class DynamicJpaBeanRegister implements BeanDefinitionRegistryPostProcessor {
    private final ConfigurableEnvironment environment;


    @Override
    public void postProcessBeanDefinitionRegistry(@NonNull BeanDefinitionRegistry registry) {
        Bindable<Map<String, DynamicDataSourceProperties.DbConfig>> bindable =
            Bindable.of(ResolvableType.forClassWithGenerics(
                Map.class, String.class, DynamicDataSourceProperties.DbConfig.class));


        // bind spring.datasources.* the same way DynamicDataSourceProperties does
        Map<String, DynamicDataSourceProperties.DbConfig> datasources =
            Binder.get(environment)
                .bind("spring.datasources", bindable)
                .orElse(Map.of());

        datasources.forEach((key, rawConfig) -> {
            DynamicDataSourceProperties.DbConfig config = bindConfig(key);

            String dsBeanName = key + "DataSource";
            String emfBeanName = key + "EntityManagerFactory";
            String tmBeanName = key + "TransactionManager";

            // 1. DataSource bean
            registerDataSourceBean(registry, dsBeanName, config);

            // 2. EntityManagerFactory bean, scanning the matching entity package
            registerEmfBean(registry, emfBeanName, dsBeanName, key);

            // 3. TransactionManager bean
            registerTxManagerBean(registry, tmBeanName, emfBeanName);
        });
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
        String key
    ) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder
            .genericBeanDefinition(LocalContainerEntityManagerFactoryBean.class);

        builder.addPropertyReference("dataSource", dsBeanName);
        builder.addPropertyValue("packagesToScan", packageForKey(key));
        builder.addPropertyValue("persistenceUnitName", key);

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        builder.addPropertyValue("jpaVendorAdapter", vendorAdapter);

        registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
    }


    private void registerTxManagerBean(BeanDefinitionRegistry registry, String beanName, String emfBeanName) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(JpaTransactionManager.class);
        builder.addPropertyReference("entityManagerFactory", emfBeanName);
        registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
    }


    // convention: key "bt-jpa1-q1" -> package "...entity.bt_jpa_1.q1"
    private String packageForKey(String key) {
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


    @Override
    public void postProcessBeanFactory(org.springframework.beans.factory.config.@NonNull ConfigurableListableBeanFactory beanFactory) {
        // no-op, required by interface
    }
}