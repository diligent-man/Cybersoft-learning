CREATE DATABASE IF NOT EXISTS `vnexpress`
USE vnexpress;

CREATE TABLE baiviet
(
    tieude  VARCHAR(255),
    noidung TEXT,
    hinhanh VARCHAR(255),
    ngaytao TIMESTAMP
);

# Insert data
# INSERT INTO table_name (col1, col2, ...) VALUES (val1, val2, ...);
INSERT INTO baiviet(tieude, noidung, hinhanh, ngaytao)
VALUES ('Tieu de 1', 'Noi dung 1', null, null);
INSERT INTO baiviet(tieude, noidung, hinhanh, ngaytao)
VALUES ('Tieu de 2', 'Noi dung 2', 'Hinh anh 2', null);
INSERT INTO baiviet(tieude, noidung, hinhanh, ngaytao)
VALUES ('Tieu de 3', 'Noi dung 3', 'Hinh anh 3', '2020-01-01 00:00:00');

# Query data
# SELECT col FROM table_name WHERE condition;
SELECT *
FROM baiviet;
SELECT tieude
FROM baiviet;
SELECT *
FROM baiviet
WHERE tieude = 'Tieu de 2';

# Remove data (DELETE + TRUNCATE)
# DELETE FROM table_name WHERE condition;
DELETE
FROM baiviet
WHERE tieude = 'Tieu de 2';

# Update data
# UPDATE table_name SET col1 = val1, col2 = val2, ... WHERE condition;
UPDATE baiviet
SET noidung = 'Noi dung 111'
WHERE tieude = 'Tieu de 1';

# Primary Key: Đối với cột được chỉ định làm khóa chính thì giá trị thêm vào phải là duy nhất và không null
# Cột khóa chính {primary key(tên_cột_làm_khóa_chính, ...)}
DROP TABLE baiviet;
CREATE TABLE baiviet
(
    id      INT AUTO_INCREMENT,
    tieude  VARCHAR(255),
    noidung TEXT,
    hinhanh VARCHAR(255),
    ngaytao TIMESTAMP,
    CONSTRAINT pk_baiviet PRIMARY KEY (id)
);

DELETE FROM baiviet WHERE id = 2;
