DROP DATABASE IF EXISTS btJPA2Q1;

CREATE DATABASE btJPA2Q1;

USE btJPA2Q1;


CREATE TABLE student
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(200) NOT NULL,
    email VARCHAR(50)  NOT NULL UNIQUE
);


INSERT INTO student(name, email)
VALUES ('Nguyen Van Mot', 'nv1@gmail.com'),
       ('Nguyen Van Hai', 'nv2@gmail.com'),
       ('Nguyen Van Ba', 'nv3@gmail.com');

# test
SELECT * FROM student;

# run after run API
DELETE
FROM student
WHERE id = 4;

ALTER TABLE student AUTO_INCREMENT = 3;


