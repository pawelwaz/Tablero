package com.example.pawel.tablero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void selectMenuItem(View view) {
        Intent intent = new Intent(this, UnitConverter.class);
        this.startActivity(intent);
    }

}
