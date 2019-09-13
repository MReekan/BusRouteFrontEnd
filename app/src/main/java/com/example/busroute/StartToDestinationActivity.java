package com.example.busroute;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartToDestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_to_destination);
    }

    public void backToHome(View view){

        setContentView(R.layout.activity_main);
    }
    public void showRouteList(View view){

        setContentView(R.layout.activity_show_route_list);
    }

}
