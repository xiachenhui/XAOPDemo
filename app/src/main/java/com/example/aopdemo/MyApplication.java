package com.example.aopdemo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.aopdemo.inter.ASILogin;
import com.example.aopdemo.utils.LoginSDK;
import com.example.aopdemo.utils.PreferenceUtils;

public class MyApplication extends Application {

    private static final String TAG ="XIA";
    @Override
    public void onCreate() {
        super.onCreate();
        LoginSDK.getInstance().init(this, iLogin);
    }

    ASILogin iLogin = new ASILogin() {
        @Override
        public void login(Context applicationContext, int userDefine) {

            switch (userDefine) {
                case 0:
                    Log.d(TAG,"333");
                    Intent intent = new Intent(applicationContext, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    applicationContext.startActivity(intent);
                    break;
                case 1:
                    Toast.makeText(applicationContext, "你还未登录，请登录后执行。", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(applicationContext, "执行失败，因为你还未登录", Toast.LENGTH_SHORT).show();
                    break;
            }

        }

        @Override
        public boolean isLogin(Context applicationContext) {
            boolean aBoolean = PreferenceUtils.getBoolean(PreferenceUtils.ISLOGIN, applicationContext);
            return aBoolean;
        }

        @Override
        public void clearLoginStatus(Context applicationContext) {
            PreferenceUtils.setBoolean(PreferenceUtils.ISLOGIN, false, applicationContext);
        }
    };

}
