package com.ahbari.Calculator.operations;

public class Divide implements Operation{
    @Override
    public double perform(double a, double b) {
        if (b != 0 ){
            return a / b;
        }
        else {
            // error
            return 0.0;
        }

    }
}
