package com.example.letsgo999.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.letsgo999.HistorySingleActivity;
import com.example.letsgo999.R;
import com.example.letsgo999.models.ModelHistory;

import java.util.ArrayList;
import java.util.List;

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.HistoryViewHolders> {

    private List<ModelHistory> itemList;
    private Context context;

    public AdapterHistory(ArrayList<ModelHistory> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public HistoryViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);
        HistoryViewHolders rcv = new HistoryViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolders holder, int position) {
        holder.rideId.setText(itemList.get(position).getRideId());
        if(itemList.get(position).getTime()!=null){
            holder.time.setText(itemList.get(position).getTime());
        }
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public class HistoryViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView rideId, time;

        public HistoryViewHolders(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            rideId = (TextView) itemView.findViewById(R.id.rideId);
            time = (TextView) itemView.findViewById(R.id.time);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), HistorySingleActivity.class);
            Bundle b = new Bundle();
            b.putString("rideId", rideId.getText().toString());
            intent.putExtras(b);
            v.getContext().startActivity(intent);
        }
    }

}
