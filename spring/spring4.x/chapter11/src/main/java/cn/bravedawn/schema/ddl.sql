-- spring4.`user` definition

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `age` int NOT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;