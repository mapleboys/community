CREATE TABLE comment (
	id BIGINT auto_increment NOT NULL COMMENT 'id',
	parent_id BIGINT NULL COMMENT '上级id',
	`type` INT NULL COMMENT '类型：0问题,1评论',
	commentator INT NULL COMMENT '评论人',
	gmt_create BIGINT NULL COMMENT '创建时间',
	gmt_modified BIGINT NULL COMMENT '修改时间',
	like_count BIGINT NULL COMMENT '点赞数',
	content VARCHAR(1024) NULL COMMENT '评论内容',
	PRIMARY KEY (`id`)
)