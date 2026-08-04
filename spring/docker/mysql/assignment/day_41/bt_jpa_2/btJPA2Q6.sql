DROP DATABASE IF EXISTS btJPA2Q6;

CREATE DATABASE btJPA2Q6;

USE btJPA2Q6;


CREATE TABLE employee
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(200) NOT NULL,
    salary DECIMAL(19, 6) NOT NULL,
    department VARCHAR(200) NOT NULL
);

INSERT INTO employee(name, salary, department)
VALUES ('Nguyen Van Mot', 14000000, 'IT'),
       ('Nguyen Van Hai', 15000000, 'IT'),
       ('Nguyen Van Ba', 16000000, 'IT'),
       ('Nguyen Van Bon', 17000000, 'HR'),
       ('Nguyen Van Nam', 18000000, 'HR'),
       ('Nguyen Van Sau', 19000000, 'HR'),
       ('Nguyen Van Bay', 20000000, 'SSC'),
       ('Nguyen Van Tam', 21000000, 'SSC'),
       ('Nguyen Van Chin', 22000000, 'SSC'),
       ('Nguyen Van Muoi', 23000000, 'Procurement');
