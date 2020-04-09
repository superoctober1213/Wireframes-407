package com.example.wireframes_407;

import android.database.sqlite.SQLiteDatabase;

/** Save the inside bottle.
 *  Save the comment, gender information under the main content.
 */
public class DTBhistory {
    SQLiteDatabase sqLiteDatabase;

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }
    public void createTable() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Bottlecontent"  +
                " (bottleID INTEGER PRIMARY KEY, usernameF TEXT, content TEXT, date TEXT, gender TEXT," +
                "usernameR TEXT, usernameC TEXT)");
    }
}

