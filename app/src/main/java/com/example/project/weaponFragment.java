package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class weaponFragment extends Fragment  implements View.OnClickListener {

    Button swordChoice;
    Button spearChoice;
    Button crushingChoice;
    Button rifleChoice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment_view = inflater.inflate(R.layout.fragment_weapon, container, false);
        swordChoice = fragment_view.findViewById(R.id.swordChoiceButton);
        swordChoice.setOnClickListener(this);
        spearChoice = fragment_view.findViewById(R.id.spearChoiceButton);
        spearChoice.setOnClickListener(this);

        return fragment_view;
    }

    @Override
    public void onClick(View fragment_view) {
        Intent fragment_intent = new Intent(getActivity(), FightActivity.class);
        switch (fragment_view.getId()){
            case R.id.swordChoiceButton:
                fragment_intent.putExtra("weapon_choice", "sword");

                break;
            case R.id.spearChoiceButton:
                fragment_intent.putExtra("weapon_choice", "spear");
                break;
            default:
                break;
        }
    }

}
