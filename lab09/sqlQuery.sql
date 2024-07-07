create database USERS_DB;

use USERS_DB;
drop table USERS;
create table USERS(
    login varchar(100) primary key,
	hashPassword varchar(100) not null
    );
    
use USERS_DB;
insert into USERS values ('admin','admin')

use USERS_DB;
select * from USERS;
select * from UNIVER;
