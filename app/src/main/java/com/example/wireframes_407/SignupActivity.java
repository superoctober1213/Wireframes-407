package com.example.wireframes_407;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignupActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button signup;
    ProgressBar pbar;
    FirebaseAuth firebaseAuth;
    Button back;
    EditText username;
    RadioGroup sex;
    String sex1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        signup = findViewById(R.id.btnSignup);
        pbar = findViewById(R.id.progressBar);
        back = findViewById(R.id.btnBack);
        pbar.setVisibility(View.GONE);
        username = findViewById(R.id.username);
        sex1 = String.valueOf(sex);


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
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(username.getText().toString())
                    .setPhotoUri(Uri.parse(sex1))
                    .build();

            user.updateProfile(profileUpdates);
//            System.out.println("1");
//            System.out.println(user.getDisplayName());
//            System.out.println("1");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

