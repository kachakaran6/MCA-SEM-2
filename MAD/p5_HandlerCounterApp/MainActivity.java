package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewCounter;
    private Button btnStart, btnStop;

    private int counter = 0;
    private boolean isRunning = false;
    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        textViewCounter = findViewById(R.id.textViewCounter);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        // Define what happens every second
        runnable = new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    counter++;
                    textViewCounter.setText(String.valueOf(counter));
                    handler.postDelayed(this, 1000); // Repeat every 1 second
                }
            }
        };

        // Start button logic
        btnStart.setOnClickListener(v -> {
            if (!isRunning) {
                isRunning = true;
                handler.post(runnable); // Start the counter
            }
        });

        // Stop button logic
        btnStop.setOnClickListener(v -> {
            isRunning = false;
            handler.removeCallbacks(runnable); // Stop the counter
        });
    }
}