package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText num1,num2;
    TextView result;
    Button Sum,minus,multiply,divide,clear;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.number1);
        num2 = findViewById(R.id.number2);
        result = findViewById(R.id.result);
        Sum = findViewById(R.id.sum);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        clear = findViewById(R.id.clear);

        Sum.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sum:
                if (isValidate()) {

                    value = Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString());
                    result.setText(Integer.toString(value));
                }
                break;

            case R.id.minus:
                if (isValidate()) {
                    value = Integer.parseInt(num1.getText().toString()) - Integer.parseInt(num2.getText().toString());
                    result.setText(Integer.toString(value));
                }
                break;

            case R.id.multiply:
                if (isValidate()) {
                    value = Integer.parseInt(num1.getText().toString()) * Integer.parseInt(num2.getText().toString());
                    result.setText(Integer.toString(value));
                }
                break;

            case R.id.divide:
                if (isValidate()) {
                    double div = Integer.parseInt(num1.getText().toString()) / (Integer.parseInt(num2.getText().toString()) * 1.0);
                    result.setText(Double.toString(div));
                }
                break;

            case R.id.clear:
                num1.getText().clear();
                num2.getText().clear();
                result.setText("");
                break;
        }
    }

    private boolean isValidate() {

        if(num1.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"please enter value1",Toast.LENGTH_LONG).show();
            return false;
        }else if(num2.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"please enter value2",Toast.LENGTH_LONG).show();
            return false;
        }else if(num1.getText().toString().isEmpty()&&num2.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"please enter values",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}