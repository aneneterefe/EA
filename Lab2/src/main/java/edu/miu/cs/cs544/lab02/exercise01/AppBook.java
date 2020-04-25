package edu.miu.cs.cs544.lab02.exercise01;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppBook {

	private static SessionFactory sessionFactory;

	static {
		// This step will read hibernate.cfg.xml and prepare hibernate for use
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(sr);
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Integer bid1 = null, bid2 = null;// book ids later will be used for delete and update 
		// ----------1. SAVE 3 books
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Book b1 = new Book("Book 1 Title", "ISBN1111", "Author 1", 20.00, new Date("2005/05/22"));
			Book b2 = new Book("Book 2 Title", "ISBN2222", "Author 2", 30.00, new Date("2016/01/22"));
			Book b3 = new Book("Book 3 Title", "ISBN3333", "Author 3", 40.00, new Date("2017/10/25"));
			System.out.println("=========Saving New Book Records=======");
			bid1 = (Integer) session.save(b1);
			bid2 = (Integer) session.save(b2);
			session.persist(b3);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		// ------------2. Retrive ALL Books
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			List<Book> books = session.createQuery("from Book").list();
			System.out.println("======List of Books======");
			books.stream().forEach(System.out::println);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		// ------------3. Update and Delete Books
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			System.out.println("======Get Book 1, and Load Book 2======");
			Book b1 = (Book) session.get(Book.class, bid1);// eager get
			Book b2 = (Book) session.load(Book.class, bid2);/// lazy get for delete
			b1.setPrice(10.32);
			b1.setTitle("Updated Title 1");
			System.out.println("======Update Book 1 and Delete Book 2======");
			session.delete(b2);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		// ------------4. Retrive ALL Books
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			List<Book> books = session.createQuery("from Book").list();
			System.out.println("======List of Books======");
			books.stream().forEach(System.out::println);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
}
