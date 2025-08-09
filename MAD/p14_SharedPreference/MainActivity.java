package com.example.sharedpreference;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private EditText nameInput;
    private TextView savedNameDisplay;
    private Button saveButton, loadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.name_input);
        savedNameDisplay = findViewById(R.id.saved_name_display);
        saveButton = findViewById(R.id.save_button);
        loadButton = findViewById(R.id.load_button);

        // Load saved name when the app starts
        loadSavedName();

        saveButton.setOnClickListener(view -> saveName());
        loadButton.setOnClickListener(view -> loadSavedName());
    }

    private void saveName() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", nameInput.getText().toString());
        editor.apply();
    }

    private void loadSavedName() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        String savedName = sharedPreferences.getString("name", "Saved name will appear here");
        savedNameDisplay.setText(savedName);
    }
}