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

public class CityPage8 extends AppCompatActivity {

    ListView listView;

    String names[] = {"Wellington, New Zealand","Auckland, New Zealand","Rotorua, New Zealand", "Christchurch, New Zealand","Dunedin, New Zealand"};
    int img[] = {R.drawable.wellington, R.drawable.auckland, R.drawable.rotorua, R.drawable.christchurch, R.drawable.dunedin};
    String Description[]={
            "New Zealand’s capital, known for the Te Papa Museum, an iconic red cable car & windy weather.",
            "New Zealand city with busy port, home to Sky Tower viewpoint & Maori artifacts in Auckland Museum.",
            "Lakeside New Zealand city with geothermal activity at Pohuto Geyser, plus spas & Maori culture.",
            "City with Avon River boating, gardens & post-earthquake icons like the Cardboard Cathedral.",
            "City known for Victorian buildings & Scottish history, plus seabird colonies on the Otago Peninsula."
    };

    String population[]={"415,000", "1,606,564", "59,379", "381,500", "36,906"};

    String airport[]={
            "Wellington International Airport",
            "Auckland Airport",
            "Rotorua Regional Airport",
            "Christchurch International Airport",
            "Dunedin International Airport"

    };
    String weather[]={"Wellington,NZ","Auckland,NZ","Rotorua,NZ","Christchurch,NZ","Dunedin,NZ"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_page8);
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
