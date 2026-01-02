package com.authlibrary.configuration;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomLoggingAspect {
	
//	@Around("@annotation(AnnotationConfig)")
//    public Object loginExceutionTime(ProceedingJoinPoint joinPoint, AnnotationConfig logExecution) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        Object result = joinPoint.proceed();
//        long endTime = System.currentTimeMillis();
//        long elapsedTime = endTime - startTime;
//        System.out.println("Elapsed time: " + elapsedTime + " ms");
//        return result;
//    }

}
