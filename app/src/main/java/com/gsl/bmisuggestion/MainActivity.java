package com.gsl.bmisuggestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightF);
        edtHeightIn = findViewById(R.id.edtHeightI);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int Hft = Integer.parseInt(edtHeightFt.getText().toString());
                int HIn = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = Hft*12 + HIn;

                double totalCm = totalIn*2.53;

                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);

                if(bmi>25){
                    txtResult.setText("You're Overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOw));
                } else if (bmi<18){
                    txtResult.setText("You're are Underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUn));
                } else{
                    txtResult.setText("You're Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
            }
        });


    }
}