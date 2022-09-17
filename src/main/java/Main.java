import dao.*;
import entities.*;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        FacultyDao facultyDao = new FacultyDao();
        SpecialtyDao specialtyDao = new SpecialtyDao();
        UgroupDao ugroupDao = new UgroupDao();
        StudentGroupDao studentGroupDao = new StudentGroupDao();
        StudentDao studentDao = new StudentDao();
        MarkDao markDao = new MarkDao();
        ExamDao examDao = new ExamDao();
        SubjectDao subjectDao = new SubjectDao();
        TeacherDepartmentDao teacherDepartmentDao = new TeacherDepartmentDao();
        DepartmentDao departmentDao = new DepartmentDao();

        Teacher teacher1 = new Teacher(
                "Анфиса", Date.valueOf("1994-04-05"), "ж", "доцент",
                "кандидат наук", "4354543", null);
        Teacher teacher2 = new Teacher(
                "Алексей", Date.valueOf("1990-02-05"), "м", "доцент",
                "кандидат наук", "111111", null);
        Teacher teacher3 = new Teacher(
                "Андрей", Date.valueOf("1970-01-05"), "м", "профессор",
                "доктор наук", "222222", null);
        Teacher teacher4 = new Teacher(
                "Юля", Date.valueOf("1995-04-05"), "ж", "доцент",
                "кандидат наук", "433353", teacher1);
        Teacher teacher5 = new Teacher(
                "Елена", Date.valueOf("1984-01-05"), "ж", "доцент",
                "кандидат наук", "2244553", teacher2);
        Teacher teacher6 = new Teacher(
                "Иван", Date.valueOf("1994-04-05"), "м", "доцент",
                "кандидат наук", "43545565", teacher3);
        Teacher teacher7 = new Teacher(
                "Георгий", Date.valueOf("1999-04-22"), "м", "доцент",
                "аспирант", "8885445", teacher6);

        teacherDao.save(teacher1);
        teacherDao.save(teacher2);
        teacherDao.save(teacher3);
        teacherDao.save(teacher4);
        teacherDao.save(teacher5);
        teacherDao.save(teacher6);
        teacherDao.save(teacher7);

        teacherDao.selectAll().forEach(System.out::println);

        Faculty faculty1 = new Faculty("Первый");
        Faculty faculty6 = new Faculty("Шестой");

        facultyDao.save(faculty1);
        facultyDao.save(faculty6);

        Specialty specialty1 = new Specialty("ИВТ", "очная", faculty6);
        Specialty specialty2 = new Specialty("ИБАС", "очная", faculty6);
        Specialty specialty3 = new Specialty("АБВ", "заочная", faculty1);

        specialtyDao.save(specialty1);
        specialtyDao.save(specialty2);
        specialtyDao.save(specialty3);

        Ugroup ugroup1 = new Ugroup(1, 2017, specialty1);
        Ugroup ugroup2 = new Ugroup(2, 2017, specialty1);
        Ugroup ugroup3 = new Ugroup(3, 2017, specialty1);
        Ugroup ugroup4 = new Ugroup(1, 2018, specialty2);
        Ugroup ugroup5 = new Ugroup(1, 2018, specialty3);

        ugroupDao.save(ugroup1);
        ugroupDao.save(ugroup2);
        ugroupDao.save(ugroup3);
        ugroupDao.save(ugroup4);
        ugroupDao.save(ugroup5);

        Student student1 = new Student(
                "Андрей", Date.valueOf("1994-04-05"), "ж", "4354543");
        Student student2 = new Student(
                "Алексей", Date.valueOf("1990-02-05"), "м", "784654");
        Student student3 = new Student(
                "Василиса", Date.valueOf("1999-02-23"), "ж", "765344");
        Student student4 = new Student(
                "Алексей", Date.valueOf("1996-02-05"), "м", "6745343");
        Student student5 = new Student(
                "Лена", Date.valueOf("1997-04-06"), "ж", "4354543");
        Student student6 = new Student(
                "Алексей", Date.valueOf("2000-02-05"), "м", "653565");
        Student student7 = new Student(
                "Лиля", Date.valueOf("2098-02-25"), "ж", "765786");
        Student student8 = new Student(
                "Рома", Date.valueOf("1989-02-05"), "м", "7434334");
        Student student9 = new Student(
                "Саша", Date.valueOf("1994-10-05"), "ж", "655443");
        Student student10 = new Student(
                "Алексей", Date.valueOf("2002-01-07"), "м", "554542");

        studentDao.save(student1);
        studentDao.save(student2);
        studentDao.save(student3);
        studentDao.save(student4);
        studentDao.save(student5);
        studentDao.save(student6);
        studentDao.save(student7);
        studentDao.save(student8);
        studentDao.save(student9);
        studentDao.save(student10);

        Studentgroup studentgroup1 = new Studentgroup(
                Date.valueOf("2017-09-01"), null, ugroup1, student1);
        Studentgroup studentgroup2 = new Studentgroup(
                Date.valueOf("2015-09-01"), null, ugroup1, student2);
        Studentgroup studentgroup3 = new Studentgroup(
                Date.valueOf("2016-09-01"), null, ugroup1, student3);
        Studentgroup studentgroup4 = new Studentgroup(
                Date.valueOf("2019-09-01"), Date.valueOf("2020-09-01"), ugroup2, student4);
        Studentgroup studentgroup5 = new Studentgroup(
                Date.valueOf("2020-09-01"), null, ugroup3, student4);
        Studentgroup studentgroup6 = new Studentgroup(
                Date.valueOf("2020-09-01"), null, ugroup3, student5);
        Studentgroup studentgroup7 = new Studentgroup(
                Date.valueOf("2014-09-01"), Date.valueOf("2016-09-01"), ugroup4, student6);
        Studentgroup studentgroup8 = new Studentgroup(
                Date.valueOf("2018-09-01"), null, ugroup5, student7);
        Studentgroup studentgroup9 = new Studentgroup(
                Date.valueOf("2020-09-01"), null, ugroup5, student8);
        Studentgroup studentgroup10 = new Studentgroup(
                Date.valueOf("2020-09-01"), null, ugroup5, student9);
        Studentgroup studentgroup11 = new Studentgroup(
                Date.valueOf("2020-09-01"), Date.valueOf("2021-09-01"), ugroup1, student10);

        studentGroupDao.save(studentgroup1);
        studentGroupDao.save(studentgroup2);
        studentGroupDao.save(studentgroup3);
        studentGroupDao.save(studentgroup4);
        studentGroupDao.save(studentgroup5);
        studentGroupDao.save(studentgroup6);
        studentGroupDao.save(studentgroup7);
        studentGroupDao.save(studentgroup8);
        studentGroupDao.save(studentgroup9);
        studentGroupDao.save(studentgroup10);
        studentGroupDao.save(studentgroup11);

        Subject subject1 = new Subject("noSql", specialty1);
        Subject subject2 = new Subject("Java", specialty1);
        Subject subject3 = new Subject("OC", specialty1);
        Subject subject4 = new Subject("Мат анализ", specialty2);
        Subject subject5 = new Subject("Кибербезопасность", specialty2);
        Subject subject6 = new Subject("Философия", specialty3);
        Subject subject7 = new Subject("Английский язык", specialty3);
        Subject subject8 = new Subject("BigData", specialty1);
        Subject subject9 = new Subject("Распределенные системы", specialty2);
        Subject subject10 = new Subject("Физика", specialty3);


        subjectDao.save(subject1);
        subjectDao.save(subject2);
        subjectDao.save(subject3);
        subjectDao.save(subject4);
        subjectDao.save(subject5);
        subjectDao.save(subject6);
        subjectDao.save(subject7);
        subjectDao.save(subject8);
        subjectDao.save(subject9);
        subjectDao.save(subject10);

        Exam exam1 = new Exam("экзамен", 54, 1, subject1, teacher1);
        Exam exam2 = new Exam("экзамен", 54, 2, subject2, teacher2);
        Exam exam3 = new Exam("зачет", 28, 2, subject3, teacher3);
        Exam exam4 = new Exam("экзамен", 54, 1, subject4, teacher3);
        Exam exam5 = new Exam("экзамен", 54, 3, subject5, teacher5);
        Exam exam6 = new Exam("зачет", 16, 4, subject6, teacher6);
        Exam exam7 = new Exam("экзамен", 48, 1, subject7, teacher7);
        Exam exam8 = new Exam("зачет", 24, 2, subject8, teacher1);
        Exam exam9 = new Exam("экзамен", 48, 3, subject9, teacher4);
        Exam exam10 = new Exam("зачет", 24, 4, subject10, teacher5);

        examDao.save(exam1);
        examDao.save(exam2);
        examDao.save(exam3);
        examDao.save(exam4);
        examDao.save(exam5);
        examDao.save(exam6);
        examDao.save(exam7);
        examDao.save(exam8);
        examDao.save(exam9);
        examDao.save(exam10);

        Mark mark1 = new Mark("5", Date.valueOf("2019-01-14"), student1, exam1);
        Mark mark2 = new Mark("4", Date.valueOf("2019-01-14"), student2, exam1);
        Mark mark3 = new Mark("3", Date.valueOf("2019-01-14"), student3, exam1);
        Mark mark4 = new Mark("5", Date.valueOf("2020-01-20"), student1, exam2);
        Mark mark5 = new Mark("3", Date.valueOf("2020-01-20"), student2, exam2);
        Mark mark6 = new Mark("2", Date.valueOf("2020-01-20"), student3, exam2);
        Mark mark7 = new Mark("зачет", Date.valueOf("2018-01-14"), student4, exam3);
        Mark mark8 = new Mark("не зачет", Date.valueOf("2018-01-14"), student5, exam3);
        Mark mark9 = new Mark("зачет", Date.valueOf("2018-01-14"), student6, exam3);
        Mark mark10 = new Mark("3", Date.valueOf("2019-06-14"), student7, exam4);
        Mark mark11 = new Mark("4", Date.valueOf("2019-06-14"), student8, exam4);
        Mark mark12 = new Mark("5", Date.valueOf("2019-06-14"), student9, exam4);
        Mark mark13 = new Mark("4", Date.valueOf("2019-06-12"), student1, exam5);
        Mark mark14 = new Mark("2", Date.valueOf("2019-06-12"), student2, exam5);
        Mark mark15 = new Mark("3", Date.valueOf("2019-09-12"), student2, exam5);
        Mark mark16 = new Mark("не зачет", Date.valueOf("2019-01-14"), student4, exam6);
        Mark mark17 = new Mark("зачет", Date.valueOf("2019-02-14"), student5, exam6);
        Mark mark18 = new Mark("4", Date.valueOf("2019-02-14"), student6, exam7);
        Mark mark19 = new Mark("зачет", Date.valueOf("2020-02-14"), student7, exam8);
        Mark mark20 = new Mark("3", Date.valueOf("2021-02-14"), student8, exam9);
        Mark mark21 = new Mark("не зачет", Date.valueOf("2020-02-14"), student9, exam10);
        Mark mark22 = new Mark("зачет", Date.valueOf("2019-02-14"), student10, exam10);

        markDao.save(mark1);
        markDao.save(mark2);
        markDao.save(mark3);
        markDao.save(mark4);
        markDao.save(mark5);
        markDao.save(mark6);
        markDao.save(mark7);
        markDao.save(mark8);
        markDao.save(mark9);
        markDao.save(mark10);
        markDao.save(mark11);
        markDao.save(mark12);
        markDao.save(mark13);
        markDao.save(mark14);
        markDao.save(mark15);
        markDao.save(mark16);
        markDao.save(mark17);
        markDao.save(mark18);
        markDao.save(mark19);
        markDao.save(mark20);
        markDao.save(mark21);
        markDao.save(mark22);

        Department department1 = new Department
                ("Кафедра технологий", "Борис", "8932223", specialty1);
        Department department2 = new Department
                ("Кафедра математики", "Артем", "4345443", specialty1);
        Department department3 = new Department
                ("Кафедра языков", "Федор", "894343", specialty2);
        Department department4 = new Department
                ("Кафедра безопасности", "Надежда", "9434231", specialty2);
        Department department5 = new Department
                ("Кафедра ин. языка", "Павел", "892544", specialty3);

        departmentDao.save(department1);
        departmentDao.save(department2);
        departmentDao.save(department3);
        departmentDao.save(department4);
        departmentDao.save(department5);

        Teacherdepartment teacherdepartment1 =
                new Teacherdepartment(
                        Date.valueOf("2019-06-14"), Date.valueOf("2021-06-14"), "к.т.н", department1, teacher1);
        Teacherdepartment teacherdepartment2 =
                new Teacherdepartment(
                        Date.valueOf("2018-06-14"), null, "к.т.н", department1, teacher2);
        Teacherdepartment teacherdepartment3 =
                new Teacherdepartment(
                        Date.valueOf("2017-06-14"), null, "к.т.н", department2, teacher3);
        Teacherdepartment teacherdepartment4 =
                new Teacherdepartment(
                        Date.valueOf("2016-06-14"), null, "к.т.н", department2, teacher4);
        Teacherdepartment teacherdepartment5 =
                new Teacherdepartment(
                        Date.valueOf("2011-06-14"), null, "к.т.н", department3, teacher5);
        Teacherdepartment teacherdepartment6 =
                new Teacherdepartment(
                        Date.valueOf("2012-06-14"), null, "к.т.н", department3, teacher6);
        Teacherdepartment teacherdepartment7 =
                new Teacherdepartment(
                        Date.valueOf("2010-06-14"), Date.valueOf("2020-06-14"), "к.т.н", department4, teacher7);
        Teacherdepartment teacherdepartment8 =
                new Teacherdepartment(
                        Date.valueOf("2021-06-14"), null, "к.т.н", department4, teacher1);
        Teacherdepartment teacherdepartment9 =
                new Teacherdepartment(
                        Date.valueOf("2012-06-14"), null, "к.т.н", department5, teacher2);
        Teacherdepartment teacherdepartment10 =
                new Teacherdepartment(
                        Date.valueOf("2013-06-14"), null, "к.т.н", department5, teacher3);

        teacherDepartmentDao.save(teacherdepartment1);
        teacherDepartmentDao.save(teacherdepartment2);
        teacherDepartmentDao.save(teacherdepartment3);
        teacherDepartmentDao.save(teacherdepartment4);
        teacherDepartmentDao.save(teacherdepartment5);
        teacherDepartmentDao.save(teacherdepartment6);
        teacherDepartmentDao.save(teacherdepartment7);
        teacherDepartmentDao.save(teacherdepartment8);
        teacherDepartmentDao.save(teacherdepartment9);
        teacherDepartmentDao.save(teacherdepartment10);


        MyQuery myQuery = new MyQuery();


        myQuery.orderByQuery();
        myQuery.havingQuery(0);
        myQuery.joinQuery("Андрей");
        myQuery.recursiveQuery(7);
    }


}
