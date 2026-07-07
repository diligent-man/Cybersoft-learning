package com.ndt.spring.config.v2;

import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Map;


public interface JpaVendorAdapterFactory {
    static JpaVendorAdapter create(Map<String, String> props){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();

        // adapter.setShowSql(resolveBoolean(props, "hibernate.show-sql", false));
        // adapter.setGenerateDdl(resolveBoolean(props, "hibernate.generate-ddl", false));

        return adapter;
    }


    private static boolean resolveBoolean(Map<String, String> props, String key, boolean fallback) {
        String v = props.get(key);
        return v != null ? Boolean.parseBoolean(v) : fallback;
    }
}
