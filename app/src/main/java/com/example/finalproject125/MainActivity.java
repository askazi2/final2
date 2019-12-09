package com.example.finalproject125;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.lang.*;
import java.io.IOException;


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
                getResult();
                title = titleInput.getText().toString();
                String newString = "";
                for (int i = 0; i < title.length() - 1; i++) {
                    if (title.substring(i, i + 1).equals(" ")) {
                        newString += "%20";
                    } else {
                        newString += title.substring(i, i + 1);
                    }
                }
                /*
                System.out.println("HERE");
                OkHttpClient client = new OkHttpClient();

                try {
                    Request request = new Request.Builder()
                            .url("https://movie-database-imdb-alternative.p.rapidapi.com/?page=1&r=json&s=Avengers%20Endgame")
                            .get()
                            .addHeader("x-rapidapi-host", "movie-database-imdb-alternative.p.rapidapi.com")
                            .addHeader("x-rapidapi-key", "3bda5a528bmsh698ae8b83d27e37p165ee0jsnec6e42c11bc3")
                            .build();

                    Response response = client.newCall(request).execute();
                    System.out.println("try " + response.body().string());
                } catch (Exception e) {
                    System.out.println("catch " + e.toString());
                }
                 */

            }
        });
    }
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if(actionId == EditorInfo.IME_ACTION_SEARCH
                || actionId == EditorInfo.IME_ACTION_DONE
                || keyEvent.getAction() == KeyEvent.ACTION_DOWN
                || keyEvent.getAction() == KeyEvent.KEYCODE_ENTER){

            //execute our method for searching
        }

        return false;
    }
    public void getResult() {
        Intent intent = new Intent(this, MovieInfo.class);
        startActivity(intent);
    }
}
