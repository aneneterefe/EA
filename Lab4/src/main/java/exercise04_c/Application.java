package exercise04_c;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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

         // Create new instance of School and set values in it
            School s=new School("MUM");
            School sc=new School("Ajou");
            Student s1= new Student("student1", "one");
            Student s2= new Student("student2", "two");
            Student s3= new Student("student3", "three");
            Student s4= new Student("student4", "four");
            
            s.addStudent(s1);
            s.addStudent(s3);
            sc.addStudent(s2);
            sc.addStudent(s4);
            
            session.persist(s);
            session.persist(sc);
           
            session.persist(s1);
            session.persist(s2);
            session.persist(s3);
            session.persist(s4);
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
            System.out.println("A)List of School with their Students");
            List<School> sList = session.createQuery("from School").list();
            for (School s : sList) {
                System.out.println("School= " +s+ ", Students= ");
                for(Student stu: s.getStudents().values())
                	System.out.println(stu);
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
