package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.project.MainActivity.audioPlayer;
import static com.example.project.MainActivity.musicState;
import static java.lang.Math.random;

public class EndOfJorneyActivity extends AppCompatActivity implements View.OnClickListener {
TextView enemyDeaths;
TextView resources;
int enemyDeathsCounter;
int resourcesCounter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        audioPlayer.loadSounds(this);
        if(musicState)audioPlayer.startMusic(this, audioPlayer.forest_themeID);
        setContentView(R.layout.end_of_jorney_activity);
        Button backToMenuButton = (Button) findViewById(R.id.TownButton);
        backToMenuButton.setOnClickListener(this);
        enemyDeaths = findViewById(R.id.monsterDeathsText);
        resources = findViewById(R.id.resourcesCollectedText);
        enemyDeathsCounter = getIntent().getIntExtra("enemyDeathsCounter", 0);
        enemyDeaths.setText("Monsters killed:                 "+11);
        resources.setText("Resources Collected:        "+0);

    }

    @Override
    public void onClick(View prepareView) {
        audioPlayer.play(audioPlayer.click_buttonID);
        switch (prepareView.getId()) {
            case R.id.TownButton:
                Intent intentBack = new Intent(this, MainActivity.class);
                startActivity(intentBack);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            default:
                break;
        }
    }
}
