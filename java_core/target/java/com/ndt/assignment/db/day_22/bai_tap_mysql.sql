CREATE DATABASE IF NOT EXISTS day_22_shop_demo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE day_22_shop_demo;

-- Bảng khách hàng
CREATE TABLE customers
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    name          VARCHAR(100) NOT NULL,
    email         VARCHAR(100) NOT NULL,
    registered_at DATE         NOT NULL
);

-- Bảng sản phẩm
CREATE TABLE products
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    name  VARCHAR(100)   NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stock INT            NOT NULL
);

-- Bảng đơn hàng
CREATE TABLE orders
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    customer_id  INT            NOT NULL,
    order_date   DATE           NOT NULL,
    total_amount DECIMAL(12, 2) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers (id)
);

-- Bảng chi tiết đơn hàng (mỗi dòng là 1 sản phẩm thuộc 1 đơn)
CREATE TABLE order_items
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    order_id   INT            NOT NULL,
    product_id INT            NOT NULL,
    quantity   INT            NOT NULL,
    price      DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);

INSERT INTO customers (name, email, registered_at)
VALUES ('Trần Văn An', 'an.tran@gmail.com', '2024-01-03'),
       ('Nguyễn Minh B', 'minhb@gmail.com', '2024-01-05'),
       ('Lê Thị C', 'c.let@gmail.com', '2024-01-10'),
       ('Phạm Hoàng D', 'd.pham@gmail.com', '2024-01-13'),
       ('Đỗ Thúy E', 'thuydo@gmail.com', '2024-01-15'),
       ('Hoàng Văn F', 'f.hoang@gmail.com', '2024-02-03'),
       ('Bùi Đức G', 'g.bui@gmail.com', '2024-02-07'),
       ('Trịnh Mai H', 'h.trinh@gmail.com', '2024-02-09'),
       ('Vũ Hải I', 'i.vu@gmail.com', '2024-02-12'),
       ('Đặng Nhật K', 'k.dang@gmail.com', '2024-02-14'),
       ('Nguyễn Thị L', 'l.nguyen@gmail.com', '2024-02-17'),
       ('Phan Văn M', 'm.phan@gmail.com', '2024-03-01'),
       ('Đoàn Thị N', 'n.doan@gmail.com', '2024-03-05'),
       ('Trương Minh O', 'o.truong@gmail.com', '2024-03-10'),
       ('Võ Gia P', 'p.vo@gmail.com', '2024-03-15'),
       ('Lý Hải Q', 'q.ly@gmail.com', '2024-03-21'),
       ('Tạ Văn R', 'r.ta@gmail.com', '2024-03-25'),
       ('Cao Thị S', 's.cao@gmail.com', '2024-04-01'),
       ('Ngô Văn T', 't.ngo@gmail.com', '2024-04-08'),
       ('Dương Thu U', 'u.duong@gmail.com', '2024-04-13');

INSERT INTO products (name, price, stock)
VALUES ('Bút bi Thiên Long', 5000, 100),
       ('Vở Campus', 20000, 50),
       ('Kéo nhỏ', 12000, 30),
       ('Thước kẻ 20cm', 7000, 60),
       ('Tẩy Student', 3000, 100),
       ('Gôm Pentel', 4000, 90),
       ('Bìa nhựa', 15000, 70),
       ('Bút chì 2B', 3500, 80),
       ('Gọt bút chì', 6000, 40),
       ('Tập A4', 25000, 40),
       ('Giấy note', 8000, 55),
       ('Bút dạ quang', 12000, 35),
       ('Compas', 30000, 25),
       ('Bảng con', 18000, 50),
       ('Bút lông bảng', 7000, 80),
       ('Kẹp giấy', 4000, 100),
       ('Hồ dán', 6000, 60),
       ('Sổ tay', 15000, 90),
       ('Mực bút máy', 20000, 25),
       ('Kẹp tài liệu', 18000, 30);

INSERT INTO orders (customer_id, order_date, total_amount)
VALUES (1, '2024-01-05', 150000),
       (2, '2024-01-07', 230000),
       (3, '2024-01-12', 50000),
       (4, '2024-01-14', 110000),
       (5, '2024-01-16', 72000),
       (6, '2024-02-05', 135000),
       (7, '2024-02-09', 98000),
       (8, '2024-02-13', 128000),
       (9, '2024-02-17', 60000),
       (10, '2024-02-19', 157000),
       (11, '2024-02-21', 81000),
       (12, '2024-03-03', 44000),
       (13, '2024-03-06', 205000),
       (14, '2024-03-12', 157000),
       (15, '2024-03-16', 129000),
       (16, '2024-03-22', 143000),
       (17, '2024-03-27', 95000),
       (18, '2024-04-03', 128000),
       (19, '2024-04-09', 100000),
       (20, '2024-04-14', 132000),
       (1, '2024-04-29', 132000);

INSERT INTO order_items (order_id, product_id, quantity, price)
VALUES (1, 1, 10, 5000),
       (1, 2, 2, 20000),
       (1, 3, 3, 12000),
       (2, 2, 5, 20000),
       (2, 4, 4, 7000),
       (2, 5, 2, 3000),
       (3, 1, 3, 5000),
       (3, 8, 2, 3500),
       (3, 9, 1, 6000),
       (4, 2, 1, 20000),
       (4, 3, 6, 12000),
       (4, 7, 1, 15000),
       (5, 5, 7, 3000),
       (5, 6, 5, 4000),
       (5, 10, 1, 25000),
       (6, 1, 5, 5000),
       (6, 2, 1, 20000),
       (6, 12, 2, 12000),
       (7, 3, 8, 12000),
       (7, 4, 2, 7000),
       (7, 5, 3, 3000),
       (8, 2, 3, 20000),
       (8, 11, 4, 8000),
       (8, 15, 5, 7000),
       (9, 1, 2, 5000),
       (9, 3, 4, 12000),
       (9, 6, 3, 4000),
       (10, 1, 7, 5000),
       (10, 13, 2, 30000),
       (10, 18, 1, 15000),
       (11, 2, 2, 20000),
       (11, 5, 5, 3000),
       (11, 8, 3, 3500),
       (12, 3, 5, 12000),
       (12, 7, 2, 15000),
       (12, 14, 1, 18000),
       (13, 2, 3, 20000),
       (13, 9, 2, 6000),
       (13, 17, 2, 15000),
       (14, 1, 5, 5000),
       (14, 10, 3, 25000),
       (14, 11, 1, 8000),
       (15, 1, 2, 5000),
       (15, 4, 7, 7000),
       (15, 5, 5, 3000),
       (16, 2, 6, 20000),
       (16, 3, 1, 12000),
       (16, 6, 3, 4000),
       (17, 7, 3, 15000),
       (17, 8, 5, 3500),
       (17, 12, 2, 12000),
       (18, 1, 4, 5000),
       (18, 13, 1, 30000),
       (18, 14, 2, 18000),
       (19, 2, 1, 20000),
       (19, 16, 4, 4000),
       (19, 17, 3, 15000),
       (20, 3, 6, 12000),
       (20, 15, 2, 7000),
       (20, 19, 2, 20000),
       (21, 1, 3, 12000);


# Liệt kê tất cả đơn hàng và tên khách hàng
SELECT o.id, c.name, o.total_amount, o.order_date
FROM orders o
         JOIN customers c on o.customer_id = c.id;

# Liệt kê chi tiết từng đơn hàng
# Cach 1.1
SELECT o.id,
       c.name,
       p.name,
       oi.quantity,
       oi.price,
       o.total_amount,
       SUM(oi.quantity * oi.price) OVER (
           PARTITION BY o.id
           ORDER BY o.id
           ) AS "Tổng giá trị hóa đơn"
FROM customers c
         JOIN orders o ON o.customer_id = c.id
         JOIN order_items oi ON oi.order_id = o.id
         JOIN products p ON p.id = oi.product_id;

# Cach 1.2
WITH tmp AS (SELECT o.id,
                    c.name AS customer_name,
                    p.name AS product_name,
                    oi.quantity,
                    oi.price,
                    o.total_amount
             FROM customers c
                      JOIN orders o ON o.customer_id = c.id
                      JOIN order_items oi ON oi.order_id = o.id
                      JOIN products p ON p.id = oi.product_id)
SELECT tmp.*,
       SUM(tmp.quantity * tmp.price) OVER (
           PARTITION BY tmp.id
           ORDER BY tmp.id
           ) AS "Tổng giá trị hóa đơn"
FROM tmp;


# Cach 2
WITH temp AS (SELECT oi.order_id, SUM(oi.quantity * oi.price) AS "Tổng giá trị hóa đơn"
              FROM order_items oi
              GROUP BY oi.order_id)
SELECT o.id, c.name, p.name, oi.quantity, oi.price, o.total_amount, temp.`Tổng giá trị hóa đơn`
FROM customers c
         JOIN orders o ON o.customer_id = c.id
         JOIN order_items oi ON oi.order_id = o.id
         JOIN products p ON p.id = oi.product_id
         JOIN temp ON temp.order_id = oi.order_id;


# Cach 3
SELECT o.id,
       c.name,
       p.name,
       oi.quantity,
       oi.price,
       o.total_amount,
       (SELECT SUM(oi.quantity * oi.price)
        FROM order_items oi
        WHERE oi.order_id = o.id
        GROUP BY oi.order_id) AS "Tổng giá trị hóa đơn"
FROM customers c
         JOIN orders o ON o.customer_id = c.id
         JOIN order_items oi ON oi.order_id = o.id
         JOIN products p ON p.id = oi.product_id;


# Thống kê doanh số khách hàng
SELECT c.name,
       COUNT(oi.order_id)          AS "Số đơn đã đặt",
       SUM(oi.quantity * oi.price) AS "Tổng chi tiêu"
FROM customers c
         JOIN orders o ON o.customer_id = c.id
         JOIN order_items oi on oi.order_id = o.id
GROUP BY oi.order_id;

# Số đơn hàng từng tháng (2024)
SELECT MONTH(order_date)        AS "Tháng",
       COUNT(MONTH(order_date)) AS "Số đơn hàng từng tháng"
FROM orders
WHERE YEAR(order_date) = 2024
GROUP BY MONTH(order_date)
ORDER BY MONTH(order_date);


# Sản phẩm bán chạy
SELECT p.name, COUNT(1) AS "sl"
FROM products p
         JOIN order_items oi ON oi.product_id = p.id
GROUP BY p.id
ORDER BY COUNT(1) DESC;

# Doanh thu theo tháng (2024)
SELECT MONTH(order_date) AS month, SUM(total_amount) AS "monthly_revenue"
FROM orders
WHERE YEAR(order_date) = 2024
GROUP BY MONTH(order_date)
ORDER BY MONTH(order_date);

# Top 5 khách hàng chi tiêu nhiều nhất
SELECT c.id, c.name, SUM(o.total_amount) AS total_expense
FROM orders o
         JOIN customers c on o.customer_id = c.id
GROUP BY c.id
ORDER BY total_expense DESC
LIMIT 5;

# Sản phẩm từng khách hàng đã mua
SELECT DISTINCT c.id,
                p.name AS customer_name,
                p.name AS product_name,
                SUM(oi.quantity) OVER (
                    PARTITION BY c.id, p.name
                    ORDER BY c.id
                    )
FROM products p
         JOIN order_items oi on p.id = oi.product_id
         JOIN orders o on oi.order_id = o.id
         JOIN customers c on o.customer_id = c.id;

# Khách hàng mua từ 2 sản phẩm trở lên
SELECT c.id, c.name, COUNT(DISTINCT oi.product_id) AS num_product_purchased
FROM order_items oi
JOIN orders o on oi.order_id = o.id
JOIN customers c on o.customer_id = c.id
GROUP BY c.id;

# Thống kê sản phẩm bán theo tháng
SELECT DISTINCT p.name, MONTH(order_date), SUM(quantity) OVER (
    PARTITION BY p.id
    ORDER BY MONTH(order_date)
    )
FROM products p
JOIN order_items oi on p.id = oi.product_id
JOIN orders o on oi.order_id = o.id
WHERE p.id IN (1, 2, 3);


SELECT *
FROM order_items
SELECT *
FROM orders
SELECT *
FROM products
SELECT *
FROM customers
