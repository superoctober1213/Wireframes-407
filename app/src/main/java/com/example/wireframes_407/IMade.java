package com.example.wireframes_407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class IMade extends AppCompatActivity {

    TextView textView;
    public static ArrayList<Bottle> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_made);

        textView = findViewById(R.id.imade);
        String currentusername = MainActivity.getUsername();
        ArrayList<Readhistory> bottleList = DTBReadhistory.getHistoryByUsernameF(currentusername);

        



    }
}
