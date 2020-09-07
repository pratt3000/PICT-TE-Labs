drop database if exists A5;
create database A5;
use A5;

create table Customer(
                    Cust_id int not null,
                    Name varchar(30),
                    DateOfPayment varchar(10),
                    NameOfScheme varchar(20),
                    Status varchar(10),
                    primary key(Cust_id)
                    );

create table Fine(
                    Cust_id int not null,
                    Date varchar(10),
                    Amt int,
                    foreign key(Cust_id) references Customer(Cust_id) on delete cascade
                    );

insert into Customer VALUES(1, "Prathamesh", "2000-04-8", "High-return", "Positive" );
insert into Customer VALUES(2, "Aditya", "2000-03-15", "Low-return", "Positive" );
insert into Customer VALUES(3, "Sourav", "2000-03-12", "High-return", "Negative" );
insert into Customer VALUES(4, "Rajesh", "2000-03-1", "Low-return", "Negative" );
insert into Customer VALUES(5, "Suman", "2000-03-27", "Low-return", "Negative" );

select * from Customer;
-- set date to 2000-03-10
create PROCEDURE setFine(in DateF varchar(10))
                    BEGIN
                    declare myDate int;
                    declare myCost int;
                    set myDate=DateF;
                    if myDate>"2000-03-25" AND myDate<"2000-04-9" THEN
                    myCost=(5*(myDate-"2000-03-25"))
                    -- incomplete, how to compare date??
