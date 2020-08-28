package com.example.travelguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contact_db";

    public static final String TABLE_NAME ="contact_info";
    public static final String ID="id";
    public static final String NAME="name";
    public static final String EMAIL ="email";
    public static final String PASSWORD ="pw";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = " CREATE TABLE contact_info( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT," + EMAIL + " TEXT," + PASSWORD + " TEXT " + " );";

        sqLiteDatabase.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
    public long addUser(String user,String mail, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",user);
        contentValues.put("email",mail);
        contentValues.put("pw",password);
        long res = db.insert("contact_info",null,contentValues);
        db.close();
        return res;
    }
    public boolean checkuser(String username, String password) {
        String[] columns = {ID};
        SQLiteDatabase db = getReadableDatabase();
        String selection = NAME + "=?" + " and " + PASSWORD + "=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        db.close();

        if (count > 0) {
            return true;
        } else
            return false;
    }
}

