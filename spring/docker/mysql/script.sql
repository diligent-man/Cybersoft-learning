DROP DATABASE IF EXISTS uniclub;
CREATE DATABASE uniclub;
USE uniclub;


CREATE TABLE users
(
    id          varchar(36),
    email       varchar(50),
    password    text,
    create_date timestamp default CURRENT_TIMESTAMP(),

    PRIMARY KEY (id)
);


INSERT INTO roles(id, name) VALUES
                                (1, "ADMIN"),
                                (2, "USER");
