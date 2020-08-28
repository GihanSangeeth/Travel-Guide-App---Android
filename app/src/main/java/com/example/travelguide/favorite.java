package com.example.travelguide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class favorite extends AppCompatActivity {


    ArrayList<String> listIndex = new ArrayList<String>();
    //ArrayList<String> listDes = new ArrayList<String>();
    ArrayList<Integer> listImg = new ArrayList<Integer>();
    ArrayList<List_itme_Index> List_Favorite = new ArrayList<List_itme_Index>();

    DB_Sqlite_Favorite db_fav = new DB_Sqlite_Favorite(this);
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        List_Favorite = db_fav.get_All_Favorite();
        for (int i = 0; i < List_Favorite.size(); i++) {
            listIndex.add(List_Favorite.get(i).getMain_Title());
            //listDes.add(List_Favorite.get(i).getDescription());
            listImg.add(List_Favorite.get(i).getImg());
        }




        listView = findViewById(R.id.favlistview);
        MyAdapter adapter = new MyAdapter(this,listIndex,listImg);
        listView.setAdapter(adapter);


    }
    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        ArrayList<String> favItem;
        ArrayList<String> listDes;
        ArrayList<Integer> listImg;


        MyAdapter(Context c, ArrayList<String> name,ArrayList<Integer> Img){
            super(c,R.layout.fav_list,R.id.favitems,listIndex);
            this.context=c;
            this.favItem= name;
            //this.listDes=des;
            this.listImg= Img;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater =(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.fav_list,parent, false);
            TextView myItem = row.findViewById(R.id.favitems);
            ImageView imageView = row.findViewById(R.id.imageView);
            //TextView myItem2 = row.findViewById(R.id.num);
            myItem.setText(listIndex.get(position));
            //myItem2.setText(listDes.get(position));
            imageView.setImageResource(listImg.get(position));
            return row;
        }
    }
}

