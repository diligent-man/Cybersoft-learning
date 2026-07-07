package com.ndt.spring.config.v2;

import org.springframework.orm.jpa.JpaVendorAdapter;

import java.util.Map;


public class HibernateVendorAdapterFactory implements JpaVendorAdapterFactory {
    private HibernateVendorAdapterFactory() {
        /* This utility class should not be instantiated */
    }

    public static JpaVendorAdapter create(Map<String, String> props) {
        return JpaVendorAdapterFactory.create(props);
    }
}