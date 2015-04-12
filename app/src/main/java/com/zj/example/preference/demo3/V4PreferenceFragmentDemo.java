package com.zj.example.preference.demo3;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.zj.example.preference.R;

/**
 * https://github.com/kolavar/android-support-v4-preferencefragment
 *
 * 使用開源的android-support-v4-preferencefragment-master
 * xml中使用自定義layout文件
 * create by zhengjiong
 * Date: 2015-04-12
 * Time: 18:32
 */
public class V4PreferenceFragmentDemo extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_preference_demo_layout);

        initToolbar();

        /**
         * 使用android-support-v4-preferencefragment-master,
         * 這裡就可以使用getSupportFragmentManager
         */
        getSupportFragmentManager().beginTransaction().replace(R.id.replace_holder, new CustomWidgetLayoutSettingFragment()).commit();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("CustomPreferenceDemo");
        toolbar.setTitleTextColor(Color.WHITE);
    }


    public static class CustomWidgetLayoutSettingFragment extends android.support.v4.preference.PreferenceFragment {

        @Override
        public void onCreate(Bundle paramBundle) {
            super.onCreate(paramBundle);
            addPreferencesFromResource(R.xml.custom_settings_fragment_xml);
        }
    }
}
