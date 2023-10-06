create database if not exists Blog_system charset utf8;
use Blog_system;
-- 删除旧表,防止旧表数据对新表的数据的加载造成影响.
drop table if exists user;
drop table if exists blog;
drop table if exists blog_classify;

-- 创建表.

-- 用户表,用户id为主键,用户名不能相同.
create table user(
    userId int primary key auto_increment,
    username varchar(20) unique,
    password varchar(20),
    avatar Blob,
    blog_count int
);

-- 博客表,博客id为主键.
create table blog(
    blogId int primary key auto_increment,
    title varchar(128),
    postTime datetime,
    content varchar(4096),
    userId int,
    classify int
);

-- 博客分类表
create table blog_classify(
    classify int primary key ,
    classname varchar(32),
    brief varchar(128),
    userId int
)

-- 创建测试数据
insert into blog values(1, '这是我的第一篇博客',  now(),'从今天开始我要认真敲代码', 1,null,null);
insert into blog values(2, '这是我的第一篇博客',  now(),'从今天开始我要认真敲代码', 1,null,null);
insert into blog values(3, '这是我的第一篇博客',  now(),'从今天开始我要认真敲代码', 1,null);

insert into user values (1,'momo',123,null,null);
insert into user values (2,'kk',123,null,null);









