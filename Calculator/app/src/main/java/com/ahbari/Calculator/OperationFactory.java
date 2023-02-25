package com.ahbari.Calculator;


import com.ahbari.Calculator.operations.Operations;

public class OperationFactory {

    public static double calculate(double a, double b, String op) throws Exception {
        switch (op) {
            case "+":
                return Operations.add(a, b);

            case "-":
                return Operations.Subtract(a, b);

            case "*":
                return Operations.Multiplication(a, b);

            case "/":
                return Operations.Divide(a, b);

            case "%":
                return Operations.Modulo(a, b);
            default:
                return b;
        }
    }

}
