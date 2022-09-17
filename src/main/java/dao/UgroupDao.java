package dao;

import entities.Ugroup;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class UgroupDao extends AbstractDao<Ugroup> {
    @Override
    public Ugroup findByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Ugroup.class,id);
        }
    }

    @Override
    public void deleteByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Ugroup.class,id));
            transaction.commit();
        }
    }

    @Override
    public List<Ugroup> selectAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("From Ugroup order by groupid", Ugroup.class).list();
        }
    }
}
