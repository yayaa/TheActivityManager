package com.yayandroid.theactivitymanager.sample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;

import com.yayandroid.theactivitymanager.library.TheActivityManager;

import java.util.ArrayList;

/**
 * Created by yahyabayramoglu on 06/04/15.
 */
public class DemoManager {

    public static void runActivitiesOneByOne(final ArrayList<Intent> array) {
        Handler handler = new Handler();
        for (int i = 0; i < array.size(); i++) {
            final Intent fIntent = array.get(i);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    TheActivityManager.getInstance().getCurrentActivity().startActivity(fIntent);
                }
            }, 800 * i);
        }
    }

    public static void dialog(int messageId) {
        Activity current = TheActivityManager.getInstance().getCurrentActivity();
        dialog(current, current.getString(messageId));
    }

    public static void dialog(String message) {
        Activity current = TheActivityManager.getInstance().getCurrentActivity();
        dialog(current, message);
    }

    private static void dialog(Activity activity, String message) {
        final AlertDialog dialog = new AlertDialog.Builder(activity).create();
        dialog.setMessage(message);
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, activity.getString(R.string.dialog_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
