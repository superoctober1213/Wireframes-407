package com.example.wireframes_407;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Timestamp;
import java.util.ArrayList;

public class DTBReadhistory {
    SQLiteDatabase sqLiteDatabase;

    public void DTBBottle(SQLiteDatabase sqLiteDatabase) {

        this.sqLiteDatabase = sqLiteDatabase;
    }

    public void createTable() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ReadhistoryDTB"  +
                " (historyId INTEGER PRIMARY KEY, usernameR TEXT, bottleID INTEGER, time DATE)");

    }

    public ArrayList<Readhistory> getHistoryByBottleID(int ID) {
        createTable();

        String q1 = "SELECT * FROM ReadhistoryDTB WHERE bottleID = this.ID";
        Cursor s = sqLiteDatabase.rawQuery(q1, null);

        int bottleIDIndex = s.getColumnIndex("bottleID");
        int timeIndex = s.getColumnIndex("time");
        int usernameRIndex = s.getColumnIndex("usernameR");

        s.moveToFirst();

        ArrayList<Readhistory> readhistories = new ArrayList<>();

        while (!s.isAfterLast()) {

            int bottleID = s.getInt(bottleIDIndex);
            Timestamp time = Timestamp.valueOf(s.getString(timeIndex));
            String usernameR = s.getString(usernameRIndex);

            // The ArrayList to save the information to return;
            Readhistory readhistory = new Readhistory(usernameR, bottleID, time);
            readhistories.add(readhistory);
            s.moveToNext();
        }
        s.close();
        sqLiteDatabase.close();

        return readhistories;
    }

    public ArrayList<Readhistory> getHistoryByUsernameR(String usernameF) {
        createTable();

        String q1 = "SELECT * FROM ReadhistoryDTB WHERE usernameR = usernameF";
        Cursor s = sqLiteDatabase.rawQuery(q1, null);

        int bottleIDIndex = s.getColumnIndex("bottleID");
        int timeIndex = s.getColumnIndex("time");
        int usernameRIndex = s.getColumnIndex("usernameR");

        s.moveToFirst();

        ArrayList<Readhistory> readhistories = new ArrayList<>();

        while (!s.isAfterLast()) {

            int bottleId = s.getInt(bottleIDIndex);
            Timestamp time = Timestamp.valueOf(s.getString(timeIndex));
            String usernameR = s.getString(usernameRIndex);

            // The ArrayList to save the information to return;
            Readhistory readhistory = new Readhistory(usernameR, bottleId, time);
            readhistories.add(readhistory);
            s.moveToNext();
        }
        s.close();
        sqLiteDatabase.close();

        return readhistories;

    }
 }