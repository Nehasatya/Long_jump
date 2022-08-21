package com.example.long_jump;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Records extends AppCompatActivity {
    ListView lv;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);


        lv=(ListView)findViewById(R.id.ListView);

        db = new DBHandler(this);
        Cursor res = db.getData();
        if(res.getCount()==0)
        {
            Toast.makeText(Records.this,"No Entry Exists",Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext())
        {
            buffer.append("Name: "+res.getString(0)+"\n");
            buffer.append("Chest No: "+res.getString(1)+"\n");
            buffer.append("DOB: "+res.getString(2)+"\n");
        }


        List<String> ath_list = new ArrayList<String>();
        ArrayAdapter adapter = new ArrayAdapter(Records.this,android.R.layout.simple_list_item_1,ath_list);
        ath_list.add(buffer.toString());
        lv.setAdapter(adapter);

    }
}