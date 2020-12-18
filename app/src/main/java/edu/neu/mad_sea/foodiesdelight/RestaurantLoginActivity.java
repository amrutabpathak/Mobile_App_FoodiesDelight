package edu.neu.mad_sea.foodiesdelight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import edu.neu.mad_sea.foodiesdelight.beans.Users;

public class RestaurantLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRestLogin;
    DatabaseReference fbDatabaseRef;
    private static final String TAG = "RestaurantLoginActivity";
    private TextView txtRestUserName;
    private TextView txtRestPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_login);
        btnRestLogin = findViewById(R.id.restLogInId);
        txtRestUserName = findViewById(R.id.restUserName);
        txtRestPassword = findViewById(R.id.restpasswordId);

        btnRestLogin.setOnClickListener(this);
        fbDatabaseRef = FirebaseDatabase.getInstance().getReference();


    }

    @Override
    public void onClick(View v) {
        Users user = new Users();
        user.setUserName(txtRestUserName.getText().toString());
        user.setPassword(txtRestPassword.getText().toString());
        MainActivity.setUser(user);
        Intent intent = new Intent(RestaurantLoginActivity.this, RestSideViewOrderActivity.class);
        startActivity(intent);
        finish();

        // Commenting to disable the login check functionality
        /*
        DatabaseReference users = fbDatabaseRef.child(getString(R.string.fireBaseRestUsers));
        Log.d(TAG, "onClick: 2nd line");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.child(txtRestUserName.getText().toString()).exists()) {
                    Log.d(TAG, "onClick: User exists");
                    Users user = dataSnapshot.child(txtRestUserName.getText().toString()).getValue(Users.class);
                    user.setUserName(txtRestUserName.getText().toString());
                    if(user.getPassword().equals(txtRestPassword.getText().toString())){
                        MainActivity.setUser(user);
                        Intent intent = new Intent(RestaurantLoginActivity.this, RestSideViewOrderActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(RestaurantLoginActivity.this, "Please check your password", Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(RestaurantLoginActivity.this, "Please register", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        };
        users.addListenerForSingleValueEvent(eventListener);
    */}
}