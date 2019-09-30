package com.khoa.project1_splitthebill;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;


public class InputAmountPeople extends AppCompatActivity {

    private int NumberOfPeople;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_amount_people);
        methodNumberPicker();


    }



    public void NextButtonClicked(View v){
        NumberPicker numberPicker = findViewById(R.id.numberPicker);
        NumberOfPeople = (int)numberPicker.getValue();
        // Data from Intent object created in first layout is not permanent
        // So we're using this way to save data

        // Create object to get data using Intent
        Bundle extra = getIntent().getExtras();

        // Create new Intent object for next layout
        Intent i = new Intent(InputAmountPeople.this, InputAmountTip.class );

        // Get data from Intent
        String numBillAmountString = extra.getString("amount_of_money");



        // Save data to Intent
        i.putExtra("amount_of_money",numBillAmountString);
        i.putExtra("amount_of_people",Integer.toString(NumberOfPeople));

        startActivity(i);

    }

    // Number Picker
    private void methodNumberPicker(){
        NumberPicker numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMaxValue(100);
        numberPicker.setMinValue(1);
    }

}
