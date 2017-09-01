package com.example.mycustomactionbardemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mycustomactionbardemo.R;

/**
 * Created by 范晋炜 on 2017/9/1 0001.
 * com.example.mycustomactionbardemo.view
 * MyCustomActionBar
 */


public class MyCustomActionBar extends LinearLayout{

    private RelativeLayout container;
    private ImageView icon;
    private TextView title;
    private TypedArray typedArray;
    private int backGround;
    private int titleColor;
    private float titleSize;
    private Drawable iconSrcDrawable;
    private String titleText;

    public MyCustomActionBar(Context context) {
        super(context);
        initView(context,null);
    }

    public MyCustomActionBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        //加载布局
        View inflate = inflate(context, R.layout.my_action_bar_layout,this);
        container = (RelativeLayout) inflate.findViewById(R.id.container);
        //获取资源ID
        icon = (ImageView) inflate.findViewById(R.id.icon);
        title = (TextView) inflate.findViewById(R.id.title);
        icon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnIconClickListener != null){
                    mOnIconClickListener.OnMyActionBarIconClick(v);
                }
            }
        });

        if(attrs == null){
            return;
        }

        initAttrs(context,attrs);
        setViewContent();
    }
    //加载布局各控件的属性
    private void initAttrs(Context context,AttributeSet attrs){
        if(attrs == null){
            return;
        }

        typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCustomActionBar);
        backGround = typedArray.getColor(R.styleable.MyCustomActionBar_action_bar_bg_color, Color.GRAY);
        titleColor = typedArray.getColor(R.styleable.MyCustomActionBar_action_bar_title_text_color, Color.RED);
        titleSize = typedArray.getDimension(R.styleable.MyCustomActionBar_action_bar_title_text_size,16);
        titleText = typedArray.getString(R.styleable.MyCustomActionBar_action_bar_title_text);
        iconSrcDrawable = typedArray.getDrawable(R.styleable.MyCustomActionBar_action_bar_icon_src);
    }

    //设置将加载好的属性
    private void setViewContent(){
        container.setBackgroundColor(backGround);   //设置背景颜色
        icon.setImageDrawable(iconSrcDrawable);     //设置图片
        title.setText(titleText);                   //设置标题文本
        title.setTextColor(titleColor);             //设置文本颜色
        title.setTextSize(titleSize);               //设置文本大小

    }

    //跳转的接口
    public interface OnIconClickListener{
        void OnMyActionBarIconClick(View icon);
    }

    private OnIconClickListener mOnIconClickListener;

    //方法
    public void setOnIconClickListener(OnIconClickListener onIconClickListener){
        mOnIconClickListener = onIconClickListener;
    }
}
