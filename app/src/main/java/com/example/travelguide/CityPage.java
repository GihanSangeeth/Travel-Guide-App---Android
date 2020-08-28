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

public class CityPage extends AppCompatActivity {

    ListView listView;

    String names[] = {"Rome, Italy","Venice, Italy","Florence, Italy", "Ischia, Italy","Amalfi, Italy"};
    int img[] = {R.drawable.rome, R.drawable.venice, R.drawable.florence, R.drawable.ischia, R.drawable.amalfi};
    String Description[]={
            "Italy's capital, home to the Vatican as well as world-class art and ancient ruins like the Colosseum.",
            "Italian island city known for canals lined with Gothic palaces, Piazza San Marco square & Carnival.",
            "Tuscan capital with Renaissance art (Michelangelo's David) and architecture (Brunelleschi's Duomo).",
            "Italian island, known for its thermal waters, Cartaromana Beach & the medieval Aragonese Castle.",
            "Resort town with port & medieval architecture such as Sant'Andrea cathedral & Museo Arsenale Amalfi."
    };

    String population[]={"2.873 million", "261,905", "382,258", "22,487", " 5,088"};

    String airport[]={
            "Aeroporto di Roma-Ciampino",
            "Venice Marco Polo Airport",
            "Florence Airport, Peretola",
            "Naples International Airport",
            "Salerno Costa d'Amalfi Airport"

    };
    String weather[]={"rome,IT","venice,IT","florence,IT","ischia,IT","amalfi,IT"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_page);
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
