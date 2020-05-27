package com.example.project;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static com.example.project.MainActivity.audioPlayer;


public class FightActivity extends AppCompatActivity implements View.OnClickListener {
    int numOfRooms;
    int monsterChoice;
    int roomChoice;
    int enemyDeathsCounter;
    int resourcesCounter;
    String weaponChoiceType = "sword";
    ImageButton weapon_choice;
    ImageButton weapon_choice_cancel;
    FragmentTransaction ft;
    FragmentManager fm;
    Fragment fragment;
    ImageButton nextRoom;
    Button inventory;
    //переменные для текущих позиций монстров
    Monster enemy1;
    Monster enemy2;
    Monster enemy3;
    Monster enemy4;
    //изображения монстров для текущих позиций
    ImageButton hero_image;
    ImageButton enemy1_image;
    ImageButton enemy2_image;
    ImageButton enemy3_image;
    ImageButton enemy4_image;
    //текст с инфой монстров для текущих позиций
    TextView enemyInfo1;
    TextView enemyInfo2;
    TextView enemyInfo3;
    TextView enemyInfo4;
    TextView heroInfo;
    //изображения монстров в очереди
    ImageView queue1;
    ImageView queue2;
    ImageView queue3;
    ImageView queue4;
    ImageView queue5;
    Hero hero = new Hero();
    //переменные персонажей для текущей позиции в очереди
    Monster queue_pos_1;
    Monster queue_pos_2;
    Monster queue_pos_3;
    Monster queue_pos_4;
    Monster queue_pos_5;
    //анимации персонажей
    AnimationDrawable hero_animation;
    AnimationDrawable enemy1_animation;
    AnimationDrawable enemy2_animation;
    AnimationDrawable enemy3_animation;
    AnimationDrawable enemy4_animation;
    //попытка в приостановку времени
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        handler = new Handler();
        numOfRooms = getIntent().getIntExtra("numOfRooms", 0) - 1;
        roomChoice = (int) (Math.random() * 2) + 1;
        enemyDeathsCounter = getIntent().getIntExtra("enemyDeathsCounter", 0);
//        resourcesCounter= getIntent().getIntExtra("resourcesCounter", 0);
        hero.setHP(getIntent().getIntExtra("heroHP", 0));
        hero.setMonsterSpeed(getIntent().getIntExtra("heroSpeed", 0));
        hero.setHeroMaxHp(200);
        hero.setAttack(50);
        hero.setMonsterView(R.drawable.hero);
        inventory = (Button)findViewById(R.id.inventory);

        super.onCreate(savedInstanceState);
        switch (roomChoice) {
            case 1:
                monsterChoice = (int) (Math.random() * 3) + 1;
                setContentView(R.layout.fight_area);
                nextRoom = (ImageButton) findViewById(R.id.next_room);
                nextRoom.setOnClickListener(this);
                nextRoom.setVisibility(View.INVISIBLE);
                nextRoom.setClickable(false);

                weapon_choice = findViewById(R.id.attackChoiceButton);
                weapon_choice.setOnClickListener(this);
                weapon_choice_cancel = findViewById(R.id.attackChoiceButtonCancel);
                weapon_choice_cancel.setOnClickListener(this);

                enemy1_image = findViewById(R.id.enemy_pos_1);
                enemy1_image.setOnClickListener(this);
                enemy2_image = findViewById(R.id.enemy_pos_2);
                enemy2_image.setOnClickListener(this);
                enemy3_image = findViewById(R.id.enemy_pos_3);
                enemy3_image.setOnClickListener(this);
                enemy4_image = findViewById(R.id.enemy_pos_4);
                enemy4_image.setOnClickListener(this);
                hero_image = findViewById(R.id.hero_pos_4);
                hero_image.setOnClickListener(this);
                hero_image.setBackgroundResource(R.drawable.hero_wait);

                squadCreation(monsterChoice);
                enemyInfo1 = findViewById(R.id.enemyText1);
                enemyInfo2 = findViewById(R.id.enemyText2);
                enemyInfo3 = findViewById(R.id.enemyText3);
                enemyInfo4 = findViewById(R.id.enemyText4);
                heroInfo = findViewById(R.id.heroText);
                enemyInfo1.setText(enemy1.getInfo());
                enemyInfo2.setText(enemy2.getInfo());
                enemyInfo3.setText(enemy3.getInfo());
                enemyInfo4.setText(enemy4.getInfo());
                heroInfo.setText(hero.getHeroInfo());
                queue1 = findViewById(R.id.queue1);
                queue2 = findViewById(R.id.queue2);
                queue3 = findViewById(R.id.queue3);
                queue4 = findViewById(R.id.queue4);
                queue5 = findViewById(R.id.queue5);
                queueCreation();

                hero_animation = (AnimationDrawable) hero_image.getBackground();
                enemy1_animation = (AnimationDrawable) enemy1_image.getBackground();
                enemy2_animation = (AnimationDrawable) enemy2_image.getBackground();
                enemy3_animation = (AnimationDrawable) enemy3_image.getBackground();
                enemy4_animation = (AnimationDrawable) enemy4_image.getBackground();

                hero_animation.start();
                enemy1_animation.start();
                enemy2_animation.start();
                enemy3_animation.start();
                enemy4_animation.start();
                enemyAttack();
                weaponType();
                break;
            case 2:
                setContentView(R.layout.treasure_activity);
                hero_image = findViewById(R.id.hero_pos_4);
                hero_image.setOnClickListener(this);
                hero_image.setBackgroundResource(R.drawable.hero_wait);
                hero_animation = (AnimationDrawable) hero_image.getBackground();
                hero_animation.start();
                nextRoom = findViewById(R.id.next_room);
                nextRoom.setOnClickListener(this);
                break;
        }
    }

    //создание отряда по выбранному рандомом числу
    void squadCreation(int monsterChoice) {
        switch (monsterChoice) {
            case 1:
                enemy1 = new Monster("Goblin", 50, R.drawable.goblin_02, R.drawable.goblin_02_wait,R.drawable.goblin_02_hurt, 5);
                enemy1.monsterType("Soldier");
                enemy1_image.setBackgroundResource(enemy1.getMonsterAnimationWait());

                enemy2 = new Monster("Goblin", 50, R.drawable.goblin_02, R.drawable.goblin_02_wait,R.drawable.goblin_02_hurt, 5);
                enemy2.monsterType("Soldier");
                enemy2_image.setBackgroundResource(enemy2.getMonsterAnimationWait());

                enemy3 = new Monster("Goblin", 50, R.drawable.goblin_02, R.drawable.goblin_02_wait,R.drawable.goblin_02_hurt, 5);
                enemy3.monsterType("Soldier");
                enemy3_image.setBackgroundResource(enemy3.getMonsterAnimationWait());

                enemy4 = new Monster("Golem", 100, R.drawable.golem, R.drawable.golem_wait,R.drawable.golem_hurt, 10);
                enemy4.monsterType("Giant");
                enemy4_image.setBackgroundResource(enemy4.getMonsterAnimationWait());
                break;
            case 2:
                enemy1 = new Monster("Goblin", 50, R.drawable.goblin_02, R.drawable.goblin_02_wait,R.drawable.goblin_02_hurt, 5);
                enemy1.monsterType("Soldier");
                enemy1_image.setBackgroundResource(enemy1.getMonsterAnimationWait());

                enemy2 = new Monster("Goblin", 50, R.drawable.goblin_02, R.drawable.goblin_02_wait,R.drawable.goblin_02_hurt, 5);
                enemy2.monsterType("Soldier");
                enemy2_image.setBackgroundResource(enemy2.getMonsterAnimationWait());

                enemy3 = new Monster("Golem", 100, R.drawable.golem, R.drawable.golem_wait,R.drawable.golem_hurt, 10);
                enemy3.monsterType("Giant");
                enemy3_image.setBackgroundResource(enemy3.getMonsterAnimationWait());

                enemy4 = new Monster("", -9999, R.drawable.free_space, R.drawable.free_space_img,R.drawable.free_space_img, 0);
                enemy4.setMonsterSpeed(0);
                enemy4_image.setBackgroundResource(enemy4.getMonsterAnimationWait());
                break;
            case 3:
                enemy1 = new Monster("Goblin", 50, R.drawable.goblin_02, R.drawable.goblin_02_wait,R.drawable.goblin_02_hurt, 5);
                enemy1.monsterType("Soldier");
                enemy1_image.setBackgroundResource(enemy1.getMonsterAnimationWait());

                enemy2 = new Monster("Goblin", 50, R.drawable.goblin_02, R.drawable.goblin_02_wait,R.drawable.goblin_02_hurt, 5);
                enemy2.monsterType("Soldier");
                enemy2_image.setBackgroundResource(enemy2.getMonsterAnimationWait());

                enemy3 = new Monster("Goblin", 50, R.drawable.goblin_02, R.drawable.goblin_02_wait,R.drawable.goblin_02_hurt, 5);
                enemy3.monsterType("Soldier");
                enemy3_image.setBackgroundResource(enemy3.getMonsterAnimationWait());

                enemy4 = new Monster("Goblin", 50, R.drawable.goblin_02, R.drawable.goblin_02_wait,R.drawable.goblin_02_hurt, 5);
                enemy4.monsterType("Soldier");
                enemy4_image.setBackgroundResource(enemy3.getMonsterAnimationWait());
                break;
            default:
                break;
        }
    }

    //смерть монстра и сдвиг трупа в конец
    void enemyDeath() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
        audioPlayer.play((int) (Math.random() * 2) == 0 ? audioPlayer.goblin_death_rattle1ID
                : audioPlayer.goblin_death_rattle2ID);
        Monster swap;
        if (enemy1.getMonsterHP() <= 0) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (enemy1.getMonsterHP() <= 0){
                        enemy1.MonsterDeathAnimation();
                        enemyDeathsCounter=+1;
                    }
                }
            });
            swap = enemy1;
            enemy1 = enemy2;
            enemy2 = swap;
        }
        if (enemy2.getMonsterHP() <= 0) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (enemy2.getMonsterHP() <= 0){
                        enemy2.MonsterDeathAnimation();
                        enemyDeathsCounter=+1;}
                }
            });
            //enemy2.MonsterDeathAnimation();
            swap = enemy2;
            enemy2 = enemy3;
            enemy3 = swap;
        }
        if (enemy3.getMonsterHP() <= 0 & enemy4.getMonsterHP() != -9999) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (enemy3.getMonsterHP() <= 0 & enemy4.getMonsterHP() != -9999){
                        enemy3.MonsterDeathAnimation();
                        enemyDeathsCounter=+1;}
                }
            });
            //enemy3.MonsterDeathAnimation();
            swap = enemy3;
            enemy3 = enemy4;
            enemy4 = swap;
        }
        if (enemy3.getMonsterHP() <= 0 & enemy4.getMonsterHP() == -9999) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (enemy3.getMonsterHP() <= 0 & enemy4.getMonsterHP() == -9999){
                        enemy3.MonsterDeathAnimation();
                        enemyDeathsCounter=+1;}
                }
            });
            //enemy3.MonsterDeathAnimation();
        }
        if (enemy4.getMonsterHP() <= 0 & enemy4.getMonsterHP() > -9999) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (enemy4.getMonsterHP() <= 0 & enemy4.getMonsterHP() > -9999){
                        enemy4.MonsterDeathAnimation();
                        enemyDeathsCounter=+1;}
                }
            });
            //enemy4.MonsterDeathAnimation();
        }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        enemy1_image.setBackgroundResource(enemy1.getMonsterAnimationWait());
                        enemy2_image.setBackgroundResource(enemy2.getMonsterAnimationWait());
                        enemy3_image.setBackgroundResource(enemy3.getMonsterAnimationWait());
                        enemy4_image.setBackgroundResource(enemy4.getMonsterAnimationWait());
                        enemyInfo1.setText(enemy1.getInfo());
                        enemyInfo2.setText(enemy2.getInfo());
                        enemyInfo3.setText(enemy3.getInfo());
                        enemyInfo4.setText(enemy4.getInfo());
                        queue1.setImageResource(queue_pos_1.getMonsterView());
                        queue2.setImageResource(queue_pos_2.getMonsterView());
                        queue3.setImageResource(queue_pos_3.getMonsterView());
                        queue4.setImageResource(queue_pos_4.getMonsterView());
                        queue5.setImageResource(queue_pos_5.getMonsterView());
                        if (enemy1.getMonsterHP() <= 0 & enemy2.getMonsterHP() <= 0 & enemy3.getMonsterHP() <= 0 & enemy4.getMonsterHP() <= 0) {
                            nextRoom.setClickable(true);
                            nextRoom.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
    });
        thread.start();
        thread.interrupt();
    }

    //создание очереди
    void queueCreation() {
        queue_pos_1 = hero;
        queue_pos_2 = enemy1;
        queue_pos_3 = enemy2;
        queue_pos_4 = enemy3;
        queue_pos_5 = enemy4;
        final Monster[] temp = new Monster[1];
        final boolean[] swapped = {true};
        Thread stream = new Thread(new Runnable() {
            @Override
            public void run() {
                while (swapped[0]) {
                    if (queue_pos_1.getMonsterSpeed() < queue_pos_2.getMonsterSpeed()) {
                        temp[0] = queue_pos_1;
                        queue_pos_1 = queue_pos_2;
                        queue_pos_2 = temp[0];
                    } else if (queue_pos_2.getMonsterSpeed() < queue_pos_3.getMonsterSpeed()) {
                        temp[0] = queue_pos_2;
                        queue_pos_2 = queue_pos_3;
                        queue_pos_3 = temp[0];
                    } else if (queue_pos_3.getMonsterSpeed() < queue_pos_4.getMonsterSpeed()) {
                        temp[0] = queue_pos_3;
                        queue_pos_3 = queue_pos_4;
                        queue_pos_4 = temp[0];
                    } else if (queue_pos_4.getMonsterSpeed() < queue_pos_5.getMonsterSpeed()) {
                        temp[0] = queue_pos_4;
                        queue_pos_4 = queue_pos_5;
                        queue_pos_5 = temp[0];
                    } else
                        swapped[0] = false;
                }
                queue1.post(new Runnable() {
                    @Override
                    public void run() {
                        queue1.setImageResource(queue_pos_1.getMonsterView());
                    }
                });
                queue2.post(new Runnable() {
                    @Override
                    public void run() {
                        queue2.setImageResource(queue_pos_2.getMonsterView());
                    }
                });
                queue3.post(new Runnable() {
                    @Override
                    public void run() {
                        queue3.setImageResource(queue_pos_3.getMonsterView());
                    }
                });
                queue4.post(new Runnable() {
                    @Override
                    public void run() {
                        queue4.setImageResource(queue_pos_4.getMonsterView());
                    }
                });
                queue5.post(new Runnable() {
                    @Override
                    public void run() {
                        queue5.setImageResource(queue_pos_5.getMonsterView());
                    }
                });
            }
        });
        stream.start();
        stream.interrupt();
    }

    //атака монстра
    void enemyAttack() {
        if (queue_pos_1.getMonsterView() != R.drawable.hero) {
            if (queue_pos_1.getMonsterView() != R.drawable.grave) {
                audioPlayer.play((int) (Math.random() * 2) == 0 ? audioPlayer.goblin_attack1ID :
                        audioPlayer.goblin_attack2ID);
            }
            hero.getDamage(queue_pos_1.getAttack());
            heroInfo.setText(hero.getHeroInfo());
            queueSwap();
            enemyAttack();
        }
    }

    //атака героя
    void heroAttack(Monster enemy, ImageView enemy_image, AnimationDrawable enemy_animation) {
        if (enemy.getMonsterHP() > 0) {
            int roll = (int) (Math.random() * 3);
            audioPlayer.play(roll == 0 ? audioPlayer.attack1ID :
                    (roll == 2 ? audioPlayer.attack2ID : audioPlayer.attack3ID));
//

            enemy.getDamage(hero.getAttack());
            audioPlayer.play(audioPlayer.goblin_hitID);

            queueSwap();
            enemyDeath();

        }
    }

    //перемещение позиции в очереди
    void queueSwap() {
        Monster temp = queue_pos_1;
        queue_pos_1 = queue_pos_2;
        queue_pos_2 = queue_pos_3;
        queue_pos_3 = queue_pos_4;
        queue_pos_4 = queue_pos_5;
        queue_pos_5 = temp;
        queue1.setImageResource(queue_pos_1.getMonsterView());
        queue2.setImageResource(queue_pos_2.getMonsterView());
        queue3.setImageResource(queue_pos_3.getMonsterView());
        queue4.setImageResource(queue_pos_4.getMonsterView());
        queue5.setImageResource(queue_pos_5.getMonsterView());
    }

    //смерть героя
    void heroDeath(Intent intent) {
        if (hero.getMonsterHP() <= 0){
            intent.putExtra("enemyDeathsCounter", enemyDeathsCounter);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }

    }

    void weaponType(){
        if (weaponChoiceType.equals("sword")){
            enemy3_image.setClickable(false);
            enemy4_image.setClickable(false);
        }
        if (weaponChoiceType.equals("spear")){
            enemy4_image.setClickable(false);
        }
        if (enemy1.getMonsterHP() <= 0 & enemy2.getMonsterHP() <= 0 & enemy3.getMonsterHP() <= 0 & enemy4.getMonsterHP() <= 0) {
            enemy2_image.setClickable(true);
            enemy3_image.setClickable(true);
            enemy4_image.setClickable(true);
            enemy1_image.setClickable(true);
        }
    }

    @Override
    public void onClick(View v) {
        Intent heroDeathIntent = new Intent(this, EndOfJorneyActivity.class);
        switch (v.getId()) {
            case R.id.next_room:
                audioPlayer.play(audioPlayer.click_buttonID);
                if (numOfRooms == 0) {
                    audioPlayer.stopMusic();
                    Intent fight_intent = new Intent(this, EndOfJorneyActivity.class);
                    fight_intent.putExtra("enemyDeathsCounter", enemyDeathsCounter);
//                    fight_intent.putExtra("numOfRooms", numOfRooms);
                    startActivity(fight_intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else {
                    Intent fight_intent = new Intent(this, FightActivity.class);
                    fight_intent.putExtra("enemyDeathsCounter", enemyDeathsCounter);
//                    fight_intent.putExtra("numOfRooms", numOfRooms);
                    fight_intent.putExtra("numOfRooms", numOfRooms);
                    fight_intent.putExtra("heroHP", hero.getMonsterHP());
                    fight_intent.putExtra("heroSpeed", hero.getMonsterSpeed());
                    startActivity(fight_intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
                break;
            case R.id.enemy_pos_1:
                weaponType();
                heroAttack(enemy1, enemy1_image, enemy1_animation);
                enemyAttack();
                heroDeath(heroDeathIntent);
                break;
            case R.id.enemy_pos_2:
                weaponType();
                heroAttack(enemy2, enemy2_image, enemy2_animation);
                enemyAttack();
                heroDeath(heroDeathIntent);
                break;
            case R.id.enemy_pos_3:
                weaponType();
                heroAttack(enemy3, enemy3_image, enemy3_animation);
                enemyAttack();
                heroDeath(heroDeathIntent);
                break;
            case R.id.enemy_pos_4:
                weaponType();
                heroAttack(enemy4, enemy4_image, enemy4_animation);
                enemyAttack();
                heroDeath(heroDeathIntent);
                break;
            case R.id.attackChoiceButton :
                fragment = new weaponFragment();
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.weaponFragmentImg,fragment);
                ft.commit();
                weapon_choice_cancel.setClickable(true);
                weapon_choice_cancel.setVisibility(View.VISIBLE);
                break;
            case R.id.attackChoiceButtonCancel:
                fragment = new BlankFragment();
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.weaponFragmentImg,fragment);
                ft.commit();
                weapon_choice_cancel.setClickable(false);
                weapon_choice_cancel.setVisibility(View.INVISIBLE);
//                weaponChoiceType = getIntent().getStringExtra("weapon_choice");
                break;
            case R.id.inventory:
                break;
            default:
                break;
        }
    }
}
