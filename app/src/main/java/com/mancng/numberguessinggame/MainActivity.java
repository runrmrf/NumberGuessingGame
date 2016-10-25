package com.mancng.numberguessinggame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    EditText myGuessIs;
    int myNumber;
    String message;



    public void btnSubmit(final View view) {


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


    public void selectText(final View view) {
        myGuessIs.requestFocus();
        myGuessIs.setText("");

        myGuessIs.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override

            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                try {

                    if (actionId == EditorInfo.IME_ACTION_DONE) {

                        btnSubmit(view);
                    }

                    return false;
                }

                catch (Exception e) {

                        Toast.makeText(getApplicationContext(),"Please enter a number",Toast.LENGTH_SHORT).show();

                        return false;
                }

            }

        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random randomGenerator = new Random();
        randomNumber = randomGenerator.nextInt(5);
        Log.i("Random Number", "Random Number is " + randomNumber);
        myGuessIs = (EditText) findViewById(R.id.myGuess);

    }

}
