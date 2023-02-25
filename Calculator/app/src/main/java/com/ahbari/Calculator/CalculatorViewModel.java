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
    private final Operand operand;
    private double currentValue;
    private String currentOperation;

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
        this.numberToDisplay.setValue(operand.getOperand());
    }

    public void clearAll() {
        operand.clear();
        this.numberToDisplay.setValue("0");
        this.expressionToDisplay.setValue("");
        this.currentValue = 0.0;
        this.currentOperation = "";
    }

    public void clearInput() {
        operand.clear();
        this.numberToDisplay.setValue("0");
    }

    public void equal() {

        try {
            double newNumber = operand.pop();
            if (currentValue != 0.0) {
                String expression = Operand.formatNumber(currentValue)
                        + " " + currentOperation + " "
                        + Operand.formatNumber(newNumber)
                        + " =";

                expressionToDisplay.setValue(expression);
            } else {
                expressionToDisplay.setValue(Operand.formatNumber(newNumber));
            }
            this.currentValue = OperationFactory.calculate(currentValue, newNumber, currentOperation);
            this.numberToDisplay.setValue(Operand.formatNumber(currentValue));

            // to be ready for new operation
            currentOperation = "";
        } catch (Exception e) {
            clearAll();
            this.expressionToDisplay.setValue(e.getMessage());
        }

    }

    public void setOperation(String op) {
        try {
            if (!operand.isEmpty()) {
                double newNumber = operand.pop();
                currentValue = OperationFactory.calculate(currentValue, newNumber, currentOperation);
                numberToDisplay.setValue(Operand.formatNumber(currentValue));
            }
            this.currentOperation = op;
            expressionToDisplay.setValue(Operand.formatNumber(currentValue) + " " + currentOperation);
        } catch (Exception e) {
            clearAll();
            this.expressionToDisplay.setValue(e.getMessage());
        }

    }

    public void addDigit(String d) {
        operand.addDigit(d);
        numberToDisplay.setValue(operand.getOperand());
    }

}
