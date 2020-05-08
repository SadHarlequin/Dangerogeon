package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Math.random;

public class PrepareActivity extends AppCompatActivity implements View.OnClickListener {
    int numOfRooms =(int)(Math.random()*6)+4;
    Hero hero = new Hero(200, 5);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare);
        Button backToMenuButton = (Button) findViewById(R.id.BackButtonPrepare);
        backToMenuButton.setOnClickListener(this);
        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View prepareViev) {
        switch (prepareViev.getId()) {
            case R.id.BackButtonPrepare:
                Intent intentBack = new Intent(this, MainActivity.class);
                startActivity(intentBack);
                break;

            case R.id.startButton:
                Intent intentStart = new Intent(this, FightActivity.class);
                intentStart.putExtra("numOfRooms",numOfRooms);
                intentStart.putExtra("heroHP", hero.getMonsterHP());
                intentStart.putExtra("heroSpeed", hero.getMonsterSpeed());
                startActivity(intentStart);
                break;
            default:
                break;
        }
    }
}
