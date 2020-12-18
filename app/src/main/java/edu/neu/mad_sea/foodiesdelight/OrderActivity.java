package edu.neu.mad_sea.foodiesdelight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import edu.neu.mad_sea.foodiesdelight.beans.Order;
import edu.neu.mad_sea.foodiesdelight.holder.OrderHolder;

public class OrderActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Order, OrderHolder> adapter;
    FirebaseRecyclerOptions<Order> firebaseRecyclerOptions;
    private DatabaseReference orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        orders = FirebaseDatabase.getInstance().getReference(String.valueOf(R.string.Orders));

        recyclerView = findViewById(R.id.orderRv);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        getOrders();
    }

    private void getOrders(){
        adapter = new FirebaseRecyclerAdapter<Order, OrderHolder>(firebaseRecyclerOptions) {
            @Override
            protected void onBindViewHolder(@NonNull OrderHolder holder, int position, @NonNull Order model) {
                holder.orderUserName.setText(model.getUserName());
                holder.orderStatus.setText(model.getOrderUpdate());

            }

            @NonNull
            @Override
            public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_display_format, parent, false);
                return new OrderHolder(view);
            }
        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}