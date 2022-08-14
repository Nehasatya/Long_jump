package com.example.long_jump;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Records extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        lv=(ListView)findViewById(R.id.ListView);
        Athlete ath1 = getIntent().getParcelableExtra("ath1");

        List<String> aths = new ArrayList<String>();
        aths.add(ath1.chest_no);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,aths);
        lv.setAdapter(arrayAdapter);

    }
}