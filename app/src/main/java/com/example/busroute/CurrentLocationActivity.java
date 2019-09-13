
package com.example.busroute;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CurrentLocationActivity extends AppCompatActivity {

    TextView txtLocationAddress;
    SupportMapFragment mapFragment;
    GoogleMap map;
    LatLng center;
    CardView cardView;
    private static final int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_location);

        txtLocationAddress = findViewById(R.id.txtLocationAddress);
        txtLocationAddress.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        txtLocationAddress.setSingleLine(true);
        txtLocationAddress.setMarqueeRepeatLimit(-1);
        txtLocationAddress.setSelected(true);

        cardView = findViewById(R.id.cardView);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent =
                            new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                                    .build(CurrentLocationActivity.this);
                    startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
                } catch (GooglePlayServicesRepairableException e) {
                    printToast("Google Play Service Repair");
                } catch (GooglePlayServicesNotAvailableException e) {
                    printToast("Google Play Service Not Available");
                }
            }
        });

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                map.getUiSettings().setZoomControlsEnabled(true);
                LatLng latLng = new LatLng(20.5937, 78.9629);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
                initCameraIdle();
            }
        });
    }

    private void initCameraIdle() {
        map.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {
                center = map.getCameraPosition().target;
                getAddressFromLocation(center.latitude, center.longitude);
            }
        });
    }

    private void getAddressFromLocation(double latitude, double longitude) {

        Geocoder geocoder = new Geocoder(this, Locale.ENGLISH);


        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);

            if (addresses.size() > 0) {
                Address fetchedAddress = addresses.get(0);
                StringBuilder strAddress = new StringBuilder();
                for (int i = 0; i < fetchedAddress.getMaxAddressLineIndex(); i++) {
                    strAddress.append(fetchedAddress.getAddressLine(i)).append(" ");
                }

                txtLocationAddress.setText(strAddress.toString());

            } else {
                txtLocationAddress.setText("Searching Current Address");
            }

        } catch (IOException e) {
            e.printStackTrace();
            printToast("Could not get address..!");
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
//            if (resultCode == RESULT_OK) {
//                Place place = PlaceAutocomplete.getPlace(this, data);
//                if (!place.getAddress().toString().contains(place.getName())) {
//                    txtLocationAddress.setText(place.getName() + ", " + place.getAddress());
//                } else {
//                    txtLocationAddress.setText(place.getAddress());
//                }
//
//                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(place.getLatLng(), 16);
//                map.animateCamera(cameraUpdate);
//
//
//            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
//                printToast("Error in retrieving place info");
//
//            }
//        }
//    }

    private void printToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
