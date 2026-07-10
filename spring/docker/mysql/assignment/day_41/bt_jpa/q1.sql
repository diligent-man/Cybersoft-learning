DROP DATABASE IF EXISTS btJPA1Q1;

CREATE DATABASE btJPA1Q1;

USE btJPA1Q1;


CREATE TABLE student
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(200),
    email VARCHAR(50) UNIQUE,
    age  INT
);


INSERT INTO student(name, email, age)
VALUES ('Nguyen Van Mot', 'nv1@gmail.com', 15),
       ('Nguyen Van Hai', 'nv2@gmail.com', 16),
       ('Nguyen Van Ba', 'nv3@gmail.com', 17);


SELECT * FROM student;
