package com.example.ntocampos.nutritionalpyramid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_WEIGHT = "com.example.ntocampos.weight";
    public final static String EXTRA_CARBS = "com.example.ntocampos.carbs";
    public final static String EXTRA_PROTEIN = "com.example.ntocampos.protein";
    public final static String EXTRA_FAT = "com.example.ntocampos.fat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button calculateButton = (Button) findViewById(R.id.calculateButton);
        final EditText weightEdit = (EditText) findViewById(R.id.weightEditText);
        final EditText carbsEdit = (EditText) findViewById(R.id.carbsEditText);
        final EditText proteinEdit = (EditText) findViewById(R.id.proteinEditText);
        final EditText fatEdit = (EditText) findViewById(R.id.fatEditText);

        if (calculateButton == null) throw new AssertionError();
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean error = false;

                String weightString = weightEdit.getText().toString();
                String carbsPercentString = carbsEdit.getText().toString();
                String proteinPercentString = proteinEdit.getText().toString();
                String fatPercentString = fatEdit.getText().toString();

                float weight, carbsPercent, proteinPercent, fatPercent;

                if (weightString.isEmpty() || carbsPercentString.isEmpty() ||
                        proteinPercentString.isEmpty() || fatPercentString.isEmpty()) {
                    error = true;
                }

                if (!error) {
                    weight = Float.valueOf(weightString);
                    carbsPercent = Float.valueOf(carbsPercentString);
                    proteinPercent = Float.valueOf(proteinPercentString);
                    fatPercent = Float.valueOf(fatPercentString);

                    Toast.makeText(getApplicationContext(), "Calculating...", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                    intent.putExtra(EXTRA_WEIGHT, weight);
                    intent.putExtra(EXTRA_CARBS, carbsPercent);
                    intent.putExtra(EXTRA_PROTEIN, proteinPercent);
                    intent.putExtra(EXTRA_FAT, fatPercent);
                    startActivity(intent);
                }
                else {
                    Snackbar.make(view, "Please, fill all the inputs before proceed...",
                            Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
