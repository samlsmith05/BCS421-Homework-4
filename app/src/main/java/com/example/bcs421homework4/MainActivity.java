package com.example.bcs421homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button mChooseMealButton;
    private Button mChooseDrinkButton;
    private EditText mMealEditText;
    private EditText mDrinkEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChooseMealButton = findViewById(R.id.MButtonChooseMeal);
        mChooseDrinkButton = findViewById(R.id.MButtonChooseDrink);
        mDrinkEditText = findViewById(R.id.MEditTextDrink);
        mMealEditText = findViewById(R.id.MEditTextMeal);

        mChooseDrinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ChooseDrinkActivity.class);
                startActivityForResult(i, 1);
            }
        });

        mChooseMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ChooseMealActivity.class);
                startActivityForResult(i, 2);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data)
    {

        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String d = data.getStringExtra("drink");
                    mDrinkEditText.setText(d);
                }
                break;
            case 2:
                if (resultCode == ChooseMealActivity.RESULT_OK) {
                    String m = data.getStringExtra("meal");
                    mMealEditText.setText(m);
                }
                break;

        }
    }
}
