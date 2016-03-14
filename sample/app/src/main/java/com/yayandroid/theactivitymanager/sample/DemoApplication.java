package com.yayandroid.theactivitymanager.sample;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.yayandroid.theactivitymanager.TheActivityManager;

/**
 * Created by ybayram on 11/12/15.
 */
public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TheActivityManager.getInstance().setLogEnabled(true);

        LeakCanary.install(this);
    }

}