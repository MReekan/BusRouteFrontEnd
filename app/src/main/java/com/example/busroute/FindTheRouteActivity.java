package com.example.busroute;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;


public class FindTheRouteActivity extends AppCompatActivity {
       TextView txtLat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_the_route);
        txtLat = findViewById(R.id.txtFrom);
    }
    //               click cancel button
    public void backToHome(View view){

        setContentView(R.layout.activity_main);
    }
    //               click search button
    public void showPathList(View view){
        String path_1     = txtLat.getText().toString().trim();

        if (TextUtils.isEmpty(path_1)){
            txtLat.setError("Route Number is required");
        }else {
        setContentView(R.layout.recyclerview_routes);}
    }
}
