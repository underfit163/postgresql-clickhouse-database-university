package dao;

import entities.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class TeacherDao extends AbstractDao<Teacher> {
    @Override
    public Teacher findByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Teacher.class,id);
        }
    }

    @Override
    public void deleteByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Teacher.class,id));
            transaction.commit();
        }
    }

    @Override
    public List<Teacher> selectAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("From Teacher order by teacherid", Teacher.class).list();
        }
    }
}
