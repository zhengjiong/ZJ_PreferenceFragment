package com.zj.example.preference.demo1;

import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.zj.example.preference.R;

/**
 *
 * @author zj
 * @date 2015年4月8日08:39:50
 */
public class BasicPreferenceDemo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_preference_demo_layout);


        initToolbar();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.replace_holder, new SettingsFragment()).commit();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("PreferenceFragment Demo");
        toolbar.setTitleTextColor(Color.WHITE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class SettingsFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_fragment_xml);

        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            /**
             * 使用setWidgetLayoutResource方式,點擊后Switch沒有動畫效果,
             * 在xml中使用android:widgetLayout才有動畫效果
             */
            CheckBoxPreference switchCompat = (CheckBoxPreference) findPreference("switch_compat");
            switchCompat.setWidgetLayoutResource(R.layout.switch_compat);


            /**
             * switch_compat Preference切换事件
             */
            switchCompat.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    Toast.makeText(getActivity(), newValue.toString(), Toast.LENGTH_SHORT).show();
                    return true;
                }
            });


            CheckBoxPreference checkBox = (CheckBoxPreference) findPreference("check_box");
            checkBox.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    Toast.makeText(getActivity(), newValue.toString(), Toast.LENGTH_SHORT).show();
                    return true;
                }
            });

            /**
             * 獲取值
             */
            PreferenceManager preferenceManager = getPreferenceManager();
            SharedPreferences sharedPreferences = preferenceManager.getSharedPreferences();
            boolean checkBoxValue = sharedPreferences.getBoolean("check_box", false);
            Log.i("zj", "check_box=" + checkBoxValue);

        }
    }
}
