package com.example.adityaprakash.braintrainer;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button goButton;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button playAgain;
    ArrayList<Integer> answers = new ArrayList<>();
    int locationOfCorrectAnswer;
    TextView result;
    TextView score;
    TextView sum;
    TextView timer;
    ConstraintLayout gameLayout;
    int noOfQues =0 ;
    int scoreGot = 0;
    //choose answer
    public void chooseAnswer(View view){
        if(Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())){
            result.setText("Correct!");
            scoreGot++;
        }
        else{
            result.setText("Wrong:(");
        }
           noOfQues++;
        score.setText(Integer.toString(scoreGot)+"/"+Integer.toString(noOfQues));
        newQues();
    }

    public void start(View view){
        goButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.playAgain));


    }

    //creating new question
    public void newQues(){
        Random rand = new Random();
        int a = rand.nextInt(31);
        int b = rand.nextInt(31);


        sum.setText(Integer.toString(a)+" + "+Integer.toString(b));
        locationOfCorrectAnswer = rand.nextInt(4);
        answers.clear();
        for(int i=0;i<4;i++){

            if(i==locationOfCorrectAnswer){
                answers.add(a+b);
            }
            else{
                int wrongAnswer = rand.nextInt(61);
                while(wrongAnswer==a+b){
                    wrongAnswer = rand.nextInt(61);
                }
                answers.add(wrongAnswer);
            }


        }
        //setting the buttons text
        button2.setText(Integer.toString(answers.get(0)));
        button3.setText(Integer.toString(answers.get(1)));
        button4.setText(Integer.toString(answers.get(2)));
        button5.setText(Integer.toString(answers.get(3)));

    }

    public void playAgain(View view){
            scoreGot = 0;
            noOfQues =0;
        score.setText(Integer.toString(scoreGot)+"/"+Integer.toString(noOfQues));
        timer.setText("30s");
        newQues();
        playAgain.setVisibility(View.INVISIBLE);
        result.setText("");
        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                result.setText(" Done");
                playAgain.setVisibility(View.VISIBLE);
            }
        }.start();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         button2 = findViewById(R.id.button2);
         button3 = findViewById(R.id.button3);
         button4 = findViewById(R.id.button4);
         button5 = findViewById(R.id.button5);

        gameLayout = findViewById(R.id.gameLayout);
        sum = findViewById(R.id.sum);
        result = findViewById(R.id.result);
        score = findViewById(R.id.score);
        timer = findViewById(R.id.timer);
        playAgain = findViewById(R.id.playAgain);
        goButton = findViewById(R.id.goButton);
        goButton.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);






    }

}
