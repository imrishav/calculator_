//Created By Rishav
package com.example.rishav.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText result;
    private EditText newNumber;
    private TextView displayOperations;

    //variables to hold operands and type caluclations.

    private Double operand1=null;
    private Double operand2=null;
    private String pendingOperations= "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (EditText) findViewById(R.id.Result);
        newNumber= (EditText) findViewById(R.id.newNumber);
        displayOperations = (TextView) findViewById(R.id.operations);

        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button buttonDot = (Button) findViewById(R.id.buttonDot);

        Button buttonEquals = (Button) findViewById(R.id.buttonEquals);
        Button buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        Button buttonDivide = (Button) findViewById(R.id.buttonDivide);
        Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
        Button buttonMinus = (Button) findViewById(R.id.buttonMinus);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                newNumber.append(b.getText().toString());
            }
        };

        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonDot.setOnClickListener(listener);

        View.OnClickListener oplistener= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String op = b.getText().toString();
                String value = newNumber.getText().toString();
                if(value.length() != 0){
                    performOperations(value, op);
                }
                pendingOperations = op;
                displayOperations.setText(pendingOperations);
            }
        };

        buttonEquals.setOnClickListener(oplistener);
        buttonDivide.setOnClickListener(oplistener);
        buttonMultiply.setOnClickListener(oplistener);
        buttonPlus.setOnClickListener(oplistener);
        buttonMinus.setOnClickListener(oplistener);
    }

    private void performOperations(String value, String Operations){
        if(null == operand1){
            operand1 = Double.valueOf(value);
        }else {
                operand2 = Double.valueOf(value);

                if(pendingOperations.equals("=")){
                    pendingOperations = Operations;
                }
                switch (pendingOperations) {
                    case "=":
                        operand1 = operand2;
                        break;
                    case "/":
                        if(operand2 == 0){
                            operand1 =0.0;
                        }else {
                            operand1 /= operand2;
                        }
                        break;
                    case "*":
                        operand1 *= operand2;
                        break;
                    case "-":
                        operand1 -= operand2;
                        break;
                    case "+":
                        operand1 += operand2;
                        break;
                }
        }

        result.setText(operand1.toString());
        newNumber.setText("");


    }


}
