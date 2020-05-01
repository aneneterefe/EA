package cs544.exercise16_2;

import java.io.IOException;

import javax.management.RuntimeErrorException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {

	private SessionFactory sf;
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO implement actual session in view filter code
			Transaction tx=null;
			try {
				tx=sf.getCurrentSession().beginTransaction();
				// pass the request along the filter chain
				System.out.println("receiving request");
				chain.doFilter(request, response);
				System.out.println("sending response");
				tx.commit();
			}catch (RuntimeException e) {
				// TODO: handle exception
				try{
					e.printStackTrace();
					tx.rollback();
				}catch (RuntimeException e2) {
					// TODO: handle exception
					System.out.println("Could not roll back"+ e2);
					e2.printStackTrace();
				}
				throw e;
			}
	}

	public void destroy() {
	}

	public void init(FilterConfig arg0) throws ServletException {
		sf=HibernateUtil.getSessionFactory();
	}
}
