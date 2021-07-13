package com.example.raghav.bankingApp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicbankingapp.R;

import java.util.List;

public class History_Adapter extends RecyclerView.Adapter<ViewHolder> {

    History_Transfer HistoryList;
    List<Model> ModelList;
    TextView mTransaction_status;

    public History_Adapter(History_Transfer historyList, List<Model> modelList) {
        this.HistoryList = historyList;
        this.ModelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.transfer_history_list, parent, false);
        mTransaction_status = itemView.findViewById(R.id.transaction_status);

        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mName1.setText(ModelList.get(position).getName1());
        holder.mName2.setText(ModelList.get(position).getName2());
        holder.mBalance.setText(ModelList.get(position).getBalance());
        holder.mDate.setText(ModelList.get(position).getDate());
        holder.mTransaction_status.setText(ModelList.get(position).getTransaction_status());

        if (ModelList.get(position).getTransaction_status().equals("Failed")) {
            holder.mTransaction_status.setTextColor(Color.parseColor("#f40404"));
        } else {
            holder.mTransaction_status.setTextColor(Color.parseColor("#4BB543"));
        }
    }

    @Override
    public int getItemCount() {
        return ModelList.size();
    }
}
