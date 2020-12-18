package edu.neu.mad_sea.foodiesdelight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import edu.neu.mad_sea.foodiesdelight.beans.CartItem;
import edu.neu.mad_sea.foodiesdelight.beans.Order;
import edu.neu.mad_sea.foodiesdelight.beans.RestOrder;
import edu.neu.mad_sea.foodiesdelight.beans.Restaurant;
import edu.neu.mad_sea.foodiesdelight.holder.RestOrderHolder;
import edu.neu.mad_sea.foodiesdelight.holder.RestaurantHolder;
import edu.neu.mad_sea.foodiesdelight.interfaces.ClickListerner;

public class RestSideViewOrderActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private DatabaseReference fbDatabaseref;
    private RestSideViewOrderAdapter adapter;
    FirebaseRecyclerOptions<Order> recOptns;
    String str = "";
    private static final String TAG = "RestSideViewOrderActivity";



    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_side_view_order);
        recyclerView = findViewById(R.id.rvRestSideOrdersId);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);
        fbDatabaseref = FirebaseDatabase.getInstance().getReference("Orders");
        recOptns = new FirebaseRecyclerOptions.Builder<Order>().setQuery(fbDatabaseref, Order.class).build();
        adapter = new RestSideViewOrderAdapter(recOptns);
        Log.d(TAG, "onCreate: " + fbDatabaseref);
        Log.d(TAG, "onCreate: "+recOptns.getSnapshots().size());
        getRestuarants();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    @SuppressLint("LongLogTag")
    private void getRestuarants() {


        Log.d(TAG, "getRestuarants: " + adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


    class RestSideViewOrderAdapter extends FirebaseRecyclerAdapter<Order, RestOrderHolder> {
        private static final String TAG1 = "RestSideViewOrderAdapter";

        public RestSideViewOrderAdapter(
                @NonNull
                        FirebaseRecyclerOptions<Order> options) {
            super(options);
        }


        @SuppressLint("LongLogTag")
        @Override
        protected void onBindViewHolder(@NonNull RestOrderHolder holder, int position, @NonNull Order model) {
            str="";
            Log.d(TAG1, "onBindViewHolder: "+adapter.getItemCount());//getItem(0).getCartItems().get(0).getDishName());
            for(int i = 0;i < adapter.getItemCount()-1; i++){
                str+=adapter.getItem(i+1).getCartItems().get(0).getDishName() + "  "+ adapter.getItem(i+1).getCartItems().get(0).getDishQty();
                str+="\n";
            }
            holder.getUserName().setText(model.getUserName());
            holder.getRestName().setText(model.getRestaurantName());
            /*for(CartItem c: model.getCartItems()){
                str= str+c.getDishName()+ "   "+ String.valueOf(c.getDishPrice()) +"\n";
            } */
            holder.getItems().setText(str);
            holder.setItemClickListener(new ClickListerner() {
                @SuppressLint("LongLogTag")
                @Override
                public void onClick(View view, int position) {
                    Log.d(TAG, "onClick: Image clicked");


                }
            });

        }

        @NonNull
        @Override
        public RestOrderHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                   int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restside_order_display_format, parent, false);
            return new RestOrderHolder(view);
        }


    }
}