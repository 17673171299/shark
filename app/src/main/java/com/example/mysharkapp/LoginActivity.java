package com.example.mysharkapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

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
                lightoff();
            }
        });
    }


    private void showPopupWindow() {
        //设置ContentView
        View contentView = LayoutInflater.from(this).inflate(R.layout.layout_popupwindow,null);
        popupWindow = new PopupWindow(contentView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        //设置背景图片，必须设置，不然动画没作用
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(true);

        //点击屏幕其他地方弹出框消失
        popupWindow.setOutsideTouchable(true);

        popupWindow.setContentView(contentView);
        //设置各个控件的点击响应事件
        TextView zhuc = (TextView) contentView.findViewById(R.id.tv_zhuc);
        TextView sjdenglu = (TextView)contentView.findViewById(R.id.tv_shuojidenglu);
        TextView quxiao = (TextView)contentView.findViewById(R.id.tv_quxiao);
        zhuc.setOnClickListener(this);
        sjdenglu.setOnClickListener(this);
        quxiao.setOnClickListener(this);
        popupWindow.setOnDismissListener(new poponDismissListener());
        //显示PopupWindow
        View rootview = LayoutInflater.from(LoginActivity.this).inflate(R.layout.activity_login,null);
        popupWindow.showAtLocation(rootview, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL,0,0);
    }


    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.tv_zhuc :{
                Toast.makeText(this, "你点击了注册", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                lighton();
                break;
            }
            case R.id.tv_shuojidenglu:{
                Intent register = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(register);
                popupWindow.dismiss();
                lighton();
                break;
            }
            case R.id.tv_quxiao:{
                popupWindow.dismiss();
                lighton();
                break;
            }
        }


    }

    //设置手机屏幕正常
    private void lighton() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 1f;
        getWindow().setAttributes(lp);
    }

    //设置手机屏幕变暗
    private void lightoff() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.3f;
        getWindow().setAttributes(lp);
    }

    private class poponDismissListener implements PopupWindow.OnDismissListener {
        @Override
        public void onDismiss() {
            lighton();
        }
    }
}
