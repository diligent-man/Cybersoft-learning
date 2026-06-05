DROP
    DATABASE IF EXISTS crm;

CREATE
    DATABASE crm;

USE
    crm;

DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS status;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;


CREATE TABLE roles
(
    id          INT AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(100),

    CONSTRAINT PK_Role PRIMARY KEY (id)
);

CREATE TABLE users
(
    id       INT AUTO_INCREMENT,
    fullname VARCHAR(50)        NOT NULL,
    email    VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100)       NOT NULL,
    avatar   VARCHAR(100),
    phone    VARCHAR(11),
    role_id  INT                NOT NULL,

    CONSTRAINT PK_User PRIMARY KEY (id)
);

CREATE TABLE status
(
    id          INT AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(100),
    color       VARCHAR(30) NOT NULL,
    CONSTRAINT PK_Status PRIMARY KEY (id)
);

CREATE TABLE projects
(
    id         INT AUTO_INCREMENT,
    name       VARCHAR(50) NOT NULL,
    start_date DATE        NOT NULL,
    end_date   DATE,

    CONSTRAINT PK_Project PRIMARY KEY (id)
);

CREATE TABLE tasks
(
    id         INT AUTO_INCREMENT,
    name       VARCHAR(50) NOT NULL,
    start_date DATE,
    end_date   DATE,
    user_id    INT         NOT NULL,
    project_id INT         NOT NULL,
    status_id  INT         NOT NULL,

    CONSTRAINT PK_Task PRIMARY KEY (id)
);


ALTER TABLE users
    ADD CONSTRAINT FK_Users_Roles FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE tasks
    ADD CONSTRAINT FK_Task_User FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE tasks
    ADD CONSTRAINT FK_Task_Project FOREIGN KEY (project_id) REFERENCES projects (id);

ALTER TABLE tasks
    ADD CONSTRAINT FK_Task_Status FOREIGN KEY (status_id) REFERENCES status (id);


-- Sample data
-- 3 roles
INSERT INTO roles(name, description)
VALUES ("admin", "quản trị hệ thống"),
       ("manager", "quản lý"),
       ("employee", "nhân viên");

-- 4 users
INSERT INTO users(email, password, fullname, avatar, role_id)
VALUES ("nv1@gmail.com", "1", "Nguyen Van Mot", "admin1.png", 1),
       ("nv2@gmail.com", "2", "Nguyen Van Hai", "manager1.png", 2),
       ("nv3@gmail.com", "3", "Nguyen Van Ba", "manager2.png", 2),
       ("nv4@gmail.com", "4", "Nguyen Van Tu", "employee4.png", 3),
       ("nv5@gmail.com", "5", "Nguyen Van Nam", "employee5.png", 3),
       ("nv6@gmail.com", "6", "Nguyen Van Sau", "employee6.png", 3),
       ("nv7@gmail.com", "7", "Nguyen Van Bay", "employee7.png", 3),
       ("nv8@gmail.com", "8", "Nguyen Van Tam", "employee8.png", 3),
       ("nv9@gmail.com", "9", "Nguyen Van Chin", "employee9.png", 3),
       ("nv10@gmail.com", "10", "Nguyen Van Muoi", "employee10.png", 3),
       ("nv11@gmail.com", "11", "Nguyen Van Muoi Mot", "employee11.png", 3),
       ("nv12@gmail.com", "12", "Nguyen Van Muoi Hai", "employee12.png", 3),
       ("nv13@gmail.com", "13", "Nguyen Van Muoi Ba", "employee13.png", 3),
       ("nv14@gmail.com", "14", "Nguyen Van Muoi Bon", "employee14.png", 3),
       ("nv15@gmail.com", "15", "Nguyen Van Muoi Lam", "employee15.png", 3),
       ("nv16@gmail.com", "16", "Nguyen Van Muoi Sau", "employee16.png", 3),
       ("nv17@gmail.com", "17", "Nguyen Van Muoi Bay", "employee17.png", 3),
       ("nv18@gmail.com", "18", "Nguyen Van Muoi Tam", "employee18.png", 3),
       ("nv19@gmail.com", "19", "Nguyen Van Muoi Chin", "employee19.png", 3),
       ("nv20@gmail.com", "20", "Nguyen Van Hai Muoi", "employee20.png", 3),
       ("nv21@gmail.com", "21", "Nguyen Van Hai Muoi Mot", "employee21.png", 3),
       ("nv22@gmail.com", "22", "Nguyen Van Hai Muoi Hai", "employee22.png", 3),
       ("nv23@gmail.com", "23", "Nguyen Van Hai Muoi Ba", "employee23.png", 3),
       ("nv24@gmail.com", "24", "Nguyen Van Hai Muoi Bon", "employee24.png", 3),
       ("nv25@gmail.com", "25", "Nguyen Van Hai Muoi Lam", "employee25.png", 3),
       ("nv26@gmail.com", "26", "Nguyen Van Hai Muoi Sau", "employee26.png", 3),
       ("nv27@gmail.com", "27", "Nguyen Van Hai Muoi Bay", "employee27.png", 3),
       ("nv28@gmail.com", "28", "Nguyen Van Hai Muoi Tam", "employee28.png", 3),
       ("nv29@gmail.com", "29", "Nguyen Van Hai Muoi Chin", "employee29.png", 3),
       ("nv30@gmail.com", "30", "Nguyen Van Ba Muoi", "employee30.png", 3),
       ("nv31@gmail.com", "31", "Nguyen Van Ba Muoi Mot", "employee31.png", 3),
       ("nv32@gmail.com", "32", "Nguyen Van Ba Muoi Hai", "employee32.png", 3),
       ("nv33@gmail.com", "33", "Nguyen Van Ba Muoi Ba", "employee33.png", 3),
       ("nv34@gmail.com", "34", "Nguyen Van Ba Muoi Bon", "employee34.png", 3),
       ("nv35@gmail.com", "35", "Nguyen Van Ba Muoi Lam", "employee35.png", 3),
       ("nv36@gmail.com", "36", "Nguyen Van Ba Muoi Sau", "employee36.png", 3),
       ("nv37@gmail.com", "37", "Nguyen Van Ba Muoi Bay", "employee37.png", 3),
       ("nv38@gmail.com", "38", "Nguyen Van Ba Muoi Tam", "employee38.png", 3),
       ("nv39@gmail.com", "39", "Nguyen Van Ba Muoi Chin", "employee39.png", 3),
       ("nv40@gmail.com", "40", "Nguyen Van Bon Muoi", "employee40.png", 3),
       ("nv41@gmail.com", "41", "Nguyen Van Bon Muoi Mot", "employee41.png", 3),
       ("nv42@gmail.com", "42", "Nguyen Van Bon Muoi Hai", "employee42.png", 3),
       ("nv43@gmail.com", "43", "Nguyen Van Bon Muoi Ba", "employee43.png", 3),
       ("nv44@gmail.com", "44", "Nguyen Van Bon Muoi Bon", "employee44.png", 3),
       ("nv45@gmail.com", "45", "Nguyen Van Bon Muoi Lam", "employee45.png", 3),
       ("nv46@gmail.com", "46", "Nguyen Van Bon Muoi Sau", "employee46.png", 3),
       ("nv47@gmail.com", "47", "Nguyen Van Bon Muoi Bay", "employee47.png", 3),
       ("nv48@gmail.com", "48", "Nguyen Van Bon Muoi Tam", "employee48.png", 3),
       ("nv49@gmail.com", "49", "Nguyen Van Bon Muoi Chin", "employee49.png", 3),
       ("nv50@gmail.com", "50", "Nguyen Van Nam Muoi", "employee50.png", 3),
       ("nv51@gmail.com", "51", "Nguyen Van Nam Muoi Mot", "employee51.png", 3),
       ("nv52@gmail.com", "52", "Nguyen Van Nam Muoi Ba", "employee52.png", 3),
       ("nv53@gmail.com", "53", "Nguyen Van Nam Muoi Bon", "employee53.png", 3);

-- 3 jobs
INSERT INTO projects(name, start_date, end_date)
VALUES ("Website CRM", "2026-05-01", "2026-06-01"),
       ("Mobile App", "2026-05-10", "2026-07-01"),
       ("Landing Page", "2026-05-15", "2026-05-30");

-- 3 status
INSERT INTO status(name, color)
VALUES ("Chưa bắt đầu", "text-danger"),
       ("Đang thực hiện", "text-megna"),
       ("Đã hoàn thành", "text-primary");


-- 6 tasks
INSERT INTO tasks(name, start_date, end_date, user_id, project_id, status_id)
VALUES ("Thiết kế giao diện", "2026-05-01", "2026-05-05", 3, 1, 2),
       ("Code Backend", "2026-05-02", "2026-05-20", 1, 1, 2),
       ("Code Frontend", "2026-06-02", "2026-07-20", 1, 1, 2),
       ("Test API", "2026-05-10", "2026-05-15", 2, 1, 1),
       ("Làm Login Mobile", "2026-05-11", "2026-05-25", 4, 2, 2),
       ("Deploy Website", "2026-05-20", "2026-05-28", 1, 3, 1);


ALTER TABLE users
    ADD COLUMN (
        first_name VARCHAR(255),
        last_name VARCHAR(255)
        );

UPDATE users
SET last_name = "Nguyen"
WHERE id = 1;

UPDATE users
SET last_name = "Nguyen"
WHERE id = 2;

UPDATE users
SET last_name = "Nguyen"
WHERE id = 3;

UPDATE users
SET last_name = "Nguyen"
WHERE id = 4;

UPDATE users
SET first_name = "Van A"
WHERE id = 1;

UPDATE users
SET first_name = "Van B"
WHERE id = 2;

UPDATE users
SET first_name = "Van C"
WHERE id = 3;

UPDATE users
SET first_name = "Van D"
WHERE id = 4;


# Query test
WITH tmp AS (SELECT id,
                    SUBSTRING_INDEX(fullname, ' ', -2) AS first_name,
                    SUBSTRING_INDEX(fullname, ' ', 1)  AS last_name
             FROM users)
SELECT tmp.*, u.email, r.name
FROM users u
         JOIN tmp on tmp.id = u.id
         JOIN roles r ON r.id = u.role_id;


SELECT t.id,
       t.name,
       t.start_date,
       t.end_date,
       prj.name   AS 'project_name',
       st.name    AS 'status_name',
       u.fullname AS 'user_name'
FROM tasks t
         JOIN projects prj ON t.project_id = prj.id
         JOIN status st ON t.status_id = st.id
         JOIN users u ON t.user_id = u.id;


SELECT u.id,
       u.fullname,
       u.email,
       st.name                  AS 'status_name',
       st.color,
       SUM(COUNT(t.id)) OVER () AS total_tasks,
       SUM(COUNT(t.id)) OVER (
           PARTITION BY st.id
           )                    AS 'total_tasks_by_status',
       IFNULL(
               (COUNT(t.id) / NULLIF(SUM(COUNT(t.id)) OVER (), 0)) * 100,
               0.00
       )                        AS 'task_status_rate',
       IF(COUNT(t.id) = 0, JSON_ARRAY(),
          JSON_ARRAYAGG(
                  JSON_OBJECT(
                          'task_id', t.id,
                          'task_name', t.name,
                          'start_date', t.start_date,
                          'end_date', t.end_date
                  )
          )
       )                        AS task_details
FROM users u
         CROSS JOIN status st
         LEFT JOIN tasks t ON t.user_id = u.id AND t.status_id = st.id
WHERE u.id = 1
GROUP BY u.id, u.fullname, u.email, st.id, st.name, st.color;


select *
from status;

select *
from tasks;

select *
from users



