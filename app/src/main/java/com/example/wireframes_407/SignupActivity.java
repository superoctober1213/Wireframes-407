package com.example.wireframes_407;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {
    EditText email, password, username, gender;
    Button signup;
    ProgressBar pbar;
    FirebaseAuth firebaseAuth;
    Button back;
    FirebaseFirestore fstore;
    String userID;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        signup = findViewById(R.id.btnSignup);
        pbar = findViewById(R.id.progressBar);
        back = findViewById(R.id.btnBack);
        pbar.setVisibility(View.GONE);
        username = findViewById(R.id.etUsername);
        gender = findViewById(R.id.etGender);

        //auth and database
        firebaseAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

    }


    public void clickBack(View v) {
        startActivity(new Intent(SignupActivity.this, MainActivity.class));
    }

    public void clickSignup(View v) {
        String mEmail = email.getText().toString().trim();
        String userName = username.getText().toString().trim();
        String mGender = gender.getText().toString().trim();
        String mPassword = password.getText().toString().trim();

        if(TextUtils.isEmpty(mEmail)) {
            email.setError("Email is needed");
        }

        if(TextUtils.isEmpty(userName)) {
            username.setError("username is needed");
        }

        if(TextUtils.isEmpty(mGender)) {
            gender.setError("gender is needed");
        }

        if(TextUtils.isEmpty(mPassword)) {
            password.setError("password is needed");
        }
        pbar.setVisibility(View.VISIBLE);
        firebaseAuth.createUserWithEmailAndPassword(mEmail,mPassword)
                .addOnCompleteListener((task) -> {
                if (task.isSuccessful()) {
                    //Toast.makeText(SignupActivity.this, "Registered successfully",
                            //Toast.LENGTH_LONG).show();

                    userID = firebaseAuth.getCurrentUser().getUid();
                    DocumentReference documentReference = fstore.collection("users").document(userID);

                    Map<String, Object> user = new HashMap<>();
                    user.put("email", mEmail);
                    user.put("username", userName);
                    user.put("gender", mGender);


                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {

                        @Override
                        public void onSuccess(Void avoid) {
                            Toast.makeText(SignupActivity.this, "Registered successfully",
                                    Toast.LENGTH_LONG).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SignupActivity.this, "Registered Fail",
                                    Toast.LENGTH_LONG).show();
                        }
                    });


                   /* fstore.collection("user").document("profile")
                            .set(user)
                            .addOnSuccessListener(new OnSuccessListener <Void > () {
                                @Override
                                public void onSuccess(Void avoid) {
                                    Toast.makeText(SignupActivity.this, "Registered successfully",
                                        Toast.LENGTH_LONG).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(SignupActivity.this, "Registered Fail",
                                            Toast.LENGTH_LONG).show();
                                }
                            });*/
                    /*fstore.collection("user").add(user)
                            .addOnSuccessListener(new OnSuccessListener <DocumentReference > () {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(SignupActivity.this, "Registered successfully",
                                            Toast.LENGTH_LONG).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w("TAG", "Error adding document", e);
                                }
                            });*/

                    /*User user = new User (
                            mEmail,
                            userName,
                            mGender
                    );

                    FirebaseDatabase.getInstance().getReference("User")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                     @Override
                                                                     public void onComplete(@NonNull Task<Void> task) {
                                                                         pbar.setVisibility(View.GONE);
                                                                         if (task.isSuccessful()) {
                                                                             Log.d("TAG", "onSuccess: user Profile is created for " + userID);
                                                                         } else {

                                                                         }
                                                                     }
                                                                 });*/

                    startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(SignupActivity.this, task.getException().getMessage(),
                            Toast.LENGTH_LONG).show();
                    pbar.setVisibility(View.GONE);
                }

            });

    }


}

