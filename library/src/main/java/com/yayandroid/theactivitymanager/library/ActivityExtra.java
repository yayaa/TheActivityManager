package com.yayandroid.theactivitymanager.library;

/**
 * Name and value holder for putExtra method to use on intents
 * Created by yahyabayramoglu on 03/04/15.
 */
public class ActivityExtra {

    private String key;
    private String value;

    public ActivityExtra(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
