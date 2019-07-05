package com.example.busroute;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startToDestination(View view){
        Intent intent = new Intent(this, StartToDestinationActivity.class);
        startActivity(intent);
    }

    public void findTheRoute(View view){
        Intent intent = new Intent(this, FindTheRouteActivity.class);
        startActivity(intent);
    }

    public void currentToDestination(View view){
        Intent intent = new Intent(this, CurrentToDestinationActivity.class);
        startActivity(intent);
    }

    public void needHelp(View view){
        Intent intent = new Intent(this, NeedHelpActivity.class);
        startActivity(intent);
    }
}
