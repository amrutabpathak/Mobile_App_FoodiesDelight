package edu.neu.mad_sea.foodiesdelight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.neu.mad_sea.foodiesdelight.adapter.CartAdapter;
import edu.neu.mad_sea.foodiesdelight.beans.CartItem;
import edu.neu.mad_sea.foodiesdelight.beans.Order;
import edu.neu.mad_sea.foodiesdelight.database.SQLLiteDB;
import edu.neu.mad_sea.foodiesdelight.utils.Constants;

import static com.google.firebase.database.FirebaseDatabase.*;

public class CartAcitivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView.Adapter adapter;
    private SQLLiteDB db;
    private Button btinOrder;
    private TextView totalView;
    DatabaseReference orders;
    private List<CartItem> ci;
    private static final String TAG = "CartAcitivity";
    private float total =  0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_acitivity);
        recyclerView = findViewById(R.id.rvCart);
        totalView = findViewById(R.id.total);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        orders = getInstance().getReference(getString(R.string.Orders));
        ci = getCartItems(MainActivity.getSelectedRestaurant().getRestTitle(), MainActivity.getUser().getUserName());
        Log.d(TAG, "onCreate: "+ci.size());

        for(CartItem c :ci){
            total+=c.getDishPrice();
            Log.d(TAG, "onCreate: "+c.getDishName());

        }
        totalView.setText(String.valueOf(total));
        btinOrder = findViewById(R.id.btnOrder);
        btinOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order o = new Order();
                o.setRestaurantName(MainActivity.getSelectedRestaurant().getRestTitle());
                o.setUserName(MainActivity.getUser().getUserName());
                o.setCartItems(ci);
                o.setOrderUpdate(Constants.ORDER_NEW);

                orders.child(String.valueOf(System.currentTimeMillis())).setValue(o);

                db.clearCart();
                Toast.makeText(CartAcitivity.this, "Order has been placed. Check status! ", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }

    private List<CartItem> getCartItems(String resturantName, String userId){
        db = new SQLLiteDB(this);
        List<CartItem> itemList = db.getAllItemsFromCart(resturantName, userId);
        adapter = new CartAdapter(itemList,this);
        recyclerView.setAdapter(adapter);
        return itemList;

    }
}