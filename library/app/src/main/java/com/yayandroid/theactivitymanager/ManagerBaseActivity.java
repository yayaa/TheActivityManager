package com.yayandroid.theactivitymanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yahyabayramoglu on 06/04/15.
 */
public class ManagerBaseActivity extends AppCompatActivity {

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
