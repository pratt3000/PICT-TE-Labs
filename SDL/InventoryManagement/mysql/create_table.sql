DROP DATABASE IF EXISTS bb_accounts;

CREATE DATABASE bb_accounts;
USE bb_accounts;

CREATE TABLE users(
    user_name VARCHAR(30),
    password VARCHAR(30) 
    );

CREATE TABLE Market(
    name VARCHAR(20),
    quantity INT,
    expiry INT,
    cost INT
    );

INSERT INTO users VALUES("admin", "admin123");

INSERT INTO Market VALUES("Spinach", 2, 3, 30);
INSERT INTO Market VALUES("Cauli-flower", 4, 4, 40);
INSERT INTO Market VALUES("Mushrooms", 5, 4, 100);
INSERT INTO Market VALUES("Beet", 2, 5, 20);
INSERT INTO Market VALUES("Brocolli", 7, 5, 20);
INSERT INTO Market VALUES("Cabbage", 7, 3, 50);
INSERT INTO Market VALUES("Apple", 9, 3, 35);
INSERT INTO Market VALUES("Orange", 12, 4, 25);
INSERT INTO Market VALUES("Bananas", 4, 2, 10);
INSERT INTO Market VALUES("Cherries", 6, 3, 5);
INSERT INTO Market VALUES("Chicken", 8, 7, 250);
INSERT INTO Market VALUES("Fish", 7, 7, 400);
INSERT INTO Market VALUES("Crabs", 13, 9, 300);


