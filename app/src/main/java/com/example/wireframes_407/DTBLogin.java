package com.example.wireframes_407;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DTBLogin {

    SQLiteDatabase sqLiteDatabase;

    public void DTBBottle(SQLiteDatabase sqLiteDatabase) {

        this.sqLiteDatabase = sqLiteDatabase;
    }

    public void createTable() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ListOfBottle" +
                " (bottleId INTEGER PRIMARY KEY, usernameF TEXT, date TEXT, gender TEXT, usernameR TEXT)");
    }

    /**
     * The form that save the bottle for history read
     *
     * @param username: The currently user's username.
     * @return
     */
    public ArrayList<BottleList> BottleRead(String username) {
        createTable();
        //SQL query for first use.
        String q = "SELECT * FROM ListOfBottle WHERE usernameR = username";
        Cursor c = sqLiteDatabase.rawQuery(q, null);

        int bottleIDIndex = c.getColumnIndex("bottleID");
        //int contentIndex = c.getColumnIndex("content");
        int dateIndex = c.getColumnIndex("date");
        int genderIndex = c.getColumnIndex("gender");
        int usernameRIndex = c.getColumnIndex("usernameR");
        int usernameFIndex = c.getColumnIndex("usernameF");

        c.moveToFirst();

        ArrayList<BottleList> historyLists = new ArrayList<>();

        while (!c.isAfterLast()) {

            int bottleId = c.getInt(bottleIDIndex);
            //String content = c.getString(contentIndex);
            String date = c.getString(dateIndex);
            String gender = c.getString(genderIndex);
            String usernameR = c.getString(usernameRIndex);
            String usernameF = c.getString(usernameFIndex);

            // The ArrayList to save the information to return;
            BottleList bottleList1 = new BottleList(usernameF, date, gender, usernameR, bottleId);
            historyLists.add(bottleList1);
            c.moveToNext();
        }
        c.close();
        sqLiteDatabase.close();

        return historyLists;
    }
}