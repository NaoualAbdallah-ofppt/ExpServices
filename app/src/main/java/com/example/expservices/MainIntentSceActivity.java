package com.example.expservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainIntentSceActivity extends AppCompatActivity {
    Button btnStart;
    Intent itt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intent_sce);
       btnStart=(Button)findViewById(R.id.btnStart);
        itt = new Intent(getApplicationContext(),
                MyIntentService.class);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(itt);
            }
        });

    }
}