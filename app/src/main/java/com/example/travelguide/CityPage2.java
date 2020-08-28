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

public class CityPage2 extends AppCompatActivity {

    ListView listView;

    String names[] = {"Colombo, Sri Lanka","Kandy, Sri Lanka","Nuwara Eliya, Sri Lanka", "Anuradhapura, Sri Lanka","Unawatuna, Sri Lanka"};
    int img[] = {R.drawable.colombo, R.drawable.kandy, R.drawable.nuwaraeliya, R.drawable.anuradhapura, R.drawable.unawatuna};
    String Description[]={
            "Sri Lankan capital with National Museum, Gangaramaya Temple & oceanside promenade Galle Face Green.",
            "Hilly, large Sri Lankan city with the Temple of the Tooth shrine, home to a Buddhist relic.",
            "Sri Lankan highland city, with Hakgala Botanical Gardens, Seetha Amman Temple & Galway’s Land Park.",
            "Buddhism, ancient history, and temples",
            "Small town in Sri Lanka, known for its coral reef, Unawatuna Beach & the Japanese Peace Pagoda."
    };

    String population[]={"2752,993", "125,400", "731,415", "50,595", " 5,088"};

    String airport[]={
            "Bandaranaike International Airport",
            "Bandaranaike International Airport",
            "Mattala Rajapaksa Hambantota Airport",
            "Bandaranaike International Airport",
            "Mattala Rajapaksa Hambantota Airport"

    };
    String weather[]={"colombo,LK","kandy","nuwara eliya","anuradhapura","unawatuna"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_page2);
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
