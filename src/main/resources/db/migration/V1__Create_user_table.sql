--drop table IF EXISTS `userEntity`;
--drop table IF EXISTS `role`;
--drop table IF EXISTS `user_role`;
--drop table IF EXISTS `role_permission`;
--drop table IF EXISTS `permission`;

create TABLE `user` (
    `id` bigint(11) NOT NULL AUTO_INCREMENT,
    `user_name` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);
create TABLE `role` (
    `id` bigint(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);
create TABLE `user_role` (
    `user_id` bigint(11) NOT NULL,
    `role_id` bigint(11) NOT NULL
);
--create TABLE `role_permission` (
--    `role_id` bigint(11) NOT NULL,
--    `permission_id` bigint(11) NOT NULL
--);
--create TABLE `permission` (
--    `id` bigint(11) NOT NULL AUTO_INCREMENT,
--    `url` varchar(255) NOT NULL,
--    `name` varchar(255) NOT NULL,
--    `description` varchar(255) NULL,
--    `pid` bigint(11) NOT NULL,
--    PRIMARY KEY (`id`)
--);

insert into user (user_name, password) VALUES ('user','e10adc3949ba59abbe56e057f20f883e');
insert into user (user_name , password) VALUES ('admin','e10adc3949ba59abbe56e057f20f883e');
insert into role (name) values ('ROLE_USER');
insert into role (name) values ('ROLE_ADMIN');
insert into user_role (user_id, role_id) values (1, 1);
insert into user_role (user_id, role_id) values (2, 2);

--insert into permission (id, url, name, pid) values (1,'/**','',0);
--insert into permission (id, url, name, pid) values (2,'/**','',0);

--insert into role_permission (role_id, permission_id) values (1, 1);
--insert into role_permission (role_id, permission_id) values (2, 2);
