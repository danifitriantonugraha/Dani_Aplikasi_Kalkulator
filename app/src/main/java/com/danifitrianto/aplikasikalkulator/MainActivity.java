package com.danifitrianto.aplikasikalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText firstNumber, secondNumber;
    Button plus,minus,multiply,devide,clear;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);

        plus = findViewById(R.id.btnPlus);
        minus = findViewById(R.id.btnMinus);
        multiply = findViewById(R.id.btnMultiply);
        devide = findViewById(R.id.btnDivide);
        clear = findViewById(R.id.btnClear);

        result = findViewById(R.id.lblResult);

        firstNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        secondNumber.setInputType(InputType.TYPE_CLASS_NUMBER);

        clear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        result.setText(String.valueOf(0));
                        firstNumber.getText().clear();
                        secondNumber.getText().clear();
                    }
                }
        );

        plus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        doMath(1,Integer.parseInt(firstNumber.getText().toString()),
                                Integer.parseInt(firstNumber.getText().toString()));
                    }
                }
        );

        minus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        doMath(2,Integer.parseInt(firstNumber.getText().toString()),
                                Integer.parseInt(firstNumber.getText().toString()));
                    }
                }
        );

        multiply.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        doMath(3,Integer.parseInt(firstNumber.getText().toString()),
                                Integer.parseInt(firstNumber.getText().toString()));
                    }
                }
        );

        devide.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        doMath(4,Integer.parseInt(firstNumber.getText().toString()),
                                Integer.parseInt(firstNumber.getText().toString()));
                    }
                }
        );

    }

    void doMath(int i,int a,int b) {

        int presult;

        switch (i) {
            case 1:
                presult = a * b;
                break;
            case 2:
                presult = a - b;
                break;
            case 3:
                presult = a + b;
                break;
            case 4:
                presult = a / b;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + i);
        }

        result.setText(String.valueOf(presult));
    }
}