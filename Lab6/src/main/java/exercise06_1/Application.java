package exercise06_1;

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
            Appointment ap=new Appointment(new Date("2015/05/08"));
            Patient patient=new Patient("John Doe", "100 Main Street", "23114", "Boston");
            Payment pay=new Payment(new Date("2012/06/08"), 100.00);
            Doctor dr=new Doctor("Eye doctor", "Frank", "Brown");
            
            ap.setPatient(patient);
            ap.setPayment(pay);
            ap.setDoctor(dr);
            
            session.persist(ap);
            session.persist(patient);
            session.persist(dr);
            
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
            System.out.println("A)List of Appointment with their details");
            List<Appointment> apList = session.createQuery("from Appointment").list();
            for (Appointment app : apList) {
                System.out.println("Appointment= " +app+ ", Patient= "+app.getPatient()+", Doctor= "+app.getDoctor()+", Payment= "+app.getPayment());
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
