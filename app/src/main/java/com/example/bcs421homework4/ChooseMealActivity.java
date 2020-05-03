package com.example.bcs421homework4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChooseMealActivity extends AppCompatActivity {

    private List<Meal> meals = new ArrayList<>();
    private RecyclerView recyclerView;
    private MealAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_meal);

        recyclerView = (RecyclerView) findViewById(R.id.CMRecyclerView);
        mAdapter = new MealAdapter(meals);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        meals.add(new Meal("Chicken", "Sweet Potatoes"));  // Add some data
        meals.add(new Meal("Eggplant", "Spaghetti"));  // Add some data
        meals.add(new Meal("Steak", "Broccoli"));  // Add some data
        mAdapter.notifyDataSetChanged();

        mAdapter.setOnItemClickListener(new MealAdapter.MealAdapterListener() {
            @Override
            public void onItemClick(int position) {
                Meal selected = meals.get(position);
                String main = selected.getMain();
                Intent result = new Intent();


                result.putExtra("meal", main);
                setResult(RESULT_OK, result);
//                setResult(ChooseMealActivity.RESULT_OK, result);
                finish();
            }
        });

    }
}
