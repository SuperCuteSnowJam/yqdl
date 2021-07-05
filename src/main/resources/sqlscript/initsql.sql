DROP DATABASE YQDL;
CREATE DATABASE YQDL;
USE YQDL;
create table user(
   id INT UNSIGNED auto_increment,
   username varchar(20) not null,
   password varchar(30) not null,
   age INT not null,
   primary key(id)
)charset=utf8;
INSERT INTO USER values(2,'admin','admin',24);
create table power_station(
   id INT UNSIGNED auto_increment,
   power_level varchar(20) not null,
   power_station_name varchar(30) not null,
   primary key(id)
)charset=utf8;
INSERT INTO power_station values(1,'220kv','长岭站');
INSERT INTO power_station values(2,'220kv','红卫站');
INSERT INTO power_station values(3,'220kv','海落湾站');
CREATE TABLE `power_station_image` (
   `id` int unsigned NOT NULL AUTO_INCREMENT,
   `image_name` varchar(20) NOT NULL,
   `image_desc` varchar(100) DEFAULT NULL,
   `power_station_name` varchar(30) NOT NULL,
   `image_info` longblob NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `image_name` (`image_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8