package edu.neu.mad_sea.foodiesdelight.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.neu.mad_sea.foodiesdelight.R;

public class CartHolder extends RecyclerView.ViewHolder {
    public void setCartItemName(TextView cartItemName) {
        this.cartItemName = cartItemName;
    }

    public TextView getCartItemName() {
        return cartItemName;
    }

    private TextView cartItemName;

    public TextView getPrice() {
        return price;
    }

    public void setPrice(TextView price) {
        this.price = price;
    }

    private TextView price;

    public CartHolder(@NonNull View itemView) {
        super(itemView);
        cartItemName = itemView.findViewById(R.id.cartItemId);
        price = itemView.findViewById(R.id.ciPrice);
    }
}
