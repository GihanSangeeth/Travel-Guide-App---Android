package com.example.travelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CityPage3 extends AppCompatActivity {

    ListView listView;

    String names[] = {"Brasilia, Brazil","Rio de Janeiro, Brazil","São Paulo, Brazil", "Foz do Iguaçu, Brazil","Fortaleza, Brazil"};
    int img[] = {R.drawable.brasilia, R.drawable.rio, R.drawable.saopaulo, R.drawable.fozdo, R.drawable.fortaleza};
    String Description[]={
            "Inaugurated in 1960, Brazil’s capital is known for modernist monuments designed by Oscar Niemeyer.",
            "Brazilian city, home to Copacabana Beach, Sugarloaf Mountain, Carnaval & Christ the Redeemer statue.",
            "Vast Brazilian metropolis with iconic architecture, São Paulo Museum of Modern Art & shopping.",
            "Brazilian gateway city to Iguaçu Falls & its surrounding rainforest & Bird Park, plus Itaipu Dam.",
            "Capital of Brazil’s Ceará state, known for beaches, folkloric traditions & seaside Praia de Iracema."
    };

    String population[]={"2.481 million", "6.32 million", "12.18 million", "269 447", "2.643 million"};

    String airport[]={
            "International Airport of Brasilia",
            "Congonhas-São Paulo Airport",
            "Foz do Iguaçu/Cataratas International Airport",
            "Foz do Iguaçu/Cataratas International Airport",
            "Pinto Martins – Fortaleza International Airport"

    };
    String weather[]={"brasilia,BR","Rio de Janeiro,BR","Sao Paulo,BR","Foz do Iguacu,BR","Fortaleza,BR"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_page3);
        listView = findViewById(R.id.listview);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {


                Toast.makeText(getApplicationContext(),names[i],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),CityViewActivity.class);
                intent.putExtra("name",names[i]);
                intent.putExtra("image",img[i]);
                intent.putExtra("pop",population[i]);
                intent.putExtra("airport",airport[i]);
                intent.putExtra("weather",weather[i]);
                startActivity(intent);
            }
        });

    }
    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {

            return img.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.city_list,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.city_name);
            TextView description = view1.findViewById(R.id.Description);
            ImageView image = view1.findViewById(R.id.image_city);
            name.setText(names[i]);
            description.setText(Description[i]);
            image.setImageResource(img[i]);
            return view1;
        }
    }
}
