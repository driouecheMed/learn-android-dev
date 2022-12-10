package com.ahbari.Calculator;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ahbari.Calculator.operand.Operand;

public class CalculatorViewModel extends AndroidViewModel {

    private final MutableLiveData<String> numberToDisplay = new MutableLiveData<>();
    private final MutableLiveData<String> expressionToDisplay = new MutableLiveData<>();
    private Operand operand;
    private double currentValue ;
    private String currentOperation ;

    public CalculatorViewModel(@NonNull Application application) {
        super(application);
        operand = new Operand();
        currentValue = 0.0;
        currentOperation = "";
    }

    public LiveData<String> getNumberToDisplay() {
        return this.numberToDisplay;
    }
    public LiveData<String> getExpressionToDisplay() {
        return this.expressionToDisplay;
    }

    public void back() {
        operand.back();
    }

    public void clearAll() {
        operand.clear();
        this.numberToDisplay.setValue("0");
        this.expressionToDisplay.setValue("");
    }

    public void clearInput() {
        operand.clear();
        this.numberToDisplay.setValue("0");
    }

    public void equal() {
        if (operand.isEmpty()){ return; }

        double newNumber = operand.pop();
        if (currentValue != 0.0) {
            String expression = currentValue + currentOperation + newNumber + " =" ;
            expressionToDisplay.setValue(expression);
        } else {
            expressionToDisplay.setValue(String.valueOf(newNumber));
        }

        this.currentValue = OperationFactory.calculate(currentValue, newNumber, currentOperation);
        this.numberToDisplay.setValue(String.valueOf(currentValue));
    }

    public void setOperation(String op) {
        if (op.equals(currentOperation)){ return; }

        if (!operand.isEmpty()){
            double newNumber = operand.pop();
            currentValue = OperationFactory.calculate(currentValue , newNumber, currentOperation);
            numberToDisplay.setValue(String.valueOf(currentValue));
        }
        this.currentOperation = op;
        expressionToDisplay.setValue(currentValue + " " + currentOperation);
    }

    public void addDigit(String d) {
        operand.addDigit(d);
        numberToDisplay.setValue(operand.getOperand());
    }

}
