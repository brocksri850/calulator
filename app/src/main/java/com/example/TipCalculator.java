package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculator extends AppCompatActivity {
    EditText e1,e2;
    Button Tip,reset,buts;
    TextView text1,text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        Tip=findViewById(R.id.Tip);
        reset=findViewById(R.id.reset);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        buts=findViewById(R.id.buts);

        Tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.length() == 0) {
                    e1.setError("Please Enter Number");
                } else if (e2.length() == 0) {
                    e2.setError("Please Enter Number");
                } else {

                    int num1 = Integer.parseInt(e1.getText().toString());
                    int num2 = Integer.parseInt(e2.getText().toString());
                    int cal = (num1 * num2) / 100;
                    int total = num1 + cal;
                    text1.setText(Integer.toString(cal));

                    text2.setText(Integer.toString(total));
                    Toast.makeText(getApplicationContext(), "successfully loaded...!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                e1.setText("");
                e2.setText("");
                text1.setText("");
                text2.setText("");
                Toast.makeText(getApplicationContext(), "Reseted", Toast.LENGTH_SHORT).show();
            }

        });
        buts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent more=new Intent(TipCalculator.this,AgeCalculator.class);
                startActivity(more);
            }
        });


    }
}