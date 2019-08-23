package com.example.aopdemo.inter;

import android.content.Context;
/**
 * author : xia chen hui
 * email : 184415359@qq.com
 * date : 2019/8/23/023 21:20
 * desc : 登录状态接口
 *
**/
public interface ASILogin {

    void login(Context applicationContext,int userDefine);

    boolean isLogin(Context applicationContext);

    void clearLoginStatus(Context applicationContext);
}
