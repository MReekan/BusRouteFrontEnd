package com.example.busroute;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;

public class StartToDestinationActivity extends AppCompatActivity {

//    EditText locationOne,locationTwo;
//
//    DatabaseReference dbTravellingPath;
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
          // txtLat.setError("Current place is required");
            Toast errorToast=Toast.makeText(StartToDestinationActivity.this, "Please select the From", Toast.LENGTH_SHORT);
            errorToast.show();
        }else if (TextUtils.equals(path_2,"To")){
            Toast errorToast=Toast.makeText(StartToDestinationActivity.this, "Please select the To", Toast.LENGTH_SHORT);
            errorToast.show();
        }
        else{
        setContentView(R.layout.activity_show_route_list);
        }
    }

}
