DROP DATABASE if EXISTS A8;
CREATE DATABASE A8;
USE A8;

CREATE TABLE student(
    roll_no INT,
    name VARCHAR(20),
    doa date, 
    branch VARCHAR(20),
    percent INT,
    status VARCHAR(20)
    );

CREATE TABLE alumni(
    roll_no INT,
    name VARCHAR(20),
    doa date, 
    branch VARCHAR(20),
    percent INT,
    status VARCHAR(20)
    );

INSERT INTO student VALUES(1, 'Prathamesh', '2020-04-8', 'Comp', '89', 'Pass');
INSERT INTO student VALUES(2, 'Aditya', '2020-04-5', 'ENTC', '45', 'Fail');
INSERT INTO student VALUES(3, 'Utkarsh', '2020-04-3', 'IT', '81', 'Pass');
INSERT INTO student VALUES(4, 'Varun', '2020-03-8', 'IT', '91', 'Pass');
INSERT INTO student VALUES(5, 'Shreya', '2020-01-23', 'Comp', '94', 'Pass');

DELIMITER $$
CREATE TRIGGER student_delete
    BEFORE DELETE ON student
    FOR EACH ROW 
    BEGIN
    INSERT INTO alumni VALUES(
    old.roll_no,
    old.name,
    old.doa, 
    old.branch,
    old.percent,
    old.status
    );
    END$$

CREATE TRIGGER student_update
    BEFORE UPDATE ON student
    FOR EACH ROW 
    BEGIN
        INSERT INTO alumni VALUES(
        old.roll_no,
        old.name,
        old.doa, 
        old.branch,
        old.percent,
        old.status
        );
    END$$

DELIMITER ;


DELETE FROM student WHERE roll_no=1;
UPDATE student SET percent=81 WHERE roll_no=2;
SELECT * FROM alumni;


drop database if exists A5;
create database A5;
use A5;
DROP PROCEDURE IF EXISTS setFine;

create table Customer(
                    Cust_id int not null,
                    Name varchar(30),
                    DateOfPayment date,
                    NameOfScheme varchar(20),
                    Status varchar(10),
                    primary key(Cust_id)
                    );

create table Fine(
                    Cust_id int not null,
                    Date date,
                    Amt int,
                    foreign key(Cust_id) references Customer(Cust_id) on delete cascade
                    );

insert into Customer VALUES(1, "Prathamesh", "2020-04-8", "High-return", "N" );
insert into Customer VALUES(2, "Aditya", "2020-03-15", "Low-return", "N" );
insert into Customer VALUES(3, "Sourav", "2020-03-12", "High-return", "N" );
insert into Customer VALUES(4, "Rajesh", "2020-03-1", "Low-return", "N" );
insert into Customer VALUES(5, "Suman", "2020-03-27", "Low-return", "N" );

delimiter @@
select * from Customer@@

CREATE TRIGGER fine_update
BEFORE UPDATE ON Customer
FOR EACH ROW
BEGIN
    declare myFine INT;
    declare myDate date;
    declare myStatus VARCHAR(10);
    declare days int;
    declare diff int;

    select DateOfPayment into myDate FROM Customer where Cust_id = old.CUST_id;
    SELECT Status into myStatus FROM Customer where Cust_id = old.CUST_id;
    select DATEDIFF(CURDATE() , myDate) into diff;

    IF myStatus="N" THEN
        IF diff>15 AND diff<=30 THEN
            set myFine = 5*diff;
        END IF;
        IF diff>30 THEN
            set myFine = 50*(diff-30) + 75;
        END IF;

        INSERT INTO Fine VALUES(old.Cust_id, myDate, myFine);
    END IF;
END @@
delimiter ;

UPDATE Customer SET Status="P" WHERE Name="Prathamesh";