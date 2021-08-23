package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText  e1,e2;
    Button b1,b2,b3,b4,reset,next;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        reset=findViewById(R.id.reset);
        text1 = findViewById(R.id.text1);
        next=findViewById(R.id.next);

     b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if(e1.length()==0)
             {
                 e1.setError("Please Enter Number");
             }
             else if(e2.length()==0){
                 e2.setError("Please Enter Number");
             }
             else {
                 int temp1 = Integer.parseInt(e1.getText().toString());
                 int temp2 = Integer.parseInt(e2.getText().toString());
                 int equal = temp1 + temp2;
                 text1.setText((Integer.toString(equal)));
             }
         }
     });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    sub();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "something", Toast.LENGTH_SHORT).show();

                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    multiple();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "something", Toast.LENGTH_SHORT).show();

                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                     division();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "something", Toast.LENGTH_SHORT).show();

                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    e1.setText("");
                    e2.setText("");
                    text1.setText("");
                    Toast.makeText(getApplicationContext(), "Reseted", Toast.LENGTH_SHORT).show();
                }catch (NullPointerException e){
                    Toast.makeText(MainActivity.this, "somethi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send=new Intent(MainActivity.this,BMICalculator.class);
                   startActivity(send);
            }
        });
    }

    private void sub() {
        if (e1.length() == 0) {
            e1.setError("Please Enter Number");
        } else if (e2.length() == 0) {
            e2.setError("Please Enter Number");
        } else {
            int num1 = Integer.parseInt(e1.getText().toString());
            int num2 = Integer.parseInt(e2.getText().toString());
            int equal = num1 - num2;
            text1.setText(Integer.toString(equal));
            Toast.makeText(getApplicationContext(), "Subtract two Numbers", Toast.LENGTH_SHORT).show();
        }
    }
    private void multiple() {
        if (e1.length() == 0) {
            e1.setError("Please Enter Number");
        } else if (e2.length() == 0) {
            e2.setError("Please Enter Number");
        } else {
            int num1 = Integer.parseInt(e1.getText().toString());
            int num2 = Integer.parseInt(e2.getText().toString());
            int equal = num1 * num2;
            text1.setText(Integer.toString(equal));
            Toast.makeText(getApplicationContext(), "Multiplication two Numbers", Toast.LENGTH_SHORT).show();
        }
    }
    public void division() {
        if (e1.length() == 0) {
            e1.setError("Please Enter Number");
        } else if (e2.length() == 0) {
            e2.setError("Please Enter Number");
        } else {
            int num1 = Integer.parseInt(e1.getText().toString());
            int num2 = Integer.parseInt(e2.getText().toString());
            int equal = num1 / num2;
            text1.setText(Integer.toString(equal));
            Toast.makeText(getApplicationContext(), "Dvision two Numbers", Toast.LENGTH_SHORT).show();
        }
    }
}









