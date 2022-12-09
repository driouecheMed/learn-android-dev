package com.ahbari.Calculator;

public class OperandAdapter {
    private String operand ;

    public OperandAdapter(){
        this.operand = "0";
    }

    public void addDigit(String d) {
        if (d.matches("^[0-9]+$")){
            if (this.operand.equals("0")){
                this.operand = d;
            } else {
                this.operand += d;
            }
        } else if (d.equals(".")) {
            if(!this.operand.contains(".")){
                this.operand += d;
            }
        }
    }

    public void back(){
        if (this.operand.length() <= 1){
            this.operand = "0" ;
        } else {
            this.operand = this.operand.substring(0,  this.operand.length()-1);
        }
    }

    public void clear() { this.operand = "0"; }

    public String getOperand (){ return this.operand; }

    public boolean isEmpty() { return this.operand.equals("0"); }

    public double pop(){
        double res = Double.parseDouble(operand);
        clear();
        return res;
    }


}
