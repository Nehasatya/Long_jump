package com.example.long_jump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText chest_no;
    EditText DOB;
    String dob_var;
    Button add_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.name);
        chest_no = (EditText)findViewById(R.id.chest_no);
        DOB = (EditText)findViewById(R.id.DOB);
        add_score=(Button)findViewById(R.id.add_score);



        add_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Athlete athlete1 = new Athlete(name.getText().toString(),chest_no.getText().toString(),DOB.getText().toString());

                Intent intent = new Intent(MainActivity.this,Score_Entry.class).putExtra("athlete1",athlete1);
                startActivity(intent);
            }
        });





    }
}