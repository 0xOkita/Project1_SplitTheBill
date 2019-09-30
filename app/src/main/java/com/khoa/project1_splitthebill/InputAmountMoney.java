package com.khoa.project1_splitthebill;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;


public class InputAmountMoney extends AppCompatActivity {
    private EditText AmountOfMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_amount_money);
        EditText editText = (EditText ) findViewById(R.id.editText_InputAmount);

        // Set automatically keypad function on edittext box when layout is shown
        editText.requestFocus();

        // Hide Number Keypad because we're using custom keyboard
        InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
        editText.setShowSoftInputOnFocus(false); // Hide built-in keyboard
    }

    public void NextButtonClicked(View v){
        AmountOfMoney = findViewById(R.id.editText_InputAmount);
        String StringAmountOfMoney = AmountOfMoney.getText().toString();

        // Save data using Intent
        Intent i = new Intent(InputAmountMoney.this, InputAmountPeople.class );
        i.putExtra("amount_of_money",(String)AmountOfMoney.getText().toString());


        // Check if input is empty or not
        // Prevent app crashing
        if(StringAmountOfMoney.isEmpty()){
            Toast.makeText(getApplicationContext(),"Money should not be empty",Toast.LENGTH_SHORT).show();
        }else{startActivity(i);}
    }

    // Custom Number Keypad using View to get Data
    public void onClick(View v) {
        Button b = (Button)v;
        AmountOfMoney = findViewById(R.id.editText_InputAmount);
        String buttonText = b.getText().toString();

        // Delete button function
        // Removing each word from String
        if(buttonText.equals("del")){
            String StringAmountOfMoney = AmountOfMoney.getText().toString();

            int charCount = StringAmountOfMoney.length();
            if (charCount > 0) {
                AmountOfMoney.getText().delete(charCount - 1, charCount);
            }
        }else {
            // After getting data from each key, add data to EditText
            AmountOfMoney.append(buttonText);
        }

    }






}
