package com.example.wireframes_407;

import android.database.sqlite.SQLiteDatabase;

/**
 * Save the list of the bottle
 * The list include usernameF(bottle main from), date and gender.
 */
public class DTBbottle {

    SQLiteDatabase sqLiteDatabase;

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }

    public void createTable() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Bottlecontent" +
                " (commentId INTEGER PRIMARY KEY, usernameF TEXT, date TEXT, gender TEXT, usernameR TEXT)");
    }
}
