package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;


public class FightActivity extends AppCompatActivity implements View.OnClickListener {
    int numOfRooms;
    ImageButton nextRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        numOfRooms=getIntent().getIntExtra("numOfRooms",0)-1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight_area);
        nextRoom=(ImageButton)findViewById(R.id.next_room);
        nextRoom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.next_room:
            if(numOfRooms==0){
                Intent fight_intent = new Intent(this, MainActivity.class);
                startActivity(fight_intent);
            }
            else {
                Intent fight_intent = new Intent(this, FightActivity.class);
                fight_intent.putExtra("numOfRooms", numOfRooms);
                startActivity(fight_intent);
            }
    }
    }
}
