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

public class CityPage5 extends AppCompatActivity {

    ListView listView;

    String names[] = {"Ottawa, Canada","Vancouver, Canada","Toronto, Canada", "Montreal, Canada","Quebec City, ICanada"};
    int img[] = {R.drawable.ottawa, R.drawable.vancouver, R.drawable.toronto, R.drawable.montreal, R.drawable.quebeccity};
    String Description[]={
            "Canada’s capital, home to the National Gallery of Canada, Rideau Canal & the Winterlude festival.",
            "Hip coastal city with historic Granville Island, beaches, Capilano Suspension Bridge & Stanley Park.",
            "Big Canadian city with the soaring CN Tower, many parks, a large Chinatown & Royal Ontario Museum.",
            "Canadian city known for Vieux-Montréal (old city), Notre-Dame Basilica & Montreal Botanical Garden.",
            "Canadian city with Château Frontenac, Hôtel de Glace (seasonal ice hotel) & famed winter carnival"
    };

    String population[]={"994,837", "675,218 ", "2.93 million", "1.78 million", "542,298"};

    String airport[]={
            "Ottawa International Airport",
            "Vancouver International Airport",
            "FToronto Pearson International Airport",
            "Montréal-Pierre Elliott Trudeau International Airport",
            "Québec City Jean Lesage International Airport"

    };
    String weather[]={"Ottawa,CA","vancouver,CA","Toronto,CA","Montreal,CA","Quebec,CA"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_page5);
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
