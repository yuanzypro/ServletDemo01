desc emp;
drop table emp;
create table emp(
empno int(11) primary key auto_increment,
ename varchar(20),
gender varchar(5),
age int(3),
salary double(10,2),
hireDate DATETIME,
deptno int(6)
);


select * from emp;
commit;
insert into emp (ename,gender,age,salary,hireDate,deptno) values ('小红','女',20,2000.00,'2015-07-21 19:31:30',100);
insert into emp (ename,gender,age,salary,hireDate,deptno) values ('肉丝','女',18,8888.88,'2015-07-21 19:31:30',200);
insert into emp (ename,gender,age,salary,hireDate,deptno) values ('接客','男',20,200.00,'2015-07-21 19:31:30',100);
insert into emp (ename,gender,age,salary,hireDate,deptno) values ('老王','男',50,3838.38,'2015-07-21 19:31:30',300);









----------------------------------