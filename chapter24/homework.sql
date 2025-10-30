select dname from dept;

select ename, (sal + IFNULL(comm, 0))*13 as '年收入' from emp;

select ename, sal from emp where sal > 2850;

select ename, sal from emp where sal < 1500 or sal > 2850;
select ename, deptno from emp where empno = '7566';
select ename, sal from emp where deptno in (10,30) and sal > 1500 ;
select ename, job from emp where mgr is null ;

select ename, job, hiredate from emp where hiredate between '1991-02-01' and '1991-05-01' order by hiredate;

select ename, sal, comm  from emp where comm is not null order by sal desc;


select ename from emp where deptno = 30;
select ename, empno, deptno from emp where job = 'CLERK';
select ename from emp where comm > sal;
select ename from emp where comm > (sal * 0.6);
select ename from emp where (deptno = 10 and job = 'MANAGER') or (deptno = 20 and job = 'CLERK');
select ename from emp where (deptno = 10 and job = 'MANAGER') or (deptno = 20 and job = 'CLERK') or (job not in ('MANAGER', 'CLERK') and sal >= 2000);
select distinct job from emp where comm is not null;
select ename from emp where comm is  null or (comm is not null and comm < 100);
    select ename from emp where LAST_DAY(hiredate) = DATE_ADD(hiredate, INTERVAL 2 DAY);
select ename from emp where DATE_ADD(hiredate, INTERVAL 12 YEAR) < NOW();

select CONCAT(LCASE(SUBSTRING(ename,1,1)),  SUBSTRING(ename,2)) as ename from emp;
select ename from emp where LENGTH(ename) = 5;

select ename from emp where ename NOT like '%R';
select LEFT(ename, 3) from emp;
select replace(ename, 'A', 'a') from emp;
select ename , hiredate from emp where DATE_ADD(hiredate, INTERVAL 10 YEAR) <= NOW();
select * from emp order by ename;
select ename, hiredate from emp order by hiredate;
select ename, job, sal from emp order by job desc, sal asc;
select ename, YEAR(hiredate) as year, MONTH(hiredate) as month from emp order by month, year ;
select FLOOR(sal/30) from emp;
select ename, hiredate from emp where MONTH(hiredate) = '2';
select ename, hiredate, DATEDIFF(NOW(), hiredate) from emp;
select ename from emp where ename like '%A%';
select  YEAR(NOW()) - YEAR(hiredate) as year,
    MONTH(NOW()) - MONTH(hiredate) as month,
    DAY(NOW()) - DAY(hiredate) as day from emp;

select FLOOR(DATEDIFF(NOW(), hiredate)/365) as year, FLOOR(DATEDIFF(NOW(), hiredate)%365/30) as month, FLOOR(DATEDIFF(NOW(), hiredate)%365%30) as day from emp;

select distinct dept.deptno, dept.dname from emp, dept where emp.deptno = dept.deptno;
select deptno, count(*) as cnt from emp group by deptno having count(*) >= 1;

select ename, sal from emp
where sal > (
select sal from emp where ename = 'SMITH'
);

select e1.ename, e1.hiredate, e1.mgr, e2.hiredate as mgr_hiredate from emp as e1, emp as e2
where e1.mgr = e2.empno and e1.hiredate > e2.hiredate;

select ename, dname from dept left join emp on dept.deptno = emp.deptno;

select ename, dname from  emp left join dept on dept.deptno = emp.deptno where job = 'CLERK';
select job from emp group by job having min(sal) > 1500;
select ename from emp where deptno = (
    select deptno from dept where dname = 'SALES'
    );

select ename, sal from emp where sal >
                                 (
select avg(sal) from emp
);

select * from emp where job = (
    select job from emp where ename = 'SCOTT'
    ) And ename != 'SCOTT';

select * from emp where sal > (
    select max(sal) from emp where deptno = 30
    );

select count(dept.deptno), avg(sal), FORMAT(DATEDIFF(NOW(), avg(hiredate)), 2) from dept left join emp on dept.deptno = emp.deptno group by dept.deptno;

select count(dept.deptno), avg(sal), FORMAT(AVG(DATEDIFF(NOW(), hiredate)), 2) from dept left join emp on dept.deptno = emp.deptno group by dept.deptno;

select ename, dname, sal from emp, dept where emp.deptno = dept.deptno;

-- select count(dept.deptno), dept.dname from dept left join emp on dept.deptno = emp.deptno group by dept.deptno, dept.dname;
select dept.*, tmp.c from dept,(
select count(*) as c, deptno from emp group by deptno) tmp
where dept.deptno = tmp.deptno;

select min(sal), job from emp group by job ;
select min(sal) from emp where job = 'MANAGER';
select 12*(sal + IFNULL(comm, 0)) as total_sal from emp order by total_sal ;



create table class
(
    classid    int primary key COMMENT '班号',
    subject    varchar(10) COMMENT '专业名',
    deptname   varchar(10) COMMENT '系名',
    enrolltime varchar(4) COMMENT '入学年份',
    num        int COMMENT '人数',
    FOREIGN KEY(deptname) REFERENCES department(deptname)
);


create table new_student(
    studentid int primary key COMMENT '学号',
    name varchar(10) NOT NULL COMMENT '姓名',
    age int COMMENT '年龄',
    classid int COMMENT '班号',
    FOREIGN KEY(classid) REFERENCES class(classid)
)

create table department(
    departmentid int primary key COMMENT '系号',
    deptname varchar(10) unique COMMENT '系名'
)

-- 添加测试数据

INSERT INTO department VALUES('001','数学');
INSERT INTO department VALUES('002','计算机');
INSERT INTO department VALUES('003','化学');
INSERT INTO department VALUES('004','中文');
INSERT INTO department VALUES('005','经济');

INSERT INTO class VALUES(101,'软件','计算机',1995,20);
INSERT INTO class VALUES(102,'微电子','计算机',1996,30);
INSERT INTO class VALUES(111,'无机化学','化学',1995,29);
INSERT INTO class VALUES(112,'高分子化学','化学',1996,25);
INSERT INTO class VALUES(121,'统计数学','数学',1995,20);
INSERT INTO class VALUES(131,'现代语言','中文',1996,20);
INSERT INTO class VALUES(141,'国际贸易','经济',1997,30);
INSERT INTO class VALUES(142,'国际金融','经济',1996,14);

INSERT INTO new_student VALUES(8101,'张三',18,101);
INSERT INTO new_student VALUES(8102,'钱四',16,121);
INSERT INTO new_student VALUES(8103,'王玲',17,131);
INSERT INTO new_student VALUES(8105,'李飞',19,102);
INSERT INTO new_student VALUES(8109,'赵四',18,141);
INSERT INTO new_student VALUES(8110,'李可',20,142);
INSERT INTO new_student VALUES(8201,'张飞',18,111);
INSERT INTO new_student VALUES(8302,'周瑜',16,112);
INSERT INTO new_student VALUES(8203,'王亮',17,111);
INSERT INTO new_student VALUES(8305,'董庆',19,102);
INSERT INTO new_student VALUES(8409,'赵龙',18,101);


select * from new_student where name like '李%';
select deptname from class group by deptname having(count(*) > 1);
select department.departmentid, department.deptname from class, department where class.deptname = department.deptname group by department.deptname, department.departmentid having(sum(class.num) > 30);

INSERT INTO department VALUES('006','物理');


START TRANSACTION
update class set num = num -1 where classid = (
    select classid from new_student where name = '张三'
    );
DELETE FROM new_student where name = '张三';
commit;