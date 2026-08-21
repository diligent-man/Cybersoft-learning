DROP DATABASE IF EXISTS btJPA1Q5;

CREATE DATABASE btJPA1Q5;

USE btJPA1Q5;

CREATE TABLE student
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(200)       NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    age   INT                NOT NULL CHECK ( age BETWEEN 1 AND 99)
);


CREATE TABLE course
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    title    VARCHAR(200)  NOT NULL,
    duration DECIMAL(2, 1) NOT NULL COMMENT 'thời lượng khóa học, tính theo giờ'
);

CREATE TABLE registration
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    registration_date DATETIME NOT NULL,
    student_id        INT      NOT NULL,
    course_id         INT      NOT NULL
);

ALTER TABLE registration
    ADD CONSTRAINT FK_student_id_registration FOREIGN KEY (student_id) REFERENCES student (id);
ALTER TABLE registration
    ADD CONSTRAINT FK_course_id_registration FOREIGN KEY (course_id) REFERENCES course (id);
ALTER TABLE registration
    ADD CONSTRAINT UNIQUE_student_course_registration UNIQUE (student_id, course_id);

INSERT INTO course(title, duration)
VALUES ('Python programming', 1),
       ('Java programming', 1.5),
       ('Ruby programming', 2),
       ('C++ programming', 2.5),
       ('C programming', 3),
       ('Rust programming', 3.5),
       ('Go programming', 4);

INSERT INTO student(name, email, age)
VALUES ('Nguyen Van Mot', 'nv1@gmail.com', 15),
       ('Nguyen Van Hai', 'nv2@gmail.com', 16),
       ('Nguyen Van Ba', 'nv3@gmail.com', 17),
       ('Nguyen Van Tu', 'nv4@fpt.edu.com', 20),
       ('Nguyen Van Nam', 'nv5@fpt.com', 21),
       ('Nguyen Van Sau', 'nv6@uit.edu.com', 22);

INSERT INTO registration(registration_date, student_id, course_id)
VALUES (NOW() - INTERVAL 1 DAY, 1, 1),
       (NOW() - INTERVAL 2 DAY, 2, 1),
       (NOW() - INTERVAL 3 DAY, 1, 2),
       (NOW() - INTERVAL 4 DAY, 2, 2),
       (NOW() - INTERVAL 5 DAY, 1, 3),
       (NOW() - INTERVAL 5 DAY, 2, 3),
       (NOW() - INTERVAL 6 DAY, 1, 4),
       (NOW() - INTERVAL 6 DAY, 2, 4);


# test
SELECT *
FROM registration;
