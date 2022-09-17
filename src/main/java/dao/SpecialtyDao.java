package dao;

import entities.Specialty;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class SpecialtyDao extends AbstractDao<Specialty> {
    @Override
    public Specialty findByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Specialty.class,id);
        }
    }

    @Override
    public void deleteByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Specialty.class,id));
            transaction.commit();
        }
    }

    @Override
    public List<Specialty> selectAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("From Specialty order by specialtyid", Specialty.class).list();
        }
    }
}
