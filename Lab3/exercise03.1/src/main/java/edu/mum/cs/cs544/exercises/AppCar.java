package edu.mum.cs.cs544.exercises;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppCar {

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
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

         // Create new instance of Owner and set values in it
            Owner o1=new Owner("Owner1 Name", "Owner1 Address");
            Owner o2=new Owner("Owner2 Name", "Owner2 Address");
            session.persist(o1);
            session.persist(o2);
         // Create new instance of Car and set values in it
            Car car1 = new Car("BMW", "SDA231", 30221.00);
            car1.setOwner(o2);
            // save the car
            session.persist(car1);
            // Create new instance of Car and set values in it
            Car car2 = new Car("Mercedes", "HOO100", 4088.00);
            car2.setOwner(o1);
            // save the car
            session.persist(car2);
            
            //update owner to check persistence
            o1.setAddress("updated address");
            
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

            // retieve all cars
            @SuppressWarnings("unchecked")
            List<Car> carList = session.createQuery("from Car").list();
            /*for (Car car : carList) {
                System.out.println("brand= " + car.getBrand() + ", year= "
                        + car.getYear() + ", price= " + car.getPrice());
            }*/
            
            //toString is Override on both entity 
            carList.stream().forEach(System.out::println);
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
    
    // Create two car associated with owner
}
