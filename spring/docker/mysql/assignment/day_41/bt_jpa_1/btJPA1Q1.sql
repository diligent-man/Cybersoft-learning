DROP DATABASE IF EXISTS btJPA1Q1;

CREATE DATABASE btJPA1Q1;

USE btJPA1Q1;

CREATE TABLE student
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(200) NOT NULL,
    email VARCHAR(50)  NOT NULL UNIQUE,
    age   INT          NOT NULL CHECK ( age BETWEEN 1 AND 99)
);


INSERT INTO student(name, email, age)
VALUES ('Nguyen Van Mot', 'nv1@gmail.com', 15),
       ('Nguyen Van Hai', 'nv2@gmail.com', 16),
       ('Nguyen Van Ba', 'nv3@gmail.com', 99);

# test
SELECT *
FROM student;
