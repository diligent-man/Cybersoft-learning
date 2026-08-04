DROP DATABASE IF EXISTS btJPA2Q4;

CREATE DATABASE btJPA2Q4;

USE btJPA2Q4;


CREATE TABLE category
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL
);


CREATE TABLE product
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(200)   NOT NULL,
    price       DECIMAL(10, 2) NOT NULL,
    category_id INT
);

ALTER TABLE product
    ADD CONSTRAINT FK_category_id_product FOREIGN KEY (category_id) REFERENCES category (id);

INSERT INTO category(name)
VALUES ('confectionery'),
       ('beverage'),
       ('meat');

INSERT INTO product(name, price, category_id)
VALUES ('kẹo dừa', 10000, 1),
       ('kẹo đậu phộng', 12000, 1),
       ('kẹo me', 20000, 1),
       ('rượu táo', 200000, 2),
       ('rượu bầu đá', 200000, 2),
       ('rượu đế', 520000, 2),
       ('thịt đùi', 120000, 3),
       ('thịt thăn', 190000, 3);
