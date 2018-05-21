package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.poojab26.jokesandroid.JokeDisplayActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }
    private ProgressBar progressBar = null;
    public String joke_loaded = null;
    public boolean testFlag = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button button = root.findViewById(R.id.btn_joke);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                    progressBar.setVisibility(View.VISIBLE);
                    tellJoke();

            }
        });

        progressBar = (ProgressBar) root.findViewById(R.id.joke_progress_bar);
        progressBar.setVisibility(View.GONE);
        return root;
    }

    private void tellJoke(){
        new EndpointsAsyncTask().execute(this);
    }

    public void launchDisplayJokeActivity(){
        if (!testFlag) {
            Context context = getActivity();
            Intent intent = new Intent(context, JokeDisplayActivity.class);
            intent.putExtra(JokeDisplayActivity.JOKE_KEY, joke_loaded);
            context.startActivity(intent);
            progressBar.setVisibility(View.GONE);
        }
    }
}
