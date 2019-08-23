package com.example.aopdemo.utils;

import android.content.Context;

import com.example.aopdemo.MyApplication;
import com.example.aopdemo.inter.ASILogin;

/**
 * author : xia chen hui
 * email : 184415359@qq.com
 * date : 2019/8/23/023 8:18
 * desc : 登录帮助类
 **/
public class LoginAssistant {
    private static LoginAssistant loginAssistant;

    public static LoginAssistant getInstance() {
        if (loginAssistant == null) {
            loginAssistant = new LoginAssistant();
        }
        return loginAssistant;
    }


    public ASILogin getLogin() {
        return LoginSDK.getInstance().getLogin();
    }

    public Context getApplicationContext() {
        return LoginSDK.getInstance().getContext();
    }
}
