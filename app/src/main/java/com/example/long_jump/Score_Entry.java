package com.example.long_jump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Score_Entry extends AppCompatActivity {
    EditText score1;
    EditText score2;
    EditText score3;
    Button show_records;
    DBHandler dbHandler;
    EditText chest_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_entry);
        score1=(EditText)findViewById(R.id.score1) ;
        score2=(EditText)findViewById(R.id.score2);
        score3=(EditText)findViewById(R.id.score3);
        show_records=(Button)findViewById(R.id.enter);
        dbHandler = new DBHandler(Score_Entry.this);
        chest_no=(EditText)findViewById(R.id.chest_no);


        show_records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(score1.getText().toString().isEmpty() && score2.getText().toString().isEmpty() && score3.getText().toString().isEmpty()) {
                    Toast.makeText(Score_Entry.this, "Please Enter All Values", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addScore(chest_no.getText().toString(),Integer.parseInt(score1.getText().toString()),Integer.parseInt(score2.getText().toString()),Integer.parseInt(score3.getText().toString()));

                Intent intent = new Intent(Score_Entry.this,Records.class);
                startActivity(intent);
            }
        });




    }
}