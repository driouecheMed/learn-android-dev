package com.ahbari.Calculator;
import com.ahbari.Calculator.operations.Operation;


public class Calculator {
    private Operation operation;

    public Calculator() {
        this.operation = null;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double calculate(double a, double b) {
        if (this.operation == null){
            return b;
        }
        return operation.perform(a, b);
    }
}
