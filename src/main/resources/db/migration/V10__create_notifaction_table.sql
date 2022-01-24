CREATE TABLE notification (
	id BIGINT auto_increment NOT NULL,
	notifier BIGINT NULL,
	receiver BIGINT NULL,
	outerid BIGINT NULL,
	`type` INTEGER NULL,
	gmt_create BIGINT NULL,
	status INTEGER NULL,
	notifier_name varchar(100) NULL,
	primary key(id)
)