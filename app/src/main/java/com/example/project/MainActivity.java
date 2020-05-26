package com.example.project;

import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static SFXPlayer audioPlayer = new SFXPlayer();
    //audioPlayer.setContext(this);
    Button musicButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        audioPlayer.startMusic(this, audioPlayer.main_themeID);
        audioPlayer.loadSounds(this);
        super.onCreate(savedInstanceState);
        //SFXPlayer.play(SFXPlayer.coinID,1,1,1);
        setContentView(R.layout.activity_main);
        Button forestButton = (Button) findViewById(R.id.forestButton);
        forestButton.setOnClickListener(this);
        Button vendButton = (Button) findViewById(R.id.vendorButton);
        vendButton.setOnClickListener(this);
        Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(this);
        musicButton = (Button) findViewById(R.id.button9);
        musicButton.setOnClickListener(this);
    }
    @Override
    protected void onResume(){
        super.onResume();
        audioPlayer.startMusic(this, audioPlayer.main_themeID);
    }

    protected void onPause(){
        super.onPause();
        audioPlayer.pauseMusic();
    }

    {
        Weapon saber = new Weapon();
        saber.set_name("Old Pirate`s Saber");
        saber.set_damage_type("One-handed");
        saber.set_base_damage(50);
        saber.set_max_durability(100);
        saber.set_weight(4);

        Weapon dagger = new Weapon();
        dagger.set_name("Dagger");
        dagger.set_damage_type("One-handed");
        dagger.set_base_damage(50);
        dagger.set_max_durability(100);
        dagger.set_weight(4);

        Weapon broadsword = new Weapon();
        broadsword.set_name("Rusty Broadsword");
        broadsword.set_damage_type("One-handed");
        broadsword.set_base_damage(50);
        broadsword.set_max_durability(100);
        broadsword.set_weight(4);

        Weapon katana = new Weapon();
        katana.set_name("Katana from far country");
        katana.set_damage_type("One-handed");
        katana.set_base_damage(50);
        katana.set_max_durability(100);
        katana.set_weight(4);

        Weapon zweihander = new Weapon();
        zweihander.set_name("Zweihander");
        zweihander.set_damage_type("Two-handed");
        zweihander.set_base_damage(50);
        zweihander.set_max_durability(100);
        zweihander.set_weight(4);

        Weapon scythe = new Weapon();
        scythe.set_name("Scythe");
        scythe.set_damage_type("Two-handed");
        scythe.set_base_damage(50);
        scythe.set_max_durability(100);
        scythe.set_weight(4);

        Weapon claymore = new Weapon();
        claymore.set_name("Unknown Knight`s Claymore");
        claymore.set_damage_type("Two-handed");
        claymore.set_base_damage(50);
        claymore.set_max_durability(100);
        claymore.set_weight(4);

        Weapon halberd = new Weapon();
        halberd.set_name("Halberd");
        halberd.set_damage_type("Two-handed", "Pierce");
        halberd.set_base_damage(30);
        halberd.set_max_durability(100);
        halberd.set_weight(4);

        Weapon spear = new Weapon();
        spear.set_name("Spear");
        spear.set_damage_type("Pierce");
        spear.set_base_damage(40);
        spear.set_max_durability(90);
        spear.set_weight(4);

        Weapon rapier = new Weapon();
        rapier.set_name("Rapier of lost prince");
        rapier.set_damage_type("Pierce");
        rapier.set_base_damage(50);
        rapier.set_max_durability(100);
        rapier.set_weight(4);

        Weapon trident = new Weapon();
        trident.set_name("Trident");
        trident.set_damage_type("Pierce");
        trident.set_base_damage(50);
        trident.set_max_durability(100);
        trident.set_weight(4);

        Weapon bow = new Weapon();
        bow.set_name("Bow");
        bow.set_damage_type("Range");
        bow.set_base_damage(60);
        bow.set_max_durability(45);
        bow.set_weight(4);

        Weapon sling = new Weapon();
        sling.set_name("Sling");
        sling.set_damage_type("Range");
        sling.set_base_damage(60);
        sling.set_max_durability(45);
        sling.set_weight(4);

        Weapon crossbow = new Weapon();
        crossbow.set_name("Crossbow");
        crossbow.set_damage_type("Range");
        crossbow.set_base_damage(80);
        crossbow.set_max_durability(50);
        crossbow.set_weight(4);

        Weapon hummer = new Weapon();
        hummer.set_name("Paladin's Hummer");
        hummer.set_damage_type("Crushing");
        hummer.set_base_damage(50);
        hummer.set_max_durability(100);
        hummer.set_weight(4);

        Weapon club = new Weapon();
        club.set_name("Training Club");
        club.set_damage_type("Crushing");
        club.set_base_damage(50);
        club.set_max_durability(100);
        club.set_weight(4);

        Weapon mace = new Weapon();
        mace.set_name("Mace");
        mace.set_damage_type("Crushing");
        mace.set_base_damage(50);
        mace.set_max_durability(100);
        mace.set_weight(4);

        Weapon morgenstern = new Weapon();
        morgenstern.set_name("Blood-waiting Morgenstern");
        morgenstern.set_damage_type("Crushing");
        morgenstern.set_base_damage(50);
        morgenstern.set_max_durability(100);
        morgenstern.set_weight(4);

        Weapon staff = new Weapon();
        staff.set_name("Staff");
        staff.set_damage_type("Magic");
        staff.set_base_damage(50);
        staff.set_max_durability(100);
        staff.set_weight(4);

        Weapon wand = new Weapon();
        wand.set_name("Magic Wand");
        wand.set_damage_type("Magic");
        wand.set_base_damage(50);
        wand.set_max_durability(100);
        wand.set_weight(4);

        Weapon grimoire = new Weapon();
        grimoire.set_name("Grimoire");
        grimoire.set_damage_type("Magic");
        grimoire.set_base_damage(50);
        grimoire.set_max_durability(100);
        grimoire.set_weight(4);

        Weapon excalibur = new Weapon();
        excalibur.set_name("Excalibur");
        excalibur.set_damage_type("One-handed", "Magic");
        excalibur.set_base_damage(50);
        excalibur.set_max_durability(100);
        excalibur.set_weight(4);
    } //Перечень оружия


    {
        Armor lh = new Armor();
        lh.set_name("Leather Helmet");
        lh.set_material("Leather");
        lh.set_max_durable(50);
        lh.set_weight(5);
        lh.part_of_set(1);

        Armor lc = new Armor();
        lc.set_name("Leather Cuirass");
        lc.set_material("Leather");
        lc.set_max_durable(50);
        lc.set_weight(5);
        lc.part_of_set(2);

        Armor lp = new Armor();
        lp.set_name("Leather Pants");
        lp.set_material("Leather");
        lp.set_max_durable(50);
        lp.set_weight(5);
        lp.part_of_set(3);

        Armor ih = new Armor();
        ih.set_name("Iron Helmet");
        ih.set_material("Iron");
        ih.set_max_durable(50);
        ih.set_weight(5);
        ih.part_of_set(1);

        Armor ic = new Armor();
        ic.set_name("Iron Cuirass");
        ic.set_material("Iron");
        ic.set_max_durable(50);
        ic.set_weight(5);
        ic.part_of_set(2);

        Armor ip = new Armor();
        ip.set_name("Iron Pants");
        ip.set_material("Iron");
        ip.set_max_durable(50);
        ip.set_weight(5);
        ip.part_of_set(3);

        Armor mh = new Armor();
        mh.set_name("Magic Hat");
        mh.set_material("Essence");
        mh.set_max_durable(50);
        mh.set_weight(5);
        mh.part_of_set(1);

        Armor mc = new Armor();
        mc.set_name("Magic Cape");
        mc.set_material("Essence");
        mc.set_max_durable(50);
        mc.set_weight(5);
        mc.part_of_set(2);

        Armor mm = new Armor();
        mm.set_name("Magic Mantle");
        mm.set_material("Essence");
        mm.set_max_durable(50);
        mm.set_weight(5);
        mm.part_of_set(3);

        Armor bh = new Armor();
        bh.set_name("Bone Helmet");
        bh.set_material("Bone");
        bh.set_max_durable(50);
        bh.set_weight(5);
        bh.part_of_set(1);

        Armor bp = new Armor();
        bp.set_name("Bone Platemail");
        bp.set_material("Bone");
        bp.set_max_durable(50);
        bp.set_weight(5);
        bp.part_of_set(2);

        Armor bpants = new Armor();
        bpants.set_name("Bone Pants");
        bpants.set_material("Bone");
        bpants.set_max_durable(50);
        bpants.set_weight(5);
        bpants.part_of_set(3);

    }//Перечень Брони

    @Override
    public void onClick(View view) {
        audioPlayer.play(audioPlayer.click_buttonID);
        switch (view.getId()) {
            case R.id.forestButton:
                audioPlayer.stopMusic();
                //audioPlayer.pause(audioPlayer.coinID);
                Intent intent1 = new Intent(this, PrepareActivity.class);
                //intent1.putExtra("sfx", audioPlayer);
                audioPlayer.startMusic(this, audioPlayer.forest_themeID);
                startActivity(intent1);
                break;
            case R.id.vendorButton:
                audioPlayer.stopMusic();
                //audioPlayer.pause(audioPlayer.coinID);
                Intent intent2 = new Intent(this, VendorActivity.class);
                //intent2.putExtra("sfx", audioPlayer);
                startActivity(intent2);
                break;
            case R.id.button9:
                audioPlayer.play(audioPlayer.click_buttonID);
                if (audioPlayer.mediaPlayer.isPlaying()){
                    audioPlayer.pauseMusic();
                    musicButton.setBackgroundResource(R.drawable.volume_off_settings);
                }else {
                    audioPlayer.startMusic(this,audioPlayer.main_themeID);
                    musicButton.setBackgroundResource(R.drawable.volume_on_settings);
                }
                break;
            default:
                break;
        }
    }

}