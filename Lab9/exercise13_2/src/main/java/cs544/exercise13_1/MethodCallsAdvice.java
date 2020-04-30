package cs544.exercise13_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class MethodCallsAdvice {

	@Around("execution(* *.*DAO.*(..))")//any class that ends with DAO
	public Object methodcounter(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();

		long totaltime = sw.getLastTaskTimeMillis();
		// print the time to the console
		System.out.println("Time to execute  save= "+totaltime);
		return retVal;
	}
}
