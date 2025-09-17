-- mysql数据库中的mysql.user 表记录了用户信息
-- 其中Host字段表示该用户可以从哪个主机登录,localhost表示在本地主机登录
--authentication_string 字段是mysql password函数处理密码后的结果

--创建用户
create user user_name@允许登录的位置 identified by 密码;

--删除用户
drop user user_name@允许登录的位置;


--创建新用户
create user 'hsp_edu'@'localhost' identified by '123456';

select * from mysql.user;

--修改当前用户的密码
set password = password('密码');
--修改其他用户的密码，当前用户需要有修改密码的权限
set password for '用户名'@'允许登录的地址' = password('密码');

--使用hsp_edu用户可以修改自身的密码，但无法修改root用户的密码
set password = password('abcdef');
set password for 'root'@'localhost' = password('abcdef');

--给指定用户赋相应的权限
grant 权限列表 on 库.对象名 to '用户名'@'登录位置' [identified by '密码']
1. 权限列表：多个权限用逗号分割 select,create
grant all on 表示赋予所有权限
2. 库.对象名：*.* 表示所有数据库的所有对象 表，视图，存储过程
库.*表示库中的所有对象
3. identified by 可写可不写，写出时，若该用户存在就是修改密码，若用户不存在就是创建用户

--收回用户权限
revoke 权限列表 on 库.对象名 from '用户名'@'登录位置'
如果上述语句没有生效则执行：flush privileges;

create user 'dqq'@'localhost' identified by '123';
create database testdb;
create table testdb.news(id int);
grant select, insert on testdb.news to 'dqq'@'localhost';
select * from mysql.user;
insert into testdb.news values(123);
select * from testdb.news;
set password for 'dqq'@'localhost' = password('abc');
drop user 'dqq'@'localhost';

--若创建用户时不指定host，则查询mysql.user表示会发现hosts为%，表示可以在所有主机上登录
--create 'username'@'192.168.1.%' 表示用户可以在192.168.1.*网段的所有机器上访问
--删除用户时如果host不是%，需要明确指定主机
create user jack;
select * from mysql.user;

create user 'smith'@'192.168.1.%';

drop user jack; --默认drop user 'jack'@'%'
drop user 'smith'@'192.168.1.%';
