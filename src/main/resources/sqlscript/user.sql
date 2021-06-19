create table user(
   id INT UNSIGNED auto_increment,
   username varchar(20) not null,
   password varchar(30) not null,
   age INT not null,
   primary key(id)
)charset=utf8;