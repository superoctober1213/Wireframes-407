package com.example.wireframes_407;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        welcome = findViewById(R.id.welcome);
        Intent intent = getIntent();
        String name = intent.getStringExtra("message");
        welcome.setText("Hello "+ name);
    }

    public void pickBottle(View view){
        Intent pick = new Intent (this, PickBottle.class);
        startActivity(pick);
    }

    public void throwBottle(View view){
        Intent write = new Intent(this, ThrowBottle.class);
        startActivity(write);
    }
}
