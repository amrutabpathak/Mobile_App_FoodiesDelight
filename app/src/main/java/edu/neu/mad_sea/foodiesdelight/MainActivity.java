package edu.neu.mad_sea.foodiesdelight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import edu.neu.mad_sea.foodiesdelight.beans.Restaurant;
import edu.neu.mad_sea.foodiesdelight.beans.Users;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnRegister;
    private Button btnCustSignIn;
    private Button btnRestauramtSignIn;
    private static final String TAG = "MainActivity";

    public Users getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Users currentUser) {
        this.currentUser = currentUser;
    }

    private Users currentUser;

    public static Restaurant getSelectedRestaurant() {
        return selectedRestaurant;
    }

    public static void setSelectedRestaurant(Restaurant selectedRestaurant) {
        MainActivity.selectedRestaurant = selectedRestaurant;
    }

    private static Restaurant selectedRestaurant;

    public static Users getUser() {
        return user;
    }

    public static void setUser(Users user) {
        MainActivity.user = user;
    }

    public static Users user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        btnRegister = findViewById(R.id.btnRegisterId);
        btnCustSignIn = findViewById(R.id.btnCustSignInId);
        btnRestauramtSignIn = findViewById(R.id.btnRestauramtSignInId);

        btnCustSignIn.setOnClickListener(this);
        btnRestauramtSignIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: "+v);
        if (v == btnCustSignIn) {
            Intent intent = new Intent(this, CustomerLoginInActivity.class);
            startActivity(intent);

        } if(v == btnRestauramtSignIn){
            Log.d(TAG, "onClick: inside btnRestauramtSignIn");
            Intent intent = new Intent(this, RestaurantLoginActivity.class);
            startActivity(intent);

        }
    }
}