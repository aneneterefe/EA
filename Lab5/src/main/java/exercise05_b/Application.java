package exercise05_b;

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
            
            Customer2 c1=new Customer2("Customer1", "Customer1");
            Customer2 c2=new Customer2("Customer2", "Customer2");
                     
            Order2 o1=new Order2(new Date());
            Order2 o2=new Order2(new Date());
            Order2 o3=new Order2(new Date());
            
            OrderLine2 ol1=new OrderLine2(1);
            OrderLine2 ol2=new OrderLine2(2);
            OrderLine2 ol3=new OrderLine2(3);
            OrderLine2 ol4=new OrderLine2(4);
            OrderLine2 ol5=new OrderLine2(5);
            OrderLine2 ol6=new OrderLine2(6);
            
            Product2 p1=new CD("pro1 cd", "prod 1 desc", "cd artist");
            Product2 p2=new DVD("pro2 dvd", "prod 2 desc", "genre");
            Product2 p3=new Book("pro2 book", "prod 3 desc", "book title");
            
            
            o1.setCustomer(c1);
            o2.setCustomer(c2);
            o3.setCustomer(c2);
            
            o1.addOrderLine(ol1);
            o1.addOrderLine(ol2);
            o2.addOrderLine(ol3);
            o2.addOrderLine(ol4);
            o3.addOrderLine(ol5);
            o3.addOrderLine(ol6);
            
            ol1.setProduct(p1);
            ol2.setProduct(p1);
            ol3.setProduct(p1);
            ol4.setProduct(p2);
            ol5.setProduct(p2);
            ol6.setProduct(p3);
            
            session.persist(c1);
            session.persist(c2);
            
            session.persist(o1);
            session.persist(o2);
            session.persist(o3);
            
            session.persist(ol1);
            session.persist(ol2);
            session.persist(ol3);
            session.persist(ol4);
            session.persist(ol5);
            session.persist(ol6);
            
            session.persist(p1);
            session.persist(p2);
            session.persist(p3);
            
            
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
            System.out.println("A)List of Customer with their orders");
            List<Customer2> cusList = session.createQuery("from Customer2").list();
            //poor performance nested loops
            for (Customer2 cus : cusList) {
                System.out.println("Customer= " +cus+ ", Orders= ");
                for(Order2 o: cus.getOrders()) {
                	System.out.println(o+ ", OrderLine= ");
                	for(OrderLine2 ol:o.getOrderLines()) {
                		System.out.println(ol+ ", Product= "+ol.getProduct());
                	}
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
