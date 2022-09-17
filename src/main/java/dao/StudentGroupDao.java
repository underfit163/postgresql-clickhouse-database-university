package dao;

import entities.Studentgroup;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class StudentGroupDao extends AbstractDao<Studentgroup> {
    @Override
    public Studentgroup findByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Studentgroup.class,id);
        }
    }

    @Override
    public void deleteByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Studentgroup.class,id));
            transaction.commit();
        }
    }

    @Override
    public List<Studentgroup> selectAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("From Studentgroup order by sudentgroupid", Studentgroup.class).list();
        }
    }
}
