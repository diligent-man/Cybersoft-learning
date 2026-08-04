DROP DATABASE IF EXISTS btJPA2Q9;

CREATE DATABASE btJPA2Q9;

USE btJPA2Q9;


CREATE TABLE customer
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    phone VARCHAR(11)  NOT NULL UNIQUE
);



INSERT INTO customer(name, email, phone)
VALUES ('Nguyen Van Mot', 'nv1@gmail.com', '0931469123'),
       ('Nguyen Van Hai','nv2@gmail.com', '0931469124'),
       ('Nguyen Van Ba','nv3@gmail.com', '0931469125');
