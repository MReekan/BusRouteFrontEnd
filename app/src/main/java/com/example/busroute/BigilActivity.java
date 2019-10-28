package com.example.busroute;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BigilActivity extends AppCompatActivity {
    private Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigil);

        click =(Button) findViewById(R.id.btnClick);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Toast.makeText(BigilActivity.this,"clicked",Toast.LENGTH_SHORT).show();
                Intent intentLoadNewActivity =new Intent(BigilActivity.this,RouteWithPlaceActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}
