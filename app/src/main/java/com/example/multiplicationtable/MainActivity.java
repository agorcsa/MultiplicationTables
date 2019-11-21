package com.example.multiplicationtable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private ArrayList<Integer> numbers;

    private ArrayAdapter arrayAdapter;

    private SeekBar seekBar;
    private int min = 1;
    private int max = 20;
    private int progress = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        seekBar = findViewById(R.id.seek_bar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seekBar.setMin(min);
        }
        seekBar.setMax(max);
        seekBar.setProgress(progress);

        // applies only when the seekbar is changing its value
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    Log.i("Seek bar is at ", String.valueOf(progress));

                    generateMultiplyTables(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // initialises
        generateMultiplyTables(progress);
    }

    private void generateMultiplyTables(int multiplier) {
        // initialize the array list with capacity of 20
        numbers = new ArrayList<>(20);

        // populates the array list
        for (int i = 1; i <= 10; i++) {
            numbers.add(i * multiplier);
        }

        // creates an adapter for the array list
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, numbers);

        // sets the adapter to the list view
        listView.setAdapter(arrayAdapter);
    }
}
