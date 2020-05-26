package com.example.project;

public class Weapon {
    String weapon_name;
    int base_damage;
    String damage_type1;
    String damage_type2;
    int max_durability;
    int current_durability;
    int range=2;
    boolean prepare_to_shoot=true;
    int weight;

    void setName(String n){
        this.weapon_name=n;
    }
    void setWeight(int n){
        this.weight=n;
    }
    void setDamageType(String n){
        this.damage_type1=n;
        if (this.damage_type1=="Range"){ this.range=4;
            this.prepare_to_shoot=false;
        }
        if (this.damage_type1=="Pierce") this.range=3;
    }
    void setDamageType(String n1, String n2){
        this.damage_type1=n1;
        this.damage_type2=n2;
        if (this.damage_type1=="Range" || this.damage_type2=="Range"){ this.range=4;
            this.prepare_to_shoot=false;
        }
        if (this.damage_type1=="Pierce" || this.damage_type2=="Pierce") this.range=3;
    }
    void setBaseDamage(int n){
        this.base_damage=n;
    }
    void print_info(){
        if (damage_type2!=null) {
            System.out.printf(this.weapon_name + " " + this.damage_type1 + " " + this.damage_type2 + " " + this.current_durability +"/"+ this.max_durability + " "
                    + this.base_damage + " " + this.range);
        }
        else System.out.printf(this.weapon_name + " " + this.damage_type1 + " " + this.current_durability);
    }
    void setMaxDurability(int n){
        this.max_durability=n;
        this.current_durability=n;
    }
}
