package com.example.aopdemo.aspect;

import android.content.Context;

import com.example.aopdemo.annotation.AOPLoginTrace;
import com.example.aopdemo.exception.AnnotationException;
import com.example.aopdemo.exception.NoInitException;
import com.example.aopdemo.inter.ASILogin;
import com.example.aopdemo.utils.LoginAssistant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
/**
 * author : xia chen hui
 * email : 184415359@qq.com
 * date : 2019/8/23/023 21:15
 * desc :  登录检测
 *
**/
@Aspect
public class AOPLoginTraceAspect {
    private static final String TAG = "XIA";

    @Pointcut("execution(@com.example.aopdemo.annotation.AOPLoginTrace * *(..))")
    public void AOPLoginTrace() {

    }

    @Around("AOPLoginTrace()")
    public void aroundLogin(ProceedingJoinPoint joinPoint) throws Throwable {
        ASILogin iLogin = LoginAssistant.getInstance().getLogin();
        if (iLogin == null) {
            throw new NoInitException("LoginSDk 没有初始化");
        }
        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new AnnotationException("AOPLoginTrace 只能作用于方法上");
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        AOPLoginTrace loginTrace = methodSignature.getMethod().getAnnotation(AOPLoginTrace.class);
        if (loginTrace == null) {
            return;
        }
        Context context = LoginAssistant.getInstance().getApplicationContext();
        if (iLogin.isLogin(context)) {
            //表示继续执行下一个方法
            joinPoint.proceed();

        } else {
            iLogin.login(context, loginTrace.userDefine());
        }

    }
}
