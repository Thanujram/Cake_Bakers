package com.example.tha_app_184172h.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tha_app_184172h.R;
import com.example.tha_app_184172h.dataModels.CardItem;

import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<CardItem> listdata;
    Data item_data;

    public ItemAdapter(List<CardItem> listdata,Data item_data) {
        this.listdata = listdata;
        this.item_data=item_data;
    }


    public interface Data {
        void set_data( CardItem listdata );
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.sample_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override


    public void onBindViewHolder(ViewHolder holder, int position) {
        final CardItem myListData = listdata.get(position);
        holder.item_name.setText(listdata.get(position).getItem_name());
        holder.item_count.setText(String.valueOf(listdata.get(position).getItem_des()));
        holder.item_price.setText(String.valueOf(listdata.get(position).getItem_price()));
        holder.parent_card.setOnClickListener(v -> { item_data.set_data(listdata.get(position));

        });
        Log.d("name", myListData.getItem_name().toString());

    }



    @Override
    public int getItemCount() {
        return listdata.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder {
    public TextView item_name;
    public TextView item_count;
    public TextView item_price;
    public CardView parent_card;
    public RelativeLayout relativeLayout;

    public ViewHolder(View itemView) {
        super(itemView);
        this.item_name = itemView.findViewById(R.id.item_name_card);
        this.item_count = itemView.findViewById(R.id.item_short_desc);
        this.item_price = (TextView) itemView.findViewById(R.id.item_price);
        this.parent_card = (CardView) itemView.findViewById(R.id.parent);
        //relativeLayout = (RelativeLayout)itemView.findViewById(R.id.recyclerview);
    }
}