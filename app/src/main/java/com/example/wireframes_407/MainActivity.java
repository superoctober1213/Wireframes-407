package com.example.wireframes_407;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    EditText editUser;
    EditText editCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        editUser = findViewById(R.id.user);
        editCode = findViewById(R.id.code);

    }


    public void clickLogin(View v) {
        String current_user = editUser.getText().toString();
        String current_code = editCode.getText().toString();
        try {
            firebaseAuth.signInWithEmailAndPassword(current_user,
                    current_code)
                    .addOnCompleteListener((task) -> {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        } else {
                            Toast.makeText(MainActivity.this, task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void clickSignup(View v) {
        startActivity(new Intent(MainActivity.this,SignupActivity.class));
    }

    public static String getUsername(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            return null;
        } else {
            return user.getDisplayName();
        }
    }

    public static String getGender() {
        FirebaseUser gender = FirebaseAuth.getInstance().getCurrentUser();
        if (gender != null) {
            return null;
        } else {
            return gender.getPhotoUrl().toString();
        }

    }


}
