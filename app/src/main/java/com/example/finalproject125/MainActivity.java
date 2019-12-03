package com.example.finalproject125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
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
        saySome.setVisibility(View.VISIBLE);
    }
}
