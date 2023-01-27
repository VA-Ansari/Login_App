package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button register_btn = findViewById(R.id.register_btn);
        EditText txtView =  findViewById(R.id.username);
        EditText pswrd = findViewById(R.id.password);
        Button login_btn = findViewById(R.id.loginbtn);

        //for login
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtView.getText().toString().equals("Arshad") && pswrd.getText().toString().equals("1436"))
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "INCORRECT CREDENTIALS", Toast.LENGTH_LONG).show();
            }
        });

        //for register
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

    }
}