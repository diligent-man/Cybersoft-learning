CREATE DATABASE bookstore;

DELETE TABLE IF EXISTS users;

USE bookstore;

CREATE TABLE users(
    id VARCHAR(36) PRIMARY KEY,
    email VARCHAR(255),
    password TEXT,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP(),
    update_date DATETIME
)
