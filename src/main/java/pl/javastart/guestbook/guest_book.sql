DROP DATABASE IF EXISTS guest_book

CREATE DATABASE guest_book CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci;

CREATE TABLE guest_book
(
    id      INT           NOT NULL,
    author  VARCHAR(45)   NOT NULL,
    message VARCHAR(2000) NOT NULL,
    PRIMARY KEY (id)
);