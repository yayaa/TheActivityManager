package com.yayandroid.theactivitymanager.sample;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yayandroid.theactivitymanager.ActivityTransporter;
import com.yayandroid.theactivitymanager.ManagerBaseActivity;
import com.yayandroid.theactivitymanager.TheActivityManager;

import java.util.ArrayList;

/**
 * Created by yahyabayramoglu on 06/04/15.
 */
public class DemoActivity extends ManagerBaseActivity implements AdapterView.OnItemClickListener {

    private String[] texts;
    private String[] alphabet = new String[]{"A", "B", "C", "D"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        TheActivityManager.getInstance().setAsLanding(this);

        ListView demoList = (ListView) findViewById(R.id.demoList);
        texts = getResources().getStringArray(R.array.DemoList);
        demoList.setAdapter(new DemoAdapter(this));
        demoList.setOnItemClickListener(this);
    }

    private class DemoAdapter extends ArrayAdapter<String> {

        private LayoutInflater inflater;

        public DemoAdapter(Context context) {
            super(context, R.layout.list_item, texts);
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return texts.length;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = inflater.inflate(R.layout.list_item, parent, false);

            TextView textView = (TextView) convertView.findViewById(R.id.listItemText);
            textView.setText(texts[position]);
            textView.setTextColor(position == 0 ? Color.WHITE : Color.BLACK);
            textView.setBackgroundColor(position == 0 ? Color.GRAY : Color.TRANSPARENT);

            return super.getView(position, convertView, parent);
        }

        @Override
        public boolean isEnabled(int position) {
            return position != 0;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 1:
                doClick(1, 3, 0);
                break;
            case 2:
                doClick(2, 2, 1);
                break;
            case 3:
                doClick(3, 2, 1);
                break;
            case 4:
                doClick(4, 0, 0);
                break;
            case 5:
                doClick(5, 3, 0);
                break;
        }
    }

    public void doClick(int typeId, int subCount, int sub2Count) {
        ArrayList<Intent> intents = new ArrayList<>();
        for (int i = 0; i < subCount; i++) {
            Intent subIntent = new Intent(this, SubActivity.class);
            subIntent.putExtra("SubExtra", alphabet[i]);
            intents.add(subIntent);
        }

        if (sub2Count > 0) {
            Intent sub2Intent = new Intent(this, Sub2Activity.class);
            sub2Intent.putExtra("SubExtra", alphabet[alphabet.length - 1]);
            intents.add(intents.size() - 1, sub2Intent);
        }

        Intent finalIntent = new Intent(this, FinalActivity.class);
        finalIntent.putExtra("FinalExtra", typeId);
        intents.add(finalIntent);

        if (typeId == FinalActivityType.STEP.id) {
            ActivityTransporter transporter = new ActivityTransporter(Sub2Activity.class);
            transporter.addExtra("StepExtra", getString(R.string.dialog_step));
            TheActivityManager.getInstance().setNextStep(transporter);
        }

        // This method is just so wrong, i know!
        // But it is just for demonstration.
        DemoManager.runActivitiesOneByOne(intents);
    }

}
