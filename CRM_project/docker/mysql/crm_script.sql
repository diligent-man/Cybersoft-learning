DROP
    DATABASE IF EXISTS crm;

CREATE
    DATABASE crm;

USE
    crm;

DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS jobs;
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
    CONSTRAINT PK_Status PRIMARY KEY (id)
);

CREATE TABLE jobs
(
    id         INT AUTO_INCREMENT,
    name       VARCHAR(50) NOT NULL,
    start_date DATE,
    end_date   DATE,
    CONSTRAINT PK_Job PRIMARY KEY (id)
);

CREATE TABLE tasks
(
    id         INT AUTO_INCREMENT,
    name       VARCHAR(50) NOT NULL,
    start_date DATE,
    end_date   DATE,
    user_id    INT         NOT NULL,
    job_id     INT         NOT NULL,
    status_id  INT         NOT NULL,

    CONSTRAINT PK_Task PRIMARY KEY (id)
);


ALTER TABLE users
    ADD CONSTRAINT FK_Users_Roles FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE tasks
    ADD CONSTRAINT FK_Task_User FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE tasks
    ADD CONSTRAINT FK_Task_Job FOREIGN KEY (job_id) REFERENCES jobs (id);
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
VALUES ("nva@gmail.com", "123456", "Nguyen Van A", "admin1.png", 1),
       ("nvb@gmail.com", "111111", "Nguyen Van B", "manager1.png", 2),
       ("nvc@gmail.com", "222222", "Nguyen Van C", "manager2.png", 2),
       ("nvd@gmail.com", "333333", "Nguyen Van D", "employee1.png", 3);

-- 3 jobs
INSERT INTO jobs(name, start_date, end_date)
VALUES ("Website CRM", "2026-05-01", "2026-06-01"),
       ("Mobile App", "2026-05-10", "2026-07-01"),
       ("Landing Page", "2026-05-15", "2026-05-30");

-- 3 status
INSERT INTO status(name)
VALUES ("Chưa thực hiện"),
       ("Đang thực hiện"),
       ("Đang thực hiện");


-- 6 tasks
INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id)
VALUES ("Thiết kế giao diện", "2026-05-01", "2026-05-05", 3, 1, 2),
       ("Code Backend", "2026-05-02", "2026-05-20", 1, 1, 2),
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
                    SUBSTRING_INDEX(fullname, ' ', -2)  AS first_name,
                    SUBSTRING_INDEX(fullname, ' ', 1) AS last_name
             FROM users)
SELECT tmp.*, u.email, r.name
FROM users u
         JOIN tmp on tmp.id = u.id
         JOIN roles r ON r.id = u.role_id;
