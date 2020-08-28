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

public class CityPage6 extends AppCompatActivity {

    ListView listView;

    String names[] = {"Athens, Greece","Santorini, Greece","Rhodes, Greece", "Chania, Greece","Crete , Greece"};
    int img[] = {R.drawable.athens, R.drawable.santorini, R.drawable.rhodes, R.drawable.chania, R.drawable.crete};
    String Description[]={
            "Greece’s capital, famous for preserved ancient ruins like the Acropolis citadel & Parthenon temple.",
            "Aegean island with whitewashed villages Fira & Oia, beaches, a volcanic landscape & Minoan ruins.",
            "Greek island known for Rhodes City's medieval landmarks, Kamiros' ancient ruins & beaches.",
            "City on the Greek island of Crete, with Venetian harbor, 16th-century lighthouse & Nautical Museum.",
            "Mountainous Greek island with Knossos Bronze Age site, Heraklion Museum & Vai & Elafonisi beaches."
    };

    String population[]={"3,153,000", "15,500", "49,541", "159,576", "634,930"};

    String airport[]={
            "Athens International Airport",
            "Santorini National Airport",
            "Rhodes International Airport",
            "Chania International Airport",
            "Heraklion International Airport"

    };
    String weather[]={"Athens,GR","Santorini,GR","Rhodes,GR","Chania,GR","crete,GR"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_page6);
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
