package com.example.project;

public class Armor {
    int weight;
    String material;
    String armor_name;
    int max_durability;
    int current_durability;
    String cell;

    void setName(String n){
        this.armor_name=n;
    }
    void setWeight(int n){
        this.weight=n;
    }
    void setMaterial(String n){
        this.material=n;
    }
    void setMaxDurable(int n){
        this.max_durability=n;
        this.current_durability=n;
    }
    void part_of_set(int n){
        switch(n){
            case(1):
                this.cell="Helmet";
                break;
            case(2):
                this.cell="Cuirass";
                break;
            case(3):
                this.cell="Pants";
                break;
            default:
                break;
        }
    }
}
