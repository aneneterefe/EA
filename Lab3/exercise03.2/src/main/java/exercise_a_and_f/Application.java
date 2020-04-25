package exercise_a_and_f;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;

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

         // Create new instance of Department and set values in it
            Department d1=new Department("department 1");
            Department d2=new Department("department 2");
            session.persist(d1);
            session.persist(d2);
         // Create new instance of Employee and set values in it
            Employee emp1=new Employee("emp1", d2);
            Employee emp2=new Employee("emp2");
            Employee emp3=new Employee("emp3");
            session.persist(emp1);
            session.persist(emp2);
            session.persist(emp3);
            //set department to employee
            emp1.setDepartment(d1);
            emp2.setDepartment(d2);
            emp3.setDepartment(d1);
         // Create new instance of Offices and set values in it
            Office o1=new Office(205, "McLaughin");
            Office o2=new Office(202, "Veril ..");
            session.persist(o1);
            session.persist(o2);
            //set office to employee
            emp1.setOffice(o1);
            emp2.setOffice(o2);
            emp3.setOffice(o2);;
            
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
            System.out.println("A)List of Employee with their department");
            List<Employee> empList = session.createQuery("from Employee").list();
            for (Employee emp : empList) {
                System.out.println("Employee= " + emp+ ", department= " + emp.getDepartment());
            }
            System.out.println();
            System.out.println("A)List of Department with their employee");
            List<Department> deptList = session.createQuery("from Department").list();
            for (Department dept : deptList) {
                System.out.println("Department= " +dept+ ", Employee= ");
                for(Employee emps: dept.getEmployee())
                	System.out.println(emps);
            }
            System.out.println();
            System.out.println("F)List of Offices with their employee");
            List<Office> officeList = session.createQuery("from Office").list();
            for(Office office: officeList) {
            	System.out.println("Office="+ office+" Employees=");
            	for(Employee e: office.getEmployees())
                	System.out.println(e);
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
