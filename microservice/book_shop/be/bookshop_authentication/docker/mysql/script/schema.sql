CREATE DATABASE bookstore;

USE bookstore;

DROP TABLE IF EXISTS users;

CREATE TABLE users(
    id VARCHAR(36) PRIMARY KEY,
    email VARCHAR(255),
    password TEXT,
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP(),
    updated_date DATETIME
);
