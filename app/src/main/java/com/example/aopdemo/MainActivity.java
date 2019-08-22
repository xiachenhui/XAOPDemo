package com.example.aopdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.aopdemo.annotation.BehaviorTrace;
import com.example.aopdemo.annotation.UserInfoBehaviorTrace;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @UserInfoBehaviorTrace("摇一摇")
    @BehaviorTrace("摇一摇")
    public void shake(View view) {

    }

    @BehaviorTrace("语音消息")
    public void voice(View view) {
    }

    @BehaviorTrace("视频消息")
    public void video(View view) {
    }

    @BehaviorTrace("发送说说")
    public void something(View view) {
    }

    @BehaviorTrace("登录")
    public void login(View view) {
        startActivity(new Intent(this, XTestActivity.class));
    }
}
