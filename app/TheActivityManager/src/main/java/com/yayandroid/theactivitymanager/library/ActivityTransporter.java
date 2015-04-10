package com.yayandroid.theactivitymanager.library;

import java.util.ArrayList;

/**
 * Created by yahyabayramoglu on 03/04/15.
 */
public class ActivityTransporter {

    private Class<?> toClazz;
    private ArrayList<ActivityExtra> extras;

    public ActivityTransporter(Class<?> toClazz) {
        this.toClazz = toClazz;
    }

    /**
     * It is only possible to send strings as extra.
     */
    public ActivityTransporter addExtra(String key, String value) {
        if (extras == null)
            extras = new ArrayList<>();

        extras.add(new ActivityExtra(key, value));
        return this;
    }

    public Class<?> toClazz() {
        return toClazz;
    }

    public ArrayList<ActivityExtra> getExtras() {
        return extras;
    }
}
