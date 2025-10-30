jdbc:java database connection

1. 使用java程序访问不同的数据库时，各数据库实现的细节不同，java制定了一系列规范接口
定义了接口的功能，由各数据库厂商实现自己的接口细节，这样对java开发者来说直接使用jdbc接口就可以屏蔽不同厂商带来的差异
2. 各厂商将自己实现的许多接口类打包为一个jar包，该jar包称为驱动
3. jdbc API是一系列的接口，它统一和规范了应用程序与数据库的连接、执行SQL语句，并得到返回结果等各类操作
相关类和接口在java.sql 与 javax.sql 包中

JDBC程序编写步骤
1.注册驱动-加载Driver类
2.获取连接-得到Connection
3.执行增删改查-发送SQL给数据库执行
4.释放资源-关闭相关连接

将jdbc驱动放置到IDEA项目库中
建一个libs目录用于存放驱动，将libs目录右键，add as library

创建测试演员表
use db02;
create table actor(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(32) NOT NULL DEFAULT '',
sex CHAR(1) NOT NULL DEFAULT '女',
borndate DATETIME,
phone VARCHAR(12)
)

SQL注入：
Statement
1．Statement对象 用于执行静态SQL语句井返回其生成的结果的对象
2．在连接建立后．需要对数据库进行访问，执行 命名或是SQL语句，可以通过
Statement[存在sql注入]
PreparedStatement 预处理
CallableStatement 存储过程

4．SQL注入是利用某些系统没有对用户输入的数据进行充分的检查，而在用户输
入数据中注入非法的SQL语句段或命令，恶意攻击数据库。sql_injection.sql
5．要防范SQL注入，只要用PreparedStatement(从Statement扩屐而来）取代
Statement就可以了

SQL注入举例
select * from user where name = 'xx' and password = 'yy';
当xx为 1' or 
yy为 or '1' = '1
下面替换后的语句中的where条件总是为真
select * from user where name = '1' or' and password = 'or '1' = '1';



PreparedStatement执行的SQL语句中的参数用问号
1．PreparedStatement执行的SQL语句中的参数用问号（？）来表示，调用
PreparedStatement对象的setxxx()方法来设置这些参数．setXxx()方法
有两个参数，第一个参数是要设的SQL语句中的参数的索引（从1开始）
第二个是设置的SQL语句中的参数的值
2．调用executeQuery()，返回ResultSet对象
3.调用executeUpdate()：执行更新，包括增删、修改

JDBC API
1. DriverManager类的getConnection(url, user, password) 用来获取连接
2. Connection接口 createStatement()创建Statement对象,preparedStatement()创建
预处理对象
3. Statement接口 executeUpdate(sql) 执行dml语句返回影响行数、executeQuery(sql) 执行查询语句 返回ResultSet对象
execute(sql) 执行任意sql语句返回布尔值，比如用来执行ddl语句
4. PreparedStatement接口 executeUpdate() 执行dml语句返回影响行数、executeQuery() 执行查询语句 返回ResultSet对象
   execute() 执行任意sql语句返回布尔值，比如用来执行ddl语句、setXxx(占位符索引，占位符值) 解决sql注入问题、setObject(占位符索引，占位符值)
5. ResultSet接口 next()向下移动光标，光标一开始在第一行前面，如果后续没有行则返回false
previous()向上移动一行，如果没有上一行则返回false getXxx(int 列数) getXxx(String 列名)获取该行列值，Xxx为类型
   getObject(int 列数) getObject(String 列名) 返回Object对象

JDBC 事务
1. Connection对象创建时，默认是自动提交事务的
2. 可以调用Connection的setAutoCommit(false) 关闭自动提交事务
3. 所有sql语句都执行成功后，调用Connection的commit()方法，提交事务
4. 若有sql语句执行失败，调用Connection的rollback()方法回滚事务

批处理
JDBC执行批量执行sql语句
addBatch() 添加sql
executeBatch() 执行批量sql语句
clearBatch() 清空批处理包语句
JDBC如果在Mysql中使用批处理，要在连接url中添加rewriteBatchedStatements=true
批处理往往和预编译一块使用，减少编译次数和运行次数


数据库连接池
传统连接方式的弊端：
传统的JDBC数据库连接使用DriverManager来获取，每次向数据库建立连接的时候
都要将Connection加载到内存中，再验证IP地址，用户名和 密码（005S-ls时间)
需要数据库连接的时候，就向数据库要求一个，
频繁地进行数据库连接将占用很多的系统资源，容易造成服务器崩溃。
每一次数据库连接，使用完后都得断开，如果程序出现异常而未能关闭
导致数据库内存泄漏，最终将导致重启数据库。

数据库连接简要介绍：
预先在缓冲池中放入一定数量的连接，当需要建立数据库连接时，只需从"缓冲池"中取出一个，使用完毕之后再放回去
数据库连接池负责分配、管理和释放数据库连接池，它允许应用程序重复使用一个现有的数据库连接，而不是重新建立一个
当应用程序向连接池请求的连接数超过最大连接数量时，这些请求将被加入到等待队列中

JDBC定义DataSource接口供厂商实现连接池

直接使用ResultSet的弊端
1. 结果集和Connection是关联的，如果关闭了连接就无法使用结果集了
2. 结果集不利于数据管理，只能用一次，用的时候要保持连接
3. 使用返回信息不方便 getString("name"),这个getString方法不够清晰
希望使用getName

使用设计，将查询结果放入到内存中存放，connection可以断开
根据表的结构定义一个java类，类对象对应表字段 称为Java Bean、POJO、Domain
如actor 表为id、name、borndate、phone
定义类
class Actor{
属性 id、name、borndate、phone
}
一个Actor对象对应actor表的一行记录

将resultSet的记录封装到ArrayList<Actor>中

DAO Database Access Object的引入 数据访问对象
DBUtils+Druid的方法简化了JDBC开发，但仍有以下不足：
1. SQL语句固定，不能通过参数传入，比如查询哪些字段，update哪些字段
2. select 返回值类型不能固定，要使用泛型
3. 涉及表很多，业务需求复杂时，不能只在一个Java类中实现
一个数据库的表对应一个domain JavaBean如Actor类
DAO类负责与数据库交互，有个BasicDao类 负责一些公有操作，如建立数据库连接，CRUD等
一张表对应一个具体的Dao类，如ActorDao负责actor表的操作，继承BasicDao
actor表 - Actor.class(Java bean) - ActorDao

简单目录结构
com.keen.dao_
1. com.keen.dao_.utils //工具类
2. com.keen.dao_.domain //java bean
3. com.keen.dao_.dao //存放XxxDAO BasicDAO
4. com.keen.dao_.test //测试类