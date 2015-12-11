package com.yayandroid.theactivitymanager;

import android.app.Activity;
import android.util.Log;

/**
 * To keep activity's instance and its current state of running
 * <p>
 * Created by yahyabayramoglu on 03/04/15.
 */
public class ActivityHolder {

    private Activity activity;
    private boolean isLanding = false;
    private boolean isRunning = true;
    private String activityName;

    public ActivityHolder(Activity activity, boolean isLanding) {
        this.activity = activity;
        this.activityName = activity.getClass().getSimpleName();
        this.isLanding = isLanding;
        log(" created.");
    }

    public void pause() {
        this.isRunning = false;
        log(" paused.");
    }

    public void resume() {
        this.isRunning = true;
        log(" resumed.");
    }

    public Activity getActivity() {
        return activity;
    }

    public boolean isLanding() {
        return isLanding;
    }

    public void setLanding(boolean isLanding) {
        this.isLanding = isLanding;
        log(isLanding ? " is landing now!" : " is not landing anymore!");
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void finish() {
        if (activity instanceof TAMBaseActivity) {
            ((TAMBaseActivity) activity).finishedByTAM();
        }
        activity.finish();
        log(" destroyed.");
    }

    public void removed() {
        log(" destroyed.");
    }

    private void log(String message) {
        if (TheActivityManager.isLogEnabled()) {
            Log.i("TheActivityManager", activityName + message);
        }
    }

}