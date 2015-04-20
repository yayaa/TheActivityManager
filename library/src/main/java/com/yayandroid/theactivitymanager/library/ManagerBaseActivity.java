package com.yayandroid.theactivitymanager.library;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by yahyabayramoglu on 06/04/15.
 */
public class ManagerBaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TheActivityManager.getInstance().onCreate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TheActivityManager.getInstance().onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        TheActivityManager.getInstance().onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TheActivityManager.getInstance().onDestroy(this);
    }

}
