package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMICalculator extends AppCompatActivity {
    EditText weight,height;
    Button submit,reset,next;
    TextView text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);
        weight=findViewById(R.id.weight);
        height=findViewById(R.id.height);
        submit=findViewById(R.id.submit);
        reset=findViewById(R.id.reset);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        next=findViewById(R.id.next);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(weight.length()==0){
                    weight.setError("Please Enter Weight");
                }
                else if(height.length()==0){
                    height.setError("Please Enter Height");
                }
                else {
                    float num1 = Float.parseFloat(weight.getText().toString());
                    float num2 = Float.parseFloat(height.getText().toString());
                    float height = num2 / 100;

                    float bmi = num1 / (height * height);
                    text1.setText(Float.toString(bmi));
                    Toast.makeText(BMICalculator.this, "Success", Toast.LENGTH_SHORT).show();
                    bmistring(bmi);
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                weight.setText("");
                height.setText("");
                text1.setText("");
                Toast.makeText(getApplicationContext(), "Reseted", Toast.LENGTH_SHORT).show();
            }

        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send=new Intent(BMICalculator.this,TipCalculator.class);
                startActivity(send);
            }
        });
    }

    private void bmistring(float bmiresult) {

        if(bmiresult<18)
        {
            text2.setText("Under Weight");
        }
        else if (bmiresult<25)
        {
            text2.setText("Normal weight");
        }
        else if (bmiresult<30)
        {
            text2.setText("overweight");
        }
        else{
            text2.setText("obese");
        }
    }
}