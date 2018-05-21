package com.poojab26.jokesandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {
    public static final String JOKE_KEY = "JOKE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        TextView jokeview = findViewById(R.id.joke_test);

        String joke = null;
        Intent intent = getIntent();
        joke = intent.getStringExtra(JokeDisplayActivity.JOKE_KEY);

        if (joke != null){
            jokeview.setText(joke);
        }else {
            jokeview.setText(R.string.no_joke_string);
        }
    }
}
