DROP DATABASE IF EXISTS btJPA1Q3;

CREATE DATABASE btJPA1Q3;

USE btJPA1Q3;


CREATE TABLE student
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(200),
    email VARCHAR(50) UNIQUE,
    age   INT
);


CREATE TABLE course
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    title    VARCHAR(200) NOT NULL,
    duration INT          NOT NULL COMMENT 'thời lượng khóa học, tính theo giờ'
);

CREATE TABLE registration
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    registration_date DATE NOT NULL,
    student_id        INT  NOT NULL,
    course_id         INT  NOT NULL
);

ALTER TABLE registration
    ADD CONSTRAINT FK_student_id_registration FOREIGN KEY (student_id) REFERENCES student (id);
ALTER TABLE registration
    ADD CONSTRAINT FK_course_id_registration FOREIGN KEY (course_id) REFERENCES course (id);


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
       ('Nguyen Van Ba', 'nv3@gmail.com', 17);

INSERT INTO registration(registration_date, student_id, course_id)
VALUES (NOW() - INTERVAL 1 DAY, 1, 1),
       (NOW() - INTERVAL 2 DAY, 1, 1),
       (NOW() - INTERVAL 3 DAY, 1, 2),
       (NOW() - INTERVAL 4 DAY, 1, 2),
       (NOW() - INTERVAL 5 DAY, 1, 3),
       (NOW() - INTERVAL 6 DAY, 1, 4);
