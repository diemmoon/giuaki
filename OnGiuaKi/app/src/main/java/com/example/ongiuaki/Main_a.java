package com.example.ongiuaki;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Main_a extends AppCompatActivity {
    private ArrayList<Item> list;
    private Adapter_a adapter;
    private RecyclerView recyclerView;
    private int amount=1;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_a);
       gridview();

    }

    private void gridview() {
        list= new ArrayList<Item>();
        list.add(new Item(R.drawable.cam, "Ghe mau cam", 500, "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE"));
        list.add(new Item(R.drawable.images__2__1, "Ghe mau do", 800, "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE"));
        list.add(new Item(R.drawable.hong, "Ghe mau hong", 300, "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE"));
        list.add(new Item(R.drawable.vang, "Ghe mau vang", 700, "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE") );
        list.add(new Item(R.drawable.cam, "Ghe mau cam", 500, "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE"));
        list.add(new Item(R.drawable.images__2__1, "Ghe mau do", 800, "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE"));
        list.add(new Item(R.drawable.hong, "Ghe mau hong", 300, "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE"));
        list.add(new Item(R.drawable.vang, "Ghe mau vang", 700, "ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE") );

        recyclerView= findViewById(R.id.rc_a);
        adapter= new Adapter_a(this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    adapter.setListener(new Adapter_a.OnItemClickListener() {
        @Override
        public void OnItemClick(int position) {
            changeScreen(position);
        }
    });

    }

    private void changeScreen(int position) {
        Item item= list.get(position);
        setContentView(R.layout.activity_b);
        ImageView img= findViewById(R.id.hinh);
        TextView name= findViewById(R.id.nameProduct);
        TextView price= findViewById(R.id.price);
        TextView description= findViewById(R.id.mota);
        TextView quantity= findViewById(R.id.soluong);

        img.setImageResource(item.getImg());
        name.setText(item.getName());
        price.setText("$" +item.getPrice()+"");
        description.setText(item.getDescription());

        ImageButton btnCong= findViewById(R.id.btnCong);
        ImageButton btnTru= findViewById(R.id.btnTru);
         btnCong.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 amount ++;
                 quantity.setText(String.valueOf(amount));
             }
         });
         btnTru.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(amount>1){
                     amount--;
                     quantity.setText(String.valueOf(amount));
                 }
             }
         });

        Button btnAddToCard= findViewById(R.id.btnAddToCard);
        btnAddToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_c);
                ImageView image = findViewById(R.id.image);
                TextView tvName= findViewById(R.id.tvten);
                TextView tvPrice= findViewById(R.id.tvgia);
                TextView tvsoluong= findViewById(R.id.tvsoluong);
                TextView subtotal= findViewById(R.id.subtotal);
                TextView total= findViewById(R.id.total);

                ImageButton btnMinus= findViewById(R.id.tru);
                ImageButton btnAdd= findViewById(R.id.cong);


                image.setImageResource(item.getImg());
                tvName.setText(item.getName());
                tvPrice.setText("$"+item.getPrice());
                tvsoluong.setText(String.valueOf(amount));
                subtotal.setText("$"+item.getPrice()* amount);
                total.setText("$"+item.getPrice()* amount);

                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        amount++;
                        tvsoluong.setText(String.valueOf(amount));
                        subtotal.setText("$"+item.getPrice()* amount);
                        total.setText("$"+item.getPrice()* amount);
                    }
                });
                btnMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(amount>0) {
                            amount--;
                            tvsoluong.setText(String.valueOf(amount));
                            subtotal.setText("$" + item.getPrice() * amount);
                            total.setText("$" + item.getPrice() * amount);
                        }
                    }
                });

            }
        });




    }
}