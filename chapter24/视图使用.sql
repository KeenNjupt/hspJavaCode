--create view view_name as select 语句
-- alter view view_name as select 语句
-- show create view view_name
-- drop view view_name1, view_name2

use db02;
create view emp_view01 as select empno, ename, job, deptno from emp;

select * from emp_view01;

show create view emp_view01;

--创建视图，数据库只会生成一个视图结构文件 视图名.frm
--视图数据变化也会影响到基表，基表数据变化也会影响到视图
update emp_view01 set job = 'MANAGER' where empno = 7369;

select * from emp where empno = 7369;

--视图中再使用视图
create view emp_view02 as select empno, ename from emp_view01;

select * from emp_view02;

--视图的作用
--1. 安全，控制用户访问视图，以隐藏一些保密字段
--2. 灵活，对外提供视图访问，视图到表的映射关系可以灵活变动，相当于对外封装的接口

-- 针对emp，dept，和salgrade张三表．创建一个
-- 视图empview03，可以显示雇员编号雇员名，
-- 雇员部门名称和水级别[即使用三张表，构建一个视图
create view empview03 as
select emp.empno, emp.ename, dept.dname, salgrade.grade
from emp, dept, salgrade
where emp.deptno = dept.deptno and emp.sal >= salgrade.losal
and emp.sal <= salgrade.hisal;