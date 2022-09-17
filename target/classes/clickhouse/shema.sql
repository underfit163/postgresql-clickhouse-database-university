drop database if exists university;

create database if not exists university;

create table if not exists university.faculty
(
    facultyID   UInt32,
    facultyName String
) engine = MergeTree()
      order by (facultyID);

create table if not exists university.specialty
(
    specialtyID   UInt32,
    specialtyName String,
    educationType String,
    facultyID     UInt32
) engine = MergeTree()
      order by (specialtyID);

create table if not exists university.uGroup
(
    groupID     UInt32,
    groupNumber UInt32,
    groupYear   Date,
    specialtyID UInt32
) engine = MergeTree()
      order by (groupID);

create table if not exists university.student
(
    studentID UInt32,
    fio       String,
    birthday  Nullable(Date),
    gender    String,
    phone     String
) engine = MergeTree()
      order by (studentID);

create table if not exists university.studentGroup
(
    sudentGroupID UInt32,
    inDate        Date,
    outData       Nullable(Date),
    groupID       UInt32,
    studentID     UInt32
) engine = MergeTree()
      order by (sudentGroupID);

create table if not exists university.subject
(
    subjectID   UInt32,
    subjectName String,
    specialtyID UInt32
) engine = MergeTree()
      order by (specialtyID);

create table if not exists university.teacher
(
    teacherID     UInt32,
    fio           String,
    birthday      Date,
    gender        Nullable(String),
    title         String,
    teacherDegree String,
    phone         String
) engine = ReplacingMergeTree()
      order by (teacherID);

create table if not exists university.department
(
    departmentID   UInt32,
    departmentName String,
    headName       String,
    phone          String,
    specialtyID    UInt32
) engine = MergeTree()
      order by (departmentID);

create table if not exists university.teacherDepartment
(
    teacherDepartmentID UInt32,
    inDate              Date,
    outDate             Nullable(Date),
    positionTeacher     Nullable(String),
    departmentID        UInt32,
    teacherID           UInt32
) engine = MergeTree()
      order by (inDate);

create table if not exists university.exam
(
    examID     UInt32,
    passType   String,
    totalHours Nullable(UInt32),
    semester   UInt32,
    subjectID  UInt32,
    teacherID  UInt32
) engine = MergeTree()
      order by (examID);

create table if not exists university.mark
(
    markID     UInt32,
    evaluation UInt8,
    passDate   Date,
    subjectID  UInt32,
    examID     UInt32,
    sign    Int8
) engine = CollapsingMergeTree(sign)
      order by (markID);

