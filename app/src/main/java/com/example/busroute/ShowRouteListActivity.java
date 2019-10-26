package com.example.busroute;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ShowRouteListActivity extends AppCompatActivity  {

    private RecyclerView recyclerView;
   // private RecyclerView.Adapter adapter;
    private TravellingPathAdapter adapter;
    private List<TravellingPath> travellingPathList;
    private ImageView one ;

//    Spinner spinnerStartPlace,spinnerDestinationPlace;

    DatabaseReference dbTravellingPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_route_list);
        one = (ImageView)findViewById(R.id.imageView);

        one.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                //one.setVisibility(View.VISIBLE);
             //   Toast.makeText(ShowRouteListActivity.this, "You clicked on ImageView", Toast.LENGTH_LONG).show();
                //  view.setVisibility(View.GONE);
                // setContentView(R.layout.activity_main);
                Intent intentLoadNewActivity =new Intent(ShowRouteListActivity.this,MainActivity.class);
                startActivity(intentLoadNewActivity);
            }});




        dbTravellingPath = FirebaseDatabase.getInstance().getReference("travelling_paths");
//        dbTravellingPath.addListenerForSingleValueEvent(valueEventListener);





//        for (int i=0; i<=10; i++){
//            TravellingPath listt=new TravellingPath(
//                    "tikcket"+i+1
//            );
//            travellingPathList.add(listt);
//        }



//        for (TravellingPath num : travellingPathList) {
//            Log.i("MyActivity",num.toString());
//            Log.i("SecondActivity","++++++++++++++++++");
//            Log.i("num","4");
//        }

        travellingPathList = new ArrayList<>();
        adapter = new TravellingPathAdapter(this, travellingPathList);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


//        Query query = FirebaseDatabase.getInstance().getReference("travelling_paths")
//                .orderByChild("locationOne")
//                .equalTo("Nugegoda")
//               .orderByChild("locationTwo")
//               .equalTo("Town Hall");
//        query.addListenerForSingleValueEvent(valueEventListener);




    }
//    public void viewImage(View view){
////
////
////
////    }


//    ValueEventListener valueEventListener = new ValueEventListener() {
//        @Override
//        public void onDataChange(DataSnapshot dataSnapshot) {
//            travellingPathList.clear();
//            if (dataSnapshot.exists()) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    TravellingPath path = snapshot.getValue(TravellingPath.class);
//                    travellingPathList.add(path);
//                   // System.out.println(path);
//                   // System.out.println("+++++++++");
//
//                  //  recyclerView = findViewById(R.id.recyclerView);
//                    //recyclerView.setLayoutManager(new LinearLayoutManager(ShowRouteListActivity.this));
//                    //LinearLayoutManager layoutmanager = new LinearLayoutManager(ShowRouteListActivity.this);
//                   // RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(ShowRouteListActivity.this);
//                  //  recyclerView.setLayoutManager(layoutmanager);
//                  //  recyclerView.setHasFixedSize(true);
//
//                   // travellingPathList = new ArrayList<>();
//                    //adapter = new TravellingPathAdapter(ShowRouteListActivity.this, travellingPathList);
//                  //  adapter = new TravellingPathAdapter(ShowRouteListActivity.this, travellingPathList);
//                  //  recyclerView.setAdapter(adapter);
//
//                }
//                adapter.notifyDataSetChanged();
//            }else{
//                System.out.println("KKKKKKKKK");
//                System.out.println("+++++++++");
//            }
//        }
//
//        @Override
//        public void onCancelled(DatabaseError databaseError) {
//
//        }
//    };
}
