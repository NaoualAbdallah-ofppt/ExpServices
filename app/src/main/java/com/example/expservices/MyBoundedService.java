package com.example.expservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MyBoundedService extends Service {
    private final IBinder IB = new LocalBinder();
    private  final Random r = new Random();
    public MyBoundedService() {
    }
    public int getRandom()
    {
        return  r.nextInt(300);
    }
    @Override
    public IBinder onBind(Intent intent) {
       return IB;
        }
    public class LocalBinder extends Binder
    {MyBoundedService getService()
        {
            return MyBoundedService.this;
        }
   }
   /* void afficher(View v)
    {
        TextView txt=(TextView) v;
        txt.setText(String.valueOf(getRandom()));

    }

    */
}