package com.litte.groupon.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.litte.groupon.R;
import com.litte.groupon.SPUtil.SPUtil;


public class SplashActivity extends Activity {

    SPUtil spUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        spUtil = new SPUtil(this);
        //停留几秒 加载资源
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //根据偏好设置中的值
                //根据是否是第一次使用 跳转
//                if (spUtil.isFirst()){
                if (spUtil.isFirst()){
                    //第一次使用--- 则进入新手指导页
                    startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                    spUtil.setFirst(false);
                }else {
                    //非第一次使用---直接进入应用
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
                finish();
            }
        },2000);
    }
}
