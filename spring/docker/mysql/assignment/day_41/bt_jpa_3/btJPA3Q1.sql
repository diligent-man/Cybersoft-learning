DROP DATABASE IF EXISTS btJPA3Q1;

CREATE DATABASE btJPA3Q1;

USE btJPA3Q1;

CREATE TABLE students
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    major VARCHAR(100) NOT NULL
);



INSERT INTO students(name, email, major)
VALUES ('Nguyen Van Mot', 'nv1@gmail.com', 'Artificial Intelligence'),
       ('Nguyen Van Hai', 'nv2@gmail.com', 'Software Engineer'),
       ('Nguyen Van Ba', 'nv3@gmail.com', 'Embedded Engineer');

# test
SELECT * FROM students;
