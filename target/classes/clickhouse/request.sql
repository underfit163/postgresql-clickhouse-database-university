insert into university.teacher
    (teacherID, fio, birthday, gender, title, teacherDegree, phone)
values (7, 'Георгий', '1999-04-22', 'м', 'профессор', 'кандидат наук', '89272625');

select * from university.teacher final;

------------------------
insert into university.mark
    (markID, evaluation, passDate, subjectID, examID, sign)
    VALUES
    (22, 5, '2019-02-14', 10, 10, -1),
    (22, 3, '2019-02-20', 10, 10, 1);

select markID, sum(evaluation*sign) from university.mark
group by markID
having sum(sign)>0;

select * from university.mark final;