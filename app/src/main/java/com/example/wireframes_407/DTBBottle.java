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

    public void saveBottle(int bottleId, String usernameF, String date, String gender, String usernameR){
        createTable();
        sqLiteDatabase.execSQL(String.format("Insert"));
    }

}
