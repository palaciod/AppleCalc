package com.example.calculator;

import java.util.Stack;

public class Model {
    // String A will be the first part of the equation
    private String a;
    // String b will be the second part of the equation.
    private String b;
    private String operation;
    private Stack<String> expression;
    public Model(){
        expression = new Stack<>();
        a = "";
        b = "";
        operation = "";
    }
    public void add(String input){
        expression.push(input);
    }
    public String top(){
        return expression.peek();
    }
    public String pop(){
        return expression.pop();
    }
    public int size(){
        return expression.size();
    }
    public void addToA(String input){
        a = a + input;
    }
    public String getA(){
        return a;
    }
    public void setA(String _a){
        a = _a;
    }

    public void setB(String _b) {
        b = _b;
    }
    public void giveNegativeSign(){
        a = "-" + a;
    }
    public void takeAwayNegativeA(){
        a = a.replace("-","");
    }
    public void giveNegativeSignB(){
        b = "-" + b;
    }
    public void takeAwayNegativeB(){
        b = b.replace("-","");
    }

    public void addToB(String input){
        b = b + input;
    }
    public String getB(){
        return b;
    }
    public String getOperation(){
        return operation;
    }
    public void setOperation(String input){
        operation = input;
    }
    public String evaluate(){
        String value = "";
        switch (getOperation()){
            case "+":
                value = Double.toString(Double.parseDouble(getA()) + Double.parseDouble(getB()));
                break;
            case "-":
                value = Double.toString(Double.parseDouble(getA()) - Double.parseDouble(getB()));
                break;
            case "X":
                value = Double.toString(Double.parseDouble(getA()) * Double.parseDouble(getB()));
                break;
            case "÷":
                //double tempVal = Double.parseDouble(getA()) / Double.parseDouble(getB());
                value = Double.toString(Double.parseDouble(getA()) / Double.parseDouble(getB()));

                break;
        }
        return value;
    }

    public boolean getCorrectFormat(String value){
        double valDouble = Double.parseDouble(value);
        int valInt = (int) valDouble;
        double decimal = valDouble - valInt;
        if(decimal == 0){
            System.out.println(true);
            return true;
        }
        return false;
    }
    public void percentA(){
        double val = Double.parseDouble(a);
        a = Double.toString(val/100);
    }
    public void percentB(){
        double val = Double.parseDouble(b);
        b = Double.toString(val/100);
    }


}
