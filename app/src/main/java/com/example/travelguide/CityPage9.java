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

public class CityPage9 extends AppCompatActivity {

    ListView listView;

    String names[] = {"Madrid, Spain","Barcelona, Spain","Seville, Spain", "Málaga, Spain","Bilbao, Spain"};
    int img[] = {R.drawable.madrid, R.drawable.barcelon, R.drawable.seville, R.drawable.malaga, R.drawable.bilbao};
    String Description[]={
            "Spain's capital, home to the Royal Palace & major art museums like the Prado & Reina Sofía.",
            "Catalan capital known for Gaudí’s whimsical architecture, the Gothic Quarter & tapas bars.",
            "Spanish city of flamenco, with a Gothic cathedral, medieval Jewish quarter & the Alcázar castle.",
            "Seaside city on Spain’s Costa del Sol that’s the birthplace of Picasso & home to 2 Moorish citadels.",
            "Northern Spanish city famed for its Guggenheim Museum Bilbao, car-free old town & Basque cuisine."
    };

    String population[]={"6,618,000", "5.575 million", "1.95 million", "569,005", "345,821"};

    String airport[]={
            "Madrid-Barajas Adolfo Suárez Airport",
            "Josep Tarradellas Barcelona-El Prat Airport",
            "Seville Airport",
            "Torre de Control Aeropuerto de Málaga",
            "Bilbao Airport"

    };
    String weather[]={"Madrid,ES","Barcelona,ES","Seville,ES","Málaga,ES","Bilbao,ES"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_page9);
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
