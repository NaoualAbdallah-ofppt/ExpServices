package com.example.expservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainStartSceActivity extends AppCompatActivity {
Button btnStop, btnStart;
Intent itt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start_sce);
btnStop=(Button) findViewById(R.id.btnStop);
btnStart=(Button)findViewById(R.id.btnStart);
itt = new Intent(getApplicationContext(),
                MyStartedService.class);
   btnStart.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
          startService(itt);
       }
   });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               stopService(itt);
            }
        });
    }
}