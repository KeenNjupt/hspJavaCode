--查看所有的存储引擎
show engines;
--MyISAM 不支持事务,也不支持外键,但访问速度快
--InnoDB支持事务,是事务安全型的,与MyISAM相比写的效率较低,会占用更多的磁盘空间以保留数据和索引
--MEMORY 使用内存来存储表,每个memory表只实际对应一个磁盘文件.数据存放在内存中,默认使用hash索引,服务一旦关闭
--内存回收表中数据就会丢失,但是表结构还在

--MyISAM表 不支持事务,也不支持外键,但访问速度快
use db02;
create table test_myisam(id int) ENGINE MYISAM;
start transaction;
savepoint t1;
insert into test_myisam values(1);
select * from test_myisam;
--myisam不支持事务,回滚时会产生warning
rollback to t1;
select * from test_myisam;

--MEMORY 使用内存来存储表,每个memory表只实际对应一个磁盘文件.数据存放在内存中,默认使用hash索引,服务一旦关闭
create table test_memory(id int) ENGINE MEMORY;
insert into test_memory values(1);
select * from test_memory;
--重启mysql服务 命令行执行
net stop mysql
net start mysql
--再查询时数据没了,但表还在
select * from test_memory;

如何选择表的引擎
1.如果你的应用不需要事务,处理的只是基本的CRUD操作.那么MyISAM是不二选择.速度快
2.如果需要支持事务,选择InnoDB.
3.Memory存储引擎就是将数据存储在内存中,由于没有磁盘I/O的等待,速度极快.
但由于是内存存储引擎,所做的任何修改在服务器重启后都将消失.(经典用法用户的在线状态().)

--修改表的存储引擎
alter table table_name ENGINE = 'xx';