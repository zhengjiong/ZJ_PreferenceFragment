package com.zj.example.preference;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.zj.example.preference.demo1.BasicPreferenceDemo;
import com.zj.example.preference.demo2.CustomWidgetLayoutPreferenceDemo;
import com.zj.example.preference.demo3.V4PreferenceFragmentDemo;

/**
 * create by zhengjiong
 * Date: 2015-04-12
 * Time: 18:30
 */
public class MainActivity extends ActionBarActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(MainActivity.this, BasicPreferenceDemo.class));

                break;
            case R.id.btn2:
                startActivity(new Intent(MainActivity.this, CustomWidgetLayoutPreferenceDemo.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(MainActivity.this, V4PreferenceFragmentDemo.class));
                break;
        }
    }
}
