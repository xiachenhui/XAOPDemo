package com.example.aopdemo.utils;

import android.content.Context;

import com.example.aopdemo.MyApplication;
import com.example.aopdemo.inter.ASILogin;

public class LoginAssitant {
    private static LoginAssitant loginAssitant;

    public static LoginAssitant getInstance() {
        if (loginAssitant == null) {
            loginAssitant = new LoginAssitant();
        }
        return loginAssitant;
    }



}
