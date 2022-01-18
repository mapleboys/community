alter table question modify creator bigint not null;
alter table comment modify commentator bigint not null;
alter table question modify id bigint NOT NULL AUTO_INCREMENT;
alter table bbs_users modify id bigint NOT NULL AUTO_INCREMENT;