drop database demo;
create database  demo;
use demo;

create table Student(SId varchar(10),Sname varchar(10),Sage datetime,Ssex varchar(10));
insert into Student values('01' , '赵雷' , '1990-01-01' , '男');
insert into Student values('02' , '钱电' , '1990-12-21' , '男');
insert into Student values('03' , '孙风' , '1990-12-20' , '男');
insert into Student values('04' , '李云' , '1990-12-06' , '男');
insert into Student values('05' , '周梅' , '1991-12-01' , '女');
insert into Student values('06' , '吴兰' , '1992-01-01' , '女');
insert into Student values('07' , '郑竹' , '1989-01-01' , '女');
insert into Student values('09' , '张三' , '2017-12-20' , '女');
insert into Student values('10' , '李四' , '2017-12-25' , '女');
insert into Student values('11' , '李四' , '2012-06-06' , '女');
insert into Student values('12' , '赵六' , '2013-06-13' , '女');
insert into Student values('13' , '孙七' , '2014-06-01' , '女');



create table Teacher(TId varchar(10),Tname varchar(10));
insert into Teacher values('01' , '张三');
insert into Teacher values('02' , '李四');
insert into Teacher values('03' , '王五');


create table SC(SId varchar(10),CId varchar(10),score decimal(18,1));
insert into SC values('01' , '01' , 80);
insert into SC values('01' , '02' , 90);
insert into SC values('01' , '03' , 99);
insert into SC values('02' , '01' , 70);
insert into SC values('02' , '02' , 60);
insert into SC values('02' , '03' , 80);
insert into SC values('03' , '01' , 80);
insert into SC values('03' , '02' , 80);
insert into SC values('03' , '03' , 80);
insert into SC values('04' , '01' , 50);
insert into SC values('04' , '02' , 30);
insert into SC values('04' , '03' , 20);
insert into SC values('05' , '01' , 76);
insert into SC values('05' , '02' , 87);
insert into SC values('06' , '01' , 31);
insert into SC values('06' , '03' , 34);
insert into SC values('07' , '02' , 89);
insert into SC values('07' , '03' , 98);



create table Course(CId varchar(10),Cname nvarchar(10),TId varchar(10));
insert into Course values('01' , '语文' , '02');
insert into Course values('02' , '数学' , '01');
insert into Course values('03' , '英语' , '03');



select * from sc
where (
          select count(*) from sc as a
          where sc.cid = a.cid and sc.score< a.score
      )< 3;

select *  from sc
inner join SC as a
where sc.cid = a.cid and sc.score< a.score


select course.cname, course.cid,
       sum(case when sc.score<=100 and sc.score>85 then 1 else 0 end)   as "[100-85]",
       sum(case when sc.score<=85 and sc.score>70 then 1 else 0 end) as "[85-70]",
       sum(case when sc.score<=70 and sc.score>60 then 1 else 0 end) as "[70-60]",
       sum(case when sc.score<=60 and sc.score>0 then 1 else 0 end) as "[60-0]"
from sc inner join course  on sc.cid = course.cid
group by course.cid,course.cname;

-- 19 查询每门课程被选修的学生数

select CId,count(*) as count
from SC
group by CId;

-- 20 查询出只选修两门课程的学生学号和姓名
select SC.SId,S.Sname,count(*) from SC
inner join Student S on SC.SId = S.SId
group by Sc.SId,S.Sname
having count(*) = 2;


-- 21.查询男生、女生人数
select Ssex,count(*) from Student
group by Ssex;

-- 21.查询名字中含有「风」字的学生信息
select *  from Student
where Sname like '%风%';

-- 23.查询同名学生名单，并统计同名人数
-- 找到同名的名字并统计个数
select Sname, count(*)  from Student
group by Sname having count(*) > 1;


-- 24.查询 1990 年出生的学生名单
select * from Student
where   year(Sage) = 1990;


-- 25.查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号升序排列

select C.Cname, SC.CId,avg(score) from SC
inner join Course C on SC.CId = C.CId
group by SC.CId,  C.Cname
order by avg(score) desc,SC.CId asc;

-- 26.查询平均成绩大于等于 85 的所有学生的学号、姓名和平均成绩

select SC.SId,S.Sname,avg(SC.score) from SC
inner join Student S on SC.SId = S.SId
group by Sc.SId,S.Sname
having avg(SC.score) >=  85;


--  27 查询课程名称为「数学」，且分数低于 60 的学生姓名和分数
select S.Sname,SC.score from SC
inner join Student S on SC.SId = S.SId
inner join Course C on SC.CId = C.CId
where C.Cname = '数学' and score < 60;

-- 28 查询所有学生的课程及分数情况（存在学生没成绩，没选课的情况）
select Student.*,S.score,C.Cname
from Student
left  join SC S on Student.SId = S.SId
left join Course C on S.CId = C.CId;

-- 29 查询任何一门课程成绩在 70 分以上的姓名、课程名称和分数
select S.Sname,SC.CId,SC.score from SC
 inner join Student S on SC.SId = S.SId
where SC.SId not in (select distinct SC.SId from SC
                     where score < 70)


