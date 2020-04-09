package com.example.wireframes_407;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/** Save the inside bottle.
 *  Save the comment, gender information under the main content.
 */
public class DTBHistory {

    SQLiteDatabase sqLiteDatabase;

    public DTBHistory (SQLiteDatabase sqLiteDatabase){
        this.sqLiteDatabase = sqLiteDatabase;
    }

    public void createTable() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Bottlecontent"  +
                " (bottleID INTEGER PRIMARY KEY, usernameF TEXT, content TEXT, date TEXT, gender TEXT, usernameC TEXT)");
    }

    public ArrayList<HistoryList> readHistory(String usernameF){
        createTable();
        Cursor c = sqLiteDatabase.rawQuery(String.format("Select * from history where username is '%s'", usernameF), null);

        int bottleIDIndex = c.getColumnIndex("bottleID");
        int contentIndex = c.getColumnIndex("content");
        int dateIndex = c.getColumnIndex("date");
        int genderIndex = c.getColumnIndex("gender");
        int usernameCIndex = c.getColumnIndex("usernameC");

        c.moveToFirst();

        ArrayList<HistoryList> historyLists = new ArrayList<>();

        while (!c.isAfterLast()){

            int bottleId = c.getInt(bottleIDIndex);
            String content = c.getString(contentIndex);
            String date = c.getString(dateIndex);
            String gender = c.getString(genderIndex);
            String usernameC = c.getString(usernameCIndex);

            HistoryList historyList = new HistoryList(usernameF, date, gender, content, usernameC, bottleId);
            historyLists.add(historyList);
            c.moveToNext();
        }
        c.close();
        sqLiteDatabase.close();

        return historyLists;
    }
}

