package edu.neu.mad_sea.foodiesdelight.holder;

import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.neu.mad_sea.foodiesdelight.R;

public class OrderHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener{

    public TextView  orderStatus, orderUserName ;
    private AdapterView.OnItemClickListener itemClickListener;

    public OrderHolder(@NonNull View itemView) {
        super(itemView);
        orderStatus =  itemView.findViewById(R.id.orderStatus);
        orderUserName =  itemView.findViewById(R.id.orderUsername);
        itemView.setOnClickListener((View.OnClickListener) this);
    }

    public void setItemClickListener(AdapterView.OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Update status");
        menu.add("Update");
        menu.add("Delete");
    }
}
