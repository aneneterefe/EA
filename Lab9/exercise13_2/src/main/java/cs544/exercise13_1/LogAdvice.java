package cs544.exercise13_1;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAdvice {

	// A answer
	/*
	 * @After("execution(public void cs544.exercise13_1.EmailSender.sendEmail(..))")
	 * public void logaftermethod(JoinPoint joinPoint) { System.out.println(new
	 * Date()+" method="+joinPoint.getSignature().getName()); }
	 */

	// B answer
	/*
	 * @After("execution(public void cs544.exercise13_1.EmailSender.sendEmail(..)) && args(email,message)"
	 * ) public void logaftermethod(JoinPoint joinPoint, String email, String
	 * message) { System.out.println(email); System.out.println(new
	 * Date()+" method="+joinPoint.getSignature().getName());
	 * System.out.println("message="+message); }
	 */
	
	// C answer
	@After("execution(public void cs544.exercise13_1.EmailSender.sendEmail(..)) && args(email,message)")
	public void logaftermethod(JoinPoint joinPoint, String email, String message) {
		System.out.println(email);
		System.out.println(new Date() + " method=" + joinPoint.getSignature().getName());
		System.out.println("message= " + message);
		EmailSender es=(EmailSender)joinPoint.getTarget();
		System.out.println("Out going mail server= "+es.outgoingMailServer);
		
	}
	

}
