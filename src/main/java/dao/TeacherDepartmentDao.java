package dao;

import entities.Teacherdepartment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class TeacherDepartmentDao extends AbstractDao<Teacherdepartment> {
    @Override
    public Teacherdepartment findByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Teacherdepartment.class,id);
        }
    }

    @Override
    public void deleteByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Teacherdepartment.class,id));
            transaction.commit();
        }
    }

    @Override
    public List<Teacherdepartment> selectAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("From Teacherdepartment order by teacherdepartmentid", Teacherdepartment.class).list();
        }
    }


}
