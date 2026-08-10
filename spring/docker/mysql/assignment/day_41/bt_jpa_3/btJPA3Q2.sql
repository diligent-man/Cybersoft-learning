DROP DATABASE IF EXISTS btJPA3Q2;

CREATE DATABASE btJPA3Q2;

USE btJPA3Q2;

# as: accent-sensitive
# cs: case sensitive
CREATE TABLE product
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(200)   NOT NULL UNIQUE COLLATE utf8mb4_0900_as_cs,
    price       DECIMAL(10, 2) NOT NULL,
    description TEXT
);


INSERT INTO product(name, price)
VALUES ('mouse', 1000000.5),
       ('mouse logitech', 1000000.5),
       ('mouse razer', 1000000.5),
       ('new mouse', 1000000.5),
       ('nEw mouse', 1000000.5),
       ('New mouse', 1000000.5),
       ('keyboard', 1500000.5),
       ('laptop', 2000000.5),
       ('headphone', 2500000.5);

# test
SHOW FULL COLUMNS FROM product;

SELECT *
FROM product;
