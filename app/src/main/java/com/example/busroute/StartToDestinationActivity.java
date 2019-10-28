package com.example.busroute;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;


public class StartToDestinationActivity extends AppCompatActivity {

    Spinner from,to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_to_destination);
        from        = (Spinner) findViewById(R.id.spinnerStartPlace);
        to          = (Spinner) findViewById(R.id.spinnerDestinationPlace);
    }

    //               click cancel button
    public void backToHome(View view){

        setContentView(R.layout.activity_main);
    }

    //               click search button
    public void showRouteList(View view){
        String path_1     = from.getSelectedItem().toString();
        String path_2     = to.getSelectedItem().toString();

        if (TextUtils.equals(path_1,"From")){
            Toast errorToast=Toast.makeText(StartToDestinationActivity.this, "Please select the From", Toast.LENGTH_SHORT);
            errorToast.show();
        }else if (TextUtils.equals(path_2,"To")){
            Toast errorToast=Toast.makeText(StartToDestinationActivity.this, "Please select the To", Toast.LENGTH_SHORT);
            errorToast.show();
        }
        else{
            Intent intentLoadNewActivity =new Intent(StartToDestinationActivity.this,BigilActivity.class);
            startActivity(intentLoadNewActivity);
        }
    }

}
