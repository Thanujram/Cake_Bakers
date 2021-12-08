package com.example.tha_app_184172h.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.tha_app_184172h.R;
import com.example.tha_app_184172h.adapters.ItemAdapter;
import com.example.tha_app_184172h.dataModels.CardItem;
import com.example.tha_app_184172h.services.DatabaseHelper;

import java.util.ArrayList;

public class EditableView extends AppCompatActivity {
//    public static List<OrderItem> onClickList = new ArrayList<>();
    ImageView menu,menu_user_icon;
    DatabaseHelper db = new DatabaseHelper(EditableView.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editable_view);
        ArrayList<CardItem> dataArrayList = new ArrayList<>();

//
//        ImageView Current_Order = findViewById(R.id.current_order);
//
//        Current_Order.setOnClickListener(v -> {
//
//        });
//        menu_user_icon.setOnClickListener(v -> {
//            Intent menu_user = new Intent(UserDashboard.this, UserProfile.class);
//            startActivity(menu_user);
//        });
//
//
//        Current_Order.setOnClickListener(v -> {
//            Intent CurrentOrder = new Intent(UserDashboard.this, CurrentOrder.class);
//            startActivity(CurrentOrder);
//        });
        Cursor res = db.getItemDetails();
        StringBuilder buffer = new StringBuilder();
        while (res.moveToNext()) {
            buffer.append("Id:").append(res.getString(0)).append("\n");
            buffer.append("name:").append(res.getString(1)).append("\n");
            buffer.append("des:").append(res.getString(2)).append("\n");
            buffer.append("price:").append(res.getString(3)).append("\n").append("\n");
            dataArrayList.add(new CardItem(res.getString(1), res.getString(2), Integer.parseInt(res.getString(3))));

        }


        RecyclerView recyclerView = findViewById(R.id.item_recycler_view);
        ItemAdapter adapter = new ItemAdapter(dataArrayList, listdata -> {

//            getOrderData(listdata);
            Log.e("nameCall", listdata.getItem_name());
//                CommunicationAdapter.getInstance().changeState(oncliickList);
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
//    void getOrderData(CardItem od) {
//
//        if (onClickList.size() > 0) {
//            int itemCount = 0;
//            int index = -1;
//
//            for (OrderItem itemPojo : onClickList) {
//
//                if (itemPojo.getItem_name().equalsIgnoreCase(od.getItem_name()) && itemPojo.getItem_price() == od.getItem_price()
//                ) {
//                    index = itemCount;
//                }
//                itemCount++;
//            }
//
//            if (index == -1) {
//                OrderItem orderItem = new OrderItem();
//
//                orderItem.setItem_name(od.getItem_name());
//                orderItem.setItem_price(od.getItem_price());
//                orderItem.setItem_count(1);
//                onClickList.add(orderItem);
//            } else {
//                onClickList.get(index).setItem_count(onClickList.get(index).getItem_count() + 1);
//            }
//
//        } else {
//            OrderItem orderItem = new OrderItem();
//
//            orderItem.setItem_name(od.getItem_name());
//            orderItem.setItem_price(od.getItem_price());
//            orderItem.setItem_count(1);
//            onClickList.add(orderItem);
//
//        }
//
//    }
}