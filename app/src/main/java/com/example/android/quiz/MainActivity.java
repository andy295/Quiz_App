package com.example.android.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * This app calculate the user's score.
 */
public class MainActivity extends AppCompatActivity {
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Evaluate which RadioButton is checked
     *
     * @param id         is the identifier of the RadioGroup element
     * @return the identifier of the selected RadioButton
     */
    private int evalueateRadioButton(int id) {
        RadioGroup radioGroup = (RadioGroup) findViewById(id);

        RadioButton rb = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());

        return radioGroup.indexOfChild(rb);
    }

    /**
     * Evaluate which checkbox is checked
     *
     * @param id         is the identifier of the checkbox element
     * @return a string with 1 if checkbox is checked, 0 otherwise
     */
    private String evalueateCheckBox(int id) {
        CheckBox answerCheckBox = (CheckBox) findViewById(id);
        if(answerCheckBox.isChecked())
            return "1";
        else
            return "0";
    }

    /**
     * This method check the answers and print the score on the screen
     */
    public void submitQuiz(View view) {
        EditText valueEditText = (EditText) findViewById(R.id.name_edittext);
        String value = valueEditText.getText().toString();

        if (value.trim().equals("")) {
            Toast.makeText(this, "Name field is empty, please insert your name", Toast.LENGTH_SHORT).show();
        } else {
            //answer question one
            if(evalueateRadioButton(R.id.radioGroupA)== 3)
                score += 3;

            //answer question two
            valueEditText = (EditText) findViewById(R.id.year_edittext);
            value = valueEditText.getText().toString();

            if(Integer.parseInt(value) == 1949)
                score += 3;

            //answer question three
            value = "";
            value = value + evalueateCheckBox(R.id.checkbox_A);
            value = value + evalueateCheckBox(R.id.checkbox_B);
            value = value + evalueateCheckBox(R.id.checkbox_C);
            value = value + evalueateCheckBox(R.id.checkbox_D);

            if(Integer.parseInt(value) == 0101)
                score += 3;

            //answer question four
            if(evalueateRadioButton(R.id.radioGroupB)== 0)
                score += 3;

            //answer question five
            if(evalueateRadioButton(R.id.radioGroupC)== 0)
                score += 3;

            //print the score on display
            if(score >= 12)
                Toast.makeText(this, "Very good, your score is: " + String.valueOf(score), Toast.LENGTH_SHORT).show();
            else
            if(score >= 8)
                Toast.makeText(this, "Not bad, your score is: " + String.valueOf(score), Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Your score is: " + String.valueOf(score) + ", please retry", Toast.LENGTH_SHORT).show();

            //reset score
            score = 0;
        }
    }
}