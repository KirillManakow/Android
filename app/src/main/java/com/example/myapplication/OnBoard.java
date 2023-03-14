package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OnBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
    }

    public void Entrance(View v) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void Register(View v) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}