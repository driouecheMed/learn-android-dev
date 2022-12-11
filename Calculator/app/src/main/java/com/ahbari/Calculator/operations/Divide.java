package com.ahbari.Calculator.operations;

public class Divide implements Operation{
    @Override
    public double perform(double a, double b) throws Exception {
        if (b != 0 ){
            return a / b;
        }
        else {
            throw new Exception("can't divide on 0");
        }

    }
}
