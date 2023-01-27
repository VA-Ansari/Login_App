package com.example.loginapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    TextView userName;
    TextView pswrd;
    Button reg_btn;

    //this is an auth of Firebase
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = findViewById(R.id.register_username);
        pswrd = findViewById(R.id.register_password);
        reg_btn = findViewById(R.id.register_btn);

        auth = FirebaseAuth.getInstance();

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = userName.getText().toString();
                String password = pswrd.getText().toString();

                //see if credentials entered or not
                if(name.isEmpty() && password.isEmpty())
                    Toast.makeText(RegisterActivity.this, "Enter Credentials", Toast.LENGTH_LONG).show();
                else if (password.length() < 6)
                    Toast.makeText(RegisterActivity.this, "Password length is Short", Toast.LENGTH_SHORT).show();
                else     //if everything is ok -> register user in firebase by calling this function
                    registerUser(name, password);
            }
        });

    }

    private void registerUser(String name, String password) {
        //call this method "createUserWithEmailAndPassword" and pass those credentials, and then add
        //another method "addOnComplete" to show user a message of register is completed or not
        auth.createUserWithEmailAndPassword(name, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Register Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, IntroActivity.class));
                }
                else
                    Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}