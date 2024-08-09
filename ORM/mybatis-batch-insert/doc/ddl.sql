drop table if exists `user`;
create table `user` (
    `id` bigint not null auto_increment comment '主键id',
    `name` varchar(50) not null default '' comment '姓名',
    `age` int not null default '0' comment '年龄',
    `gender` tinyint not null default '1' comment '性别，1-男，2-女',
    `phone` varchar(20) not null default '' comment '手机号',
    `family_address` varchar(200) not null default '' comment '家庭住址',
    `email` varchar(50) not null default '' comment '邮箱',
    `marital_status` tinyint not null default '0' comment '婚姻状态，0-未婚，1-已婚',
    `date_of_birth` varchar(10) not null default '1970-01-01' comment '出生日期',
    `education_background` tinyint not null default '1' comment '学历，0-大专，1-本科，3-硕士，4-博士',
    `create_user` varchar(50) not null default '' comment '插入人员',
    `insert_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_user` varchar(50) not null default '' comment '更新人员',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
)engine = InnoDB comment '用户表';