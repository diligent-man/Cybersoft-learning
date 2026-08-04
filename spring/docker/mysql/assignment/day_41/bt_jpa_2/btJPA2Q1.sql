DROP DATABASE IF EXISTS btJPA2Q1;

CREATE DATABASE btJPA2Q1;

USE btJPA2Q1;


CREATE TABLE student
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(200),
    email VARCHAR(50) UNIQUE
);


INSERT INTO student(name, email)
VALUES ('Nguyen Van Mot', 'nv1@gmail.com'),
       ('Nguyen Van Hai', 'nv2@gmail.com'),
       ('Nguyen Van Ba', 'nv3@gmail.com');
