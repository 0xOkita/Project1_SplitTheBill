package com.khoa.project1_splitthebill;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ExtractFinalBill extends AppCompatActivity {
    private TextView TipTextView;
    private TextView TotalTextView;
    private TextView AmountMoneyTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extract_final_bill);
        AmountMoneyTextView = findViewById(R.id.textView_Amount_Per_Person_result);
        TipTextView = findViewById(R.id.textView_Tip_result);
        TotalTextView = findViewById(R.id.textView_Total_result);
        Calculate();
    }

    public void Calculate(){
        // Create Bundle to get data with Intent
        Bundle extra = getIntent().getExtras();


        //
        int numPeople,IntcheckedId;
        double NumBillAmount;

        // Get Data from Bundle by using Intent
        String numBillAmountString = extra.getString("amount_of_money");
        String numPeopleString = extra.getString("amount_of_people");
        String checkedId = extra.getString("check_id");;

        // Cast data from String to Double and Imteger
        NumBillAmount = Double.parseDouble(numBillAmountString);
        numPeople = Integer.parseInt(numPeopleString);
        IntcheckedId = Integer.parseInt(checkedId);


        //Get option radio button
        BillCalculator.TypeQualityOfService type = BillCalculator.TypeQualityOfService.EXCELLENT;
        if(IntcheckedId == R.id.radio_buttAverage){
            type = BillCalculator.TypeQualityOfService.AVERAGE;
        }else if(IntcheckedId == R.id.radio_buttPoor){
            type = BillCalculator.TypeQualityOfService.POOR;
        }

        // Create object and calculate bill
        BillCalculator newBillCalculate = new BillCalculator(NumBillAmount,numPeople,type);
        double tip = newBillCalculate.TipCalculate();
        double billEachPerson = newBillCalculate.BillEachPerson();
        double total = tip + billEachPerson;

        // Show output by setting TextView
        AmountMoneyTextView.setText("$"+billEachPerson);
        TipTextView.setText("$"+tip);
        TotalTextView.setText("$"+total);


    }

}
