package com.example.userregister;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import models.Person;

public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.MyViewHolder> {
    private ArrayList<Person> userList;
    public recycleAdapter(ArrayList<Person> userList){
        this.userList=userList;

    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTxt;

        public MyViewHolder(final View view){
            super(view);
            nameTxt=view.findViewById(R.id.auther_Txtview);
        }
    }
    @NonNull
    @Override
    public recycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
         return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recycleAdapter.MyViewHolder holder, int position) {
        String name=userList.get(position).getName();
        holder.nameTxt.setText(name);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
