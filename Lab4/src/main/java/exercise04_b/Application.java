package exercise04_b;

import java.util.Date;
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

         // Create new instance of Passenger and set values in it
            Passenger p1=new Passenger("passenger 1");
            Passenger p2=new Passenger("passenger 2");
         // Create new instance of Flights and set values in it
            Flight f1= new Flight("309", "Iowa", "Ohio", new Date("2020/05/01"));
            Flight f2= new Flight("319", "Chicago", "New york", new Date("2020/06/01"));
            Flight f3= new Flight("300", "USA", "Ethiopia", new Date("2020/09/01"));
            
            p1.addFlight(f1);
            p1.addFlight(f2);
            p2.addFlight(f3);
     
            session.persist(p1);
            session.persist(p2);
           
            session.persist(f1);
            session.persist(f2);
            session.persist(f3);
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
            List<Passenger> pList = session.createQuery("from Passenger").list();
            for (Passenger p : pList) {
                System.out.println("Passenger= " +p+ ", Flights= ");
                for(Flight f: p.getFlights())
                	System.out.println(f);
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
