package com.example.piotr.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

/**
 * Created by Piotr on 2016-02-23.
 */
public class OurLazyIntentService  extends IntentService{

    public static final String BROADCAST = "com.example.piotr.servicetest.BROADCAST";
    public static final String DATA = "data";
    public static final String INPUT = "input";

    public OurLazyIntentService() {
        super("OurLazyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        SystemClock.sleep(5000);

        Log.v("servicetest", "OurLazyIntentService input: " + "przed");
        String input = intent.getExtras().getString(INPUT);

        Log.v("servicetest", "OurLazyIntentService input: " + input);
        Intent broadcast = new Intent();
        broadcast.setAction(BROADCAST);
        broadcast.putExtra(DATA, "Zakonczylem prace z danymi: " + input);
        sendBroadcast(broadcast);


        Log.v("servicetest", "OurLazyIntentService");


    }
}
