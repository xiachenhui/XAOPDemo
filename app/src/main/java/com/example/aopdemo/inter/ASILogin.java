package com.example.aopdemo.inter;

import android.content.Context;

public interface ASILogin {

    void login(Context applicationContext,int userDefine);

    boolean isLogin(Context applicationContext);

    void clearLoginStatus(Context applicationContext);
}
