create database if not exists Servlet charset utf8;
use Servlet;

create table message(
    `from` varchar(20),
    `to` varchar(20),
    massage varchar(128)
);