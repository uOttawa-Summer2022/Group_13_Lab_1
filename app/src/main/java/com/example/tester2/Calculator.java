package com.example.tester2;



import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Calculator {
    private String operator;
    private String operand1;
    private String operand2;
    private double resultInDecimal;
    private boolean integerPrecision =false;
    private boolean error = false;


    public void setOperands(String operand1, String operand2) {

        if (operand1.equals("") && operand2.equals("")) {// reset case for clear
            this.operand1 = operand1;
            this.operand2 = operand2;
        }

        if (!operand1.equals("")) {
            this.operand1 = operand1;
        }
        if (!operand2.equals("")) {
            this.operand2 = operand2;
        }
    }

    public void setArithmeticOperator(String operator) {
        this.operator = operator;
    }
    public void setIntegerPrecision(boolean value){
        integerPrecision = value;
    }


    public String getResult(){
        calculate();
        DecimalFormat format = new DecimalFormat("0.##");
        if(!error){
            return format.format(resultInDecimal).toString();
        }else{
            error = false;
            return "ERROR";
        }

    }


    private void calculate(){
        double opD1 = 0;
        double opD2 = 0;
        opD1 = Double.parseDouble(operand1);
        opD2 = Double.parseDouble(operand2);
        if(operator.equals("+")){
            resultInDecimal = opD1+opD2;
        }
        else if (operator.equals("-")){
            resultInDecimal = opD1-opD2;
        }
        else if (operator.equals("*")){
            resultInDecimal = opD1*opD2;
        }
        else if (operator.equals("/")){
            if(opD2 != 0) {
                resultInDecimal = opD1/opD2;
            }else{
                error = true;
            }

        }
    }
}
