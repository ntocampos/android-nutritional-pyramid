package com.example.ntocampos.nutritionalpyramid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        float weight = getIntent().getFloatExtra(MainActivity.EXTRA_WEIGHT, 0);
        float carbsPercent = getIntent().getFloatExtra(MainActivity.EXTRA_CARBS, 0);
        float proteinPercent = getIntent().getFloatExtra(MainActivity.EXTRA_PROTEIN, 0);
        float fatPercent = getIntent().getFloatExtra(MainActivity.EXTRA_FAT, 0);

        DecimalFormat df =  new DecimalFormat("#.##");

        float protein = weight * 2;
        float one_percent = protein / proteinPercent;
        float carbs = one_percent * carbsPercent;
        float fat = one_percent * fatPercent;

        TextView weightText = (TextView) findViewById(R.id.weightText);
        TextView carbsText = (TextView) findViewById(R.id.carbsText);
        TextView proteinText = (TextView) findViewById(R.id.proteinText);
        TextView fatText = (TextView) findViewById(R.id.fatText);

        weightText.setText(df.format(weight) + " Kg");
        carbsText.setText(df.format(carbs) + "g");
        proteinText.setText(df.format(protein) + "g");
        fatText.setText(df.format(fat) + " g");
    }
}
