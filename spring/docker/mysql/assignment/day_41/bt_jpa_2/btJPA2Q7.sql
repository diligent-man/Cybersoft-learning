DROP DATABASE IF EXISTS btJPA2Q7;

CREATE DATABASE btJPA2Q7;

USE btJPA2Q7;


CREATE TABLE user
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    username  VARCHAR(200) NOT NULL ,
    email VARCHAR(200) NOT NULL UNIQUE,
    password VARCHAR(60) NOT NULL
);

INSERT INTO user(username, email, password)
VALUES ('Nguyen Van Mot', 'nv1@gmail.com', '1'),
       ('Nguyen Van Hai', 'nv2@gmail.com', '2'),
       ('Nguyen Van Ba', 'nv3@gmail.com', '3');

# test
SELECT * FROM user;