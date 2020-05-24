package com.example.project;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import static android.media.MediaPlayer.create;


class SFXPlayer implements Serializable {
    private SoundPool soundPool;
    private MediaPlayer mediaPlayer;

    //private Context context;
    /*int armorID,
    attack1ID,
    attack2ID,
    attack3ID,
    click_buttonID,
    coinID,
    goblin_attack1ID,
    goblin_attack2ID,
    goblin_death_rattle1ID,
    goblin_death_rattle2ID,
    goblin_hitID,
    main_themeID,
    open_chestID,
    open_inventoryID,
    weaponID;*/
    int armorID = R.raw.armor,
    attack1ID = R.raw.attack1,
    attack2ID =R.raw.attack2,
    attack3ID=R.raw.attack3,
    click_buttonID = R.raw.click_button,
    coinID = R.raw.coin,
    goblin_attack1ID = R.raw.goblin_attack1,
    goblin_attack2ID = R.raw.goblin_attack2,
    goblin_death_rattle1ID = R.raw.goblin_death_rattle1,
    goblin_death_rattle2ID = R.raw.goblin_death_rattle2,
    goblin_hitID = R.raw.goblin_hit,
    main_themeID = R.raw.main_theme,
    open_chestID = R.raw.open_chest,
    open_inventoryID = R.raw.open_inventory,
    weaponID = R.raw.weapon,
    forest_themeID = R.raw.forest_theme;

    private static Logger log = Logger.getLogger("SfxPlayer");

    SFXPlayer(/*final Context context*/) {
        //this.context = context;
        AudioAttributes.Builder attributesBuilder = new AudioAttributes.Builder();
        attributesBuilder.setUsage(AudioAttributes.USAGE_GAME);
        attributesBuilder.setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION);
        AudioAttributes attributes = attributesBuilder.build();

        SoundPool.Builder soundpoolBuilder = new SoundPool.Builder();
        soundpoolBuilder.setAudioAttributes(attributes);
        soundpoolBuilder.setMaxStreams(20);

        soundPool = soundpoolBuilder.build();

        //this.mediaPlayer = new MediaPlayer();
        /*streamThread = new Thread(new Runnable() {
            @Override
            public void run() {

            armorID = soundPool.load(context,R.raw.armor,1);
            attack1ID = soundPool.load(context,R.raw.attack1,1);
            attack2ID = soundPool.load(context,R.raw.attack2,1);
            attack3ID = soundPool.load(context,R.raw.attack3,1);
            click_buttonID = soundPool.load(context,R.raw.click_button,1);
            coinID = soundPool.load(context,R.raw.coin,1);
            goblin_attack1ID = soundPool.load(context,R.raw.goblin_attack1,1);
            goblin_attack2ID = soundPool.load(context,R.raw.goblin_attack2,1);
            goblin_death_rattle1ID = soundPool.load(context,R.raw.goblin_death_rattle1,1);
            goblin_death_rattle2ID = soundPool.load(context,R.raw.goblin_death_rattle2,1);
            goblin_hitID = soundPool.load(context,R.raw.goblin_hit,1);
        //main_themeID = soundPool.load(context,R.raw.main_theme,1);
            open_chestID = soundPool.load(context,R.raw.open_chest,1);
            open_inventoryID = soundPool.load(context,R.raw.open_inventory,1);
            weaponID = soundPool.load(context,R.raw.weapon,1);

            }
        });
        streamThread.start();
        /*armorID = soundPool.load(context,R.raw.armor,1);
        attack1ID = soundPool.load(context,R.raw.attack1,1);
        attack2ID = soundPool.load(context,R.raw.attack2,1);
        attack3ID = soundPool.load(context,R.raw.attack3,1);
        click_buttonID = soundPool.load(context,R.raw.click_button,1);
        coinID = soundPool.load(context,R.raw.coin,1);
        goblin_attack1ID = soundPool.load(context,R.raw.goblin_attack1,1);
        goblin_attack2ID = soundPool.load(context,R.raw.goblin_attack2,1);
        goblin_death_rattle1ID = soundPool.load(context,R.raw.goblin_death_rattle1,1);
        goblin_death_rattle2ID = soundPool.load(context,R.raw.goblin_death_rattle2,1);
        goblin_hitID = soundPool.load(context,R.raw.goblin_hit,1);
        //main_themeID = soundPool.load(context,R.raw.main_theme,1);
        open_chestID = soundPool.load(context,R.raw.open_chest,1);
        open_inventoryID = soundPool.load(context,R.raw.open_inventory,1);
        weaponID = soundPool.load(context,R.raw.weapon,1);*/

    }
    void setContext(Context context){
        //this.context = context;
    }
    void loadSounds(final Context context){
     //   Thread streamThread = new Thread(new Runnable() {
       //     @Override
          //  public void run() {
             //   soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
             //       @Override
              //      public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {



                armorID = soundPool.load(context,R.raw.armor,1);
                log.log(Level.INFO," загружен объект");
                attack1ID = soundPool.load(context,R.raw.attack1,1);
                log.log(Level.INFO," загружен объект");
                attack2ID = soundPool.load(context,R.raw.attack2,1);
                log.log(Level.INFO," загружен объект");
                attack3ID = soundPool.load(context,R.raw.attack3,1);
                log.log(Level.INFO," загружен объект");
                click_buttonID = soundPool.load(context,R.raw.click_button,1);
                        log.log(Level.INFO," загружен объект");
                //coinID = soundPool.load(context,R.raw.coin,1);
                goblin_attack1ID = soundPool.load(context,R.raw.goblin_attack1,1);
                        log.log(Level.INFO," загружен объект");
                goblin_attack2ID = soundPool.load(context,R.raw.goblin_attack2,1);
                        log.log(Level.INFO," загружен объект");
                goblin_death_rattle1ID = soundPool.load(context,R.raw.goblin_death_rattle1,1);
                        log.log(Level.INFO," загружен объект");
                goblin_death_rattle2ID = soundPool.load(context,R.raw.goblin_death_rattle2,1);
                        log.log(Level.INFO," загружен объект");
                goblin_hitID = soundPool.load(context,R.raw.goblin_hit,1);
                        log.log(Level.INFO," загружены все объекты");

                //main_themeID = soundPool.load(context,R.raw.main_theme,1);
                //open_chestID = soundPool.load(context,R.raw.open_chest,1);
                //open_inventoryID = soundPool.load(context,R.raw.open_inventory,1);
                //weaponID = soundPool.load(context,R.raw.weapon,1);
                  //  }
            //    });
                /*soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                    @Override
                    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                        soundPool.play(audio,1, 1, 1, 0, 1f);
                    }
                });*/

       //     }
      //  });
       // streamThread.start();

    }

    void play(int audioID) {
        soundPool.play(audioID,1,1,0,0,1f);
    }

    void startMusic(Context context, int audioID){
       if (mediaPlayer == null) {
           mediaPlayer = MediaPlayer.create(context, audioID);
            log.log(Level.INFO, "Создан медиаплеер");
       }else {
           mediaPlayer.release();
           mediaPlayer = MediaPlayer.create(context, audioID);
           log.log(Level.INFO, "Создан медиаплеер после удаления");
       }
       mediaPlayer.setLooping(true);
        mediaPlayer.start();
        log.log(Level.INFO,"Стартует музыка");
    }

    void stopMusic(){
        mediaPlayer.stop();
        mediaPlayer.release();
        log.log(Level.INFO, "Медиаплеер удален");
    }

}

