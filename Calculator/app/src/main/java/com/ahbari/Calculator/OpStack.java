package com.ahbari.Calculator;

import android.annotation.SuppressLint;

import java.util.ArrayList;

public class OpStack {
    private ArrayList<String> opStack;

    public OpStack() {
        this.opStack = new ArrayList<>();
    }

    public void pushNumber(String num) {
        if (num.isEmpty() || num.equals("0")) return;
        if (opStack.isEmpty() || opStack.size() == 2) {
            opStack.add(num);
        }
    }
    public void pushOperation(String op) {
        if (opStack.size() == 1) {
            opStack.add(op);
        } else if(opStack.size() == 2 ){
            opStack.set(1,op);
        }

    }

    @SuppressLint("DefaultLocale")
    public String equal() {
        String result ;
        if (opStack.isEmpty()) {
            return "0";
        } else if(opStack.size() == 1 || opStack.size() == 2) {
            return opStack.get(0);
        } else {
            double oldInt = Double.parseDouble(opStack.get(0));
            double newInt =  Double.parseDouble(opStack.get(2));

            double total = 0 ;
            switch (opStack.get(1)) {
                case "+":
                    total = oldInt + newInt ;
                    break;
                case "-":
                    total = oldInt - newInt  ;
                    break;
                case "/":
                    total =  oldInt / newInt ;
                    break;
                case "*":
                    total = oldInt * newInt ;
                    break;
                case "%":
                    total = oldInt % newInt ;
                    break;
            }

            opStack.clear();
            String res ;
            if (total % 1.0 > 0) {
                res = String.format("%.2f", total) ;
            } else {
                res = (long)total + "" ;
            }
            opStack.add(res);
            return res;
        }
    }

    public String getExpretion() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < opStack.size(); i++) {
            res.append(opStack.get(i)).append(" ");
        }
        return res.toString();
    }

    public void clear() { opStack.clear();}

}
