package spring.mvc.pj_lyw.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 횡단관심 클래스 - 공통 클래스 => 핵심 관심 출력 메서드의 경과 시간에 대한 로그 출력 클래스
@Configuration
@EnableAspectJAutoProxy
@Aspect
public class LogAop {
	public LogAop() {	}
	
	@Around(value = "execution(* spring.mvc.pj_lyw.controller.*.*(..))")
	public Object loggerAop(ProceedingJoinPoint joinpoint) {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "is start");
		long st = System.currentTimeMillis();
		Object result = null;
		
		try {
			result = joinpoint.proceed(); // 핵심 관심 작동
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + "is end");
			System.out.println(signatureStr + "경과 시간" + (et-st));
		}
		
		return result;
	}
	
	@AfterReturning(pointcut = "execution(* spring.mvc.pj_lyw.dao.*.*(..))",
					returning = "result")
	public void returnAOP(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().toShortString();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		System.out.println("Method " + methodName + " in class " + className + " returned: " + result);
		return;	
	}
	
	@AfterThrowing(pointcut = "execution(* spring.mvc.pj_lyw.service.*.*(..))", 
					throwing = "ex")
	public void exceptionAOP(Exception ex) {
		// 예외 처리 로직
		System.err.println("An exception occurred: " + ex.getMessage());
		ex.printStackTrace();
	}

}
