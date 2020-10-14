drop database if exists DBMS_mock;
create database DBMS_mock;
use DBMS_mock;
DROP PROCEDURE IF EXISTS setBorrowerCategory;

CREATE TABLE Customer(
    cust_name VARCHAR(20),
    acc_no INT,
    balance INT,
    city VARCHAR(20),
    PRIMARY KEY(cust_name)
);

CREATE TABLE Loan(
    loan_no INT,
    branch_name VARCHAR(20),
    amount INT,
    PRIMARY KEY(loan_no)
);

CREATE TABLE Borrower(
    cust_name VARCHAR(20),
    loan_no INT,
    foreign key(loan_no) references Loan(loan_no) on delete cascade,
    foreign key(cust_name) references Customer(cust_name) on delete cascade
);

CREATE TABLE Borrower_category(
    cust_name VARCHAR(20),
    acc_no INT,
    loan_no INT,
    branch_name VARCHAR(20),
    amount INT,
    category VARCHAR(20),
    foreign key(loan_no) references Loan(loan_no) on delete cascade,
    foreign key(cust_name) references Customer(cust_name) on delete cascade
);

INSERT INTO Customer VALUES("Prathamesh", 1, 100000, "Pune");
INSERT INTO Customer VALUES("Aditya", 2, 100, "Mumbai");
INSERT INTO Customer VALUES("Sooraj", 3, 52000, "Nashik");
INSERT INTO Customer VALUES("Swatej", 4, 30000, "Nagpur");
INSERT INTO Customer VALUES("Utkarsh", 5, 24000, "Mumbai");

INSERT INTO Loan VALUES(101, "Mumbai Dept.", 50000);
INSERT INTO Loan VALUES(102, "Mumbai Dept.", 70000);
INSERT INTO Loan VALUES(103, "Pune Dept.", 10000);
INSERT INTO Loan VALUES(104, "Pune Dept.", 10);
INSERT INTO Loan VALUES(105, "Delhi Dept.", 10000000);

INSERT INTO Borrower VALUES("Prathamesh", 101);
INSERT INTO Borrower VALUES("Aditya", 102);
INSERT INTO Borrower VALUES("Sooraj", 103);
INSERT INTO Borrower VALUES("Swatej", 104);
INSERT INTO Borrower VALUES("Utkarsh", 105);

SELECT * FROM Customer;
SELECT * FROM Loan;
SELECT * FROM Borrower;

delimiter @@
create PROCEDURE setBorrowerCategory(IN cust_name_new VARCHAR(20))
BEGIN

    DECLARE acc_no_new INT;
    DECLARE loan_no_new INT;
    DECLARE branch_name_new VARCHAR(20);
    DECLARE category VARCHAR(20);
    DECLARE loan_amount_new INT;

    DECLARE exit handler for 1062
    SELECT 'Error : Duplicate' AS MESSAGE;
    DECLARE exit handler for NOT found
    SELECT 'Error :  Record not found' AS MESSAGE;

    SELECT acc_no INTO acc_no_new FROM Customer WHERE STRCMP(cust_name,cust_name_new)=0;
    SELECT loan_no INTO loan_no_new FROM Borrower WHERE STRCMP(cust_name,cust_name_new)=0;
    SELECT branch_name INTO branch_name_new FROM Loan WHERE loan_no=loan_no_new;
    SELECT amount INTO loan_amount_new FROM Loan WHERE loan_no=loan_no_new;

    IF loan_amount_new>=100000 THEN
        SET category="Critical";
    END IF;
    IF loan_amount_new<100000 AND loan_amount_new>=30000 THEN
        SET category="Moderate";
    END IF;
    IF loan_amount_new<30000 THEN
        SET category="Nominal";
    END IF;

    INSERT INTO Borrower_category VALUES(
        cust_name_new,
        acc_no_new,
        loan_no_new,
        branch_name_new,
        loan_amount_new,
        category
    );
    
END@@

delimiter ;


CALL setBorrowerCategory("Prathamesh");
CALL setBorrowerCategory("Aditya");
CALL setBorrowerCategory("Sooraj");
CALL setBorrowerCategory("Swatej");
CALL setBorrowerCategory("Utkarsh");
SELECT * FROM Borrower_category;






