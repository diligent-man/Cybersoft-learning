CREATE DATABASE day_19_QuanLySach;
USE day_19_QuanLySach;

CREATE TABLE TacGia (
	ma_tac_gia INT AUTO_INCREMENT,
	ten_tac_gia VARCHAR(100) NOT NULL,
	quoc_tich VARCHAR(50),
    CONSTRAINT PK_MaTacGia PRIMARY KEY (ma_tac_gia)
);


CREATE TABLE Sach (
    ma_sach INT AUTO_INCREMENT,
    tieu_de VARCHAR(200) NOT NULL,
    nam_xuat_ban INT,
    ma_tac_gia INT NOT NULL,
    CONSTRAINT PK_MaSach PRIMARY KEY (ma_sach)
);

ALTER TABLE Sach ADD
CONSTRAINT FK_ma_tac_gia_bai_viet FOREIGN KEY (ma_tac_gia) REFERENCES TacGia(ma_tac_gia);

INSERT INTO TacGia VALUE
    (1, 'Nguyễn Nhật Ánh', 'Việt Nam'),
    (2, 'Haruki Murakami', 'Nhật Bản'),
    (3, 'J.K. Rowling', 'Anh');

INSERT INTO Sach VALUE
    (1, 'Mắt Biếc', 1990, 1),
    (2, 'Tôi thấy hoa vàng trên cỏ xanh', 2005, 1),
    (3, 'Rừng Na Uy', 1987, 2),
    (4, 'Harry Potter và Hòn đá Phù thủy', 1997, 3);



# 1.Lấy danh sách tất cả sách trong hệ thống.
SELECT * FROM Sach;

# 2.Lấy danh sách tất cả tác giả có quốc tịch là "Việt Nam".
SELECT * FROM TacGia WHERE quoc_tich = 'Việt Nam';

# 3.Lấy tên sách và tên tác giả tương ứng (JOIN 2 bảng).
SELECT Sach.*, TacGia.ten_tac_gia, TacGia.quoc_tich FROM TacGia INNER JOIN Sach ON TacGia.ma_tac_gia = Sach.ma_tac_gia;

# 4.Lấy danh sách các sách xuất bản sau năm 1990.
SELECT * FROM Sach WHERE nam_xuat_ban >= 1990;

# 5.Đếm số lượng sách của mỗi tác giả.
SELECT Sach.ma_tac_gia, COUNT(Sach.ma_tac_gia) AS so_luong_sach
FROM Sach
    INNER JOIN TacGia ON Sach.ma_tac_gia = TacGia.ma_tac_gia
GROUP BY ma_tac_gia;

# 6.Tìm tác giả có nhiều sách nhất.
WITH tmp AS (
    SELECT ma_tac_gia, COUNT(*) AS sl FROM Sach GROUP BY ma_tac_gia
)
SELECT Sach.ma_tac_gia, COUNT(*) AS sl
FROM Sach
    INNER JOIN tmp ON Sach.ma_tac_gia = tmp.ma_tac_gia
GROUP BY Sach.ma_tac_gia
HAVING Sach.sl = tmp.sl;

