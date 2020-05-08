package com.example.project;

import android.graphics.drawable.Drawable;


public class Monster {
    String monsterName;
    int monsterHP;
    int monsterMaxHP;
    String monsterWeakness;
    String monsterStrong;
    int monsterView;
    int monsterSpeed;
    int attack;

    void setAttack(int power){this.attack=power; }

    int getAttack(){return attack;}

    Monster(String monsterName, int monsterMaxHP, int monsterView, int attack){
        this.monsterMaxHP = monsterMaxHP;
        this.monsterHP = monsterMaxHP;
        this.monsterName = monsterName;
        this.monsterView = monsterView;
        this.attack=attack;
//        this.monsterSpeed=monsterSpeed;
    }

    public Monster(int monsterMaxHP, int monsterSpeed) {
        this.monsterSpeed=monsterSpeed;
        this.monsterMaxHP=monsterMaxHP;
        this.monsterHP=monsterMaxHP;
    }

    public Monster() {
    }

    void setMonsterView(int monsterView){
        this.monsterView = monsterView;
    }

    void setMonsterSpeed(int monsterSpeed){this.monsterSpeed=monsterSpeed;}

    int getMonsterSpeed(){return monsterSpeed;}

    int getMonsterMaxHP(){return monsterMaxHP;}


    int getMonsterView(){
        return monsterView;
    }

    void getDamage(int damage){
        this.monsterHP-=damage;
    }

    void setMonsterName(String n){
        this.monsterName=n;
    }

    String getMonsterName (){return monsterName;}

    String getInfo(){
        if (monsterHP<=0) return "";
        return monsterName+"\n"+monsterHP+"/"+monsterMaxHP+"\n"+monsterSpeed;}

    void setHP(int n){
        this.monsterHP=n;
    }

    int getMonsterHP (){
        return monsterHP;
    }

    void monsterType(String n){
        switch (n){
            case ("Soldier"):
                this.monsterStrong="One-handed";
                this.monsterWeakness="Two-handed";
                this.monsterSpeed=(int)(Math.random()*4)+2;
                break;
            case("Skeleton"):
                this.monsterStrong="Pierce";
                this.monsterWeakness="Crushing";
                this.monsterSpeed=(int)(Math.random()*3)+1;
                break;
            case("Magic Pet"):
                this.monsterStrong="Magic";
                this.monsterWeakness="One-handed";
                this.monsterSpeed=(int)(Math.random()*6)+2;
            case("Giant"):
                this.monsterStrong="Crushing";
                this.monsterWeakness="Pierce";
                this.monsterSpeed=(int)(Math.random());
            case("Mystic"):
                this.monsterStrong="Two-handed";
                this.monsterWeakness="Magic";
                this.monsterSpeed=(int)(Math.random()*5)+3;
            default:
                break;
        }

    }
   /* {
        Monster goblin = new Monster();
        goblin.set_name("Dirty Goblin");
        goblin.monster_type("Soldier");
        goblin.set_HP(50);

        Monster skeleton_warrior = new Monster();
        skeleton_warrior.set_name("Skeleton");
        skeleton_warrior.monster_type("Skeleton");
        skeleton_warrior.set_HP(50);

        Monster skeleton_archer = new Monster();
        skeleton_archer.set_name("Skinny Sniper");
        skeleton_archer.monster_type("Skeleton");
        skeleton_archer.set_HP(50);

        Monster child_dragon = new Monster();
        child_dragon.set_name("Cute Flamethrower");
        child_dragon.monster_type("Magic Pet");
        child_dragon.set_HP(50);

        Monster giant_rat = new Monster();
        giant_rat.set_name("Plague Carrier");
        giant_rat.monster_type("Giant");
        giant_rat.set_HP(50);

        Monster zombie = new Monster();
        zombie.set_name("Braineater");
        zombie.monster_type("Soldier");
        zombie.set_HP(50);

        Monster ghost = new Monster();
        ghost.set_name("Lost Soul");
        ghost.monster_type("Mystic");
        ghost.set_HP(50);

        Monster flesh_golem = new Monster();
        flesh_golem.set_name("Flesh golem");
        zombie.monster_type("Giant");
        zombie.set_HP(50);
    } //Перечень Монстров*/

}
