package com.example.bcs421homework4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseDrinkActivity extends AppCompatActivity {

    private RadioGroup mDrinksRadioGroup;
    private Button mSaveDrinkButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_drink);

        mDrinksRadioGroup = findViewById(R.id.CDRadioGroup);
        mSaveDrinkButton = findViewById(R.id.CDButtonSaveDrink);

        mSaveDrinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = mDrinksRadioGroup.getCheckedRadioButtonId();
                String drink = "";
                switch (selectedId){
                    case R.id.CDRadioButtonSoda:
                        drink = "Soda";
                        break;
                    case R.id.CDRadioButtonWater:
                        drink = "Water";
                        break;
                }

                Intent result = new Intent();

                result.putExtra("drink", drink);
                setResult(RESULT_OK, result);
//                setResult(ChooseDrinkActivity.RESULT_OK, result);

                finish();
            }
        });


    }
}
