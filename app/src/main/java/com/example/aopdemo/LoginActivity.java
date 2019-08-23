package com.example.aopdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.aopdemo.utils.PreferenceUtils;

/**
 * author : xia chen hui
 * email : 184415359@qq.com
 * date : 2019/8/23/023 19:36
 * desc : proxy代理方式处理登录
 **/
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        PreferenceUtils.setBoolean(PreferenceUtils.IS_LOGIN, true, this);
        finish();
    }
}
