package com.example.finalproject125;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class MainActivity extends AppCompatActivity {
    // this code is for the button that we created
    private Button submit;
    private String title;
    private EditText titleInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        titleInput = findViewById(R.id.titleInput);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = titleInput.getText().toString();
                HttpResponse<String> response = Unirest.get("https://movie-database-imdb-alternative.p.rapidapi.com/?page=1&r=json&s=Frozen")
                        .header("x-rapidapi-host", "movie-database-imdb-alternative.p.rapidapi.com")
                        .header("x-rapidapi-key", "3bda5a528bmsh698ae8b83d27e37p165ee0jsnec6e42c11bc3")
                        .asString();
                JSONObject myResponse = new JSONObject(response);
            }
        });
    }

}
