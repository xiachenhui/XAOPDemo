package com.example.aopdemo.aspect;

import android.os.SystemClock;
import android.util.Log;

import com.example.aopdemo.annotation.BehaviorTrace;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Random;

/**
 * 表示面
 */
@Aspect
public class BehaviorTraceAspect {
    //定义切面规则
    //1.在原来的应用中使用注解的地方会放到当前切面进行处理

    //这个注解表示切入点,executions(@注解名 注解用的地方)  *表示所有的地方
    @Pointcut("execution(@com.example.aopdemo.annotation.BehaviorTrace * *(..))")
    public void methodAnnotatesWithBehaviorTrace() {

    }


    //2.对进入切面的内容进行处理

   //@Before 在切入点之前运行
    //@After 在切入点之后运行
    //@Around 在切入点前后都运行
    @Around("methodAnnotatesWithBehaviorTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws  Throwable{
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        String value = methodSignature.getMethod().getAnnotation(BehaviorTrace.class).value();
        SystemClock.sleep(new Random().nextInt(2000));
        long end = System.currentTimeMillis();
        long duration = end - begin;
        Log.d("HeiBai",String.format("%s 功能, %s 类的 %s 方法耗时 %d ms",value,className,methodName,duration));
        return result;

    }

}
