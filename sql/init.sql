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


-- 10、查询没有学全所有课的学生的学号、姓名(重点)


select Student.* from
(select s_id from Score
 group by s_id
 having count(*) <  (select count(distinct c_id) from Course)) as b
inner join Student
on  Student.s_id = b.s_id;


-- 11、查询至少有一门课与学号为“01”的学生所学课程相同的学生的学号和姓名（重点）

select distinct S.* from
Score
inner join Student S on Score.s_id = S.s_id
where Score.c_id in (select c_id from Score
                     where s_id = '01');


-- 12.查询和“01”号同学所学课程完全相同的其他同学的学号(重点)

select s_id from score
where s_id != '01'
  and s_id not in (
    select s_id from score where c_id not in ( select c_id from score where s_id = '01')
      )
group by s_id
having count(*) = (select count(*) from score where s_id = '01')


select s_id from score
where s_id != '01'
group by s_id
having GROUP_CONCAT(c_id order by c_id) = (select GROUP_CONCAT(c_id order by c_id)  from score
                             where s_id = '01'
                             group by s_id);

-- 13、查询没学过"张三"老师讲授的任一门课程的学生姓名 和47题一样（重点，能做出来）

select * from Student
where s_id not  in (select distinct s_id  from Score
                                                   inner join Course C on Score.c_id = C.c_id
                                                   inner join Teacher T on C.t_id = T.t_id
                    where T.t_name = '张三');

-- 15、查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩（重点）

select Student.*,avg_score from
(select s_id, avg(s_score) avg_score from Score
 where s_score < 60
 group by s_id
 having count(*) <= 2) b
inner join Student
on Student.s_id = b.s_id;

-- 16、检索"01"课程分数小于60，按分数降序排列的学生信息

select S.*,Score.s_score from Score
inner join Student S on Score.s_id = S.s_id
where c_id = '01' and s_score < 60
order by s_score desc



-- 17、按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩(重重点与35一样) todo



-- 18.查询各科成绩最高分、最低分和平均分：以如下形式显示：课程ID，课程name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率 todo



-- 19、按各科成绩进行排序，并显示排名(重点row_number) todo



-- 20、查询学生的总成绩并进行排名（不重点）
select s_id,sum(s_score) from Score
group by s_id
order by  sum(s_score) desc;


-- 21 、查询不同老师所教不同课程平均分从高到低显示(不重点)
select  T.t_id,AVG(Score.s_score) from Score
inner join Course C on Score.c_id = C.c_id
inner join Teacher T on C.t_id = T.t_id
group by T.t_id;

-- 22、查询所有课程的成绩第2名到第3名的学生信息及该课程成绩（重要 25类似） todo



-- 23、使用分段[100-85],[85-70],[70-60],[<60]来统计各科成绩，分别统计各分数段人数：课程ID和课程名称(重点和18题类似) TODO


-- 24、查询学生平均成绩及其名次


--  25、查询各科成绩前三名的记录（不考虑成绩并列情况）


-- 26、查询每门课程被选修的学生数(不重点)
select s_id,count(*) as '数量' from Score
group by s_id;

-- 27、 查询出只有两门课程的全部学生的学号和姓名(不重点)
select Student.* from
(select s_id from Score
 group by s_id having count(*) = 2) as a
inner join Student on Student.s_id = a.s_id;


-- 28、查询男生、女生人数(不重点)
select s_sex,count(*) as count from Student
group by s_sex;

-- 29 查询名字中含有"风"字的学生信息
select *
from Student
where s_name like '%风%';

-- 31、查询1990年出生的学生名单（重点year）
select * from Student where year(s_birth) = 1990


-- 32、查询平均成绩大于等于85的所有学生的学号、姓名和平均成绩
# 太简单了 不做
-- 33、查询每门课程的平均成绩，结果按平均成绩升序排序，平均成绩相同时，按课程号降序排列（不重要）
# 太简单了 不做

-- 34、查询课程名称为"数学"，且分数低于60的学生姓名和分数（不重点）
select S.s_name,Score.s_score from Score
inner join Course C on Score.c_id = C.c_id
inner join Student S on Score.s_id = S.s_id
where Score.s_score < 60 and C.c_name = '数学';



-- 35、查询所有学生的课程及分数情况（重点）todo


-- 36、查询任何一门课程成绩在70分以上的姓名、课程名称和分数（重点）

select S.s_name, C.c_name,Score.s_score from Score
inner join Course C on Score.c_id = C.c_id
inner join Student S on Score.s_id = S.s_id
where  Score.s_score >= 70;



-- 37、查询不及格的课程并按课程号从大到小排列(不重点)
select S.s_name, C.c_id,C.c_name,Score.s_score from Score
inner join Course C on Score.c_id = C.c_id
inner join Student S on Score.s_id = S.s_id
where  Score.s_score < 60 order by C.c_id desc;


-- 38、查询课程编号为03且课程成绩在80分以上的学生的学号和姓名（不重要）
select S.s_id,S.s_name from Score
inner join Course C on Score.c_id = C.c_id
inner join Student S on Score.s_id = S.s_id
where  C.c_id= '03' and Score.s_score >= 80;



-- 39、求每门课程的学生人数（不重要）

select Score.c_id,count(*) student_account from Score
group by Score.c_id;

-- 40、查询选修“张三”老师所授课程的学生中成绩最高的学生姓名及其成绩

select S.*,Score.s_score from Score
inner join Student S on Score.s_id = S.s_id
inner join Course C on Score.c_id = C.c_id
inner join Teacher T on C.t_id = T.t_id
where T.t_name= '张三' order by s_score desc limit 1;



-- 41.查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩 （重点）
select Student.*,c.s_id,c.s_score from
(select a.s_id,a.s_score from
    (select * from Score) as a
        inner join
    (select * from Score) as b
 where a.s_score = b.s_score and a.s_id = b.s_id and a.c_id != b.c_id) as c
inner join Student
on Student.s_id = c.s_id;

-- 43、统计每门课程的学生选修人数（超过5人的课程才统计）。要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列（不重要）
# 太简单了不做了
-- 44、检索至少选修两门课程的学生学号（不重要）
# 太简单了不做了
-- 45、 查询选修了全部课程的学生信息
# 太简单了不做了
-- 47、查询没学过“张三”老师讲授的任一门课程的学生姓名
# 太简单了不做了
-- 48、查询两门以上不及格课程的同学的学号及其平均成绩
# 太简单了不做了
-- 46、查询各学生的年龄


















































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