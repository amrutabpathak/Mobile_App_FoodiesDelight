package edu.neu.mad_sea.foodiesdelight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.android.gms.common.internal.service.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import edu.neu.mad_sea.foodiesdelight.beans.Restaurant;
import edu.neu.mad_sea.foodiesdelight.holder.RestaurantHolder;
import edu.neu.mad_sea.foodiesdelight.interfaces.ClickListerner;

public class RestaurantsActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private DatabaseReference fbDatabaseref;
    private RestaurantAdapter adapter;
    FirebaseRecyclerOptions<Restaurant> recOptns;

    private static final String TAG = "RestaurantsActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        recyclerView = findViewById(R.id.rvRestaurantsId);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);
        fbDatabaseref = FirebaseDatabase.getInstance().getReference("restaurants");
        recOptns = new FirebaseRecyclerOptions.Builder<Restaurant>().setQuery(fbDatabaseref, Restaurant.class).build();
        adapter = new RestaurantAdapter(recOptns);
        Log.d(TAG, "onCreate: " + fbDatabaseref);
        Log.d(TAG, "onCreate: "+recOptns.getSnapshots().size());
        getRestuarants();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

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


    class RestaurantAdapter extends FirebaseRecyclerAdapter<Restaurant, RestaurantHolder> {

        public RestaurantAdapter(
                @NonNull
                        FirebaseRecyclerOptions<Restaurant> options) {
            super(options);
        }

        @Override
        protected void onBindViewHolder(@NonNull RestaurantHolder holder, int position, @NonNull Restaurant model) {
            holder.getRestTitle().setText(model.getRestTitle());
            holder.getRestDesc().setText(model.getRestDesc());
            holder.setItemClickListener(new ClickListerner() {
                @Override
                public void onClick(View view, int position) {
                    Log.d(TAG, "onClick: Image clicked");
                    Log.d(TAG, "onClick: adapter.getRef(position).getKey() "+adapter.getRef(position).getKey());
                    Restaurant r = new Restaurant();
                    r.setRestTitle(adapter.getRef(position).getKey());
                    MainActivity.setSelectedRestaurant(r);
                    Intent menu = new Intent(RestaurantsActivity.this, RestaurantDetailsActivity.class);
                    startActivity(menu);
                }
            });

        }

        @NonNull
        @Override
        public RestaurantHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                   int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_dsplay_format, parent, false);
            return new RestaurantHolder(view);
        }


    }
}