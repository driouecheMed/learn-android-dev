package com.ahbari.Calculator;
import com.ahbari.Calculator.operations.Add;
import com.ahbari.Calculator.operations.Divide;
import com.ahbari.Calculator.operations.Modulo;
import com.ahbari.Calculator.operations.Multiplication;
import com.ahbari.Calculator.operations.Operation;
import com.ahbari.Calculator.operations.Subtract;


public class OperationFactory {

    public static double calculate (double a, double b, String op) throws Exception{
        switch (op){
            case "+" :
                return new Add().perform(a,b);

            case "-" :
                return new Subtract().perform(a,b);

            case "*" :
                return new Multiplication().perform(a,b);

            case "/" :
                return new Divide().perform(a,b);

            case "%" :
                return new Modulo().perform(a,b);
            default:
                return b;
        }
    }

}
