package cs544.exercise13_1;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import cs544.exercise13_1.EmailSender;

@Aspect
@Component
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
		EmailSender es=(EmailSender) joinPoint.getTarget();
		//EmailSender es=(EmailSender)joinPoint.getTarget();
		System.out.println("Out going mail server= "+es.outgoingMailServer);
		
	}
	 @Around("execution(* *.*.*DAO.*(..))")
	    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
	        StopWatch sw = new StopWatch();
	        sw.start(call.getSignature().getName());
	        Object retVal = call.proceed();
	        sw.stop();

	        long totaltime = sw.getLastTaskTimeMillis();
	        System.out.println("Time to execute save = "+totaltime+"ms");

	        return retVal;
	    }
	/*@Around("execution(* *.*DAO.*(..))")//any class that ends with DAO
	public Object methodcounter(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();

		long totaltime = sw.getLastTaskTimeMillis();
		// print the time to the console
		System.out.println("Time to execute  save= "+totaltime);
		return retVal;
	}*/
	

}
