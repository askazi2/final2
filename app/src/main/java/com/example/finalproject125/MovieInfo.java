package com.example.finalproject125;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;


public class MovieInfo extends AppCompatActivity {
    private String response;
    private TextView responseView;
    private Button newMovie;
    @Override
    protected void onCreate(Bundle here) {
        super.onCreate(here);
        setContentView(R.layout.movie_info);
        response = getIntent().getStringExtra("response");
        responseView = findViewById(R.id.responseView2);
        newMovie = findViewById(R.id.newmovie);
        responseView.setText("");
        responseView.setText(response);
        responseView.setVisibility(View.VISIBLE);
        newMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(this, MainActivity.class);
                //startActivity(i);
                finish();
            }
        });
    }

}
