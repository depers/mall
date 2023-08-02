CREATE TABLE `customer`
(
    `id`   int NOT NULL COMMENT 'id',
    `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '名字',
    `age`  int NOT NULL COMMENT '年龄'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;