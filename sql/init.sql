drop database demo;
create database  demo;
use demo;



-- 建表
-- 学生表
CREATE TABLE `Student`(
                          `s_id` VARCHAR(20),

                          `s_name` VARCHAR(20) NOT NULL DEFAULT '',
                          `s_birth` VARCHAR(20) NOT NULL DEFAULT '',
                          `s_sex` VARCHAR(10) NOT NULL DEFAULT '',
                          PRIMARY KEY(`s_id`)
);
-- 课程表
CREATE TABLE `Course`(
                         `c_id` VARCHAR(20),
                         `c_name` VARCHAR(20) NOT NULL DEFAULT '',
                         `t_id` VARCHAR(20) NOT NULL,
                         PRIMARY KEY(`c_id`)
);
-- 教师表
CREATE TABLE `Teacher`(
                          `t_id` VARCHAR(20),
                          `t_name` VARCHAR(20) NOT NULL DEFAULT '',
                          PRIMARY KEY(`t_id`)
);
-- 成绩表
CREATE TABLE `Score`(
                        `s_id` VARCHAR(20),
                        `c_id` VARCHAR(20),
                        `s_score` INT(3),
                        PRIMARY KEY(`s_id`,`c_id`)
);
-- 插入学生表测试数据
insert into Student values('01' , '赵雷' , '1990-01-01' , '男');
insert into Student values('02' , '钱电' , '1990-12-21' , '男');
insert into Student values('03' , '孙风' , '1990-05-20' , '男');
insert into Student values('04' , '李云' , '1990-08-06' , '男');
insert into Student values('05' , '周梅' , '1991-12-01' , '女');
insert into Student values('06' , '吴兰' , '1992-03-01' , '女');
insert into Student values('07' , '郑竹' , '1989-07-01' , '女');
insert into Student values('08' , '王菊' , '1990-01-20' , '女');
-- 课程表测试数据
insert into Course values('01' , '语文' , '02');
insert into Course values('02' , '数学' , '01');
insert into Course values('03' , '英语' , '03');

--  教师表测试数据
insert into Teacher values('01' , '张三');
insert into Teacher values('02' , '李四');
insert into Teacher values('03' , '王五');

--  成绩表测试数据
insert into Score values('01' , '01' , 80);
insert into Score values('01' , '02' , 90);
insert into Score values('01' , '03' , 99);
insert into Score values('02' , '01' , 70);
insert into Score values('02' , '02' , 60);
insert into Score values('02' , '03' , 80);
insert into Score values('03' , '01' , 80);
insert into Score values('03' , '02' , 80);
insert into Score values('03' , '03' , 80);
insert into Score values('04' , '01' , 50);
insert into Score values('04' , '02' , 30);
insert into Score values('04' , '03' , 20);
insert into Score values('05' , '01' , 76);
insert into Score values('05' , '02' , 87);
insert into Score values('06' , '01' , 31);
insert into Score values('06' , '03' , 34);
insert into Score values('07' , '02' , 89);
insert into Score values('07' , '03' , 98);


-- 1.查询课程编号为“01”的课程比“02”的课程成绩高的所有学生的学号

select Student.*,a.s_score,b.s_score from
(select * from Score where c_id = '01') as a
inner join
(select * from Score where c_id = '02') as b
on a.s_id = b.s_id
inner join Student on Student.s_id = a.s_id
where a.s_score > b.s_score;


-- 2、查询平均成绩大于60分的学生的学号和平均成绩
select s_id,avg(s_score) from Score
group by s_id
having avg(s_score) > 60;

-- 3、查询所有学生的学号、姓名、选课数、总成绩（不重要）

select S.s_id,S.s_name,count(*),sum(Score.s_score)
from Score
inner join Student S on Score.s_id = S.s_id
group by S.s_id, S.s_name;

-- 4、查询姓“猴”的老师的个数（不重要）

select count(*)
from Teacher
where t_name like '猴%';

-- 5、查询没学过“张三”老师课的学生的学号、姓名（重点）
select * from Student
where s_id not in (
    select distinct Score.s_id  from Score
    inner join Course C on Score.c_id = C.c_id
    inner join Teacher T on C.t_id = T.t_id
    where T.t_name = '张三'
);

-- 6、查询学过“张三”老师所教的所有课的同学的学号、姓名（重点）

SELECT C.s_id
FROM (
         SELECT s.s_id,s.c_id FROM score s
         WHERE s.c_id IN(
             SELECT c_id FROM course c
             INNER JOIN teacher t ON c.t_id=t.t_id
             WHERE t_name ='张三')
     ) C
GROUP BY C.s_id
HAVING COUNT(*) = (
    SELECT COUNT(*)
    FROM Course c
             INNER JOIN Teacher t
                        ON c.t_id = t.t_id
    WHERE t.t_name ='张三'
);

-- 7、查询学过编号为“01”的课程并且也学过编号为“02”的课程的学生的学号、姓名（重点）

select * from
(select * from Score where c_id = '01') as a
inner join
(select * from Score  where c_id = '02') as b
on a.s_id = b.s_id
inner join Student on Student.s_id = a.s_id;



  select s_id from
  (  (select * from Score where c_id = '01')
     union all
     (select * from Score  where c_id = '02')) b
 group by s_id having count(*) =2




-- 8、查询课程编号为“02”的总成绩

select sum(s_score) from
Score
where Score.c_id = '02';

-- 9、查询所有课程成绩小于60分的学生的学号、姓名

select s_id,max(s_score) as max_score from Score
group by s_id
having max(s_score)< 60;


select Score.s_id from Score
where Score.s_score <  60
group by Score.s_id
having count(*) =(select count(distinct Course.c_id) from Course)
























# INSERT INTO t1(id, pattern)
# VALUES(1,'Divot'),
#       (2,'Brick'),
#       (3,'Grid');
#
# INSERT INTO t2(id, pattern)
# VALUES('A','Brick'),
#       ('B','Grid'),
#       ('C','Diamond');
#
# select * from t1;
# select * from t2;