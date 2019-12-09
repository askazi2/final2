package com.example.finalproject125;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.*;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    // this code is for the button that we created
    private Button submit;
    private String title;
    private EditText titleInput;
    //public JSONArray array;

    public MainActivity() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        titleInput = findViewById(R.id.titleInput);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getResult();
                title = titleInput.getText().toString();
                AsyncTaskRunner runner = new AsyncTaskRunner();
                runner.execute(title);

            }
        });
    }

    public class AsyncTaskRunner extends AsyncTask<String, String, String> {

        //private Exception exception;
        private ProgressBar progressBar;

        protected void onPreExecute() {
            progressBar = findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);
            //responseView = findViewById(R.id.responseView2);
            //responseView.setText("Nothing");
        }
        protected String doInBackground(String... params) {
            // Do some validation here
            String newString = "";
            for (int i = 0; i < title.length(); i++) {
                if (title.substring(i, i + 1).equals(" ")) {
                    newString += "%20";
                } else {
                    newString += title.substring(i, i + 1);
                }
            }
            System.out.println(newString);

            OkHttpClient client = new OkHttpClient();

            try {
                Request request = new Request.Builder()
                        .url("https://movie-database-imdb-alternative.p.rapidapi.com/?page=1&r=json&s=" + newString)
                        .get()
                        .addHeader("x-rapidapi-host", "movie-database-imdb-alternative.p.rapidapi.com")
                        .addHeader("x-rapidapi-key", "3bda5a528bmsh698ae8b83d27e37p165ee0jsnec6e42c11bc3")
                        .build();

                Response myResponse = client.newCall(request).execute();
                System.out.println("try ");
                // array = new JSONArray(myResponse.body().string());
                return myResponse.body().string();
            } catch (Exception e) {
                System.out.println("catch ");
                return e.toString();
            }
        }
        protected void onPostExecute(String response) {
            if (response == null) {
                System.out.println("THERE WAS AN ERROR");
            }
            progressBar.setVisibility(View.GONE);
            //Log.i("INFO", a);
            //responseView.setText(response);
            //responseView.setVisibility(View.VISIBLE);
            getResult(response);
        }
    }

    public void getResult(String response) {
        Intent intent = new Intent(this, MovieInfo.class);
        intent.putExtra("response", response);
        startActivity(intent);
    }

}