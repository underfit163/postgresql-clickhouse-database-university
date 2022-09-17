package utils;

import entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Department.class);
                configuration.addAnnotatedClass(Exam.class);
                configuration.addAnnotatedClass(Faculty.class);
                configuration.addAnnotatedClass(Mark.class);
                configuration.addAnnotatedClass(Specialty.class);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Studentgroup.class);
                configuration.addAnnotatedClass(Subject.class);
                configuration.addAnnotatedClass(Teacher.class);
                configuration.addAnnotatedClass(Teacherdepartment.class);
                configuration.addAnnotatedClass(Ugroup.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Exception!" + e);
            }
        }
        return sessionFactory;
    }
}