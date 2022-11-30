package com.example.expservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
DrawerLayout DL;
NavigationView NV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
DL=(DrawerLayout) findViewById(R.id.MyDrawer);
NV=(NavigationView) findViewById(R.id.MyNavigationView);

NV.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent itt=null;
        switch (item.getItemId())
        {
            case R.id.actSceStart:
                itt= new Intent(getApplicationContext(),MainStartSceActivity.class);
                break;
            case R.id.actSceBind:
                itt= new Intent(getApplicationContext(),MainBindSceActivity.class);
                break;
            case R.id.actSceIntent:
                itt= new Intent(getApplicationContext(),MainIntentSceActivity.class);
                break;
            case R.id.act4:
                finish();
                return true;
        }
        startActivity(itt);
       DL.closeDrawer(GravityCompat.START);
        return true;
    }
});
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // if (MyT.onOptionsItemSelected(item))
        //   return  true;
        return super.onOptionsItemSelected(item);

    }

}