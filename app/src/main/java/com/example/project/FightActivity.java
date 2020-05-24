package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.project.MainActivity.audioPlayer;


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
    TextView enemyInfo1;
    TextView enemyInfo2;
    TextView enemyInfo3;
    TextView enemyInfo4;
    TextView heroInfo;
    ImageView queue1;
    ImageView queue2;
    ImageView queue3;
    ImageView queue4;
    ImageView queue5;
    Hero hero=new Hero();
    Monster queue_pos_1;
    Monster queue_pos_2;
    Monster queue_pos_3;
    Monster queue_pos_4;
    Monster queue_pos_5;
    //Intent in_intent =  getIntent();
    //SFXPlayer audioPlayer =(SFXPlayer)in_intent.getSerializableExtra("sfx");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        numOfRooms=getIntent().getIntExtra("numOfRooms",0)-1;
        roomChoice=(int)(Math.random()*2)+1;
        hero.setHP(getIntent().getIntExtra("heroHP",0));
        hero.setMonsterSpeed(getIntent().getIntExtra("heroSpeed",0));
        hero.setHeroMaxHp(200);
        hero.setMonsterView(R.drawable.hero);

        super.onCreate(savedInstanceState);
        switch (roomChoice){
            case 1:
                monsterChoice=(int)(Math.random()*2)+1;
                setContentView(R.layout.fight_area);
                nextRoom=(ImageButton)findViewById(R.id.next_room);
                nextRoom.setOnClickListener(this);
                nextRoom.setVisibility(View.INVISIBLE);
                nextRoom.setClickable(false);
                enemy1_image = (ImageButton)findViewById(R.id.enemy_pos_1);
                enemy1_image.setOnClickListener(this);
                enemy2_image = (ImageButton)findViewById(R.id.enemy_pos_2);
                enemy2_image.setOnClickListener(this);
                enemy3_image = (ImageButton)findViewById(R.id.enemy_pos_3);
                enemy3_image.setOnClickListener(this);
                enemy4_image = (ImageButton)findViewById(R.id.enemy_pos_4);
                enemy4_image.setOnClickListener(this);
                squadCreation(monsterChoice);
                enemyInfo1 = (TextView) findViewById(R.id.enemyText1);
                enemyInfo2 = (TextView) findViewById(R.id.enemyText2);
                enemyInfo3 = (TextView) findViewById(R.id.enemyText3);
                enemyInfo4 = (TextView) findViewById(R.id.enemyText4);
                heroInfo=(TextView) findViewById(R.id.heroText) ;
                enemyInfo1.setText(enemy1.getInfo());
                enemyInfo2.setText(enemy2.getInfo());
                enemyInfo3.setText(enemy3.getInfo());
                enemyInfo4.setText(enemy4.getInfo());
                heroInfo.setText(hero.getMonsterHP()+"/"+hero.getMonsterMaxHP());
                queue1 = (ImageView)findViewById(R.id.queue1);
                queue2 = (ImageView)findViewById(R.id.queue2);
                queue3 = (ImageView)findViewById(R.id.queue3);
                queue4 = (ImageView)findViewById(R.id.queue4);
                queue5 = (ImageView)findViewById(R.id.queue5);
                queueCreation();
                enemyAttack();

                break;
            case 2:
                setContentView(R.layout.treasure_activity);
                nextRoom=(ImageButton)findViewById(R.id.next_room);
                nextRoom.setOnClickListener(this);
                break;
        }
    }

    void squadCreation(int monsterChoice){
        switch (monsterChoice){
            case 1:
                enemy1=new Monster("Goblin",50, R.drawable.goblin_01,10);
                enemy1.monsterType("Soldier");
                enemy1_image.setImageResource(enemy1.getMonsterView());

                enemy2=new Monster("Goblin",50, R.drawable.goblin_02,10);
                enemy2.monsterType("Soldier");
                enemy2_image.setImageResource(enemy2.getMonsterView());

                enemy3=new Monster("Goblin",50, R.drawable.goblin_03,10);
                enemy3.monsterType("Soldier");
                enemy3_image.setImageResource(enemy3.getMonsterView());

                enemy4=new Monster("Golem",100, R.drawable.golem,20);
                enemy4.monsterType("Giant");
                enemy4_image.setImageResource(enemy4.getMonsterView());
                break;
            case 2:
                enemy1=new Monster("Goblin",50,R.drawable.goblin_03,10);
                enemy1.monsterType("Soldier");
                enemy1_image.setImageResource(enemy1.getMonsterView());

                enemy2=new Monster("Goblin",50, R.drawable.goblin_02,10);
                enemy2.monsterType("Soldier");
                enemy2_image.setImageResource(R.drawable.goblin_01);

                enemy3=new Monster("Golem",100, R.drawable.golem,20);
                enemy3.monsterType("Giant");
                enemy3_image.setImageResource(enemy3.getMonsterView());

                enemy4=new Monster("",-9999, R.drawable.free_space,0);
                enemy4.setMonsterSpeed(0);
                break;
            default:
                break;
        }
    }

    void enemyDeath() {
        audioPlayer.play((int)(Math.random()*2)==0?audioPlayer.goblin_death_rattle1ID
                :audioPlayer.goblin_death_rattle2ID);
        Monster swap;
        if (enemy1.getMonsterHP() <= 0) {
            enemy1.setMonsterView(R.drawable.grave);
            swap = enemy1;
            enemy1 = enemy2;
            enemy2 = swap;
        }
        if (enemy2.getMonsterHP() <= 0) {
            enemy2.setMonsterView(R.drawable.grave);
            swap = enemy2;
            enemy2 = enemy3;
            enemy3 = swap;
        }
        if (enemy3.getMonsterHP() <= 0 & enemy4.getMonsterHP() != -9999) {
            enemy3.setMonsterView(R.drawable.grave);
            swap = enemy3;
            enemy3 = enemy4;
            enemy4 = swap;
        }
        if (enemy3.getMonsterHP() <= 0 & enemy4.getMonsterHP() == -9999) {
            enemy3.setMonsterView(R.drawable.grave);
        }
        if (enemy4.getMonsterHP() <= 0 & enemy4.getMonsterHP() > -9999) {
            enemy4.setMonsterView(R.drawable.grave);

        }
        enemy1_image.setImageResource(enemy1.getMonsterView());
        enemy2_image.setImageResource(enemy2.getMonsterView());
        enemy3_image.setImageResource(enemy3.getMonsterView());
        enemy4_image.setImageResource(enemy4.getMonsterView());
        enemyInfo1.setText(enemy1.getInfo());
        enemyInfo2.setText(enemy2.getInfo());
        enemyInfo3.setText(enemy3.getInfo());
        enemyInfo4.setText(enemy4.getInfo());
        if (enemy1.getMonsterHP() <= 0 & enemy2.getMonsterHP() <= 0 & enemy3.getMonsterHP() <= 0 & enemy4.getMonsterHP() <= 0){
            nextRoom.setClickable(true);
            nextRoom.setVisibility(View.VISIBLE);
        }
    }

    void queueCreation (){
        queue_pos_1=hero;
        queue_pos_2=enemy1;
        queue_pos_3=enemy2;
        queue_pos_4=enemy3;
        queue_pos_5=enemy4;
        Monster temp;
        boolean swapped=true;
        while(swapped==true){
        if (queue_pos_1.getMonsterSpeed()<queue_pos_2.getMonsterSpeed()){
            temp=queue_pos_1;
            queue_pos_1=queue_pos_2;
            queue_pos_2=temp;
            }
        else if (queue_pos_2.getMonsterSpeed()<queue_pos_3.getMonsterSpeed()){
            temp=queue_pos_2;
            queue_pos_2=queue_pos_3;
            queue_pos_3=temp;
            }
        else if (queue_pos_3.getMonsterSpeed()<queue_pos_4.getMonsterSpeed()){
            temp=queue_pos_3;
            queue_pos_3=queue_pos_4;
            queue_pos_4=temp;
            }
        else if (queue_pos_4.getMonsterSpeed()<queue_pos_5.getMonsterSpeed()){
            temp=queue_pos_4;
            queue_pos_4=queue_pos_5;
            queue_pos_5=temp;
            }
        else
            swapped=false;
        }
        queue1.setImageResource(queue_pos_1.getMonsterView());
        queue2.setImageResource(queue_pos_2.getMonsterView());
        queue3.setImageResource(queue_pos_3.getMonsterView());
        queue4.setImageResource(queue_pos_4.getMonsterView());
        queue5.setImageResource(queue_pos_5.getMonsterView());
    }

    void enemyAttack(){
        if (queue_pos_1.getMonsterView()!=R.drawable.hero){
            audioPlayer.play((int)(Math.random()*2)==0?audioPlayer.goblin_attack1ID:
                    audioPlayer.goblin_attack2ID);
            hero.getDamage(queue_pos_1.getAttack());
            heroInfo.setText(hero.getMonsterHP()+"/"+hero.getMonsterMaxHP());
            queueSwap();
            enemyAttack();
        }
    }

    void heroAttack(Monster enemy){
        if (enemy.getMonsterHP()>0){
            int roll = (int)(Math.random()*3);
            audioPlayer.play(roll==0?audioPlayer.attack1ID:
                    (roll==2?audioPlayer.attack2ID:audioPlayer.attack3ID));
            enemy.getDamage(50);
            audioPlayer.play(audioPlayer.goblin_hitID);
            enemyDeath();
            queueSwap();
        }
    }

    void queueSwap(){
        Monster temp=queue_pos_1;
        queue_pos_1=queue_pos_2;
        queue_pos_2=queue_pos_3;
        queue_pos_3=queue_pos_4;
        queue_pos_4=queue_pos_5;
        queue_pos_5=temp;
        queue1.setImageResource(queue_pos_1.getMonsterView());
        queue2.setImageResource(queue_pos_2.getMonsterView());
        queue3.setImageResource(queue_pos_3.getMonsterView());
        queue4.setImageResource(queue_pos_4.getMonsterView());
        queue5.setImageResource(queue_pos_5.getMonsterView());
    }

    void heroDeath(Intent intent){
        if (hero.getMonsterHP()<=0)
            startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        Intent heroDeathIntent = new Intent(this, MainActivity.class);
    switch (v.getId()){
        case R.id.next_room:
            audioPlayer.play(audioPlayer.click_buttonID);
            if(numOfRooms==0){
                audioPlayer.stopMusic();
                Intent fight_intent = new Intent(this, MainActivity.class);
                startActivity(fight_intent);
            }
            else {
                Intent fight_intent = new Intent(this, FightActivity.class);
                fight_intent.putExtra("numOfRooms", numOfRooms);
                fight_intent.putExtra("heroHP", hero.getMonsterHP());
                fight_intent.putExtra("heroSpeed", hero.getMonsterSpeed());
                startActivity(fight_intent);
            }
            break;
        case R.id.enemy_pos_1:
            heroAttack(enemy1);
            enemyAttack();
            heroDeath(heroDeathIntent);
            break;
        case R.id.enemy_pos_2:
            heroAttack(enemy2);
            enemyAttack();
            heroDeath(heroDeathIntent);
            break;
        case R.id.enemy_pos_3:
            heroAttack(enemy3);
            enemyAttack();
            heroDeath(heroDeathIntent);
            break;
        case R.id.enemy_pos_4:
            heroAttack(enemy4);
            enemyAttack();
            heroDeath(heroDeathIntent);
            break;
        default:
            break;
    }
    }
}
