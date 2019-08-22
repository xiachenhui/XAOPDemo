package com.example.aopdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.aopdemo.inter.ILogin;
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

    public void check(View view) {
        proxyLogin.toLoin();
    }

    public void buy(View view) {
        proxyLogin.toLoin();
    }

    public void me(View view) {
        proxyLogin.toLoin();
    }

    @Override
    public void toLoin() {
        startActivity(new Intent(this,MemberActivity.class));

    }

    public void loginOut(View view) {
        PreferenceUtils.setBoolean(PreferenceUtils.ISLOGIN, false, this);
    }
}
