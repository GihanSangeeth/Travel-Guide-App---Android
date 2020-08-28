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

public class CityPage4 extends AppCompatActivity {

    ListView listView;

    String names[] = {"Thimphu, Bhutan","Paro, Bhutan","Punakha, Bhutan", "Trongsa, Bhutan","Laya, Bhutan"};
    int img[] = {R.drawable.thimphu, R.drawable.paro, R.drawable.punakha, R.drawable.trongsa, R.drawable.laya};
    String Description[]={
            "Bhutan's capital city home to Tashichho Dzong, a huge Buddha statue & a weekend farmer's market.",
            "Bhutanese town in the Paro Valley known for Taktsang Palphug monastery & Drukgyel Dzong fortress.",
            "Bhutanese town known for the Punakha Dzong riverside fortress, plus temples in the Punakha Valley.",
            "Dzong architecture and museums.",
            "Hikings, yaks, hot springs, and climbing."
    };

    String population[]={"114,551", "11,448", "6,262", "19,960", " 3,000"};

    String airport[]={
            "Paro International Airport",
            "Paro International Airport",
            "Paro International Airport",
            "Lokpriya Gopinath Bordoloi International Airport",
            "Paro International Airport "

    };
    String weather[]={"Thimphu,BT","Paro,BT","Punakha,BT","Tongsa,BT","Laya,BT"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_page4);
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
