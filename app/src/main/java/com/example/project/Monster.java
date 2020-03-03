package com.example.project;

public class Monster {
    String monster_name;
    int monster_HP;
    String monster_weakness;
    String monster_strong;

    void set_name(String n){
        this.monster_name=n;
    }

    void set_HP(int n){
        this.monster_HP=n;
    }

    void monster_type(String n){
        switch (n){
            case ("Soldier"):
                this.monster_strong="One-handed";
                this.monster_weakness="Two-handed";
                break;
            case("Skeleton"):
                this.monster_strong="Pierce";
                this.monster_weakness="Crushing";
                break;
            case("Magic Pet"):
                this.monster_strong="Magic";
                this.monster_weakness="One-handed";
            case("Giant"):
                this.monster_strong="Crushing";
                this.monster_weakness="Pierce";
            case("Mystic"):
                this.monster_strong="Two-handed";
                this.monster_weakness="Magic";
            default:
                break;
        }

    }
}
