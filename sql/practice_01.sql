--  以下题目均采集于 https://zhuanlan.zhihu.com/p/43289968
-- https://www.jianshu.com/p/476b52ee4f1b

-- 1.查询课程编号为“01”的课程比“02”的课程成绩高的所有学生的学号

select Student.*, a.s_score, b.s_score
from Student
         inner join
         (select * from Score where c_id = '02') as a on a.s_id = Student.s_id
         inner join
         (select * from Score where c_id = '01') as b on a.s_id = b.s_id
where a.s_score > b.s_score;


-- 查询平均成绩大于60分的学生的学号和平均成绩 类似的题目
select Score.s_id, avg(Score.s_score)
from Score
group by s_id
having avg(Score.s_score) > 60;

--  查询所有学生的学号、姓名、选课数、总成绩

select S.s_id,
       S.s_name,
       count(*) AS course_num,
       sum(s_score)
from Score
         inner join Student S on Score.s_id = S.s_id
group by Score.s_id;


SELECT s.s_id,
       s.s_name,
       COUNT(sc.c_id)  AS course_num,
       SUM(sc.s_score) AS total_score
FROM Student s
         LEFT JOIN Score sc ON s.s_id = sc.s_id
GROUP BY s.s_id,
         s.s_name;


-- 查询没学过“张三”老师课的学生的学号、姓名


select *
from Student
where s_id not in (select distinct Score.s_id
                   from Score
                            inner join Course C on Score.c_id = C.c_id
                            inner join Teacher T on C.t_id = T.t_id
                   where T.t_name = '张三');



SELECT s.s_id, s.s_name
FROM Student s
WHERE NOT EXISTS(
        SELECT *
        FROM Course c
                 INNER JOIN Teacher t ON c.t_id = t.t_id
                 INNER JOIN Score sc ON c.c_id = sc.c_id
        WHERE s.s_id = sc.s_id
          AND t.t_name = '张三'
    );

-- 查询学过“张三”老师所教的所有课的同学的学号、姓名


SELECT s.s_id, s.s_name
FROM Student s
WHERE NOT EXISTS(
        SELECT c.c_id
        FROM Course c
                 JOIN Teacher t ON c.t_id = t.t_id
        WHERE t.t_name = '张三'
          AND c.c_id NOT IN (
            SELECT c2.c_id
            FROM Course c2
                     JOIN Score sc ON c2.c_id = sc.c_id
            WHERE sc.s_id = '01'
        )
    );



SELECT c.c_id
FROM Course c
         JOIN Teacher t ON c.t_id = t.t_id
WHERE t.t_name = '张三'
  AND c.c_id NOT IN (
    SELECT c2.c_id
    FROM Course c2
             JOIN Score sc ON c2.c_id = sc.c_id
    WHERE sc.s_id = '02'
);


select *
from Student
where s_id in (select distinct Score.s_id
               from Score
                        inner join Course C on Score.c_id = C.c_id
                        inner join Teacher T on C.t_id = T.t_id
               where T.t_name = '张三');


select C.c_id
from Course C
         inner join Teacher T on C.t_id = T.t_id
where T.t_name = '张三';

-- 7、查询学过编号为“01”的课程并且也学过编号为“02”的课程的学生的学号、姓名


select a.s_id, Student.s_name
from (select * from Score where c_id = '01') as a
         inner join (select * from Score where c_id = '02') as b
                    on a.s_id = b.s_id
         inner join Student
                    on Student.s_id = a.s_id;



SELECT s.s_id, s.s_name
FROM Student s
         INNER JOIN Score sc1 ON s.s_id = sc1.s_id
         INNER JOIN Score sc2 ON s.s_id = sc2.s_id
WHERE sc1.c_id = '01'
  AND sc2.c_id = '02';

-- 8、查询课程编号为“02”的总成绩（不重点）

select sum(Score.s_score)
from Score
where c_id = '02';


-- 9、查询所有课程成绩小于60分的学生的学号、姓名
select *
from Score
where s_id = '08';
select *
from Student
where s_id not in (select s_id
                   from Score
                   where s_score >= 60);


-- 10.查询没有学全所有课的学生的学号、姓名(重点)


-- 10.查询没有学全所有课的学生的学号、姓名
select Student.*
from (select s_id, count(*) from Score group by s_id having count(*) < (select count(distinct c_id) from Course)) as b
         inner join Student
                    on Student.s_id = b.s_id
where Student.s_id = b.s_id;

-- 11、查询至少有一门课与学号为“01”的学生所学课程相同的学生的学号和姓名（重点）
select Student.s_id, Student.s_name
from (select distinct s_id from Score where c_id in (select c_id from Score where s_id = '01')) as s
         inner join Student
                    on Student.s_id = s.s_id;


-- 查询至少有一门课与学号为“01”的学生所学课程相同的学生的学号和姓名

select Student.*
from Student
         inner join
     (select distinct s_id from Score where Score.c_id in (select c_id from Score where s_id = '01')) as b
where Student.s_id = b.s_id;

-- 12.查询和“01”号同学所学课程完全相同的其他同学的学号(重点)
select *
from (select s_id, c_id from Score where s_id = '01') as a
         inner join Score on Score.s_id = a.s_id;

-- 12.查询和“01”号同学所学课程完全相同的其他同学的学号(重点)

select s_id
from score
where s_id != '01'
  and s_id not in (
    select s_id from score where c_id not in (select c_id from score where s_id = '01')
)
group by s_id
having count(*) = (select count(*) from score where s_id = '01');

-- 13 查询没学过"张三"老师讲授的任一门课程的学生姓名 和47题一样（重点，能做出来）
select * from Student where s_id not in
( select distinct Score.s_id  from Score
                                         inner join Course C on Score.c_id = C.c_id
                                         inner join Teacher T on C.t_id = T.t_id
    where T.t_name = '张三');

-- 15、查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩（重点）
select  Student.s_id,Student.s_name, avg(s_score) from Student
inner join  Score
on Score.s_id = Student.s_id
where s_score < 60 group by s_id having count(*) > 2;


-- 16、检索"01"课程分数小于60，按分数降序排列的学生信息（和34题重复，不重点）
select distinct S.*, s_score
from Score
inner join Student S on Score.s_id = S.s_id
inner join Course C on Score.c_id = C.c_id
where C.c_name = '数学' and  Score.s_score < 60 order by s_score;


-- 17、按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩(重重点与35一样)

-- 18 查询各科成绩前三名的记录





-- 21 、查询不同老师所教不同课程平均分从高到低显示(不重点)
select distinct S.*, s_score
from Score
         inner join Student S on Score.s_id = S.s_id
         inner join Course C on Score.c_id = C.c_id
group by C.t_id;







-- 46、查询各学生的年龄（精确到月份）
select s_id,
       s_birth,
       ROUND(period_diff(extract(YEAR_MONTH from now()), extract(YEAR_MONTH from s_birth)) / 12) as age
from Student;


-- 48、查询两门以上不及格课程的同学的学号及其平均成绩（还可以，自己写的，答案中没有）

select s_id,count(*),avg(s_score)
from Score
  where s_score < 60
  group by s_id
  having count(*) > 2















