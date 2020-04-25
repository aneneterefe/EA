package exercise_d_and_e;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import exercise_b.Book;
import exercise_c.Course;
import exercise_c.Student;

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

         // Create new instance of Customer and set values in it
            Customer c1=new Customer("customer 1");
            Customer c2=new Customer("customer 2");
            session.persist(c1);
            session.persist(c2);
         // Create new instance of Reservations and set values in it
            Reservation r1=new Reservation(new Date("2020/05/22"));
            Reservation r2=new Reservation(new Date("2020/04/20"));
            Reservation r3=new Reservation(new Date("2020/03/22"));
            Reservation r4=new Reservation(new Date("2020/07/09"));
            
            //add reservations to customer
            c1.addReservation(r1);
            c1.addReservation(r2);
            c2.addReservation(r3);
            c2.addReservation(r4);
            session.persist(r1);
            session.persist(r2);
            session.persist(r3);
            session.persist(r4);
         //Create Book
            Book newbook=new Book("newisbn", "new book to reserve", "author name");
            session.persist(newbook);
            r4.setBook(newbook);
            
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
            
            System.out.println("===============D) List of Customer with Reservations========");
            // retieve all customer
            List<Customer> customerList = session.createQuery("from Customer").list();
            for (Customer customer : customerList) {
                System.out.println("Customer= " + customer+ ", Reservations= ");
                for(Reservation r: customer.getReservations()) {
                	System.out.println(r);
                }
            }
            System.out.println("===============E) List of Reservation with Book========");
            //retirve book reservation
            List<Reservation> rlist=session.createQuery("from Reservation").list();
            for (Reservation reserve : rlist) {
            	if(reserve.getBook()!=null)
            		System.out.println("Reservation= "+reserve+", Book= "+reserve.getBook());
        
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
