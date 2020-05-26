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
    protected MediaPlayer mediaPlayer;
    private Thread handleThread;

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

    SFXPlayer() {

        AudioAttributes.Builder attributesBuilder = new AudioAttributes.Builder();
        attributesBuilder.setUsage(AudioAttributes.USAGE_GAME);
        attributesBuilder.setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION);
        AudioAttributes attributes = attributesBuilder.build();

        SoundPool.Builder soundpoolBuilder = new SoundPool.Builder();
        soundpoolBuilder.setAudioAttributes(attributes);
        soundpoolBuilder.setMaxStreams(20);

        soundPool = soundpoolBuilder.build();


    }

    void loadSounds(final Context context){
        Thread streamThread = new Thread(new Runnable() {
            @Override
            public void run() {
                armorID = soundPool.load(context,R.raw.armor,1);
                log.log(Level.INFO," загружен объект armorID");
                attack1ID = soundPool.load(context,R.raw.attack1,1);
                log.log(Level.INFO," загружен объект  attack1ID");
                attack2ID = soundPool.load(context,R.raw.attack2,1);
                log.log(Level.INFO," загружен объект attack2ID");
                attack3ID = soundPool.load(context,R.raw.attack3,1);
                log.log(Level.INFO," загружен объект attack3ID");
                click_buttonID = soundPool.load(context,R.raw.click_button,1);
                        log.log(Level.INFO," загружен объект  click_buttonID");
                //coinID = soundPool.load(context,R.raw.coin,1);
                goblin_attack1ID = soundPool.load(context,R.raw.goblin_attack1,1);
                        log.log(Level.INFO," загружен объект  goblin_attack1ID");
                goblin_attack2ID = soundPool.load(context,R.raw.goblin_attack2,1);
                        log.log(Level.INFO," загружен объект  goblin_attack2ID");
                goblin_death_rattle1ID = soundPool.load(context,R.raw.goblin_death_rattle1,1);
                        log.log(Level.INFO," загружен объект goblin_death_rattle1ID ");
                goblin_death_rattle2ID = soundPool.load(context,R.raw.goblin_death_rattle2,1);
                        log.log(Level.INFO," загружен объект  goblin_death_rattle2ID");
                goblin_hitID = soundPool.load(context,R.raw.goblin_hit,1);
                        log.log(Level.INFO,"  загружен goblin_hitID и все объекты");

            }
            //    });
                /*soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                    @Override
                    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {

                    }
                });*/

       //     }
       });
       streamThread.start();
       streamThread.interrupt();

    }

    void play(final int audioID) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                soundPool.play(audioID, 1, 1, 0, 0, 1f);
            }
        });
        thread.start();
        thread.interrupt();
        }

    void startMusic(final Context context, final int audioID){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
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
        });
      thread.start();
      handleThread = thread;
    }

    void pauseMusic(){
        if(mediaPlayer!=null)
            if(mediaPlayer.isPlaying())
                mediaPlayer.pause();
    }

    void stopMusic(){
        try{
            mediaPlayer.stop();
        }catch(IllegalStateException ignored){

        }
        if(mediaPlayer != null)
            mediaPlayer.release();
        log.log(Level.INFO, "Медиаплеер удален");
        if(handleThread!=null) handleThread.interrupt();
    }

}

