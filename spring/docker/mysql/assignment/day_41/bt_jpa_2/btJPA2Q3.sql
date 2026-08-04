DROP DATABASE IF EXISTS btJPA2Q3;

CREATE DATABASE btJPA2Q3;

USE btJPA2Q3;


CREATE TABLE book
(
    id     INT AUTO_INCREMENT PRIMARY KEY,
    title  VARCHAR(255)   NOT NULL,
    author VARCHAR(200)   NOT NULL,
    price  DECIMAL(10, 2) NOT NULL
);



INSERT INTO book(title, author, price)
VALUES ('Cậu vàng và Lão Hạc', 'Nam Cao', 1100000),
       ('Dế mèn phiêu lưu ký', 'Tô Hoài', 1200000),
       ('Tôi là Bêtô', 'Nguyễn Nhật Ánh', 1300000),
       ('Tôi thấy hoa vàng trên cỏ xanh', 'Nguyễn Nhật Ánh', 1400000),
       ('Số đỏ', 'Vũ Trọng Phụng', 1500000),
       ('Làm đỉ', 'Vũ Trọng Phụng', 1600000);
