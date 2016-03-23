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

        // If only your application targets minSdkVersion=14
        // CAUTION: If you call this method, DO NOT extend your activities from TAMBaseActivity
        // TheActivityManager.getInstance().configure(this);

        LeakCanary.install(this);
    }

}