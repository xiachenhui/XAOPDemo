package com.example.aopdemo.aspect;

import android.os.SystemClock;
import android.util.Log;

import com.example.aopdemo.annotation.BehaviorTrace;
import com.example.aopdemo.annotation.UserInfoBehaviorTrace;

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
public class UserInfoBehaviorTraceAspect {
    //定义切面规则
    //1.在原来的应用中使用注解的地方会放到当前切面进行处理

    //这个注解表示切入点,executions(@注解名 注解用的地方)  *表示所有的地方
    @Pointcut("execution(@com.example.aopdemo.annotation.UserInfoBehaviorTrace * *(..))")
    public void methodAnnotatesWithUserInfoBehaviorTrace() {

    }


    //2.对进入切面的内容进行处理

    //@Before 在切入点之前运行
    //@After 在切入点之后运行
    //@Around 在切入点前后都运行
    @Around("methodAnnotatesWithUserInfoBehaviorTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();
        //joinPoint可以获取到方法的签名
        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        //通过方法的签名可以获取到className 和methodName
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        //获取注解的值
        String value = methodSignature.getMethod().getAnnotation(UserInfoBehaviorTrace.class).value();
        Log.d("HeiBai",String.format("%s 功能, %s 类的 %s 方法被执行了",value,className,methodName));
        return proceed;

    }

}
