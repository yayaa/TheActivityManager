package com.yayandroid.theactivitymanager.library;

import android.app.Activity;

import java.util.ArrayList;

/**
 * To keep activity's instance and its current state of running
 * <p/>
 * Created by yahyabayramoglu on 03/04/15.
 */
public class ActivityHolder {

    private Activity activity;
    private boolean isLanding = false;
    private boolean isRunning = true;

    public ActivityHolder(Activity activity, boolean isLanding) {
        this.activity = activity;
        this.isLanding = isLanding;
    }

    public void pause() {
        this.isRunning = false;
    }

    public void resume() {
        this.isRunning = true;
    }

    public Activity getActivity() {
        return activity;
    }

    public boolean isLanding() {
        return isLanding;
    }

    public void setLanding(boolean isLanding) {
        this.isLanding = isLanding;
    }

    public boolean isRunning() {
        return isRunning;
    }

}