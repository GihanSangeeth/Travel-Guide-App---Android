package com.example.travelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {


    private Button click;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click =(Button) findViewById(R.id.button);
        click.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                HomePage();
            }
        });




    }
    public void HomePage(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
    public void click(View view) {
        Intent click = new Intent(this, HomePage.class);
        startActivity(click);
    }
    public void signup(View view) {
        Intent signup = new Intent(this, Register.class);
        startActivity(signup);
    }


}

