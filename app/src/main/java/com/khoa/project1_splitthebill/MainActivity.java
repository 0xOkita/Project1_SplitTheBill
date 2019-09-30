package com.khoa.project1_splitthebill;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.app.assist.AssistStructure;
import android.os.Build;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tomer.fadingtextview.FadingTextView;

public class MainActivity extends AppCompatActivity {

    FadingTextView fadingTextView;

    private int fadingTextViewTimeOut = 2500;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_animation);
        fadingTextView = (FadingTextView) (findViewById(R.id.fadingAnimation));
        fadingTextView.setTimeout(fadingTextViewTimeOut);

    }

    public void run(View view) {
        //Do any action here. Now we are moving to next page
        Intent mySuperIntent = new Intent(MainActivity.this, InputAmountMoney.class);
        startActivity(mySuperIntent);
        /* This 'finish()' is for exiting the app when back button pressed
         *  from Home page which is ActivityHome
         */
        finish();
    }


}
