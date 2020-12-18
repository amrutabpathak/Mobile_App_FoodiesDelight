package edu.neu.mad_sea.foodiesdelight.holder;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.neu.mad_sea.foodiesdelight.R;
import edu.neu.mad_sea.foodiesdelight.interfaces.ClickListerner;
import edu.neu.mad_sea.foodiesdelight.utils.Constants;

public class RestOrderHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener, View.OnCreateContextMenuListener {

    private TextView restName;
    private TextView userName;
    private TextView items;
    private ClickListerner itemClickListener;

    public TextView getRestName() {
        return restName;
    }

    public void setRestName(TextView restName) {
        this.restName = restName;
    }

    public TextView getUserName() {
        return userName;
    }

    public void setUserName(TextView userName) {
        this.userName = userName;
    }

    public TextView getItems() {
        return items;
    }

    public void setItems(TextView items) {
        this.items = items;
    }

    public RestOrderHolder(@NonNull View itemView) {
        super(itemView);
        restName = itemView.findViewById(R.id.restaurantName);
        userName = itemView.findViewById(R.id.userName);
        items = itemView.findViewById(R.id.cartItems);
        restName.setOnClickListener(this);
        userName.setOnClickListener(this);
        items.setOnClickListener(this);

        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);

    }

    public void setItemClickListener(ClickListerner itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v, getAdapterPosition());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Update Order");
        menu.add( Constants.ORDER_SHIPPED);
        menu.add( Constants.ORDER_READY);

    }
}
