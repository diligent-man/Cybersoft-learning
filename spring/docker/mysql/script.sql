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


ALTER TABLE users
ADD COLUMN role_id INTEGER;


ALTER TABLE users
ADD CONSTRAINT FK_role_id_users FOREIGN KEY (role_id) REFERENCES roles(id);



INSERT INTO roles(id, name) VALUES
                                (1, "ADMIN"),
                                (2, "USER");


INSERT INTO users(id, email, password, create_date, role_id) VALUES
    (1, 'nguyenvana@gmail.com', '123456', CURRENT_TIMESTAMP(), 1),
    (2, 'nguyenvanb@gmail.com', '123', CURRENT_TIMESTAMP() - 3, 2);
