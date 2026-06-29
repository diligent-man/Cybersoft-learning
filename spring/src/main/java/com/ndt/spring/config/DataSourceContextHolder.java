package com.ndt.spring.config;


public final class DataSourceContextHolder {

    private static final ThreadLocal<DatabaseType> CONTEXT = new ThreadLocal<>();


    private DataSourceContextHolder() {
    }


    public static void set(DatabaseType key) {
        CONTEXT.set(key);
    }


    public static DatabaseType get() {
        return CONTEXT.get();
    }


    public static void clear() {
        CONTEXT.remove();
    }
}