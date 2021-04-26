package com.example.ongiuaki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_a  extends RecyclerView.Adapter<Adapter_a.ItemViewHolder> {
  private final ArrayList<Item> list;
  private LayoutInflater layoutInflater;
private OnItemClickListener mlistener;

    public Adapter_a(Context context,ArrayList<Item> list) {
        this.layoutInflater= LayoutInflater.from(context);
        this.list = list;
    }
    public interface OnItemClickListener{
        void OnItemClick(int position);
    }

    public void setListener(OnItemClickListener listener) {
        this.mlistener = listener;
    }

    @NonNull
    @Override
    public Adapter_a.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.item_a, parent, false);


        return new ItemViewHolder(view, this, mlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_a.ItemViewHolder holder, int position) {
        Item item= list.get(position);
        holder.img.setImageResource(item.getImg());
        holder.tensp.setText(item.getName());
        holder.gia.setText(("$" +item.getPrice()+""));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private final Adapter_a adapter;
        private final ImageView img;
        private final TextView gia;
        private final TextView tensp;

        public ItemViewHolder(@NonNull View itemView, Adapter_a adapter, OnItemClickListener listener) {
            super(itemView);

            img = itemView.findViewById(R.id.hinh);
            gia= itemView.findViewById(R.id.gia);
            tensp= itemView.findViewById(R.id.tensp);
            this.adapter = adapter;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!= null){
                        int position= getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION)
                            listener.OnItemClick(position);
                    }

                }
            });
        }
    }
}
