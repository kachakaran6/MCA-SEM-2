package com.example.savedinstancestatepractical;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private static final String TEXT_KEY = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        // Restore the saved instance state
        if (savedInstanceState != null) {
            String savedText = savedInstanceState.getString(TEXT_KEY);
            editText.setText(savedText);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the text when the button is clicked
                String textToSave = editText.getText().toString();
                // You can save it to a database or shared preferences if needed
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the current text in the EditText
        outState.putString(TEXT_KEY, editText.getText().toString());
    }
}