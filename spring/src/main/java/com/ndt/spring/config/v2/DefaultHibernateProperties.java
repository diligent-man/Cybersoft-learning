package com.ndt.spring.config.v2;

import java.util.Map;
import java.util.LinkedHashMap;


public final class DefaultHibernateProperties {
    private DefaultHibernateProperties() {
    }


    public static Map<String, String> get() {
        Map<String, String> defaults = new LinkedHashMap<>();
        defaults.put("hibernate.hbm2ddl.auto", "none");
        defaults.put("hibernate.show_sql", "true");
        defaults.put("hibernate.format_sql", "true");
        defaults.put("hibernate.highlight_sql", "true");
        defaults.put("hibernate.jdbc.batch_size", "20");
        defaults.put("hibernate.connection.provider_disables_autocommit", "true");
        return defaults;
    }
}
