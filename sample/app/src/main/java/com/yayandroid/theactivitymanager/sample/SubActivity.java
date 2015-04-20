package com.yayandroid.theactivitymanager.sample;

import android.os.Bundle;
import android.widget.TextView;

import com.yayandroid.theactivitymanager.library.ManagerBaseActivity;

/**
 * Created by yahyabayramoglu on 06/04/15.
 */
public class SubActivity extends ManagerBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String text = extras.getString("SubExtra") + " Activity";
            ((TextView) findViewById(R.id.subHugeText)).setText(text);
        }
    }

}
