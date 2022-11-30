package com.example.expservices;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.provider.Settings;

public class MyStartedService extends Service {
   MediaPlayer MP;
    public MyStartedService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


       MP=MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
       // Uri uri = Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.son);

        //MP=MediaPlayer.create(this,uri);

        MP.setLooping(true);
        MP.start();

        return super.onStartCommand(intent, flags, startId);
    }


    //A ne pas toucher pour un service de type startes
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
       MP.stop();
        super.onDestroy();
    }
}