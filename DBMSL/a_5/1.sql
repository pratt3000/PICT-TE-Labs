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
create PROCEDURE setFine(IN id int, IN NameOfScheme varchar(20))
BEGIN
    declare myFine INT;
    declare myDate date;
    declare myStatus VARCHAR(10);
    declare days int;
    declare diff int;

    declare exit handler for 1062
    select 'Error : Duplicate' as message;
    declare exit handler for not found
    select 'Error :  Record not found' as message;
    
    select DateOfPayment into myDate FROM Customer where Cust_id = id;
    SELECT Status into myStatus FROM Customer where Cust_id = id;
    select DATEDIFF(CURDATE() , myDate) into diff;

    IF myStatus="N" THEN
        IF diff>15 AND diff<=30 THEN
            set myFine = 5*diff;
        END IF;
        IF diff>30 THEN
            set myFine = 50*(diff-30) + 75;
        END IF;

        INSERT INTO Fine VALUES(id, myDate, myFine);
        UPDATE Customer set Status="P" where Cust_id = id;

    END IF;
END @@
delimiter ;









