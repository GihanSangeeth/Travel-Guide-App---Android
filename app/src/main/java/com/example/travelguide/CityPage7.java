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

public class CityPage7 extends AppCompatActivity {

    ListView listView;

    String names[] = {"Dublin, Ireland","Galway, Ireland","Cork, Ireland", "Limerick, Ireland","Kilkenny, Ireland"};
    int img[] = {R.drawable.dublin, R.drawable.galway, R.drawable.cork, R.drawable.lime, R.drawable.kilkenny};
    String Description[]={
            "The Republic of Ireland's capital, home to the Book of Kells, Dublin Castle & numerous museums.",
            "Irish city with bustling Eyre Square, medieval St. Nicholas’ Church & a vibrant arts scene.",
            "Irish city known for its 19th-century gaol, Shandon Church bells & Blarney Castle's famed stone.",
            "Irish city with medieval sites like King John's Castle & St. Mary's church, plus Hunt Museum art.",
            "Medieval Irish town known for Kilkenny Castle & its historic churches, plus local crafts & pubs."
    };

    String population[]={"1.388 million", "79,934", "190,384", "94,192", "21,589"};

    String airport[]={
            "Dublin Airport",
            "Shannon Airport",
            "Cork Airport",
            "Shannon(SNN) Airport",
            "Dublin Airport"

    };
    String weather[]={"Dublin,IE","Galway,IE","Cork,IE","Limerick,IE","Kilkenny,IE"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_page7);
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
