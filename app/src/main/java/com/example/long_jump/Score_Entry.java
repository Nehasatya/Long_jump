package com.example.long_jump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Score_Entry extends AppCompatActivity {
    EditText score1;
    EditText score2;
    EditText score3;
    Button show_records;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_entry);
        score1=(EditText)findViewById(R.id.score1) ;
        score2=(EditText)findViewById(R.id.score2);
        score3=(EditText)findViewById(R.id.score3);
        show_records=(Button)findViewById(R.id.enter);


        show_records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Athlete ath1 = getIntent().getParcelableExtra("athlete1");
                try {
                    ath1.score1 = Integer.parseInt(score1.getText().toString());
                    ath1.score2 = Integer.parseInt(score2.getText().toString());
                    ath1.score3 = Integer.parseInt(score3.getText().toString());
                }
                catch(NumberFormatException e)
                {
                    e.printStackTrace();
                }


                Intent intent = new Intent(Score_Entry.this,Records.class).putExtra("ath1",ath1);
                startActivity(intent);
            }
        });




    }
}