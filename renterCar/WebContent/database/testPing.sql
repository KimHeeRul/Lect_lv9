
drop database rentCar; #드랍 데이터베이스
#create schema 데이터베이스이름;
create database  rentCar;

use rentCar;

create table users(
	code integer primary key auto_increment, 
	id varchar(20) not null,
    pw varchar(20) not null,
    name varchar(20) not null,
    regDate datetime not null default current_timestamp  
);



select * from users;


use rentCar;
create table car(
	no integer primary key auto_increment, 
    name varchar(20) not null,
    company varchar(20) not null,
    price int not null,
    category int  not null,
    rentalfee int not null,
    fuel varchar(20) not null,
    info varchar(50) not null,
    img varchar(50) not null
);

insert into car(name,company,price,category,rentalfee,fuel,info,img)
VALUES (1,1,1,1,30,"연료","설명","rent_1.jpg");
insert into car(name,company,price,category,rentalfee,fuel,info,img)
VALUES (2,1,1,1,30,"연료","설명","rent_2.jpg");
insert into car(name,company,price,category,rentalfee,fuel,info,img)
VALUES (3,1,1,1,30,"연료","설명","rent_3.jpg");
insert into car(name,company,price,category,rentalfee,fuel,info,img)
VALUES (4,1,1,1,30,"연료","설명","rent_4.jpg");
insert into car(name,company,price,category,rentalfee,fuel,info,img)
VALUES (5,1,1,1,30,"연료","설명","rent_5.jpg");

select * from car;

use rentCar;
create table CarReserve(
	reserve_seq integer primary key auto_increment, 
    no int not null,
    id varchar(20) not null,
    qty int not null,
    dday int not null,
    rday varchar(30) not null,
    usein int  not null,
    usewifi int  not null,
	usenavi int  not null,
    price int  not null,
    img  varchar(20) not null,
    name varchar(20) not null
);

insert into CarReserve(no,id,qty,dday,rday,usein,usewifi,usenavi,price,img,name)
VALUES (2,"id",1,1,1,"1",1,1,100,"이미지","이름");

select * from CarReserve;

use rentCar;
create table board(
	code integer primary key auto_increment,
    title varchar(200),
    content varchar(5000),
    id varchar(20),
    password varchar(20),
    view integer default 0,
    likes integer default 0,
    date datetime not null default current_timestamp
    );
    select* from board;


