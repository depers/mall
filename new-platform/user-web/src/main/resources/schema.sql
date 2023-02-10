-- 用户表

-- 用户表
CREATE TABLE `member` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `username` varchar(20) NOT NULL COMMENT '用户名',
    `password` varchar(100) NOT NULL COMMENT '密码',
    `email` varchar(30) NOT NULL COMMENT '邮箱',
    primary key(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '用户表';



insert into `member` (username, password, email) values ("depers", "fx1212", "dev_fengxiao@163.com");