package com.example.busroute;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class CurrentToDestinationActivity extends AppCompatActivity implements LocationListener {


    protected LocationManager locationManager;
    protected LocationListener locationListener;
    TextView txtLat;
    boolean isGetCurrentLocation = false;
    boolean connected = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_to_destination);

        txtLat = findViewById(R.id.txtFrom);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


    }

    //    click button
    public void currentLocation(View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

            return;
        }

//        if (!isGetCurrentLocation){
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
//            isGetCurrentLocation=true;
//        }


        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;
    }

    public  void getLocation(Double lat , Double lon){
        Geocoder geocoder = new Geocoder(this, Locale.ENGLISH);

        try {
            List<Address> addresses = geocoder.getFromLocation(lat, lon, 10);
            if (addresses.size() >= 0){
                Address fetchedAddress = addresses.get(0);
                StringBuilder strAddress = new StringBuilder();
                System.out.println("0000000000000"+fetchedAddress.getAddressLine(0)+"***********************************");

//                data split
                String locationName = fetchedAddress.getAddressLine(0);
                String[] arrOfStr = locationName.split("," ,10);
//                String s = arrOfStr[1];
//                String[] arrOfSddress=s.split(" " , 10);

                if (arrOfStr[1].length() >6)
                    txtLat.setText(arrOfStr[1]);
//                    txtLat.setText("My Location");

                System.out.println("&&&&&&&&&&&&&&&&%%%%%%%%%%%%"+arrOfStr[1]+"***********************************");


            }else {
                txtLat.setText("Searching Current Address");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void printToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onLocationChanged(Location location) {
        txtLat = findViewById(R.id.txtFrom);
//        txtLat.setText(location.getLatitude() + " | " + location.getLongitude());

        double lat =location.getLatitude();
        double lon =location.getLongitude();

        getLocation(lat , lon);




//        *******************************************

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Log.d("Latitude", "disable");

    }

    @Override
    public void onProviderEnabled(String s) {
        Log.d("Latitude", "disable");

    }

    @Override
    public void onProviderDisabled(String s) {
        Log.d("Latitude", "disable");
    }
}
