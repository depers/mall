CREATE TABLE `role` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `role_name` varchar(4) DEFAULT NULL,
    `type` tinyint(2) DEFAULT NULL,
    `note` varchar(255) DEFAULT NULL,
    `insert_time` datetime DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;