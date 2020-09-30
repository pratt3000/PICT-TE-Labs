drop database if exists A7;
create database A7;
use A7;

CREATE TABLE customer(
    id INT,
    cust_name VARCHAR(20),
    total_purchase INT, 
    PRIMARY KEY(id)
    );

CREATE TABLE category(
    cust_id INT,
    name VARCHAR(20),
    class VARCHAR(20), 
    FOREIGN KEY(cust_id) REFERENCES customer(id) ON DELETE CASCADE
    );

INSERT INTO customer VALUES(1,"Prathamesh",9000);
INSERT INTO customer VALUES(2,"Aditya",15000);
INSERT INTO customer VALUES(3,"Varun",3000);
INSERT INTO customer VALUES(4,"Prachi",2000);
INSERT INTO customer VALUES(5,"Utkarsh",11000);


delimiter //
CREATE PROCEDURE decideCategory(IN total_purchase INT, OUT class VARCHAR(20))
BEGIN
IF total_purchase<= 20000 AND total_purchase>=10000 THEN SET class="PLATINUM";
END IF;
IF total_purchase<10000 AND total_purchase >= 5000 THEN SET class="GOLD";
END IF;
IF total_purchase<5000 AND total_purchase >=2000 THEN SET class="SILVER";
END IF;
END;
//

CREATE PROCEDURE proc_category()
BEGIN
    DECLARE cust_name VARCHAR(20);
    DECLARE b INT default 0;
    DECLARE cust_id  INT;
    DECLARE total_purchase INT;
    DECLARE class INT;
    DECLARE c1 cursor for SELECT * FROM customer;
    DECLARE CONTINUE handler for NOT found SET b=1;
    OPEN c1;
    repeat
    FETCH c1 INTO cust_id,cust_name,total_purchase;
    IF NOT b THEN
        CALL decideCategory(total_purchase,@class);
        INSERT INTO category VALUES(cust_id,cust_name,@class);
    END IF;
    until b END repeat;
END;
//

delimiter ;
SELECT * FROM category;

CALL proc_category();
SELECT * FROM category;

delimiter //
CREATE FUNCTION insertCategory(cust_id INT) RETURNS VARCHAR(20) deterministic
BEGIN
DECLARE total_purchase INT;
DECLARE class VARCHAR(20);
DECLARE cust_name VARCHAR(20);
SELECT customer.cust_name,customer.total_purchase INTO cust_name,total_purchase FROM customer WHERE customer.id=cust_id;
CALL decideCategory(total_purchase,@class);
INSERT INTO category VALUES(cust_id,cust_name,@class);
RETURN @class;
END;
//

delimiter ;
DELETE FROM category;

SELECT insertCategory(1);
SELECT * FROM category;
