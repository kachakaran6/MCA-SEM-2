package com.example.notificationsapp;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    private EditText lowerBoundEditText, upperBoundEditText;
    private TextView resultTextView;
    private static final String CHANNEL_ID = "prime_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkNotificationPermission();

        lowerBoundEditText = findViewById(R.id.lowerBound);
        upperBoundEditText = findViewById(R.id.upperBound);
        resultTextView = findViewById(R.id.resultTextView);
        Button findButton = findViewById(R.id.findButton);

        createNotificationChannel();

        findButton.setOnClickListener(v -> {
            int lower = Integer.parseInt(lowerBoundEditText.getText().toString());
            int upper = Integer.parseInt(upperBoundEditText.getText().toString());

            new Thread(() -> {
                StringBuilder primes = new StringBuilder();
                for (int i = lower; i <= upper; i++) {
                    if (isPrime(i)) primes.append(i).append(" ");
                }

                String result = primes.toString();
                new Handler(Looper.getMainLooper()).post(() -> {
                    resultTextView.setText(result);
                    showNotification("Prime Numbers :", result + "are the prime numbers between " + lower + " and " + upper + ".");
                });
            }).start();
        });
    }
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    private void showNotification(String title, String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());
    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Prime Channel";
            String description = "Shows when prime calculation completes";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }
    private void checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
            }
        }
    }
}