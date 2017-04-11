package com.example.comicexchange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Console;

import BDD.DbHelper;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DbHelper myDBHelper = new DbHelper(this); // L'Activité est le Context qu'il faut donner
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
