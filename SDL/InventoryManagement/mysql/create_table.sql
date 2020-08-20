drop database if exists bb_accounts;

create database bb_accounts;
use bb_accounts;

create table users(user_name varchar(30),password varchar(30) );
insert into users values("admin", "admin123");

select *from users;
#--dummy entries
#-- source /home/pratt3000/Documents/College Codes/PICT_TE-Labs/SDL/InventoryManagement/mysql/create_table.sql

