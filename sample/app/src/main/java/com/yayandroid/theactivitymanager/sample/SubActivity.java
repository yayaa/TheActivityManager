package com.yayandroid.theactivitymanager.sample;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by yahyabayramoglu on 06/04/15.
 */
public class SubActivity extends BaseActivity {

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
