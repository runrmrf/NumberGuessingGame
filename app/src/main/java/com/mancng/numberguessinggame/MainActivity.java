package com.mancng.numberguessinggame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    EditText myGuessIs;
    int myNumber;
    String message;



    public void btnSubmit(View view) {

        myGuessIs = (EditText) findViewById(R.id.myGuess);
        myNumber = Integer.parseInt(myGuessIs.getText().toString());
        message = "";


        if (myNumber == randomNumber) {
            myGuessIs.setText("");
            message = "You're Correct!! Play again!";
        } else if (myNumber >= 6) {
            message = "Only enter number 1-5";
        } else {
            message = "Try again!";
        }
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random randomGenerator = new Random();
        randomNumber = randomGenerator.nextInt(5);
        Log.i("Random Number", "Random Number is " + randomNumber);


    }




}
