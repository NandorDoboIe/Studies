DROP DATABASE IF EXISTS WebDev3_BookStore;
CREATE DATABASE WebDev3_BookStore;
USE WebDev3_BookStore;

CREATE TABLE book_details (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(150) NOT NULL,
    author VARCHAR(100) NOT NULL,
    price DECIMAL(8,2) NOT NULL,
    stock_quantity INT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO book_details (title, author, price, stock_quantity)
VALUES
    ('The Hobbit', 'J.R.R. Tolkien', 12.99, 8),
    ('1984', 'George Orwell', 10.50, 5),
    ('Pride and Prejudice', 'Jane Austen', 9.99, 6);

SELECT * FROM book_details;
