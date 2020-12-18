package edu.neu.mad_sea.foodiesdelight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.neu.mad_sea.foodiesdelight.beans.CartItem;
import edu.neu.mad_sea.foodiesdelight.database.SQLLiteDB;

public class FoodDetailsOrder extends AppCompatActivity implements View.OnClickListener{
    private TextView foodName;
    private EditText qty;
    private Button addTocart;
    private Button goToCartocart;
    private  Button deleteCart;
    private SQLLiteDB db;
    private static final String TAG = "FoodDetailsOrder";

    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Insideeeee");
        setContentView(R.layout.activity_food_details_order);
         bundle = getIntent().getExtras();
        foodName = findViewById(R.id.foodNameId);
        qty = findViewById(R.id.qtyId);
        addTocart = findViewById(R.id.addtoCart);
        addTocart.setOnClickListener(this);
        goToCartocart = findViewById(R.id.gotoCart);
        goToCartocart.setOnClickListener(this);
        deleteCart = findViewById(R.id.deleteCart);
        deleteCart.setOnClickListener(this);
        foodName.setText(bundle.getString("dishName"));
        db = new SQLLiteDB(this);

    }

    @Override
    public void onClick(View v) {
        if (v == addTocart) {
            addToCart();
            Toast.makeText(FoodDetailsOrder.this, "Added to cart! ", Toast.LENGTH_SHORT).show();
        }else if(v == goToCartocart){
            Intent intent = new Intent(FoodDetailsOrder.this, CartAcitivity.class);
            startActivity(intent);
        }else if(v == deleteCart){
            deletecart();
        }


    }

    private void deletecart() {
        db.clearCart();
        Toast.makeText(FoodDetailsOrder.this, "Cleared the cart! ", Toast.LENGTH_SHORT).show();

    }

    private void addToCart() {
        CartItem c = new CartItem();
        c.setDishQty(Integer.valueOf(qty.getText().toString()));
        c.setDishName((String) foodName.getText());
        c.setDishPrice((float) (Integer.valueOf(qty.getText().toString()) * Integer.valueOf(bundle.getString("dishPrice"))));
        db.addItemTocart(c);
    }


}