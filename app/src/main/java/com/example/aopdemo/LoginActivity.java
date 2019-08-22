package com.example.aopdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.aopdemo.utils.PreferenceUtils;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        PreferenceUtils.setBoolean(PreferenceUtils.ISLOGIN,true,this);
        finish();
    }
}
