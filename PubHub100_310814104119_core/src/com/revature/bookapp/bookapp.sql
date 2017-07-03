use users;

select * from users;

create table users(id int auto_increment,
username varchar(10) not null,
password varchar(12) not null,
constraint pk_users_id primary key(id)
);

insert into users(username,password) values("arshi","123"); 
insert into users(username,password) values("arhi","13"); 

select username from  users where username="arshi" and password="123";

select*from books;

create table books(id int auto_increment,
name varchar(20) not null,
price int not null,
constraint pk_books_id primary key(id)
);


insert into books(name,price) values("java",1230); 
insert into books(name,price) values("c",130); 

UPDATE BOOKS SET NAME="javabasic" WHERE ID=1;

UPDATE BOOKS SET PRICE=1234 WHERE ID=1;

DELETE FROM BOOKS WHERE ID=1;

TRUNCATE BOOKS;

SELECT ID,NAME,PRICE FROM BOOKS;

SELECT ID,NAME,PRICE FROM BOOKS WHERE NAME="c";

drop table books;