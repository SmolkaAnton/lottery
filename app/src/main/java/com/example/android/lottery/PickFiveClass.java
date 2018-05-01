package com.example.android.lottery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by android on 4/26/18.
 */

public class PickFiveClass extends AppCompatActivity {

    private EditText user1, user2, user3, user4, user5;
    private EditText gen1, gen2, gen3, gen4, gen5;
    private EditText money;
    int score;
    int int1, int2, int3, int4, int5;
    Random r;
    private Update update;
    private Handler handler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickfive_activity);

        user1 = findViewById(R.id.user1);
        user2 = findViewById(R.id.user2);
        user3 = findViewById(R.id.user3);
        user4 = findViewById(R.id.user4);
        user5 = findViewById(R.id.user5);

        gen1 = findViewById(R.id.gen1);
        gen2 = findViewById(R.id.gen2);
        gen3 = findViewById(R.id.gen3);
        gen4 = findViewById(R.id.gen4);
        gen5 = findViewById(R.id.gen5);

        money = findViewById(R.id.moneyET);

        score = 0;

        r = new Random();

        update = new Update();

        handler = new Handler();
    }

    public void generatePressed(View v) {
        handler.postDelayed(update, 200);
    }

    public void stopPressed(View v) {
        handler.removeCallbacks(update);
        showScore();
    }

    public void showScore() {

        //Get 1st user input
        String use1 = user1.getText().toString();
        int u1 = Integer.parseInt(use1);

        //Get 2nd user input
        String use2 = user2.getText().toString();
        int u2 = Integer.parseInt(use2);

        //Get 3rd user input
        String use3 = user3.getText().toString();
        int u3 = Integer.parseInt(use3);

        //Get 4th user input
        String use4 = user4.getText().toString();
        int u4 = Integer.parseInt(use4);

        //Get 5th user input
        String use5 = user5.getText().toString();
        int u5 = Integer.parseInt(use5);

        //Get 1st Gen input
        String generate1 = gen1.getText().toString();
        int g1 = Integer.parseInt(generate1);

        //Get 2nd Gen input
        String generate2 = gen2.getText().toString();
        int g2 = Integer.parseInt(generate2);

        //Get 3rd Gen input
        String generate3 = gen3.getText().toString();
        int g3 = Integer.parseInt(generate3);

        //Get 4th Gen input
        String generate4 = gen4.getText().toString();
        int g4 = Integer.parseInt(generate4);

        //Get 5th Gen input
        String generate5 = gen5.getText().toString();
        int g5 = Integer.parseInt(generate5);

        if((u1==g1) && (u2==g2) && (u3==g3) && (u4==g4) && (u5==g5)) {
            score += 1000;
            money.setText(score + "");
            Toast.makeText(this, "Grand Prize!", Toast.LENGTH_SHORT).show();
        }
        else {
            score += 0;
            money.setText(score + "");
            Toast.makeText(this, "You lose! Play Again!", Toast.LENGTH_SHORT).show();
        }
    }

    public void pickFiveRulesPressed(View V) {
        Intent i = new Intent(this,PickFiveRulesClass.class);
        startActivityForResult(i, 1);
    }

    private class Update implements Runnable {

        public void run() {
            int1 = r.nextInt(15) + 1;
            int2 = r.nextInt(15) + 1;
            int3 = r.nextInt(15) + 1;
            int4 = r.nextInt(15) + 1;
            int5 = r.nextInt(15) + 1;

            //Set First Generated Number
            gen1.setText(int1 + "");

            //Set Second Generated Number
            gen2.setText(int2 + "");

            //Set Third Generated Number
            gen3.setText(int3 + "");

            //Set Fourth Generated Number
            gen4.setText(int4 + "");

            //Set Fifth Generated Number
            gen5.setText(int5 + "");

            handler.postDelayed(update, 200);
        }
    }

}
