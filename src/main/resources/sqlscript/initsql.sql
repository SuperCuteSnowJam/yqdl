drop database yqdl;
create database yqdl;
use yqdl;
create table `user`(
    `id` int unsigned auto_increment comment '用户id',
    `username` varchar(20) not null comment '用户名称',
    `password` varchar(30) not null comment '用户密码',
    `type` char not null comment '用户类型 A:管理员 B:普通用户',
    primary key(id)
)engine=innodb default charset=utf8 comment = '供电站登录人员信息表';

create table `power_station`(
    `id` int auto_increment comment 'id,供电站序号',
    `name` varchar(20) not null unique comment '供电站名称',
    `voltage_level` varchar(20) not null comment '电压等级',
    `desc` varchar(50) comment '供电站描述',
    primary key(id)
)engine=innodb default charset=utf8 comment = '供电站信息表';
insert into `user` values(1,'admin','admin','A');
insert into `power_station` values(1,'长岭站','220kv','');
insert into `power_station` values(2,'红卫站','220kv','');
insert into `power_station` values(3,'海落湾站','220kv','');

CREATE TABLE `power_station_image` (
    `id` int unsigned NOT NULL AUTO_INCREMENT comment '图片ID',
    `origin_name` varchar(100) NOT NULL comment '图片原先名称',
    `file_type` varchar(20) NOT NULL comment '图片类型',
    `file_size` varchar(20) NOT NULL comment '图片大小',
    `file_name` varchar(100) not null comment '图片名称',
    `file_path` varchar(100) not null comment '图片地址',
    `file_desc` varchar(100) DEFAULT NULL comment '图片描述',
    `file_qrcode_path` varchar(100)  not NULL comment '图片二维码地址',
    `power_station_id` int NOT NULL comment '图片所属站点id',
    PRIMARY KEY (`id`),
    UNIQUE KEY `image_name` (`file_name`),
    foreign key(power_station_id) references power_station(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment = '图片信息表';