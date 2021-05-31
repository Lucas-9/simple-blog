create database `blog` character set utf8 collate utf8_general_ci;
use `blog`;
drop table if exists `user`;
create table `user`
(
    `id`         bigint(20) not null auto_increment,
    `username`   varchar(64)  default null,
    `avatar`     varchar(255) default null,
    `email`      varchar(64)  default null,
    `password`   varchar(64)  default null,
    `salt`       varchar(64)  default null,
    `created`    timestamp    default current_timestamp,
    `last_login` datetime     default null,
    primary key (`id`)
) engine = innodb auto_increment = 0 default charset = utf8;

drop table if exists `role`;
create table `role`
(
    `id`   int(11)      not null auto_increment,
    `name` varchar(255) not null unique,
    primary key (`id`)
) engine = innodb auto_increment = 0 default charset = utf8;

drop table if exists `inner_user_role`;
create table `inner_user_role`
(
    `id`      int(11) not null auto_increment,
    `user_id` int(11),
    `role_id` int(11),
    primary key (`id`)
) engine = innodb auto_increment = 0 default charset = utf8;

create table `blog`
(
    `id`          bigint(20)   not null auto_increment,
    `user_id`     bigint(20)   not null,
    `title`       varchar(255) not null,
    `description` varchar(255) not null,
    `content`     longtext,
    `created`     timestamp default current_timestamp,
    `last_update` timestamp default current_timestamp on update current_timestamp,
    primary key (`id`)
) engine = innodb auto_increment = 0 default charset = utf8mb4;

insert into `user` (`id`, `username`, `avatar`, `email`, `password`, `salt`, `created`, `last_login`) values ('1', 'lucas', null, '1778410268@qq.com', '38502053a33d42e9eb09c8ea6b335b1f', '55e4a08cffd746f695779b9e4736c458', null, null);

insert into role (id, name) values (1, 'admin');

insert into inner_user_role(user_id, role_id) values (1, 1);
