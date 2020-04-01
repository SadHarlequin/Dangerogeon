package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class VendorActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);
        Button backToMenuButton = (Button) findViewById(R.id.BackButtonVendorMenu);
        backToMenuButton.setOnClickListener(this);
        }
    @Override
    public void onClick(View vendorView) {
        switch (vendorView.getId()) {
            case R.id.BackButtonVendorMenu:
                Intent intentVendor = new Intent(this, MainActivity.class);
                startActivity(intentVendor);
                break;
            default:
                break;
        }
    }

}
