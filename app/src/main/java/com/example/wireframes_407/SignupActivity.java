package com.example.wireframes_407;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button signup;
    ProgressBar pbar;
    FirebaseAuth firebaseAuth;
    Button back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        signup = findViewById(R.id.btnSignup);
        pbar = findViewById(R.id.progressBar);
        back = findViewById(R.id.btnBack);
        pbar.setVisibility(View.GONE);


        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void clickBack(View v) {
        startActivity(new Intent(SignupActivity.this, MainActivity.class));
    }
    public void clickSignup(View v) {
        try {
            pbar.setVisibility(View.VISIBLE);
            firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),
                    password.getText().toString())
                    .addOnCompleteListener((task) -> {
                        pbar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(SignupActivity.this, "Registered successfully",
                                    Toast.LENGTH_LONG).show();
                            email.setText("");
                            password.setText("");
                            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                        } else {
                            Toast.makeText(SignupActivity.this, task.getException().getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }

                    });
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
