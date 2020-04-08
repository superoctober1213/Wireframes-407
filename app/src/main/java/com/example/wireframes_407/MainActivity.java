package com.example.wireframes_407;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        EditText user = findViewById(R.id.user); //username
        EditText code = findViewById(R.id.code); //password, for future use

        String name = user.getText().toString();
        goToLogin(name);
    }

    public void goToLogin(String s){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("message",s);
        startActivity(intent);
    }


}
