package com.example.expservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainBindSceActivity extends AppCompatActivity {
    Button btnRecup, btnStop;
    TextView txtAfficher;
    ServiceConnection SC;
    MyBoundedService Sce;
    Intent itt;
    boolean isBind=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bind_sce);
     //___________________________________
        SC= new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //ibinder c'est le paramètre de onServiceConnected
            MyBoundedService.LocalBinder bd =(MyBoundedService.LocalBinder) iBinder;
            Sce=bd.getService();
            isBind=true;
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBind=false;
              }
    };
        itt = new Intent(this,MyBoundedService.class);
        bindService(itt,SC, Context.BIND_AUTO_CREATE);

        //_________________________________________
        btnRecup=(Button)findViewById(R.id.btnRecup);
        btnStop=(Button)findViewById(R.id.btnStop);
        txtAfficher=(TextView) findViewById(R.id.txtAfficher);
        btnRecup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a =Sce.getRandom();
                  txtAfficher.setText(String.valueOf(a));
               //   autre manière
               // le sce s'occupe de l'affichage
             //   Sce.afficher(txtAfficher);

            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBind) {
                    unbindService(SC);
                    Toast.makeText(getApplicationContext(), "Déconnecté", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Toast.makeText(getApplicationContext(), "rien à déconnecter", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}