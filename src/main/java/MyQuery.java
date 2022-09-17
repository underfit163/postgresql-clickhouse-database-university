import entities.Student;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import utils.HibernateSessionFactory;

import java.util.List;

public class MyQuery {

    public void orderByQuery() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            String hql = "from Student s order by s.gender asc, s.birthday desc";

            Query<Student> query = session.createQuery(hql,Student.class);
            List<Student> rows = query.list();
            rows.forEach(System.out::println);
        }
    }

    public void havingQuery(long countStudent) {
        //Вывести номер группы количество студентов в которых больше или равно countStudent
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            String hql = "SELECT g.groupnumber, count(s.studentid) from Student s join s.studentgroupsByStudentid gs join gs.ugroupByGroupidfk g " +
                    "group by g.groupnumber " +
                    "having count(s.studentid)>= :cs";

            Query query = session.createQuery(hql).setParameter("cs",countStudent);
            List<Object[]> rows = query.list();
            for (Object[] row : rows) {
                System.out.println("Номер группы=" + row[0] + " количество студентов=" + row[1]);
            }
        }
    }

    public void joinQuery(String fio) {
        //По имени студена получить все экзамены которые он сдавал, оценки по ним и имя преподавателя принимающего экзамен
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            String hql = "SELECT s.fio, sub.subjectname, marks.evaluation " +
                    "from Student s " +
                    "join s.marks marks " +
                    "join marks.examByExamidfk exem " +
                    "join exem.subjectBySubjectidfk sub " +
                    "join exem.teacherByTeacheridfk teacher " +
                    "where s.fio like :pr1";

            Query query = session.createQuery(hql);
            query.setParameter("pr1", "%" + fio + "%");
            List<Object[]> rows = query.list();
            for (Object[] row : rows) {
                System.out.println("ФИО=" + row[0] + " предмет=" + row[1] + " оценка=" + row[2]);
            }
        }
    }

    public void recursiveQuery(int idTeacher) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            String sql = "with recursive directors as (" +
                    "select teacherid, fio, director from teacher where teacherid = :id " +
                    "union all " +
                    "select t.teacherid, t.fio, t.director from teacher as t join directors as d on t.teacherid = d.director)" +
                    "select teacherid,fio,director from directors";


            NativeQuery query = session.createSQLQuery(sql).setParameter("id", idTeacher);
            List<Object[]> rows = query.list();

            System.out.println("Выводим всех руководителей для 1 записи");
            int k = 1;
            for (Object[] row : rows) {
                if (k == 2) {
                    System.out.println("Руководители:");
                }
                System.out.println("id=" + row[0] + " fio=" + row[1] + " idDirector=" + row[2]);
                k++;
            }
        }
    }
}
