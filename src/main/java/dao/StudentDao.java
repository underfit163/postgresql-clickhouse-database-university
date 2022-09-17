package dao;

import entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class StudentDao extends AbstractDao<Student> {
    @Override
    public Student findByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Student.class,id);
        }
    }

    @Override
    public void deleteByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Student.class,id));
            transaction.commit();
        }
    }

    @Override
    public List<Student> selectAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("From Student order by studentid", Student.class).list();
        }
    }
}
