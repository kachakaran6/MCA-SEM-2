package com.example.progressbar;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.progressbar.R;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    ProgressBar progressBar;
    TextView txtProgress, txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        progressBar = findViewById(R.id.progressBar);
        txtProgress = findViewById(R.id.txtProgress);
        txtMessage = findViewById(R.id.txtMessage);

        btnStart.setOnClickListener(v -> {
            new ProgressTask().execute();
        });
    }

    private class ProgressTask extends AsyncTask<Void, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setProgress(0);
            txtProgress.setText("Progress: 0%");
            txtMessage.setText("");
        }

        @Override
        protected String doInBackground(Void... voids) {
            int progress = 0;
            while (progress <= 100) {
                try {
                    Thread.sleep(50); // simulate time-consuming task
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(progress);
                progress++;
            }
            return "✅ Task Completed Successfully!";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int value = values[0];
            progressBar.setProgress(value);
            txtProgress.setText("Progress: " + value + "%");
        }

        @Override
        protected void onPostExecute(String result) {
            txtMessage.setText(result);
        }
    }
}