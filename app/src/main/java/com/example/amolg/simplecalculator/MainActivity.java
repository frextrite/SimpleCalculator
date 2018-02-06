package com.example.amolg.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    Button numDecimal, clearAll, divide, multiply, add, subtract, equals;
    TextView displayNumber;
    TextView mainDisplay;

    boolean first = true;
    float numberA = 0, numberB = 0, res = 0;
    char operator = '+';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Misc Text Fields
        displayNumber = findViewById(R.id.outputTextView);
        mainDisplay = findViewById(R.id.outputEditText);

        // Number Buttons
        num0 = findViewById(R.id.num0);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);

        // Misc Buttons
        numDecimal = findViewById(R.id.numDecimal);
        clearAll = findViewById(R.id.clearAll);
        divide = findViewById(R.id.opDivide);
        multiply = findViewById(R.id.opMultiply);
        add = findViewById(R.id.opAdd);
        subtract = findViewById(R.id.opSubtract);
        equals = findViewById(R.id.opEqual);

        // Operations
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempNum = String.valueOf(mainDisplay.getText());
                numberB = Float.parseFloat(tempNum);
                displayNumber.setText(tempNum);
                res = calculate(numberA, numberB, operator);
                mainDisplay.setText(String.valueOf(res));
                res = 0;
                first = true;
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operate('/', numberA);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operate('*', numberA);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operate('+', numberA);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operate('-', numberA);
            }
        });

        // Clear function
        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String current_text = mainDisplay.getText().toString();
                if(current_text != null && current_text.length() > 0) {
                    current_text = current_text.substring(0, current_text.length() - 1);
                }
                mainDisplay.setText(current_text);
            }
        });

        clearAll.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                displayNumber.setText("");
                mainDisplay.setText("");
                first = true;
                numberA = 0;
                numberB = 0;
                operator = '+';
                return false;
            }
        });

        // Number functions
        numDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + ".");
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "0");
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "1");
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "2");
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "3");
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "4");
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "5");
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "6");
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "7");
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "8");
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(mainDisplay.getText() + "9");
            }
        });

    }

    private float calculate(float num1, float num2, char operator) {
        float out = 0;
        switch(operator) {
            case '+':
                out = num1 + num2;
                break;
            case '-':
                out = num1 - num2;
                break;
            case '*':
                out = num1 * num2;
                break;
            case '/':
                if(num2 != 0.0) {
                    out = num1 / num2;
                } else {
                    out = 0;
                    displayNumber.setText("Divide by 0 error!");
                }
                break;
            default:
                break;
        }
        return out;
    }

    private void operate(char operator, float numberA) {
        String tempNum = String.valueOf(mainDisplay.getText());
        mainDisplay.setText("");
        float tempA = Float.parseFloat(tempNum);
        if(first == false) {
            float oldResult = calculate(numberA, tempA, operator);
            tempA = oldResult;
        }
        numberA = tempA;
        displayNumber.setText(String.valueOf(numberA) + '/');
        first = false;
        this.operator = operator;
        this.numberA = numberA;
    }
}
