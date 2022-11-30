package com.example.expservices;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Toast.makeText(this, "service started", Toast.LENGTH_LONG).show();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service destroyed", Toast.LENGTH_LONG).show();

        super.onDestroy();
    }
}