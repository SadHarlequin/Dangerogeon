package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PrepareActivity extends AppCompatActivity implements View.OnClickListener {
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
                startActivity(intentStart);
                break;
            default:
                break;
        }
    }
}
