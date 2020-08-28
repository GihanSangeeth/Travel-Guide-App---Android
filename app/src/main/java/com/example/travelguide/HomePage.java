package com.example.travelguide;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {
    int pageNum;
    String Title;
    String id;
    String Description ;
    int Img;
    DB_Sqlite_Favorite db_fav = new DB_Sqlite_Favorite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ImageView slideshow = findViewById(R.id.mainImage);
        AnimationDrawable animationDrawable = (AnimationDrawable) slideshow.getDrawable();
        animationDrawable.start();

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void btn_favorite1(View view) {
        pageNum = 0;
        Title = "Italy";
        id="0";
        Description= "Somthing about Italy";
        Img=R.drawable.italy;
        int check = db_fav.get_check_List_Favorite(Title);
        if (check>0){
            db_fav.Delete(id);
            Toast.makeText(this, "remove", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_shadow_24dp));


        }else{
            db_fav.Insert_to_favorite(Title,pageNum,Description,Img);
            Toast.makeText(this,"bookmarked", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_red_24dp));
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void btn_favorite2(View view) {
        pageNum = 1;
        Title = "Sri Lanka";
        id="1";
        Description= "Somthing about Sri Lanka";
        Img=R.drawable.srilanka;
        int check = db_fav.get_check_List_Favorite(Title);
        if (check>0){
            db_fav.Delete(id);
            Toast.makeText(this, "remove", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_shadow_24dp));
        }else{
            db_fav.Insert_to_favorite(Title,pageNum,Description,Img);
            Toast.makeText(this,"bookmarked", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_red_24dp));
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void btn_favorite3(View view) {
        pageNum = 2;
        Title = "Brazil";
        id="2";
        Description= "Somthing about brazil";
        Img=R.drawable.brazil;
        int check = db_fav.get_check_List_Favorite(Title);
        if (check>0){
            db_fav.Delete(id);
            Toast.makeText(this, "remove", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_shadow_24dp));
        }else{
            db_fav.Insert_to_favorite(Title,pageNum,Description,Img);
            Toast.makeText(this,"bookmarked", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_red_24dp));
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void btn_favorite4(View view) {
        pageNum = 3;
        Title = "Bhutan";
        id="3";
        Description= "Somthing about bhutan";
        Img=R.drawable.bhutan;
        int check = db_fav.get_check_List_Favorite(Title);
        if (check>0){
            db_fav.Delete(id);
            Toast.makeText(this, "remove", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_shadow_24dp));
        }else{
            db_fav.Insert_to_favorite(Title,pageNum,Description,Img);
            Toast.makeText(this,"bookmarked", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_red_24dp));
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void btn_favorite5(View view) {
        pageNum = 4;
        Title = "Canada";
        id="4";
        Description= "Somthing about canada";
        Img=R.drawable.canada;
        int check = db_fav.get_check_List_Favorite(Title);
        if (check>0){
            db_fav.Delete(id);
            Toast.makeText(this, "remove", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_shadow_24dp));
        }else{
            db_fav.Insert_to_favorite(Title,pageNum,Description,Img);
            Toast.makeText(this,"bookmarked", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_red_24dp));
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void btn_favorite6(View view) {
        pageNum = 5;
        Title = "Greece";
        id="5";
        Description= "Somthing about greece";
        Img=R.drawable.greece;
        int check = db_fav.get_check_List_Favorite(Title);
        if (check>0){
            db_fav.Delete(id);
            Toast.makeText(this, "remove", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_shadow_24dp));
        }else{
            db_fav.Insert_to_favorite(Title,pageNum,Description,Img);
            Toast.makeText(this,"bookmarked", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_red_24dp));
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void btn_favorite7(View view) {
        pageNum = 6;
        Title = "Ireland";
        id="6";
        Description= "Somthing about Ireland";
        Img=R.drawable.ireland;
        int check = db_fav.get_check_List_Favorite(Title);
        if (check>0){
            db_fav.Delete(id);
            Toast.makeText(this, "remove", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_shadow_24dp));
        }else{
            db_fav.Insert_to_favorite(Title,pageNum,Description,Img);
            Toast.makeText(this,"bookmarked", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_red_24dp));
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void btn_favorite8(View view) {
        pageNum = 7;
        Title = "New Zealand";
        id="7";
        Description= "Somthing about NZ";
        Img=R.drawable.auckland;
        int check = db_fav.get_check_List_Favorite(Title);
        if (check>0){
            db_fav.Delete(id);
            Toast.makeText(this, "remove", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_shadow_24dp));
        }else{
            db_fav.Insert_to_favorite(Title,pageNum,Description,Img);
            Toast.makeText(this,"bookmarked", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_red_24dp));
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void btn_favorite9(View view) {
        pageNum = 8;
        Title = "Spain";
        id="8";
        Description= "Somthing about Spain";
        Img=R.drawable.spain;
        int check = db_fav.get_check_List_Favorite(Title);
        if (check>0){
            db_fav.Delete(id);
            Toast.makeText(this, "remove", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_shadow_24dp));
        }else{
            db_fav.Insert_to_favorite(Title,pageNum,Description,Img);
            Toast.makeText(this,"bookmarked", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_red_24dp));
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void btn_favorite10(View view) {
        pageNum = 9;
        Title = "Switzerland";
        id="9";
        Description= "Somthing about Switzerland";
        Img=R.drawable.switzerland;
        int check = db_fav.get_check_List_Favorite(Title);
        if (check>0){
            db_fav.Delete(id);
            Toast.makeText(this, "remove", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_shadow_24dp));
        }else{
            db_fav.Insert_to_favorite(Title,pageNum,Description,Img);
            Toast.makeText(this,"bookmarked", Toast.LENGTH_SHORT).show();
            view.setBackground(getResources().getDrawable(R.drawable.ic_favorite_red_24dp));
        }

    }
    public void favorite(View view) {

        Intent intent = new Intent(this,favorite.class);
        startActivity(intent);

    }
    public void click_italy(View view) {

        Intent intent = new Intent(this,CityPage.class);
        startActivity(intent);
    }
    public void click_SL(View view) {

        Intent intent = new Intent(this,CityPage2.class);
        startActivity(intent);
    }
    public void click_BR(View view) {

        Intent intent = new Intent(this,CityPage3.class);
        startActivity(intent);
    }
    public void click_BH(View view) {

        Intent intent = new Intent(this,CityPage4.class);
        startActivity(intent);
    }
    public void click_CA(View view) {

        Intent intent = new Intent(this,CityPage5.class);
        startActivity(intent);
    }
    public void click_GR(View view) {

        Intent intent = new Intent(this,CityPage6.class);
        startActivity(intent);
    }
    public void click_IR(View view) {

        Intent intent = new Intent(this,CityPage7.class);
        startActivity(intent);
    }
    public void click_NZ(View view) {

        Intent intent = new Intent(this,CityPage8.class);
        startActivity(intent);
    }
    public void click_SP(View view) {

        Intent intent = new Intent(this,CityPage9.class);
        startActivity(intent);
    }
    public void click_SW(View view) {

        Intent intent = new Intent(this,CityPage10.class);
        startActivity(intent);
    }
}
