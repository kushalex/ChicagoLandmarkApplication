package com.example.mp3_a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivityA2 extends AppCompatActivity {

    // display pictures as specified using HorizontalScrollView
    // activity_main.xml
    // intent filter to launch mp3_A2 from mp3_A1 in Manifest

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}