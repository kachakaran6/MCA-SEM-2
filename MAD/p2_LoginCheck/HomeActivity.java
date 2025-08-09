package com.example.loginmodule;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView welcomeText = findViewById(R.id.welcomeText);
        String username = getIntent().getStringExtra("USERNAME");
        welcomeText.setText("Welcome, " + username + "!");
    }
}