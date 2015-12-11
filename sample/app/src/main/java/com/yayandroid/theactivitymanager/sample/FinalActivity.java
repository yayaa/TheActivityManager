package com.yayandroid.theactivitymanager.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yayandroid.theactivitymanager.TheActivityManager;

/**
 * Created by yahyabayramoglu on 06/04/15.
 */
public class FinalActivity extends BaseActivity {

    private FinalActivityType type = FinalActivityType.NONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int typeId = extras.getInt("FinalExtra", 0);
            type = FinalActivityType.getType(typeId);
        }

        ((TextView) findViewById(R.id.finalInfoText)).setText(getString(type.textId));

    }

    public void justDoIt(View v) {
        if (type != null) {
            switch (type) {
                case TO_LANDING:
                    TheActivityManager.getInstance().toLanding();
                    break;
                case REMOVE_INSTANCE:
                    TheActivityManager.getInstance().finishInstance(Sub2Activity.class);
                    DemoManager.dialog(R.string.dialog_remove_instance);
                    break;
                case TO_INSTANCE:
                    TheActivityManager.getInstance().toInstanceOf(Sub2Activity.class);
                    break;
                case STEP:
                    TheActivityManager.getInstance().moveForward(true);
                    break;
                case QUIT:
                    TheActivityManager.getInstance().finishAll();
                    break;
                default:
                    break;
            }
        }
    }

}
