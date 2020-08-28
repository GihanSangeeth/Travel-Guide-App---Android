package com.example.travelguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CityViewActivity extends AppCompatActivity {
    TextView name, population, airport;
    ImageView img;

    String receivedAP;
    String receivedName;
    TextView t_temp,t_city,t_description,t_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_view);

        name = findViewById(R.id.city_name);
        population = findViewById(R.id.population);
        airport = findViewById(R.id.airport);
        img = findViewById(R.id.image);
        Intent intent = getIntent();
        receivedName =  intent.getStringExtra("name");
        String receivedPop =  intent.getStringExtra("pop");
        receivedAP =  intent.getStringExtra("airport");

        int receivedImage = intent.getIntExtra("image",0);
        name.setText(receivedName);
        population.setText(receivedPop);
        airport.setText(receivedAP);
        img.setImageResource(receivedImage);



        //weather------------------------------------
        t_temp = (TextView) findViewById(R.id.temp);
        t_city = (TextView) findViewById(R.id.city);
        t_description = (TextView) findViewById(R.id.status);
        t_date = (TextView) findViewById(R.id.date);
        find_weather();

    }
    public void find_weather(){
        Intent intent2 = getIntent();
        String receivedWeather =  intent2.getStringExtra("weather");
        String URL= ("https://api.openweathermap.org/data/2.5/weather?q="+receivedWeather+"&appid=4f7a00285efab986affd6042691cd1cc&units=metric");
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try{
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String temp = String.valueOf(main_object.getDouble("temp"));
                    String description = object.getString("description");
                    String city= response.getString("name");
                    t_temp.setText(temp+"C");
                    t_description.setText(description);
                    t_city.setText(city);

                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
                    String formatted_date = sdf.format(calendar.getTime());

                    t_date.setText(formatted_date);


                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);

    }
    public  void map(View view){

        Intent mapview= new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/?q="+receivedAP));
        startActivity(mapview);
    }
    public  void wiki(View view){

        Intent mapview= new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/"+receivedName));
        startActivity(mapview);

    }


}
