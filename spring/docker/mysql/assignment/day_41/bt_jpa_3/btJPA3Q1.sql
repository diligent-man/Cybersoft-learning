DROP DATABASE IF EXISTS btJPA3Q1;

CREATE DATABASE btJPA3Q1;

USE btJPA3Q1;

CREATE TABLE students
(
    id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(100)        NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    major VARCHAR(100)
);



INSERT INTO students(name, email, major)
VALUES ('Nguyen Van Mot', 'nv1@gmail.com', 'Artificial Intelligence'),
       ('Nguyen Van Hai', 'nv2@gmail.com', 'Software Engineer'),
       ('Nguyen Van Ba', 'nv3@gmail.com', 'Embedded Engineer');
