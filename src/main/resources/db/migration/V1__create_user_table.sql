CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `token` char(36) DEFAULT NULL,
  `gmt_create` bigint DEFAULT NULL,
  `gmt_modified` bigint DEFAULT NULL,
  `bio` varchar(256) DEFAULT NULL,
  `avatar_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3 COMMENT='登录人员信息表'




