--  以下题目均采集于 https://zhuanlan.zhihu.com/p/43289968

-- 1.查询课程编号为“01”的课程比“02”的课程成绩高的所有学生的学号


-- 查询没学过“张三”老师课的学生的学号、姓名
select *
from Student
where s_id not in (select distinct Score.s_id
                   from Score
                            inner join Course C on Score.c_id = C.c_id
                            inner join Teacher T on C.t_id = T.t_id
                   where T.t_name = '张三');

-- 查询学过“张三”老师所教的所有课的同学的学号、姓名
select *
from Student
where s_id in (select distinct Score.s_id
               from Score
                        inner join Course C on Score.c_id = C.c_id
                        inner join Teacher T on C.t_id = T.t_id
               where T.t_name = '张三');


-- 7、查询学过编号为“01”的课程并且也学过编号为“02”的课程的学生的学号、姓名

select *
from Student
where s_id in (select a.s_id
               from (select * from Score where c_id = "01") as a
                        inner join
                        (select * from Score where c_id = "02") as b on a.s_id = b.s_id)

-- 10.查询没有学全所有课的学生的学号、姓名

select Student.*
from Student
         inner join
     (select s_id, count(*) from Score group by s_id having count(*) < (select count(distinct c_id) from Course)) as b
where Student.s_id = b.s_id;

-- 查询至少有一门课与学号为“01”的学生所学课程相同的学生的学号和姓名

select Student.*
from Student
         inner join
     (select distinct s_id from Score  where Score.c_id in (select c_id from Score where s_id= '01') ) as b
where Student.s_id = b.s_id;

-- 12.查询和“01”号同学所学课程完全相同的其他同学的学号(重点)
select * from
            (select s_id,c_id from Score where s_id= '01') as a
    inner join Score on Score.s_id = a.s_id
