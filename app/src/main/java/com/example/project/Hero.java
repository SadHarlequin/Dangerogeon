package com.example.project;

public class Hero extends Monster{

    Hero(int monsterMaxHP, int monsterSpeed) {
        super(monsterMaxHP, monsterSpeed);
    }
    Hero(){}

    void setHeroMaxHp(int heroMaxHp){this.monsterMaxHP=heroMaxHp;}
    String getHeroInfo(){
        return monsterHP+"/"+monsterMaxHP+" HP\nAttack "+attack;}
}
