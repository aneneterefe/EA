package exercise04_a;

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

         // Create new instance of Employee and set values in it
            Employee e1=new Employee("Employee1", "One");
            Employee e2=new Employee("Employee2", "Two");
            session.persist(e1);
            session.persist(e2);
         // Create new instance of Laptops and set values in it
            Laptop l1= new Laptop("LG", "lgNoteBook");
            Laptop l2= new Laptop("Toshiba", "toshibaNoteBook");
            Laptop l3= new Laptop("Apple", "macNoteBook");
            Laptop l4= new Laptop("Dell", "dellNoteBook");
            l1.setEmployee(e1);
            l2.setEmployee(e1);
            l3.setEmployee(e2);
            l4.setEmployee(e2);

            //set laptops to employee
            session.persist(l1);
            session.persist(l2);
            session.persist(l3);
            session.persist(l4);
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
            System.out.println("A)List of Employee with their laptops");
            List<Employee> empList = session.createQuery("from Employee").list();
            for (Employee emp : empList) {
                System.out.println("Employee= " +emp+ ", Laptops= ");
                for(Laptop l: emp.getLaptops())
                	System.out.println(l);
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
