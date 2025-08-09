package com.example.myinfo;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.name).setBackgroundColor(Color.RED);
        findViewById(R.id.qualification).setBackgroundColor(Color.GREEN);
        findViewById(R.id.contact).setBackgroundColor(Color.BLUE);
        findViewById(R.id.email).setBackgroundColor(Color.YELLOW);
        findViewById(R.id.address).setBackgroundColor(Color.MAGENTA);
    }
}