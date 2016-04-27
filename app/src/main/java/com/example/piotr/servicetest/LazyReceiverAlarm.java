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
public class LazyReceiverAlarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
       Intent myActitivyIntent = new Intent(context, MainActivity.class);
        myActitivyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        myActitivyIntent.putExtra(MainActivity.TEXT, "Zakonczylem praca z alarm receiverem");
        context.startActivity(myActitivyIntent);

        Log.v("servicetest", "LazyReceiverAlarm");
    }
}
