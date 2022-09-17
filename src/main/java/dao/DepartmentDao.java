package dao;

import entities.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class DepartmentDao extends AbstractDao<Department> {

    @Override
    public Department findByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Department.class,id);
        }
    }

    @Override
    public void deleteByID(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Department.class,id));
            transaction.commit();
        }
    }

    @Override
    public List<Department> selectAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("From Department order by departmentid", Department.class).list();
        }
    }

    /*public List<Composition> selectComposition(int id, double duration) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            String hql = "from Composition c where c.album.idAlbum = :pr1 and c.durationComposition >= :pr2";
            MyQuery<Composition> query = session.createQuery(hql, Composition.class);
            query.setParameter("pr1", id);
            query.setParameter("pr2", duration);
            return query.list();
        }
    }*/
}
