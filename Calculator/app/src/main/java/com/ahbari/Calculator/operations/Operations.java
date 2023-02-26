package com.ahbari.Calculator.operations;

public class Operations {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double Multiplication(double a, double b) {
        return a * b;
    }

    public static double Modulo(double a, double b) {
        return a % b;
    }

    public static double Subtract(double a, double b) {
        return a - b;
    }

    public static double Divide(double a, double b) throws ArithmeticException {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("can't divide on 0");
        }
    }
}
