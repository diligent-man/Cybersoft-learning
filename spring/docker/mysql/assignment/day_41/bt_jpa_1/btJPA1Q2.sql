DROP DATABASE IF EXISTS btJPA1Q2;

CREATE DATABASE btJPA1Q2;

USE btJPA1Q2;


CREATE TABLE student
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(200) NOT NULL,
    email VARCHAR(50)  NOT NULL UNIQUE,
    age   INT          NOT NULL CHECK ( age BETWEEN 1 AND 99)
);

CREATE TABLE course
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    title    VARCHAR(200) NOT NULL,
    duration DECIMAL(2, 1)          NOT NULL COMMENT 'thời lượng khóa học, tính theo giờ'
);


INSERT INTO student(name, email, age)
VALUES ('Nguyen Van Mot', 'nv1@gmail.com', 15),
       ('Nguyen Van Hai', 'nv2@gmail.com', 16),
       ('Nguyen Van Ba', 'nv3@gmail.com', 99);

INSERT INTO course(title, duration)
VALUES ('Python programming', 1),
       ('Java programming', 1.5),
       ('Ruby programming', 2),
       ('C++ programming', 2.5),
       ('C programming', 3),
       ('Rust programming', 3.5),
       ('Go programming', 4);

# test
SELECT *
FROM student;

SELECT *
FROM course;
