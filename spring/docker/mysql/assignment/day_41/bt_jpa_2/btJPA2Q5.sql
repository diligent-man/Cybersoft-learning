DROP DATABASE IF EXISTS btJPA2Q5;

CREATE DATABASE btJPA2Q5;

USE btJPA2Q5;


CREATE TABLE student
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(200)
);


CREATE TABLE course
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    title    VARCHAR(200) NOT NULL
);

CREATE TABLE registration
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    student_id        INT  NOT NULL,
    course_id         INT  NOT NULL
);

ALTER TABLE registration
    ADD CONSTRAINT FK_student_id_registration FOREIGN KEY (student_id) REFERENCES student (id);
ALTER TABLE registration
    ADD CONSTRAINT FK_course_id_registration FOREIGN KEY (course_id) REFERENCES course (id);


INSERT INTO student(name)
VALUES ('Nguyen Van Mot'),
       ('Nguyen Van Hai'),
       ('Nguyen Van Ba');

INSERT INTO course(title)
VALUES ('Python programming'),
       ('Java programming'),
       ('Ruby programming'),
       ('C++ programming'),
       ('C programming'),
       ('Rust programming'),
       ('Go programming');

INSERT INTO registration(student_id, course_id)
VALUES (1, 1),
       (1, 1),
       (1, 2),
       (1, 2),
       (1, 3),
       (1, 4),
       (2, 1),
       (2, 1),
       (2, 2),
       (2, 2),
       (2, 3),
       (2, 4),
       (3, 1),
       (3, 1),
       (3, 2),
       (3, 2),
       (3, 3),
       (3, 4);
