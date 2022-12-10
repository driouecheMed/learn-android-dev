package com.ahbari.Calculator.operations;

public class Modulo implements Operation{
    @Override
    public double perform(double a, double b) {
        return a % b;
    }
}
