package com.example.aopdemo.exception;

import android.util.Log;

/**
 * author : xia chen hui
 * email : 184415359@qq.com
 * date : 2019/8/23/023 8:20
 * desc : 自定义异常，随便处理
 **/
public class NoInitException extends Exception {

    public NoInitException(String message) {
        super(message);
        Log.e("NoInitException", message);
    }


}
