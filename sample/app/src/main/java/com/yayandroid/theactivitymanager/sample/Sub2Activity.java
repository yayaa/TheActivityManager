package com.yayandroid.theactivitymanager.sample;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.yayandroid.theactivitymanager.ManagerBaseActivity;

/**
 * Created by yahyabayramoglu on 06/04/15.
 */
public class Sub2Activity extends ManagerBaseActivity {

    private String stepMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("SubExtra")) {
                String text = extras.getString("SubExtra") + " Instance Activity!";
                ((TextView) findViewById(R.id.subHugeText)).setText(text);
            }

            if (extras.containsKey("StepExtra")) {
                stepMessage = extras.getString("StepExtra");
            }
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (!TextUtils.isEmpty(stepMessage)) {
            DemoManager.dialog(stepMessage);
            stepMessage = "";
        }
    }

}
