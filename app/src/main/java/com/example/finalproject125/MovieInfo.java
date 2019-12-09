package com.example.finalproject125;


import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


public class MovieInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle here) {
        super.onCreate(here);
        setContentView(R.layout.movie_info);

        /*class AsyncTaskRunner extends AsyncTask<String, String, String> {

            //private Exception exception;
            private ProgressBar progressBar;
            private TextView responseView;

            protected void onPreExecute() {
                progressBar = findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);
                responseView = findViewById(R.id.responseView2);
                responseView.setText("Nothing");
            }

            protected String doInBackground(String... params) {
                // Do some validation here
                String newString = "";
                for (int i = 0; i < title.length() - 1; i++) {
                    if (title.substring(i, i + 1).equals(" ")) {
                        newString += "%20";
                    } else {
                        newString += title.substring(i, i + 1);
                    }
                }

                OkHttpClient client = new OkHttpClient();

                try {
                    Request request = new Request.Builder()
                            .url("https://movie-database-imdb-alternative.p.rapidapi.com/?page=1&r=json&s=Avengers%20Endgame")
                            .get()
                            .addHeader("x-rapidapi-host", "movie-database-imdb-alternative.p.rapidapi.com")
                            .addHeader("x-rapidapi-key", "3bda5a528bmsh698ae8b83d27e37p165ee0jsnec6e42c11bc3")
                            .build();

                    Response myResponse = client.newCall(request).execute();
                    System.out.println("try ");
                    return myResponse.body().toString();
                } catch (Exception e) {
                    System.out.println("catch ");
                    return e.toString();
                }
            }

            protected void onPostExecute(String response) {
                if (response == null) {
                    response = "THERE WAS AN ERROR";
                }
                progressBar.setVisibility(View.GONE);
                Log.i("INFO", response);
                responseView.setText(response);
                responseView.setVisibility(View.VISIBLE);
            }
        }

         */
    }
}
