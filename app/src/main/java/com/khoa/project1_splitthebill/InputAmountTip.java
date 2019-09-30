package com.khoa.project1_splitthebill;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.RadioGroup;
import android.os.Bundle;

public class InputAmountTip extends AppCompatActivity {
    private RadioGroup rgQualityOfService;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_amount_tip);
        rgQualityOfService = findViewById(R.id.radioGroup);

    }
    public void NextButtonClicked(View v){
        // Data from Intent object created in first layout is not permanent
        // So we're using this way to save data

        Bundle extra = getIntent().getExtras();
        Intent i = new Intent(InputAmountTip.this, ExtractFinalBill.class );
        int checkedId = rgQualityOfService.getCheckedRadioButtonId();
        // Get Data using Intent
        String numBillAmountString = extra.getString("amount_of_money");
        String numPeopleAmountString = extra.getString("amount_of_people");
        // Save data using Intent
        i.putExtra("amount_of_money",numBillAmountString);
        i.putExtra("amount_of_people",numPeopleAmountString);
        i.putExtra("check_id",Integer.toString(checkedId));
        //Toast.makeText(getApplicationContext(),Integer.toString(checkedId),Toast.LENGTH_SHORT).show();
        startActivity(i);

    }

    // Simple function to play sound with parameter
    public void playSoundFile(Integer fileName){
        mediaPlayer = MediaPlayer.create(this, fileName);
        mediaPlayer.start();
    }
    public void poorSound(View v){playSoundFile(R.raw.poor); }
    public void good(View v){playSoundFile(R.raw.godlike); }
    public void excellent(View v){playSoundFile(R.raw.excellent); }
}
