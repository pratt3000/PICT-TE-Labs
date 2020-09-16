drop database if exists A1_professor_schema;

create database A1_professor_schema;
use A1_professor_schema;

create table department(dept_id int not null,dept_name varchar(10),primary key(dept_id));
create table professor(prof_id int not null,fname varchar(20),lname varchar(30),dept_id int,designation varchar(30),salary varchar(15),dob varchar(15),email varchar(30),phone varchar(20),city varchar(20),primary key(prof_id),foreign key(dept_id) references department(dept_id) on delete cascade);
create table works( prof_id int, dept_id int, duration varchar(10), foreign key(prof_id) references professor(prof_id) on delete cascade, foreign key(dept_id) references department(dept_id) on delete cascade );
create table shift( prof_id int, shift varchar(20), working_hrs varchar(20), foreign key(prof_id) references professor(prof_id) on delete cascade );

insert into department values(1, "COMP");
insert into department values(2, "IT");
insert into department values(3, "ENTC");

insert into professor values( 1, "Sarang", "Joshi", 1, "Professor", "30000", "1976-02-12", "sajoshi@pict.edu", "3244334321", "Nashik");
insert into professor values( 2, "Rajesh", "Ingle", 1, "Professor", "40000", "1970-08-21", "ringle@pict.edu", "1814223456", "Pune");
insert into professor values( 3, "Girish", "Potdar", 1, "Associate Professor", "50000", "1974-09-16", "gpotdar@pict.edu", "7678223314", "Pune");
insert into professor values( 4, "Khatri", "Indraraj", 2, "Associate Professor", "73200", "1985-01-01", "khatri@pict.edu", "9999923231", "Pune");
insert into professor values( 5, "Sunil", "parasnese", 3, "Professor", "15000", "1971-02-23", "sunilpp@pict.edu", "1814223252", "mumbai");
insert into professor values( 6, "arun", "joshi", 3, "Assistant Professor", "120000", "1961-02-23", "rrk@pict.edu", "1814224252", "aurangabad");
insert into professor values( 7, "dinesh", "mehta", 2, "Assistant Professor", "13000", "2016-01-01", "ronakm@pict.edu", "9814224252", "mumbai");
insert into professor values( 8, "Pralhad", "kulkarni", 1, "Assistant Professor", "90000", "2015-01-01", "pralhadk@pict.edu", "9814224252", "pune");
insert into professor values( 9, "shushil", "Chandak", 2, "Professor", "90000", "1987-02-23", "chandak@pict.edu", "9814224322", "aurangabad");
insert into professor values( 10, "Prashant", "rathod", 3, "Professor", "45000", "1970-02-23", "prashant@pict.edu", "1814223452", "mumbai");

insert into shift values(1,1,"9-3");
insert into shift values(2,2,"9-3");
insert into shift values(3,1,"9-3");
insert into shift values(4,2,"9-3");
insert into shift values(5,2,"8-9");
insert into shift values(6,2,"8-9");
insert into shift values(7,1,"8-9");
insert into shift values(8,1,"9-6");
insert into shift values(9,1,"9-5");
insert into shift values(10,1,"9-5");

insert into works values(1,1,6);
insert into works values(2,2,7);
insert into works values(3,1,7);
insert into works values(4,2,9);
insert into works values(5,2,9);
insert into works values(6,3,10);
insert into works values(7,3,5);
insert into works values(8,3,8);
insert into works values(9,2,8);
insert into works values(10,1,8);

select *from professor;
select *from department;
select *from shift;
select *from works;
