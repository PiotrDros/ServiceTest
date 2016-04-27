package com.example.piotr.servicetest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Piotr on 2016-02-23.
 */
public class LazyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        TextView textView = (TextView) ((Activity) context).findViewById(R.id.textView1);
        String string = intent.getExtras().getString(OurLazyIntentService.DATA);
textView.setText(string);

        Log.v("servicetest", "LazyReceiver");
    }
}
