package com.example.busroute;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class CurrentToDestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_to_destination);
    }

    public void currentLocation(View view){
        Intent intent = new Intent(this, CurrentLocationActivity.class);
        startActivity(intent);
    }
}
