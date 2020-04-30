package com.example.project;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Math.random;


public class FightActivity extends AppCompatActivity implements View.OnClickListener {
    int numOfRooms;
    int monsterChoice;
    int roomChoice;
    ImageButton nextRoom;
    Monster enemy1;
    Monster enemy2;
    Monster enemy3;
    Monster enemy4;
    ImageButton enemy1_image;
    ImageButton enemy2_image;
    ImageButton enemy3_image;
    ImageButton enemy4_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        numOfRooms=getIntent().getIntExtra("numOfRooms",0)-1;
        monsterChoice=(int)(random()*2)+1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight_area);
        nextRoom=(ImageButton)findViewById(R.id.next_room);
        nextRoom.setOnClickListener(this);
        enemy1_image = (ImageButton)findViewById(R.id.enemy_pos_1);
        enemy1_image.setOnClickListener(this);
        enemy2_image = (ImageButton)findViewById(R.id.enemy_pos_2);
        enemy2_image.setOnClickListener(this);
        enemy3_image = (ImageButton)findViewById(R.id.enemy_pos_3);
        enemy3_image.setOnClickListener(this);
        enemy4_image = (ImageButton)findViewById(R.id.enemy_pos_4);
        enemy4_image.setOnClickListener(this);
        squadCreation(monsterChoice);
    }

    void squadCreation(int monsterChoice){
        switch (monsterChoice){
            case 1:
                enemy1=new Monster("Goblin",50, R.drawable.goblin);
                enemy1.monsterType("Soldier");
                enemy1_image.setImageResource(enemy1.getMonsterView());

                enemy2=new Monster("Goblin",50, R.drawable.goblin);
                enemy2.monsterType("Soldier");
                enemy2_image.setImageResource(enemy2.getMonsterView());

                enemy3=new Monster("Goblin",50, R.drawable.goblin);
                enemy3.monsterType("Soldier");
                enemy3_image.setImageResource(enemy3.getMonsterView());

                enemy4=new Monster("Golem",100, R.drawable.golem);
                enemy4.monsterType("Giant");
                enemy4_image.setImageResource(enemy4.getMonsterView());
                break;
            case 2:
                enemy1=new Monster("Goblin",50,R.drawable.goblin);
                enemy1.monsterType("Soldier");
                enemy1_image.setImageResource(enemy1.getMonsterView());

                enemy2=new Monster("Goblin",50, R.drawable.goblin);
                enemy2.monsterType("Soldier");
                enemy2_image.setImageResource(R.drawable.goblin);

                enemy3=new Monster("Golem",100, R.drawable.golem);
                enemy3.monsterType("Giant");
                enemy3_image.setImageResource(enemy3.getMonsterView());

                enemy4=new Monster("",-9999, R.drawable.free_space);
                break;
            default:
                break;
        }
    }

    void enemyDeath(){
        Monster swap;
        if (enemy1.getMonsterHP()<=0){
            enemy1.setMonsterView(R.drawable.grave);
//            swap = enemy1;
//            enemy1 = enemy2;
//            enemy2 = swap;
            enemy1_image.setImageResource(enemy1.getMonsterView());
            enemy2_image.setImageResource(enemy2.getMonsterView());
        }
        if (enemy2.getMonsterHP()<=0){
            enemy2.setMonsterView(R.drawable.grave);
//            swap = enemy2;
//            enemy3 = enemy2;
//            enemy3 = swap;
            enemy2_image.setImageResource(enemy2.getMonsterView());
            enemy3_image.setImageResource(enemy3.getMonsterView());
        }
        if (enemy3.getMonsterHP()<=0 & enemy4.getMonsterHP()!=-9999){
            enemy3.setMonsterView(R.drawable.grave);
//            swap = enemy3;
//            enemy3 = enemy4;
//            enemy4 = swap;
            enemy3_image.setImageResource(enemy3.getMonsterView());
            enemy4_image.setImageResource(enemy4.getMonsterView());
        }
        if (enemy4.getMonsterHP()<=0 & enemy4.getMonsterHP()>-9999){
            enemy4.setMonsterView(R.drawable.grave);
            enemy4_image.setImageResource(enemy4.getMonsterView());

        }
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
            break;
        case R.id.enemy_pos_1:
            enemy1.getDamage(50);
            enemyDeath();
            break;
        case R.id.enemy_pos_2:
            enemy2.getDamage(50);
            enemyDeath();
            break;
        case R.id.enemy_pos_3:
            enemy3.getDamage(50);
            enemyDeath();
            break;
        case R.id.enemy_pos_4:
            enemy4.getDamage(50);
            enemyDeath();
            break;
        default:
            break;
    }
    }
}
