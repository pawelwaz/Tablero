package com.example.pawel.tablero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void openMenu(View view) {
        Intent intent = new Intent(this, MainMenu.class);
        this.startActivity(intent);
    }
}
