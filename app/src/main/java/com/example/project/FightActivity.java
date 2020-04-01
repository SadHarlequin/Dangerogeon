package com.example.project;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class FightActivity extends AppCompatActivity {
    final int FIRST_ATTACK = 1;
    final int SECOND_ATTACK = 2;
     int CHOSEN_ATTACK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight_area);
//        Button attackChoiceButton = (Button)findViewById(R.id.attackChoiceButton);
//        registerForContextMenu(attackChoiceButton); // контекстное меню по кнопке attackChoiceButton
    }
//
//    @Override//создание контекстного меню
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        switch (v.getId()){
//            case R.id.attackChoiceButton:
//                menu.add(0, FIRST_ATTACK,0,"Сильный удар");
//                menu.add(0, SECOND_ATTACK,0,"Быстрый удар");
//                break;
//        }
//    }
//    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case FIRST_ATTACK:
//                CHOSEN_ATTACK = FIRST_ATTACK;
//                break;
//            case SECOND_ATTACK:
//                CHOSEN_ATTACK = SECOND_ATTACK;
//                break;
//        }
//        return super.onContextItemSelected(item);
//    }
}
