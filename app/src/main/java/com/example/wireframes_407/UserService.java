package com.example.wireframes_407;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wireframes_407.User;

public class UserService {

    private DatabaseHelper dbHelper;
    public UserService(Context context){
        dbHelper=new DatabaseHelper(context);
    }


    public boolean register(User user){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="insert into user(username,sex) values(?,?)";
        Object obj[]={user.getUsername(),user,user.getSex()};
        sdb.execSQL(sql, obj);
        return true;
    }
}

