package com.example.fooddeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SetOrderStatus extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;

    ArrayList<OrderModel> orderModels = new ArrayList<OrderModel>();
    TextView orders;

    ImageView searchIcon;
    String orderString = "";

    EditText ordernumber;

    ArrayList<Long> orderNumbers = new ArrayList<Long>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_order_status);

        ordernumber = findViewById(R.id.ordernumber);

        searchIcon = findViewById(R.id.searchIcon);
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference("orders");
        orders = findViewById(R.id.orders);


        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchText = ordernumber.getText().toString();

                if(orderNumbers.contains(Long.valueOf(searchText))){
                    int index = orderNumbers.indexOf(Long.valueOf(searchText));
                    OrderModel orderModel;
                    orderModel = orderModels.get(index);

                    Intent intent = new Intent(getApplicationContext(),FixOrderStatus.class);
                    intent.putExtra("orderNo",searchText);
                    intent.putExtra("orderModel",orderModel);
                    startActivity(intent);

                }

            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                orderModels.clear();

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    OrderModel orderModel;

                    orderModel = dataSnapshot1.getValue(OrderModel.class);

                    if(!orderModel.getCurrentStatus().matches("delivered")){
                        orderModels.add(orderModel);
                        orderString += dataSnapshot1.getKey()+"\n"+orderModel.getFoodname()+"\n"+"Qty: "+orderModel.getQty()+
                                "\nPrice: "+orderModel.getPrice()+"\nTotal Price: "+orderModel.getTotalPrice()+"\n\n\n";
                        orderNumbers.add(Long.valueOf(dataSnapshot1.getKey()));
                    }

                }
                orders.setText(orderString);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}