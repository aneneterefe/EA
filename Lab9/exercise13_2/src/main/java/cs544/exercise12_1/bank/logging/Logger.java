package cs544.exercise12_1.bank.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class Logger implements ILogger{

	public void log(String logstring) {
	//	java.util.logging.Logger.getLogger("BankLogger").info(logstring);		
	}
	//Log every call to any method in the bank.dao package (using the Logger). 
	@Around("execution(* cs544.exercise12_1.bank.*.*(..))")
	public Object methodcounter(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();

		long totaltime = sw.getLastTaskTimeMillis();
		// print the time to the console
		System.out.println("Time to execute for"+call.getSignature().getName()+" = "+totaltime);
		return retVal;
	}
	
	@After("execution(* *.JMSSender.*(..)) && args(text)")
	public void logjms(JoinPoint jointPoint,String text){
		System.out.println("JMSSender: sending JMS message ="+text);
	}

}
