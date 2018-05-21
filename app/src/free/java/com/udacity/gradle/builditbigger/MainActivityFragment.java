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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
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

        AdView mAdView = (AdView) root.findViewById(R.id.adView);

        Button button = (Button) root.findViewById(R.id.btn_joke);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                    progressBar.setVisibility(View.VISIBLE);
                    tellJoke();

            }
        });

        progressBar = (ProgressBar) root.findViewById(R.id.joke_progress_bar);
        progressBar.setVisibility(View.GONE);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
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
