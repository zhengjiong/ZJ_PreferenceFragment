package com.zj.example.preference.demo2;

import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.zj.example.preference.R;

/**
 *
 * xml中使用自定義layout文件
 * create by zhengjiong
 * Date: 2015-04-12
 * Time: 18:32
 */
public class CustomWidgetLayoutPreferenceDemo extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_preference_demo_layout);

        initToolbar();

        /**
         * 這裡只能使用getFragmentManager,
         * 因為PreferenceFragment不是V4里的
         */
        getFragmentManager().beginTransaction().replace(R.id.replace_holder, new CustomWidgetLayoutSettingFragment()).commit();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("CustomPreferenceDemo");
        toolbar.setTitleTextColor(Color.WHITE);
    }


    public static class CustomWidgetLayoutSettingFragment extends PreferenceFragment{

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.custom_settings_fragment_xml);
        }
    }
}
