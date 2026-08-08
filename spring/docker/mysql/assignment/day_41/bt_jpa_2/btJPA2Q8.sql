DROP DATABASE IF EXISTS btJPA2Q8;

CREATE DATABASE btJPA2Q8;

USE btJPA2Q8;


CREATE TABLE `order`
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    customerName VARCHAR(200)   NOT NULL,
    totalAmount  DECIMAL(13, 4) NOT NULL,
    createdAt    DATETIME       NOT NULL
);


INSERT INTO `order`(customerName, totalAmount, createdAt)
VALUES ('Nguyen Van Mot', 1500000, NOW() - INTERVAL 1 DAY),
       ('Nguyen Van Mot', 1600000, NOW() - INTERVAL 2 DAY),
       ('Nguyen Van Mot', 1700000, NOW() - INTERVAL 3 DAY),
       ('Nguyen Van Hai', 1500000, NOW() - INTERVAL 1 DAY),
       ('Nguyen Van Hai', 1600000, NOW() - INTERVAL 2 DAY),
       ('Nguyen Van Hai', 1700000, NOW() - INTERVAL 3 DAY),
       ('Nguyen Van Ba', 1800000, NOW() - INTERVAL 1 DAY),
       ('Nguyen Van Ba', 1900000, NOW() - INTERVAL 2 DAY),
       ('Nguyen Van Ba', 2000000, NOW() - INTERVAL 3 DAY);

# test
SELECT * FROM `order`;