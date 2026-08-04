DROP DATABASE IF EXISTS btJPA1Q2;

CREATE DATABASE btJPA1Q2;

USE btJPA1Q2;


CREATE TABLE course
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    title    VARCHAR(200) NOT NULL,
    duration INT          NOT NULL COMMENT 'thời lượng khóa học, tính theo giờ'
);


INSERT INTO course(title, duration)
VALUES ('Python programming', 1),
       ('Java programming', 1.5),
       ('Ruby programming', 2),
       ('C++ programming', 2.5),
       ('C programming', 3),
       ('Rust programming', 3.5),
       ('Go programming', 4);
