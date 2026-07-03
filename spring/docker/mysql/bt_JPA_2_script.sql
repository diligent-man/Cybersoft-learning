DROP DATABASE IF EXISTS btJPA1Q1;
DROP DATABASE IF EXISTS btJPA1Q2;

CREATE DATABASE btJPA1Q1;
CREATE DATABASE btJPA1Q2;

USE btJPA1Q1;
USE btJPA1Q2;


CREATE TABLE usersss
(
    id       varchar(36),
    email    varchar(50),
    password text,
    PRIMARY KEY (id)
);

INSERT INTO userss(id, email, password)
VALUES (1, 'nguyenvana@gmail.com', '123456');



INSERT INTO usersss(id, email, password)
VALUES (2, 'nguyenvanb@gmail.com', '123');

