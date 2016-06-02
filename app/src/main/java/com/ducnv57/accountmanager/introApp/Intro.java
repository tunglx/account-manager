package com.ducnv57.accountmanager.introApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ducnv57.accountmanager.Main;
import com.ducnv57.accountmanager.R;
import com.github.paolorotolo.appintro.AppIntro;

/**
 * Created by W10-PRO on 02-Jun-16.
 */
public class Intro extends AppIntro {
    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(SampleSlide.newInstance(R.layout.intro));
        addSlide(SampleSlide.newInstance(R.layout.intro2));
        addSlide(SampleSlide.newInstance(R.layout.intro3));
        addSlide(SampleSlide.newInstance(R.layout.intro4));
    }

    @Override
    public void onSkipPressed() {
        Intent main = new Intent(getBaseContext(), Main.class);
        startActivity(main);
        finish();
    }

    @Override
    public void onDonePressed() {
        Intent main = new Intent(getBaseContext(), Main.class);
        startActivity(main);
        finish();
    }

    public void getStarted(View v) {
        Intent main = new Intent(getBaseContext(), Main.class);
        startActivity(main);
        finish();
    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onSlideChanged() {

    }
}

