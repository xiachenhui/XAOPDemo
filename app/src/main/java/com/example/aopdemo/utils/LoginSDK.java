package com.example.aopdemo.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.aopdemo.MyApplication;
import com.example.aopdemo.inter.ASILogin;

public class LoginSDK {

    private static LoginSDK loginSDK;

    public static LoginSDK getInstance() {
        if (loginSDK == null) {
            loginSDK = new LoginSDK();
        }

        return loginSDK;
    }


    public void init(Context applicationContext, ASILogin iLogin) {
        if (iLogin == null) {
            Toast.makeText(applicationContext, "LoginSDK还未初始化!", Toast.LENGTH_SHORT).show();
        }
    }

}
