package edu.miu.cs.cs544.lab02.exercise02;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppPerson {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ----------1. SAVE 3 persons
		Long pid1 = null, pid2 = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Person p1 = new Person("FirstName1", "LastName2", new Date("1991/05/22"));
			Person p2 = new Person("FirstName2", "LastName2", new Date("1992/01/22"));
			Person p3 = new Person("FirstName3", "LastName2", new Date("1993/10/25"));
			System.out.println("=========Saving New Person Records=======");
			pid1 = (Long) session.save(p1);
			pid2 = (Long) session.save(p2);
			session.persist(p3);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		// ------------2. Retrive ALL Persons
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			List<Person> persons = session.createQuery("from Person").list();
			System.out.println("======List of Persons======");
			persons.stream().forEach(System.out::println);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		// ------------3. Update and Delete Persons
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			System.out.println("======Get Person 1, and Load Person 2======");
			Person p1 = (Person) session.get(Person.class, pid1);
			Person p2 = (Person) session.load(Person.class, pid2);
			p1.setFirstname("Updated FirstName");
			p1.setLastname("Updated LastName");
			System.out.println("======Update Person 1 and Delete Person 2======");
			session.delete(p2);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		// ------------4. Retrive ALL Persons
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			List<Person> persons = session.createQuery("from Person").list();
			System.out.println("======List of Persons======");
			persons.stream().forEach(System.out::println);
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
