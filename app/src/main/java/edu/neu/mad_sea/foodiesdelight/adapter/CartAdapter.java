package edu.neu.mad_sea.foodiesdelight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.neu.mad_sea.foodiesdelight.R;
import edu.neu.mad_sea.foodiesdelight.beans.CartItem;
import edu.neu.mad_sea.foodiesdelight.holder.CartHolder;

public class CartAdapter extends RecyclerView.Adapter<CartHolder> {

    private List<CartItem> cartItems;
    private Context context;

    public CartAdapter(List<CartItem> cartItems, Context context) {
        this.cartItems = cartItems;
        this.context = context;
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.cart_item_display_format, parent, false);
        return new CartHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
        CartItem cartItem = cartItems.get(position);
        holder.getCartItemName().setText(cartItem.getDishName());
        holder.getPrice().setText(cartItem.getDishPrice().toString());

    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }
}



