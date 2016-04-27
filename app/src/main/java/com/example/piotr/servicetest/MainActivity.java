package com.example.piotr.servicetest;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

    public  static final String TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String text = extras.getString(TEXT);

            TextView textView2 = (TextView) findViewById(R.id.textView2);
            textView2.setText(text);
        }



        LazyReceiver lazyReceiver = new LazyReceiver();
        IntentFilter intentFilter = new IntentFilter(OurLazyIntentService.BROADCAST);
        registerReceiver(lazyReceiver, intentFilter);

        Intent intent = new Intent(this, OurLazyIntentService.class);
        intent.putExtra(OurLazyIntentService.INPUT, "Dane wejsciowe");
        startService(intent);


        Intent alarmIntent = new Intent(this, LazyReceiverAlarm.class);
        PendingIntent pendingIntent =  PendingIntent.getBroadcast(this, 0, alarmIntent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 13 * 1000, pendingIntent);

        Log.v("servicetest", "MainActivity");
    }
}
