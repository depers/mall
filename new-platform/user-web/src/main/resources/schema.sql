-- 用户表

create table `member` (
    `id` int(11) not null comment '自增主键',
    `username` varchar(20) not null comment '用户名',
    `password` varchar(100) not null comment '密码',
    `email` varchar(30) not null comment '邮箱'
);


insert into `member` (username, password, email) values ("depers", "fx1212", "dev_fengxiao@163.com");