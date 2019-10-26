package com.example.busroute;

import android.content.Context;
//import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TravellingPathAdapter extends RecyclerView.Adapter<TravellingPathAdapter.TravellingPathViewHolder> {
    private Context mCtx;
    private List<TravellingPath> travellingPathList;

    public TravellingPathAdapter(Context mCtx, List<TravellingPath> travellingPathList) {
        this.mCtx = mCtx;
        this.travellingPathList = travellingPathList;
    }

    @Override
    public TravellingPathViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_paths, parent, false);
        //return new TravellingPathViewHolder(view);
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_paths, parent, false);
        //TravellingPathAdapter.TravellingPathViewHolder travellingPathViewHolder = new TravellingPathAdapter.TravellingPathViewHolder(view);
        return new TravellingPathViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TravellingPathViewHolder holder, int position) {
        TravellingPath path = travellingPathList.get(position);

        Log.i("MainActivity",path.getTicket_fee());
        Log.i("SecondActivity","===================");
        Log.i("num","7");

        holder.textViewTicket.setText("Ticket: " + path.getTicket_fee());

    }

    @Override
    public int getItemCount() {
        Log.i("sssss",Integer.toString(travellingPathList.size()));
        Log.i("ihiuig","_________________________");

        return travellingPathList.size();
    }

    class TravellingPathViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTicket;

        public TravellingPathViewHolder(View itemView) {
            super(itemView);

            textViewTicket = itemView.findViewById(R.id.text_view_ticket);

        }
    }
}
