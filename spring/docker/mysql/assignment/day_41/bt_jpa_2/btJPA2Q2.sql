DROP DATABASE IF EXISTS btJPA2Q2;

CREATE DATABASE btJPA2Q2;

USE btJPA2Q2;


CREATE TABLE product
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(200) NOT NULL ,
    price       DECIMAL(10, 2) NOT NULL,
    description TEXT
);


INSERT INTO product(name, price)
VALUES ('mouse', 1000000.5),
       ('keyboard', 1500000.5),
       ('laptop', 2000000.5),
       ('headphone', 2500000.5);
