package com.khoa.project1_splitthebill;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculateHomeActivity extends AppCompatActivity {
    private EditText numBillAmountEditText;
    private EditText numPeopleEditText;
    private TextView numBillAmountTextView;
    private RadioGroup rgQualityOfService;
    private TextView TipTextView;
    private TextView TotalTextView;
    private TextView BillTextView;
    ProgressBar aprogressBar;
    TextView textView_progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_screen);
        numBillAmountEditText = findViewById(R.id.editText_bill_amount);
        numPeopleEditText = findViewById(R.id.editText_Number_of_people);
        TipTextView = findViewById(R.id.textView_Tip_result);
        rgQualityOfService = findViewById(R.id.radioQoS);
        BillTextView = findViewById(R.id.textView_Bill_result);
        TotalTextView = findViewById(R.id.textView_Total_result);
        //


    }

    public void Calculate(View view){
        // Get how much input money
        int numBillAmount, numPeople;
        try{
            String numBillAmountString = numBillAmountEditText.getText().toString();
            String numPeopleString = numPeopleEditText.getText().toString();
            numBillAmount = Integer.parseInt(numBillAmountString);
            numPeople = Integer.parseInt(numPeopleString);
        }
        catch(NumberFormatException ex){
            numBillAmount=0;
            numPeople=0;
        }

        //Get option radio button
        int checkedId = rgQualityOfService.getCheckedRadioButtonId();
        BillCalculator.TypeQualityOfService type = BillCalculator.TypeQualityOfService.EXCELLENT;
        if(checkedId == R.id.radio_Average){
            type = BillCalculator.TypeQualityOfService.AVERAGE;
        }else if(checkedId == R.id.radio_Poor){
            type = BillCalculator.TypeQualityOfService.POOR;
        }

        // show result
        BillCalculator newBillCalculate = new BillCalculator(numBillAmount,numPeople,type);
        double tip = newBillCalculate.TipCalculate();
        double billEachPerson = newBillCalculate.BillEachPerson();
        double total = tip + billEachPerson;
        BillTextView.setText("$"+billEachPerson);
        TipTextView.setText("$"+tip);
        TotalTextView.setText("$"+total);


    }




}
