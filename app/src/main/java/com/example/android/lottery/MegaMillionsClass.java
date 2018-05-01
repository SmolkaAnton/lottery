package com.example.android.lottery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by android on 5/1/18.
 */

public class MegaMillionsClass extends AppCompatActivity {

    private EditText user1, user2, user3, user4, user5, userMM;
    private EditText gen1, gen2, gen3, gen4, gen5, genMM;
    private EditText money;
    int score;
    int int1, int2, int3, int4, int5, intMM;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.megamillions_activity);

        user1 = findViewById(R.id.user1);
        user2 = findViewById(R.id.user2);
        user3 = findViewById(R.id.user3);
        user4 = findViewById(R.id.user4);
        user5 = findViewById(R.id.user5);
        userMM = findViewById(R.id.userMM);

        gen1 = findViewById(R.id.gen1);
        gen2 = findViewById(R.id.gen2);
        gen3 = findViewById(R.id.gen3);
        gen4 = findViewById(R.id.gen4);
        gen5 = findViewById(R.id.gen5);
        genMM = findViewById(R.id.genMM);

        money = findViewById(R.id.moneyET);

        score = 0;

        r = new Random();
    }

    public void generated() {
        int1 = r.nextInt(25) + 1;
        int2 = r.nextInt(25) + 1;
        int3 = r.nextInt(25) + 1;
        int4 = r.nextInt(25) + 1;
        int5 = r.nextInt(25) + 1;
        intMM = r.nextInt(50) + 1;

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

        //Set MegaMillions Number
        genMM.setText(intMM + "");
    }

    public void showScore() {

        int matches = 0;

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
        String power = userMM.getText().toString();
        int mm = Integer.parseInt(power);

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
        String generatePB = genMM.getText().toString();
        int gMM = Integer.parseInt(generatePB);

        if(u1==g1) {
            matches ++;
        }
        else if(u2==g2) {
            matches ++;
        }
        else if(u3==g3) {
            matches++;
        }
        else if(u4==g4) {
            matches++;
        }
        else if(u5==g5) {
            matches++;
        }

        if(matches==5 && (mm==gMM)) {
            score+=1000000;
            money.setText(score + "");
            Toast.makeText(this, "5 Matches and the Mega Million!", Toast.LENGTH_SHORT).show();
        }
        else if(matches==5) {
            score+=500000;
            money.setText(score + "");
            Toast.makeText(this, "5 matches!", Toast.LENGTH_SHORT).show();
        }
        else if(matches==4 && (mm==gMM)) {
           score+=10000;
            money.setText(score + "");
            Toast.makeText(this, "4 Matches and the Mega Million!", Toast.LENGTH_SHORT).show();
        }
        else if(matches==4) {
            score+=500;
            money.setText(score + "");
            Toast.makeText(this, "4 Matches!", Toast.LENGTH_SHORT).show();
        }
        else if(matches==3 && (mm==gMM)) {
            score += 200;
            money.setText(score + "");
            Toast.makeText(this, "3 Matches and the Mega Million!", Toast.LENGTH_SHORT).show();
        }
        else if(matches==3) {
            score +=10;
            money.setText(score + "");
            Toast.makeText(this, "3 Matches!", Toast.LENGTH_SHORT).show();
        }
        else if(matches==2 && (mm==gMM)) {
            score +=10;
            money.setText(score + "");
            Toast.makeText(this, "2 Matches and the Mega Million!", Toast.LENGTH_SHORT).show();
        }
        else if(matches==1 && (mm==gMM)) {
            score +=4;
            money.setText(score + "");
            Toast.makeText(this, "1 Match and the Mega Million!", Toast.LENGTH_SHORT).show();
        }
        else if(mm==gMM) {
            score +=2;
            money.setText(score + "");
            Toast.makeText(this, "Mega Million!", Toast.LENGTH_SHORT).show();
        }
        else {
            score += 0;
            money.setText(score + "");
            Toast.makeText(this, "You lose!", Toast.LENGTH_SHORT).show();
        }
    }

    public void genButtonPressed(View v) {
        generated();
        showScore();
    }


}
