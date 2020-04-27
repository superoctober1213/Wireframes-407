package com.example.wireframes_407;

import java.sql.Timestamp;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

/**
 * Save the list of the bottle.
 * 1. Bottle that user send.
 * 2. Bottle that user read before.
 * The list include usernameF(bottle main from), date and gender.
 */
public class DTBBottle {

    SQLiteDatabase sqLiteDatabase;

    public void DTBBottle(SQLiteDatabase sqLiteDatabase) {

        this.sqLiteDatabase = sqLiteDatabase;
    }

    public void createTable() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS BottleDTB" +
                " (bottleId INTEGER PRIMARY KEY, usernameF TEXT, date DATETIME, gender TEXT, usernameR TEXT, content TEXT)");
    }


    /**
     * The information for save the bottle that the usersend before.
     *
     * @param Username: The currently user's username.
     * @return
     */
    public ArrayList<Bottle> BottleMade(String Username) {
        createTable();

        String q1 = "SELECT * FROM BottleDTB WHERE usernameF = username";
        Cursor s = sqLiteDatabase.rawQuery(q1, null);

        int bottleIDIndex = s.getColumnIndex("bottleID");
        //int contentIndex = c.getColumnIndex("content");
        int dateFIndex = s.getColumnIndex("dateF");
        int genderFIndex = s.getColumnIndex("genderF");
        int contentIndex = s.getColumnIndex("content");
        int usernameFIndex = s.getColumnIndex("usernameF");

        s.moveToFirst();
        // The ArrayList to save the information to return;
        ArrayList<Bottle> bottleMade = new ArrayList<>();

        while (!s.isAfterLast()) {

            int bottleId = s.getInt(bottleIDIndex);
            Timestamp dateF = Timestamp.valueOf(s.getString(dateFIndex));
            String genderF = s.getString(genderFIndex);
            String content = s.getString(contentIndex);
            String usernameF = s.getString(usernameFIndex);

            // The ArrayList to save the information to return;
            Bottle bottle = new Bottle( usernameF, dateF, genderF,content, bottleId);
            bottleMade.add(bottle);
            s.moveToNext();
        }
        s.close();
        sqLiteDatabase.close();

        return bottleMade;
    }

    public ArrayList<Bottle> Viewbottle(int BottleID) {
        createTable();
        return null;
    }

    public void ThrowBottle(String usernameF, Timestamp dateF, String genderF, String content) {
        createTable();
        String sql ="INSERT INTO BottleDTB(usernameF, dateF, genderF, content, bottleID) VALUES('%s','%s''%s''%s')";
        sqLiteDatabase.execSQL(String.format(sql,
                usernameF,dateF, genderF, content));
    }

    /**
     * The function with pick bottle
     * @param id: A random number to select;
     * @return
     */
    public ArrayList<Bottle> Pickbottle(int id) {
        createTable();
        String sql = "SELECT * FROM BottleDTB WHERE BottleID = id";
        Cursor s = sqLiteDatabase.rawQuery(sql,null);
        int bottleIDIndex = s.getColumnIndex("bottleID");
        //int contentIndex = c.getColumnIndex("content");
        int dateFIndex = s.getColumnIndex("dateF");
        int genderFIndex = s.getColumnIndex("genderF");
        int contentIndex = s.getColumnIndex("content");
        int usernameFIndex = s.getColumnIndex("usernameF");

        s.moveToFirst();
        // The ArrayList to save the information to return;
        ArrayList<Bottle> bottleMade = new ArrayList<>();

        while (!s.isAfterLast()) {

            int bottleId = s.getInt(bottleIDIndex);
            Timestamp dateF = Timestamp.valueOf(s.getString(dateFIndex));
            String genderF = s.getString(genderFIndex);
            String content = s.getString(contentIndex);
            String usernameF = s.getString(usernameFIndex);

            // The ArrayList to save the information to return;
            Bottle bottle = new Bottle( usernameF, dateF, genderF,content, bottleId);
            bottleMade.add(bottle);
            s.moveToNext();
        }
        s.close();
        sqLiteDatabase.close();

        return bottleMade;

    }

    public ArrayList<Bottle> SelectGender(String gender) {
        createTable();
        String sql = "SELECT * FROM BottleDTB WHERE gender = this.gender";
        Cursor s = sqLiteDatabase.rawQuery(sql,null);
        int bottleIDIndex = s.getColumnIndex("bottleID");
        //int contentIndex = c.getColumnIndex("content");
        int dateFIndex = s.getColumnIndex("dateF");
        int genderFIndex = s.getColumnIndex("genderF");
        int contentIndex = s.getColumnIndex("content");
        int usernameFIndex = s.getColumnIndex("usernameF");

        s.moveToFirst();
        // The ArrayList to save the information to return;
        ArrayList<Bottle> bottleMade = new ArrayList<>();

        while (!s.isAfterLast()) {

            int bottleId = s.getInt(bottleIDIndex);
            Timestamp dateF = Timestamp.valueOf(s.getString(dateFIndex));
            String genderF = s.getString(genderFIndex);
            String content = s.getString(contentIndex);
            String usernameF = s.getString(usernameFIndex);

            // The ArrayList to save the information to return;
            Bottle bottle = new Bottle( usernameF, dateF, genderF,content, bottleId);
            bottleMade.add(bottle);
            s.moveToNext();
        }
        s.close();
        sqLiteDatabase.close();

        return bottleMade;

    }

    }

