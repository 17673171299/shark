package com.example.mysharkapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private PopupWindow popupWindow;

    private Button weixinlogin;
    private TextView tv_morelogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_morelogin = findViewById(R.id.tv_morelogin);
        //设置点击跳转事件
        tv_morelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });
    }

    private void showPopupWindow() {
        //设置ContentView
        View contentView = LayoutInflater.from(this).inflate(R.layout.layout_popupwindow,null);
        popupWindow = new PopupWindow(contentView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(contentView);
        //设置各个控件的点击响应事件
        TextView zhuc = (TextView) contentView.findViewById(R.id.tv_zhuc);
        TextView sjdenglu = (TextView)contentView.findViewById(R.id.tv_shuojidenglu);
        TextView quxiao = (TextView)contentView.findViewById(R.id.tv_quxiao);
        //显示PopupWindow
        View rootview = LayoutInflater.from(LoginActivity.this).inflate(R.layout.activity_login,null);
        popupWindow.showAtLocation(rootview, Gravity.BOTTOM,0,0);
    }

//    @Override
//    public void onClick(View v) {
//        int id = v.getId();
//        switch (id) {
//            case R.id.tv_zhuc :{
//                Toast.makeText(this, "你点击了注册", Toast.LENGTH_SHORT).show();
//                popupWindow.dismiss();
//            }
//            case R.id.tv_shuojidenglu:{
//                Toast.makeText(this, "你点击了手机登录", Toast.LENGTH_SHORT).show();
//                popupWindow.dismiss();
//            }
//            case R.id.tv_quxiao:{
//                Toast.makeText(this, "你点击了取消", Toast.LENGTH_SHORT).show();
//                popupWindow.dismiss();
//            }
//        }
//    }
}
