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
import android.widget.AdapterView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import edu.neu.mad_sea.foodiesdelight.beans.RestMenu;
import edu.neu.mad_sea.foodiesdelight.beans.Restaurant;
import edu.neu.mad_sea.foodiesdelight.holder.RestMenuHolder;
import edu.neu.mad_sea.foodiesdelight.holder.RestaurantHolder;
import edu.neu.mad_sea.foodiesdelight.interfaces.ClickListerner;

public class RestaurantDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private DatabaseReference fbDatabaseref;
    private FirebaseRecyclerAdapter adapter;
    private static final String TAG = "RestaurantDetailsActivity";
    FirebaseRecyclerOptions<RestMenu> recOptns;


    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        Log.d(TAG, "onClick: Opens menu");

        recyclerView = findViewById(R.id.rvRestaurantDetailsId);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        fbDatabaseref = FirebaseDatabase.getInstance().getReference("restaurants").child(MainActivity.getSelectedRestaurant().getRestTitle()).child("menu");

        Log.d(TAG, "onCreate: fbDatabaseref "+fbDatabaseref);
        recOptns = new FirebaseRecyclerOptions.Builder<RestMenu>().setQuery(fbDatabaseref, RestMenu.class).build();
        Log.d(TAG, "onCreate: "+recOptns.getSnapshots().size());
        adapter = new RestMenuAdapter(recOptns);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

   /* private void getRestuarantDetails() {


        adapter = new FirebaseRecyclerAdapter<RestMenu, RestMenuHolder>(firebaseRecyclerOptions) {
            @NonNull
            @Override
            public RestMenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_display_format, parent, false);
                return new RestMenuHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull RestMenuHolder holder, int position, @NonNull RestMenu model) {
              /*  holder.getMenuName().setText(model.getMenuName());
                holder.getMenuDesc().setText(model.getMenuDesc());
                holder.getMenuImage().setText(model.getMenuImg());


                Picasso.get().load(model.getImage())
                        .into(holder.menuImage);

                final Category clickItem = model;
                holder.getMenuImage().setOnClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        //Toast.makeText(HomeActivity.this, "" + clickItem.getName(), Toast.LENGTH_SHORT).show();
                        //Get CategoryId and send to new activity
                        Intent foodList = new Intent(RestaurantDetailsActivity.this, FoodListActivity.class);
                        //Because CategoryId is a key, so we just key of this item
                        foodList.putExtra(Common.CATEGORY_ID, adapter.getRef(position).getKey());
                        startActivity(foodList);
                    }
                });
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }*/


    class RestMenuAdapter extends FirebaseRecyclerAdapter<RestMenu, RestMenuHolder> {

        public RestMenuAdapter(
                @NonNull
                        FirebaseRecyclerOptions<RestMenu> options) {
            super(options);
        }

        @Override
        protected void onBindViewHolder(@NonNull RestMenuHolder holder, int position, @NonNull RestMenu model) {
            holder.getMenuName().setText(model.getMenuName());
            holder.getMenuDesc().setText(model.getMenuDesc());
            holder.getPrice().setText(model.getPrice());
            holder.setItemClickListener(new ClickListerner() {
                @Override
                public void onClick(View view, int position) {
                    Bundle bundle = new Bundle();
                    bundle.putString("dishName", adapter.getRef(position).getKey());
                    bundle.putString("dishPrice", "10");


                    Intent menu = new Intent(RestaurantDetailsActivity.this, FoodDetailsOrder.class);
                    menu.putExtras(bundle);
                    startActivity(menu);
                }
            });

        }

        @NonNull
        @Override
        public RestMenuHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                   int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_display_format, parent, false);
            return new RestMenuHolder(view);
        }




    }
    }