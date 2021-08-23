package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

public class AgeCalculator extends AppCompatActivity {
    Button btbirth,bttoday,btcalculate,n;
    TextView tvresult;
    DatePickerDialog.OnDateSetListener dateSetListener1,dateSetListener2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);
        btbirth=findViewById(R.id.bt_birth);
        bttoday=findViewById(R.id.bt_today);
        btcalculate=findViewById(R.id.bt_calculate);
        tvresult=findViewById(R.id.tv_result);
        n=findViewById(R.id.n);

        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        String date=simpleDateFormat.format(Calendar.getInstance().getTime());
        bttoday.setText(date);
        btbirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        AgeCalculator.this
                        ,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth
                        ,dateSetListener1,day,month,year);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        dateSetListener1=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day)  {
                month=month+1;
                String date=day+"/"+month+"/"+year;
                btbirth.setText(date);
            }
        };
        bttoday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        AgeCalculator.this
                        ,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth
                        ,dateSetListener2,day,month,year);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        dateSetListener2=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int day, int month, int year)  {
                month=month+1;
                String date=day+"/"+month+"/"+year;
                bttoday.setText(date);
            }
        };
        btcalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  String sDate=btbirth.getText().toString();
                  String eDate=bttoday.getText().toString();
                  SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("dd/MM/yyyy");

                try {
                    Date date1=simpleDateFormat1.parse(sDate);
                    Date date2=simpleDateFormat1.parse(eDate);

                    long startDate=date1.getTime();
                    long endDate=date2.getTime();

                    if (startDate <= endDate){
                        Period period=new Period(startDate,endDate,PeriodType.yearMonthDay());
                        int year1=period.getYears();
                        int months1=period.getMonths();
                        int days1=period.getDays();
                        tvresult.setText(year1+" Years |"+months1+" Month |"+days1+" Days");
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"birth date should not be larger then currunt date",Toast.LENGTH_SHORT).show();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send=new Intent(AgeCalculator.this,Calculator.class);
                startActivity(send);
            }
        });
    }
}