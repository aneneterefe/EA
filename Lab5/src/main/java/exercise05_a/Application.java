package exercise05_a;

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
            
            Customer c1=new Customer("Customer1", "Customer1");
            Customer c2=new Customer("Customer2", "Customer2");
                     
            Order o1=new Order(new Date());
            Order o2=new Order(new Date());
            Order o3=new Order(new Date());
            
            OrderLine ol1=new OrderLine(1);
            OrderLine ol2=new OrderLine(2);
            OrderLine ol3=new OrderLine(3);
            OrderLine ol4=new OrderLine(4);
            OrderLine ol5=new OrderLine(5);
            OrderLine ol6=new OrderLine(6);
            
            Product p1=new Product("pro1","desc 1");
            Product p2=new Product("pro2","desc 2");
            
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
            ol6.setProduct(p2);
            
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
            List<Customer> cusList = session.createQuery("from Customer").list();
            //poor performance nested loops
            for (Customer cus : cusList) {
                System.out.println("Customer= " +cus+ ", Orders= ");
                for(Order o: cus.getOrders()) {
                	System.out.println(o+ ", OrderLine= ");
                	for(OrderLine ol:o.getOrderLines()) {
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
