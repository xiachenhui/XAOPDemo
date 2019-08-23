package com.example.aopdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.aopdemo.annotation.AOPLoginTrace;
import com.example.aopdemo.inter.ILogin;
import com.example.aopdemo.utils.LoginAssistant;
import com.example.aopdemo.utils.PreferenceUtils;

import java.lang.reflect.Proxy;

public class XTestActivity extends AppCompatActivity implements ILogin {

    private ILogin proxyLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        proxyLogin = (ILogin) Proxy.newProxyInstance(this.getClassLoader(), new Class[]{ILogin.class}, new MyHandler(this, this));
    }

    //代理方式实现登录检测
    public void me(View view) {
        proxyLogin.toLoin();
    }

    //代理方式实现登录检测
    public void buy(View view) {
        proxyLogin.toLoin();
    }

    //LoginSdk方式实现登录检测
    @AOPLoginTrace()
    public void check(View view) {
        // proxyLogin.toLoin();
        startActivity(new Intent(this, MemberActivity.class));
    }

    @Override
    public void toLoin() {
        startActivity(new Intent(this, MemberActivity.class));
    }

    //LoginSdk方式实现登录检测
    public void loginOut(View view) {
        LoginAssistant.getInstance().getLogin().clearLoginStatus(this);
        finish();
    }
}
