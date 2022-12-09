package com.ahbari.Calculator;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ahbari.Calculator.operations.Add;
import com.ahbari.Calculator.operations.Divide;
import com.ahbari.Calculator.operations.Modelo;
import com.ahbari.Calculator.operations.Multiplication;
import com.ahbari.Calculator.operations.Operation;
import com.ahbari.Calculator.operations.Subtract;

public class CalculatorViewModel extends AndroidViewModel {

    private final MutableLiveData<String> numberToDisplay = new MutableLiveData<>();
    private final MutableLiveData<String> expressionToDisplay = new MutableLiveData<>();
    Calculator calculator;
    OperandAdapter operandAdapter;
    double currentValue ;
    String currentOperation ;

    public CalculatorViewModel(@NonNull Application application) {
        super(application);
        calculator = new Calculator();
        operandAdapter = new OperandAdapter();
        currentValue = 0.0;
    }

    public LiveData<String> getNumberToDisplay() {
        return this.numberToDisplay;
    }
    public LiveData<String> getExpressionToDisplay() {
        return this.expressionToDisplay;
    }

    public void back() {
        operandAdapter.back();
    }

    public void clearAll() {
        operandAdapter.clear();
        this.numberToDisplay.setValue("0");
        this.expressionToDisplay.setValue("");
    }

    public void clearInput() {
        operandAdapter.clear();
        this.numberToDisplay.setValue("0");
    }

    public void equal() {
        if (operandAdapter.isEmpty()){
            return;
        }

        double newNumber = operandAdapter.pop();
        if (currentValue != 0.0) {
            String expression = currentValue + currentOperation + newNumber + " =" ;
            expressionToDisplay.setValue(expression);
        } else {
            expressionToDisplay.setValue(String.valueOf(newNumber));
        }

        this.currentValue = calculator.calculate(currentValue, newNumber);
        this.numberToDisplay.setValue(String.valueOf(currentValue));

    }
    public void setOperation(String op) {
        if (op.equals(currentOperation)){
            return;
        }

        this.currentOperation = op;
        switch (op){
            case "+" :
                handelOperation(new Add());
                break;
            case "-" :
                handelOperation(new Subtract());
                break;
            case "*" :
                handelOperation(new Multiplication());
                break;
            case "/" :
                handelOperation(new Divide());
                break;
            case "%" :
                handelOperation(new Modelo());
                break;
        }
    }

    void handelOperation(Operation op) {
        if (operandAdapter.isEmpty()){
            calculator.setOperation(op);
        } else {
            double newNumber = operandAdapter.pop();
            currentValue = calculator.calculate(currentValue , newNumber);
            calculator.setOperation(op);
            numberToDisplay.setValue(String.valueOf(currentValue));
        }
        expressionToDisplay.setValue(currentValue + " " + currentOperation);
    }

    public void addDigit(String d) {
        operandAdapter.addDigit(d);
        numberToDisplay.setValue(operandAdapter.getOperand());
    }

}
