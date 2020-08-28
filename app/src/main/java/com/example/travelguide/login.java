package com.example.travelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;

public class login extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    TextView register;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        username = (EditText)findViewById(R.id.un);
        password = (EditText)findViewById(R.id.pw);
        login = (Button)findViewById(R.id.login);
        register = (TextView) findViewById(R.id.reg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(login.this, Register.class);
                startActivity(registerIntent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String pwd= password.getText().toString().trim();
                Boolean res = db.checkuser(user, pwd);
                if(res == true){
                    Intent instant = new Intent(login.this, HomePage.class);
                    startActivity(instant);
                }
                else {
                    Toast.makeText(login.this,"Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
