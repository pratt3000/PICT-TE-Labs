drop database if exists bb_accounts;

create database bb_accounts;
use bb_accounts;

create table users(user_name varchar(30),password varchar(30) );

--dummy entries
insert into users values("a", "c");
insert into users values("b", "c");
insert into users values("c", "c");