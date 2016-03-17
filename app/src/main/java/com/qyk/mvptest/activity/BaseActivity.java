package com.qyk.mvptest.activity;

import android.app.Activity;
import android.os.Bundle;

import com.qyk.mvptest.base.ActivityCollector;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}