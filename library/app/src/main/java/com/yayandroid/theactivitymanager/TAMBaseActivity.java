package com.yayandroid.theactivitymanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yahyabayramoglu on 06/04/15.
 */
public class TAMBaseActivity extends AppCompatActivity {

    /**
     * Flag to determine that activity has killed by TheActivityManager or not
     */
    protected boolean isFinishedByTAM = false;

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

        if (isFinishedByTAM) {
            // Don't even bother, TheActivityManager already knows it!
            // Actually even if you call onDestroy on TheActivityManager,
            // because this activity is already removed from array it will do nothing.
        } else {
            TheActivityManager.getInstance().onDestroy(this);
        }
    }

    public void finishedByTAM() {
        this.isFinishedByTAM = true;
    }

}
