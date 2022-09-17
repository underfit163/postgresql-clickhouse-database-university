package dao;

import entities.Subject;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class SubjectDao extends AbstractDao<Subject>{
    @Override
    public Subject findByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Subject.class,id);
        }
    }

    @Override
    public void deleteByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Subject.class,id));
            transaction.commit();
        }
    }

    @Override
    public List<Subject> selectAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("From Subject order by subjectid", Subject.class).list();
        }
    }
}
