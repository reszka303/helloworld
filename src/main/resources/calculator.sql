DROP DATABASE IF EXISTS calculator;

CREATE DATABASE calculator;

CREATE TABLE IF NOT EXISTS
    calculator.user (
        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(40) NOT NULL UNIQUE,
        password VARCHAR(45) NOT NULL,
        email VARCHAR(45) not NULL
    )
;

CREATE TABLE if NOT EXISTS
    calculator.user_role (
    role_name VARCHAR(20) NOT NULL,
    username VARCHAR(40) NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (role_name, user_id, username),
    CONSTRAINT fk_user_role_user
    FOREIGN KEY (user_id)
    REFERENCES calculator.user (id)
    )
;


INSERT INTO calculator.user
(username, password, email)
VALUES
    ('administrator', 'hardPass123', 'admin@mysuperdomain.com'),
    ('john', 'john1234', 'john@someemail.com')
;

INSERT INTO calculator.user_role
(user_id, username, role_name)
VALUES
    (1, 'administrator', 'admin_role'),
    (2, 'john', 'user_role')
;


CREATE TABLE IF NOT EXISTS
    calculator.user (
                        id INT NOT NULL AUTO_INCREMENT,
                        username VARCHAR(40) NOT NULL UNIQUE,
    password VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    PRIMARY KEY (id, username)
    )
;

CREATE TABLE IF NOT EXISTS
    calculator.user_role (
    role_name VARCHAR(20) NOT NULL,
    username VARCHAR(40) NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (role_name, user_id, username),
    CONSTRAINT fk_user_role_user
    FOREIGN KEY (user_id, username)
    REFERENCES calculator.user (id, username)
    ON UPDATE CASCADE
    )
;

INSERT INTO calculator.user
(username, password, email)
VALUES
    ('administrator', 'hardPass123', 'admin@mysuperdomain.com'),
    ('john', 'john1234', 'john@someemail.com')
;


INSERT INTO calculator.user_role
(user_id, username, role_name)
VALUES
    (1, 'administrator', 'admin_role'),
    (2, 'john', 'user_role')
;


UPDATE calculator.user SET username = 'johnny' WHERE id = 2;
UPDATE calculator.user_role SET username = 'johnny' WHERE user_id = 2;
# lub
UPDATE calculator.user SET username = 'johnny' WHERE username = 'john';
UPDATE calculator.user_role SET username = 'johnny' WHERE username = 'john'