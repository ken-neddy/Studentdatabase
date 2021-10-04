package com.neddycode.recyclerviewproject2;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private final ArrayList<ExampleItem> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        //declaring our variables
        public ImageView mImageView;
        public TextView transactionIdTv;
        public TextView balanceTv;
        public TextView balanceTv1;


        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            //initializing our variables
            mImageView = itemView.findViewById(R.id.ImageView);
            transactionIdTv = itemView.findViewById(R.id.transactionIdTv);
            balanceTv = itemView.findViewById(R.id.balanceTv);
            balanceTv1 = itemView.findViewById(R.id.balanceTv1);
        }
    }


    //parsing data from array list to the view holder
    public ExampleAdapter(ArrayList<ExampleItem> exampleList){
        mExampleList = exampleList;
    }
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_example_item,parent, false);
        return new ExampleViewHolder(v);
    }


    //implementing onBindViewHolder
    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        holder.transactionIdTv.setText(currentItem.getTransactionId());
        holder.balanceTv.setText(currentItem.getBalance());
        holder.balanceTv1.setText(currentItem.getBalance1());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}