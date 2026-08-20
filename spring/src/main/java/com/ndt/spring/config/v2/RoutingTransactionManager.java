package com.ndt.spring.config.v2;

import java.util.Map;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.jspecify.annotations.NonNull;


import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.PlatformTransactionManager;

// TODO: check working of this class later
public class RoutingTransactionManager implements PlatformTransactionManager {
    private final Map<String, PlatformTransactionManager> managers;


    public RoutingTransactionManager(Map<String, PlatformTransactionManager> managers) {
        this.managers = managers;
    }


    private PlatformTransactionManager resolve() {
        DatabaseType type = DataSourceContextHolder.get();

        if (type == null) {
            throw new IllegalStateException("No database was set from DataSourceContextHolder");
        }

        // convention: enum JPA1Q3 -> bean "bt-jpa1-q1-TransactionManager"
        String key = toBeanKey(type.name());

        PlatformTransactionManager tm = managers.get(key);
        if (tm == null) {
            throw new IllegalStateException("Not found corresponding TransactionManager for: " + key);
        }
        return tm;
    }


    @Override
    @NonNull
    public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
        return resolve().getTransaction(definition);
    }


    @Override
    public void commit(@NonNull TransactionStatus status) throws TransactionException {
        resolve().commit(status);
    }


    @Override
    public void rollback(@NonNull TransactionStatus status) throws TransactionException {
        resolve().rollback(status);
    }


    private String toBeanKey(String enumName) {
        // "JPA1Q3" -> "bt-jpa1-q3TransactionManager"
        Matcher m = Pattern.compile("JPA(\\d+)Q(\\d+)").matcher(enumName);
        if (m.matches()) {
            return "bt-jpa" + m.group(1) + "-q" + m.group(2) + "TransactionManager";
        }
        throw new IllegalStateException("Không parse được enum: " + enumName);
    }
}
