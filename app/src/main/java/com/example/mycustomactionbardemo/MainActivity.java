package com.example.mycustomactionbardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mycustomactionbardemo.view.MyCustomActionBar;

/**
 * 自定义View  自定义标题栏
 *
 * 首先在values文件夹下创建一个文件 attrs
 */
public class MainActivity extends AppCompatActivity implements MyCustomActionBar.OnIconClickListener {

    private MyCustomActionBar myCustomActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //显示当前页面布局
        setContentView(R.layout.activity_main);
        myCustomActionBar = (MyCustomActionBar) findViewById(R.id.my_action_bar);
        myCustomActionBar.setOnIconClickListener(this);
    }

    @Override
    public void OnMyActionBarIconClick(View icon) {
        startActivity(new Intent(this,SecondActivity.class));
    }
}
