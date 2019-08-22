package com.example.aopdemo.aspect;

import com.example.aopdemo.inter.ASILogin;
import com.example.aopdemo.utils.LoginAssitant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

public class AOPLoginTraceAspect {
    public AOPLoginTraceAspect() {
    }

    @Pointcut("execution(@com.example.aopdemo.annotation.AOPLoginTrace * *(..))")
    public void LoginTrace() {

    }

    @Around("AOPLoginTrace()")
    public void aroundLogin(ProceedingJoinPoint joinPoint) {



    }
}
