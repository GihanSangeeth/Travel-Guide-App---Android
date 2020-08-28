package com.example.travelguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    DatabaseHelper db;
    EditText username;
    EditText email;
    EditText password;
    Button register;
    TextView login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db =new DatabaseHelper(this);
        username = (EditText)findViewById(R.id.username);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        register = (Button)findViewById(R.id.signup);
        login = (TextView) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(Register.this,login.class);
                startActivity(LoginIntent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String mail= email.getText().toString().trim();
                String pwd= password.getText().toString().trim();
                long val =db.addUser(user,mail,pwd);
                if (val> 0){
                    Toast.makeText(Register.this, "You have registered",Toast.LENGTH_SHORT).show();
                    Intent moveToLogin = new Intent(Register.this,login.class);
                    startActivity(moveToLogin);
                }
                else {
                    Toast.makeText(Register.this, "Registration Error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

