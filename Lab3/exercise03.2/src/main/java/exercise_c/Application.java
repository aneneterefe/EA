package exercise_c;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import exercise_b.Book;
import exercise_b.Publisher;

public class Application {

	private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

         // Create new instance of Student and set values in it
            Student s1=new Student("610-00-000", "Student1", "Name1");
            Student s2=new Student("610-00-222", "Student2", "Name2");
            session.persist(s1);
            session.persist(s2);
         // Create new instance of Courses and set values in it
            Course c1=new Course("CS544", "EA");
            Course c2=new Course("CS472", "WAP");
            session.persist(c1);
            session.persist(c2);
            s1.addCourse(c1);
            s1.addCourse(c2);
            s2.addCourse(c1);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // retieve all students
            List<Student> studentList = session.createQuery("from Student").list();
            for (Student student : studentList) {
                System.out.println("Student= " + student+ ", Courses= ");
                for(Course c: student.getCourses()) {
                	System.out.println(c);
                }
            }
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        // Close the SessionFactory (not mandatory)
        sessionFactory.close();
        System.exit(0);
	}
}
