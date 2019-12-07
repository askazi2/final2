package com.example.finalproject125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // this code is for the button that we created
    private Button shuffle;
    private TextView saySome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saySome = findViewById(R.id.saySome);
        saySome.setVisibility(View.GONE);

        shuffle = findViewById(R.id.shuffleAnything);
        shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateEpisode();
            }
        });
    }

    public void generateEpisode() {
        // this makes the button actually show up as visible
        saySome.setVisibility(View.VISIBLE);
    }
}
