package com.example.aopdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtils {

    public static String ISLOGIN = "isLogin";
    private static String PREFERENCE_NAME = "XPreference";


    public static boolean getBoolean(String key, Context mContext) {

        SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        boolean aBoolean = sharedPreferences.getBoolean(key, false);
        return aBoolean;

    }

    public static void setBoolean(String key, boolean value, Context mContext) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }
}
