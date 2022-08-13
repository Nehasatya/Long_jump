package com.example.long_jump;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText chest_no;
    EditText DOB;
    String dob_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.name);
        chest_no = (EditText)findViewById(R.id.chest_no);
        DOB = (EditText)findViewById(R.id.DOB);

        Athlete athlete1 = new Athlete(name.getText().toString(),chest_no.getText().toString(),DOB.getText().toString());




    }
}