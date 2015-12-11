package com.yayandroid.theactivitymanager.sample;

import android.util.Log;

import com.yayandroid.theactivitymanager.TAMBaseActivity;

/**
 * Created by ybayram on 11/12/15.
 */
public class BaseActivity extends TAMBaseActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (isFinishedByTAM) {
            Log.w("BaseActivity", getClass().getSimpleName() + " finished by TheActivityManager.");
        }
    }
}