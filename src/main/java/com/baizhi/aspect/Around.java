package com.baizhi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class Around {

    /*//配置前置通知
    @Before("execution(* com.baizhi.service.*.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("目标方法执行之前");
    }*/

    //切入点
    @Pointcut("@annotation(Log)")
    public void pointCut(){}
    @After(value ="pointCut()")
    public void before(JoinPoint joinPoint){
        //参数列表
        Object[] args = joinPoint.getArgs();
        //目标方法所在的对象
        Object target = joinPoint.getTarget();
        //代理对象
        Object aThis = joinPoint.getThis();
        //方法对象
        Signature signature = joinPoint.getSignature();
        System.out.println("this is 前置通知");
    }
}
