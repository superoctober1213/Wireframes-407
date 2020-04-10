package com.example.wireframes_407;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Save the list of the bottle
 * The list include usernameF(bottle main from), date and gender.
 */
public class DTBBottle {

    SQLiteDatabase sqLiteDatabase;

    public void DTBBottle (SQLiteDatabase sqLiteDatabase){

        this.sqLiteDatabase = sqLiteDatabase;
    }

    public void createTable() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Bottlecontent" +
                " (bottleId INTEGER PRIMARY KEY, usernameF TEXT, date TEXT, gender TEXT, usernameR TEXT)");
    }

    public ArrayList<BottleList> readBottle(String usernameF){
        createTable();
        Cursor c  = sqLiteDatabase.rawQuery(String.format("Pick a Bottle where username is %s", usernameF), null);

        int bottleIdIndex = c.getColumnIndex("bottleId");
        int dateIndex = c.getColumnIndex("date");
        int genderIndex = c.getColumnIndex("gender");
        int usernameRIndex = c.getColumnIndex("usernameR");

        c.moveToFirst();

        ArrayList<BottleList> bottleLists = new ArrayList<>();

        while (!c.isAfterLast()){

            int bottleId = c.getInt(bottleIdIndex);
            String date = c.getString(dateIndex);
            String gender = c.getString(genderIndex);
            String usernameR = c.getString(usernameRIndex);

            BottleList bottleList = new BottleList(usernameF, date, gender, usernameR, bottleId);
            bottleLists.add(bottleList);
            c.moveToNext();
        }
        c.close();
        sqLiteDatabase.close();

        return bottleLists;
    }

    public void saveBottle(int bottleId, String usernameF, String date, String gender, String usernameR){
        createTable();
        sqLiteDatabase.execSQL(String.format("Insert"));
    }

}
