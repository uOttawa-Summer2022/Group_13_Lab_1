package com.example.tester2;



import java.math.BigDecimal;

public class Calculator {
    private String operator;
    private String operand1;
    private String operand2;
    private BigDecimal resultInDecimal;
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
        if(!error){
            if(integerPrecision){
                Integer i = resultInDecimal.intValue();
                return i.toString();
            }
            return resultInDecimal.toString() ;
        }else{
            error = false;
            return "ERROR";
        }

    }


    private void calculate(){
        BigDecimal opD1 = BigDecimal.ZERO;
        BigDecimal opD2 = BigDecimal.ZERO;
        opD1 = BigDecimal.valueOf(Double.parseDouble(operand1));
        opD2 = BigDecimal.valueOf(Double.parseDouble(operand2));
        if(operator.equals("+")){
            resultInDecimal = opD1.add(opD2);
        }
        else if (operator.equals("-")){
            resultInDecimal = opD1.subtract(opD2);
        }
        else if (operator.equals("*")){
            resultInDecimal = opD1.multiply(opD2);
        }
        else if (operator.equals("/")){
            if(opD2.compareTo(BigDecimal.ZERO) != 0) {
                resultInDecimal = opD1.divide(opD2);
            }else{
                error = true;
            }

        }
    }
}
