create database UNIVERSITIES;
drop table univer;
create table univer(
name varchar(100) not null,
city varchar(30) not null
)

use UNIVERSITIES;
insert into univer values ('BSTU','Minsk');

select * from univer;