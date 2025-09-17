-- 事务保证数据的一致性，由一组dml语句组成，该组dml语句要么全部成功，要么全部失败。
-- 如转账就要用事务来处理，用以保证数据的一致性
-- 当执行事务操作时，mysql会在表上加锁，防止其他用户改表的数据
-- start transaction 开始一个事务
-- savepoint 保存点名 设置保存点
-- rollback to 保存点名 回退到该保存点
-- rollback 回退全部dml语句
-- commit 提交事务，所有操作生效，不能回退，会自动删除该事务所定义的所有保存点，结束事务，释放锁
-- 数据生效。其他会话也可以查看到事务提交后的新数据
-- 如果不开始事务，所有dml语句都是默认提交的，即无法回滚
-- mysql事务机制需要innodb存储引擎支持，myisam不支持
-- 开始事务的方式 start transaction、set autocommit=off(将自动提交关闭，即需要显式的commit    )


--创建测试表
CREATE TABLE t27
(
    id   INT,
    name VARCHAR(32)
);

--开始事务
START TRANSACTION
--设置保存点a
SAVEPOINT a
--执行dml操作
insert into t27 values(100,'tom');
select * from t27;
--设置保存点b
SAVEPOINT b
--执行dml操作
insert into t27 values(200,'jack');
select * from t27;

--回退到b
rollback to b
--回退到a
rollback to a

--回退到事务开始
rollback


--事务隔离级别：多个连接开启事务，操作数据库时，数据库系统要负责隔离操作，以保证各个连接在获取数据时的准确性
--不考虑事务隔离时引发的问题：
-- 脏读（dirty read读取到其他事务尚未提交的修改）
-- 不可重复读（non-repeatable read多次同一查询由于其他提交事务的更新和删除操作，导致结果集不同）
-- 幻读（phantom read多次同一查询由于其他提交事务的插入操作，导致结果集不同）、

--mysql事务隔离级别，定义了事务与事务之间的隔离程度
--4种隔离级别
--读未提交(read uncommitted):不加锁读，脏读、不可重复读和幻读都会出现
--读已提交(read committed): 不加锁读，脏读不会出现，不可重复读和幻读都会出现
--可重复读(repeatable read)：不加锁读，脏读和不可重复读不会出现，幻读会出现
-- 可串行化(serializable)：加锁读，脏读、不可重复读和幻读都不会出现

--开两个命令行窗口，分别连接mysql数据库
--A 查看隔离级别
create table account (id INT, name varchar(32), money int);
select @@tx_isolation;
--B 设置隔离级别会 read uncommitted
set session transaction isolation level read uncommitted;
--A B start transaction
start transaction ;
--A

insert into account values(100, 'tom', 1000);
--B 此时可以看到A插入的结果，并且此时A还未提交，脏读

--A
insert into account values(200, 'marry', 2000);
update account set money = 2100 where id = 200;
commit;
--B 此时B可以看到提交后的A update的结果(不可重复读),可以看到A insert 的结果(幻读)
--即 B应该要看到，它连接数据库时的数据库中的数据，其他事务的提交不影响B看到的东西

--再测试 read committed
--B
set session transaction isolation level read committed;
--A B start transaction
start transaction ;

--A

insert into account values(300, 'scott', 8000);
--B 此时不可以看到A插入的结果，并且此时A还未提交，未出现脏读
--A
update account set money = 3300 where id = 200;
commit;
--B 此时B可以看到提交后的A update的结果(不可重复读),可以看到A insert 的结果(幻读)

--再测试 read repeatable
--A B start transaction
start transaction ;

--A

insert into account values(400, 'milan', 8000);
--B 此时不可以看到A插入的结果，并且此时A还未提交，未出现脏读
--A
update account set money = 3600 where id = 200;
commit;
--B 此时B不可以看到提交后的A update的结果(未出现不可重复读),不可以看到A insert 的结果(未出现幻读)

--测试 可串行化 serializable
--B 设置隔离级别为 serializable
set session transaction isolation level serializable;
--A B start transaction
start transaction ;
--A
insert into account values(500, 'keen', 8000);
--B
select * from account; --会卡住，时间长的时候会超时
--再次查询时，一旦Acommit，就会查出结果

--查看当前会话隔离级别
SELECT @@tx_isolation
--查看系统隔离级别
select @@global.tx_isolation
--设置当前会话隔离级别
set session transaction isolation level xx

--设置系统隔离级别
set global transaction isolation level xx
如果要设置mysql全局的隔离级别
my.ini文件添加一行,重启mysql服务,mysql 默认隔离级别会可重复读
transaction-isolation=xxx(READ-UNCOMMITTED)

事务的ACID
Atomicity:原子性 事务操作要么都发生，要么都不发生
Consistency：一致性 事务必须使数据库从一个一致状态变换到另一个一致状态
Isolation：隔离性 多个用户并发访问数据库时，多个事务之间不相互干扰
Durability：持久性 一个事务一旦被提交，它对数据库中数据的改变是永久的，即使数据库故障也不应对其有任何影响














