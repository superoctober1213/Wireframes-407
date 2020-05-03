package com.example.wireframes_407;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.wireframes_407.DTBBottle;

public class ThrowBottle extends AppCompatActivity {

    EditText message;
    Button button;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    AnimationDrawable throwAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_throw_bottle);

        message = findViewById(R.id.context);
        button = findViewById(R.id.throwButton);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setBackgroundResource(R.drawable.animation);
        throwAnimation = (AnimationDrawable) imageView.getBackground();
    }

    public void sendItFlowing(View view){
        String usernameF = MainActivity.getUsername();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String  gender = MainActivity.getGender();
        String content = message.toString();
        DTBBottle.throwBottle(usernameF, timestamp, gender, content);

        throwAnimation.start();

        Intent back = new Intent(this,LoginActivity.class);
        startActivity(back);

    }


}
