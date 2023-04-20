package com.example.loginapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username=(EditText)findViewById(R.id.username);
                EditText email=(EditText)findViewById(R.id.email);
                EditText mobile=(EditText)findViewById(R.id.mobile);
                EditText password=(EditText)findViewById(R.id.password);

                myRef = database.getReference("UserDetails");
                User user = new User(username.getText().toString(),email.getText().toString(),mobile.getText().toString(),password.getText().toString());
                        myRef.push().setValue(user);
                            username.setText("");
                            email.setText("");
                            mobile.setText("");
                            password.setText("");

                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                startActivity(intent);

            }
        });
    }
}
