package com.example.android.lottery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by android on 4/19/18.
 */

public class PowerballClass extends AppCompatActivity {

    private EditText user1, user2, user3, user4, user5, userPB;
    private EditText gen1, gen2, gen3, gen4, gen5, genPB;
    private EditText money;
    int score;
    int int1, int2, int3, int4, int5, intPB;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.powerball_activity);

        user1 = findViewById(R.id.user1);
        user2 = findViewById(R.id.user2);
        user3 = findViewById(R.id.user3);
        user4 = findViewById(R.id.user4);
        user5 = findViewById(R.id.user5);
        userPB = findViewById(R.id.userPB);

        gen1 = findViewById(R.id.gen1);
        gen2 = findViewById(R.id.gen2);
        gen3 = findViewById(R.id.gen3);
        gen4 = findViewById(R.id.gen4);
        gen5 = findViewById(R.id.gen5);
        genPB = findViewById(R.id.genPB);

        money = findViewById(R.id.moneyET);

        score = 0;

        r = new Random();
    }

    public void genButtonPressed(View v) {
        generated();
        showScore();
    }

    public void rulesButtonPressed(View v) {
        Intent i = new Intent(this,PowerBallRulesClass.class);
        startActivityForResult(i, 1);
    }

    public void generated() {
        int1 = r.nextInt(30) + 1;
        int2 = r.nextInt(30) + 1;
        int3 = r.nextInt(30) + 1;
        int4 = r.nextInt(30) + 1;
        int5 = r.nextInt(30) + 1;
        intPB = r.nextInt(30) + 1;

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

        //Set Powerball Number
        genPB.setText(intPB + "");
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

        //Get Powerball input
        String power = userPB.getText().toString();
        int pb = Integer.parseInt(power);

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

        //Get PBGen input
        String generatePB = genPB.getText().toString();
        int gPB = Integer.parseInt(generatePB);

        //Grandprize! - Every number and the powerball
        if((u1==g1) && (u2==g2) && (u3==g3) && (u4==g4) && (u5==g5) && (pb==gPB)) {
            score += 1000;
            money.setText(score + "");
            Toast.makeText(this, "Grand Prize!", Toast.LENGTH_SHORT).show();
        }

        //Second prize - Every number but the powerball
        else if ((u1==g1) && (u2==g2) && (u3==g3) && (u4==g4) && (u5==g5)) {
            score+=500;
            money.setText(score +"");
            Toast.makeText(this, "You rock!", Toast.LENGTH_SHORT).show();
        }

        //Third prize - You get only the powerball
        else if(pb==gPB) {
            score+=100;
            money.setText(score+ "");
            Toast.makeText(this, "Nice!", Toast.LENGTH_SHORT).show();
        }

        //4th prize - you get one number correct and the powerball
       else if(((u1==g1) || (u2==g2) || (u3==g3) || (u4==g4) ||(u5==g5)) && (pb==gPB)) {
            score +=50;
            money.setText(score+ "");
            Toast.makeText(this, "Good Job!", Toast.LENGTH_SHORT).show();
        }

        //5th prize - Get one number right
        else if((u1==g1) || (u2==g2) || (u3==g3) || (u4==g4) ||(u5==g5)) {
            score +=5;
            money.setText(score + "");
            Toast.makeText(this, "Thumbs up!", Toast.LENGTH_SHORT).show();
        }

        //You lose!
        else {
            score+=0;
            money.setText(score +"");
            Toast.makeText(this, "You lose! Play Again!", Toast.LENGTH_SHORT).show();
        }

    }
}
