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

public class CityPage10 extends AppCompatActivity {

    ListView listView;

    String names[] = {"Bern, Switzerland","Zurich, Switzerland","Geneva, Switzerland", "Lucerne, Switzerland","Basel, Switzerland"};
    int img[] = {R.drawable.bern, R.drawable.zurich, R.drawable.genevea, R.drawable.lucerne, R.drawable.basel};
    String Description[]={
            "Swiss capital home to medieval Old Town & Zytglogge clock tower, plus a Paul Klee art museum.",
            "Global finance center with Old Town on the Limmat River, home to Fraumünster church & Landesmuseum.",
            "Swiss city on Lake Geneva with United Nations headquarters, a cobbled Old Town & art museums.",
            "Swiss lakeside city with medieval structures like the Museggmauer ramparts & covered Chapel Bridge.",
            "Swiss city with many museums, including Renzo Piano–designed Fondation Beyeler & Museum Tinguely."
    };

    String population[]={"1.035 million", "402,762", "499,480", "81,592", "559,000"};

    String airport[]={
            "Bern Airport",
            "Zurich Airport",
            "Genève Aéroport",
            "Zurich Airport",
            "Basel-Mulhouse Airport"

    };
    String weather[]={"Bern,CH","Zurich,CH","Geneva,CH","Lucerne,CH","Basel,CH"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_page10);
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
