package com.example.busroute;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CurrentRouteActivity extends AppCompatActivity {
    private Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_route);

        click =(Button) findViewById(R.id.btnClick);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity =new Intent(CurrentRouteActivity.this,CurrentRoutePlaceActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}
