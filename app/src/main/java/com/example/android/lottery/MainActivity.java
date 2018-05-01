package com.example.android.lottery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void powerballPressed(View v) {
        Intent i = new Intent(this,PowerballClass.class);
        startActivityForResult(i, 1);
    }

    public void pickFivePressed(View v) {
        Intent i = new Intent(this,PickFiveClass.class);
        startActivityForResult(i, 1);
    }

    public void megaMillionsPressed(View v) {
        Intent i = new Intent(this,MegaMillionsClass.class);
        startActivityForResult(i, 1);
    }
}
