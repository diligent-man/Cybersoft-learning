DROP DATABASE IF EXISTS btJPA3Q3;

CREATE DATABASE btJPA3Q3;

USE btJPA3Q3;


CREATE TABLE categories
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE products
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    price       DECIMAL(10, 2),
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES categories (id)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


INSERT INTO categories(name)
VALUES ('confectionery'),
       ('beverage'),
       ('meat');


INSERT INTO products(name, price, category_id)
VALUES ('kẹo dừa', 10000, 1),
       ('kẹo đậu phộng', 12000, 1),
       ('kẹo me', 20000, 1),
       ('rượu táo', 200000, 2),
       ('rượu bầu đá', 200000, 2),
       ('rượu đế', 520000, 2),
       ('thịt đùi', 120000, 3),
       ('thịt thăn', 190000, 3);

# test
SELECT * FROM products;

DELETE FROM products WHERE id = 9;
ALTER TABLE products AUTO_INCREMENT = 8;