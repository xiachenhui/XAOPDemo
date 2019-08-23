package com.example.aopdemo;

import android.content.Context;
import android.content.Intent;

import com.example.aopdemo.utils.PreferenceUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
    private Object target;
    private Context mContext;

    public MyHandler(Object target, Context mContext) {
        this.target = target;
        this.mContext = mContext;
    }

    /**
     * invoke就是拦截Object对象的所有方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        boolean isLogin = PreferenceUtils.getBoolean(PreferenceUtils.IS_LOGIN, mContext);
        if (isLogin) {
            object= method.invoke(target, args);
        } else {
            mContext.startActivity(new Intent(mContext, LoginActivity.class));
        }
        return object;
    }
}
