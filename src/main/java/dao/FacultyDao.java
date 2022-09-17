package dao;

import entities.Faculty;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class FacultyDao extends AbstractDao<Faculty> {
    @Override
    public Faculty findByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Faculty.class,id);
        }
    }

    @Override
    public void deleteByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Faculty.class,id));
            transaction.commit();
        }
    }

    @Override
    public List<Faculty> selectAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("From Faculty order by facultyid", Faculty.class).list();
        }
    }
}
