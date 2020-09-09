drop database if exists A5;
create database A5;
use A5;

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

insert into Customer VALUES(1, "Prathamesh", "2000-04-8", "High-return", "Negative" );
insert into Customer VALUES(2, "Aditya", "2000-03-15", "Low-return", "Negative" );
insert into Customer VALUES(3, "Sourav", "2000-03-12", "High-return", "Negative" );
insert into Customer VALUES(4, "Rajesh", "2000-03-1", "Low-return", "Negative" );
insert into Customer VALUES(5, "Suman", "2000-03-27", "Low-return", "Negative" );

select * from Customer;

delimiter @@

create PROCEDURE setFine(IN id int, IN NameOfScheme varchar(20))
    BEGIN
    declare myFine INT;
    declare myDate date;
    declare myStatus VARCHAR(10);
    declare days int;
    declare diff int;
    select DateOfPayment into myDate FROM Customer where Cust_id = id;
    SELECT Status into myStatus FROM Customer where Cust_id = id;
    select DATEDIFF(CURDATE() , myDate) into diff;

    declare exit handler for 1062
    select 'Error : Duplicate' as message;

    declare exit handler for not found
    select 'Error :  Record not found' as message;

    IF myStatus="Negative" THEN
        IF diff>15 AND diff<=30 THEN
            set myFine = 5*diff;
        END IF
        IF diff>30 THEN
            set myFine = 50*(diff-30) + 150;
        END IF

        INSERT INTO Fine VALUES(id, myDate, myFine);
        UPDATE Customer set Status="Positive" where Cust_id = id;

    END IF;
END;
@@







