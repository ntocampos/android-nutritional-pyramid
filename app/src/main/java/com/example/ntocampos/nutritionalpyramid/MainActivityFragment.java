package com.example.ntocampos.nutritionalpyramid;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button calculateButton = (Button) view.findViewById(R.id.calculateButton);
        final EditText weightEdit = (EditText) view.findViewById(R.id.weightEditText);
        final EditText carbsEdit = (EditText) view.findViewById(R.id.carbsEditText);
        final EditText proteinEdit = (EditText) view.findViewById(R.id.proteinEditText);
        final EditText fatEdit = (EditText) view.findViewById(R.id.fatEditText);

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

                    Toast.makeText(getActivity().getApplicationContext(), "Calculating..",
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getActivity().getApplicationContext(),
                            ResultsActivity.class);
                    intent.putExtra(MainActivity.EXTRA_WEIGHT, weight);
                    intent.putExtra(MainActivity.EXTRA_CARBS, carbsPercent);
                    intent.putExtra(MainActivity.EXTRA_PROTEIN, proteinPercent);
                    intent.putExtra(MainActivity.EXTRA_FAT, fatPercent);
                    startActivity(intent);
                }
                else {
                    Snackbar.make(view, "Please, fill all the inputs before proceed...",
                            Snackbar.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}
