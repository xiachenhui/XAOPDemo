package com.example.aopdemo.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.aopdemo.inter.ASILogin;

/**
 * author : xia chen hui
 * email : 184415359@qq.com
 * date : 2019/8/23/023 21:22
 * desc : 登录SDK
 **/
public class LoginSDK {

    private static LoginSDK loginSDK;
    private Context context;

    public Context getContext() {
        return context;
    }

    public ASILogin getLogin() {
        return login;
    }

    private ASILogin login;


    public static LoginSDK getInstance() {
        if (loginSDK == null) {
            loginSDK = new LoginSDK();
        }

        return loginSDK;
    }


    public void init(Context applicationContext, ASILogin iLogin) {
        if (iLogin == null) {
            Toast.makeText(applicationContext, "LoginSDK还未初始化!", Toast.LENGTH_SHORT).show();
            return;
        }
        this.context = applicationContext;
        this.login = iLogin;
    }


}
