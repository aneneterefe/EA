package exercise_b;

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

         // Create new instance of Publisher and set values in it
            Publisher p1=new Publisher("publisher 1");
            Publisher p2=new Publisher("publisher 2");
            session.persist(p1);
            session.persist(p2);
         // Create new instance of Book and set values in it
            Book b1=new Book("1232", "Book 1", "Author 1");
            Book b2=new Book("2222", "Book 2", "Author 2");
            session.persist(b1);
            session.persist(b2);
            b1.setPublisher(p2);
            b2.setPublisher(p1);
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

            // retieve all books
            List<Book> bookList = session.createQuery("from Book").list();
            for (Book book : bookList) {
                System.out.println("Book= " + book+ ", Publisher= " + book.getPublisher());
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
