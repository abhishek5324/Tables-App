package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity

{
    ListView listtable;
    public void generate(int timetable)
    {
        ArrayList<String> tl = new ArrayList<>();
        {
            for(int i=1;i<=20;i++)
            {
                tl.add(Integer.toString(timetable)+ " * "+Integer.toString(i)+" = " + Integer.toString(i*timetable));
            }
        }
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,tl);
        listtable.setAdapter(ad);

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final SeekBar seek = findViewById(R.id.SeekTable);
         listtable = findViewById(R.id.ListTable);
        seek.setMax(20);
        seek.setProgress(10);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min =1;
                int timetable ;
                if(i<min)
                {
                    timetable = min;
                    seek.setProgress(min);
                }
                else
                {
                    timetable = i;
                }
                generate((timetable));

            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generate(10);


    }
}