create database if not exists java_blog_system charset utf8;

use java_blog_system;

drop table if exists blog;

drop table is exists user;

create table blog (
    blogId int primary key auto_increment,
    title varchar(1024),
    content varchar(4096),
    postTime datetime,
    userId int
);

create table user (
    userId int primary key,
    username varchar(50) unique,   -- 用户名也要求不能重复
    password varchar(50)
);

-- 插入一些测试数据,方便后续进行测试工作
insert into blog values (1, '这是第一篇博客', '# 从今天开始我要认真写代码', now(), 1);
insert into blog values (2, '这是第二篇博客', '# 从昨天开始我要认真写代码', now(), 1);
insert into blog values (3, '这是第三篇博客', '# 从前天开始我要认真写代码', now(), 1);

insert into user values (1,'zhangsan','123');
insert into user values (2,'lisi','123');
