package com.example.busroute;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;


public class ShowRouteListActivity extends AppCompatActivity  {

    private RecyclerView recyclerView;
   // private RecyclerView.Adapter adapter;
    private TravellingPathAdapter adapter;
    private List<TravellingPath> travellingPathList;


    DatabaseReference dbTravellingPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_route_list);

        travellingPathList = new ArrayList<>();
        adapter = new TravellingPathAdapter(this, travellingPathList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        Query query = FirebaseDatabase.getInstance().getReference("travelling_paths")
                .orderByChild("locationOne")
                .equalTo("Nugegoda")
               .orderByChild("locationTwo")
               .equalTo("Town Hall");
        query.addListenerForSingleValueEvent(valueEventListener);

        Query query2 = FirebaseDatabase.getInstance().getReference("travelling_paths")
                .orderByChild("locationOne")
                .equalTo("Kelaniya")
                .orderByChild("locationTwo")
                .equalTo("Pettah");
        query2.addListenerForSingleValueEvent(valueEventListener);


    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            travellingPathList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    TravellingPath path = snapshot.getValue(TravellingPath.class);
                    travellingPathList.add(path);

                }
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };
}
