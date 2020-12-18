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

public class CustomerLoginInActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCustLogin;
    DatabaseReference fbDatabaseRef;
    private static final String TAG = "CustomerLoginInActivity";
    private TextView txtUserName;
    private TextView txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login_in);
        btnCustLogin = findViewById(R.id.btnCustLogInId);
        txtUserName = findViewById(R.id.ipUserName);
        txtPassword = findViewById(R.id.ippasswordId);

        btnCustLogin.setOnClickListener(this);
        fbDatabaseRef = FirebaseDatabase.getInstance().getReference();


    }

    @Override
    public void onClick(View v) {
        Users user = new Users();
        user.setUserName(txtUserName.getText().toString());
        user.setPassword(txtPassword.getText().toString());
        MainActivity.setUser(user);
        Intent intent = new Intent(CustomerLoginInActivity.this, RestaurantsActivity.class);
        startActivity(intent);
        finish();
    }
    // Commenting to disable the login check functionality
        /*
        DatabaseReference users = fbDatabaseRef.child(getString(R.string.fireBaseUsers));
        Log.d(TAG, "onClick: 2nd line");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.child(txtUserName.getText().toString()).exists()) {
                    Log.d(TAG, "onClick: User exists");
                    Users user = dataSnapshot.child(txtUserName.getText().toString()).getValue(Users.class);
                    user.setUserName(txtUserName.getText().toString());
                    if(user.getPassword().equals(txtPassword.getText().toString())){
                        MainActivity.setUser(user);
                        Intent intent = new Intent(CustomerLoginInActivity.this, RestaurantsActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(CustomerLoginInActivity.this, "Please check your password", Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(CustomerLoginInActivity.this, "Please register", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        };
        users.addListenerForSingleValueEvent(eventListener);
    } */
}