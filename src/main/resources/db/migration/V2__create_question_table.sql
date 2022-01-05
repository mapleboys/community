CREATE TABLE `question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `description` text,
  `gmt_create` bigint DEFAULT NULL,
  `gmt_modified` bigint DEFAULT NULL,
  `creator` int DEFAULT NULL,
  `comment_account` int DEFAULT '0',
  `view_account` int DEFAULT '0',
  `like_account` int DEFAULT '0',
  `tag` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3