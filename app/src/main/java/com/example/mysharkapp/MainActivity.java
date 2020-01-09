package com.example.mysharkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //是否是第一次使用
    private Boolean isFirstUse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        //SharedPreferences是用来存储轻量级的数据
        SharedPreferences preferences = getSharedPreferences("isFirstUse",MODE_PRIVATE);
        isFirstUse = preferences.getBoolean("isFirstUse",true);
        /**
         *如果用户不是第一次使用则使用直接调转到显示页面，否则调转到引导页面
         */
        if (isFirstUse){
            startActivity(new Intent(MainActivity.this,HandlerActivity.class));
        }else {
            startActivity(new Intent(MainActivity.this,WelcomActivity.class));
        }
        finish();
        //实例化Editor对象
        SharedPreferences.Editor editor = preferences.edit();
        //存入数据
        editor.putBoolean("isFirstUse", false);
        //提交修改
        editor.commit();

    }

    private void initView() {

    }
}
