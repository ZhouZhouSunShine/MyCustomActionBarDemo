package com.example.mycustomactionbardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mycustomactionbardemo.view.MyCustomActionBar;

/**
 * Created by 范晋炜 on 2017/9/1 0001.
 * com.example.mycustomactionbardemo
 * SecondActivity
 */


public class SecondActivity extends AppCompatActivity implements MyCustomActionBar.OnIconClickListener {

    private MyCustomActionBar myCustomActionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //显示当前页面布局
        setContentView(R.layout.activity_second);
        myCustomActionBar = (MyCustomActionBar) findViewById(R.id.my_action_bar);
        myCustomActionBar.setOnIconClickListener(this);
    }

    @Override
    public void OnMyActionBarIconClick(View icon) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
