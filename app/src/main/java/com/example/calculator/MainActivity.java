package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Model m;
    private TextView topView;
    private int count;
    private int clearButtonCounter;
    private int negativeButtonCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m = new Model();
        topView = findViewById(R.id.view);
        count = 0;
        clearButtonCounter = 0;
        negativeButtonCounter = 0;
    }

    public void numberButton(View view){
        Button clickedButton = findViewById(view.getId());
        String input = clickedButton.getText().toString();

        if(m.getOperation().isEmpty()){
            if(count!=0){
                m.setA("");
                count--;
            }
            m.addToA(input);
            topView.setText(m.getA());
            System.out.println(m.getA());
        }else{
            m.addToB(input);
            topView.setText(m.getB());
            System.out.println(m.getB());
        }
        clearButtonCounter = 0;
    }
    public void clearButton(View view){
        if(clearButtonCounter == 1){
            m.setA("");
            m.setOperation("");
            m.setB("");
            topView.setText("0");
        }
        if(m.getOperation().isEmpty()){
            m.setA("");
            topView.setText("0");
        }else{
            m.setB("");
            topView.setText("0");
        }
        clearButtonCounter++;
    }

    public void operationButton(View view){

        Button clickedButton = findViewById(view.getId());
        String input = clickedButton.getText().toString();
        m.setOperation(input);
        clearButtonCounter = 0;
    }
    public void equalButton(View view){
        System.out.println("This is my A: " + m.getA() + " This is my B: " + m.getB());
        String value = m.evaluate();
        System.out.println("This is my result: " + value);
        m.setA(value);
        m.setOperation("");
        m.setB("");
        if(m.getCorrectFormat(value)){
            double valDouble = Double.parseDouble(value);
            int valInt = (int) valDouble;
            topView.setText(Integer.toString(valInt));
        }else{
            topView.setText(value);
        }
        clearButtonCounter = 0;
        count++;
    }


    public void negativeButton(View view) {
        if(m.getOperation().isEmpty()){
            if(!m.getA().isEmpty()){
                if(m.getA().charAt(0) == '-'){
                    m.takeAwayNegativeA();
                }else{
                    m.giveNegativeSign();
                }

                topView.setText(m.getA());
            }
        }else{
            if(!m.getB().isEmpty()){
                if(m.getB().charAt(0) == '-'){
                    m.takeAwayNegativeB();
                }else{
                    m.giveNegativeSignB();
                }
                topView.setText(m.getB());
            }
        }
        clearButtonCounter = 0;
    }

    public void percentButton(View view){
        if(m.getOperation().isEmpty()){
            if(!m.getA().isEmpty()){
                m.percentA();
                topView.setText(m.getA());
            }
        }else{
            if(!m.getB().isEmpty()){
                m.percentB();
                topView.setText(m.getB());
            }
        }
    }
}
