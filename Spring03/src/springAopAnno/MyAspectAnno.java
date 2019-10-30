package springAopAnno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
* @author blw
* @version 创建时间：2019年10月29日 下午4:17:41
* 类说明   切面类：注解的切面类
*/
@Aspect
public class MyAspectAnno {
	
		// 切入点注解：
		@Pointcut(value="execution(* springAopAnno.OrderDao.save(..))")
		private void pointcut1(){}
		@Pointcut(value="execution(* springAopAnno.OrderDao.find(..))")
		private void pointcut2(){}
		
		@Before(value="MyAspectAnno.pointcut1()")
		public void before(){
			System.out.println("前置增强");
		}
		
		// 后置通知:
		@AfterReturning(value="MyAspectAnno.pointcut1()",returning="result")
		public void afterReturning(Object result){
			System.out.println("后置增强");
		}
		
		// 环绕通知:
		@Around(value="MyAspectAnno.pointcut1()")
		public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
			System.out.println("环绕前增强");
			Object obj  = joinPoint.proceed();
			System.out.println("环绕后增强");
			return obj;
		}
		
		// 异常抛出通知:
		@AfterThrowing(value="MyAspectAnno.pointcut2()",throwing="e")
		public void afterThrowing(Throwable e){
			System.out.println("异常抛出========="+e.getMessage());
		}
		
		// 最终通知
		@After(value="MyAspectAnno.pointcut2()")
		public void after(){
			System.out.println("操作完成！");
		}
		
}
