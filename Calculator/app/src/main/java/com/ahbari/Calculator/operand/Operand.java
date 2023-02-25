package com.ahbari.Calculator.operand;

public class Operand {
    public static final int operandMaxLen = 7;

    private String operand;

    public static String formatNumber(double d) {
        String[] numParts;

        if (d % 1.0 == 0) {
            numParts = new String[]{String.valueOf((long) d), "0"};
        } else {
            numParts = Double.toString(d).split("\\.");
        }

        int len = numParts[0].length();
        if (len > operandMaxLen) {
            return numParts[0].substring(0, operandMaxLen) + "e" + (len - operandMaxLen);
        } else if (!numParts[1].equals("0")) {
            if (numParts[1].length() > 2 + operandMaxLen - len)
                return numParts[0] + "." + numParts[1].substring(2 + operandMaxLen - len);
            return numParts[0] + "." + numParts[1];
        }

        return numParts[0];
    }

    public Operand() {
        this.operand = "0";
    }

    public void addDigit(String d) {
        if (operand.length() > operandMaxLen + 2) return;

        if (d.matches("^[0-9]+$")) {
            if (this.operand.equals("0")) {
                this.operand = d;
            } else {
                this.operand += d;
            }
        } else if (d.equals(".")) {
            if (!this.operand.contains(".")) {
                this.operand += d;
            }
        }
    }

    public void back() {
        if (this.operand.length() <= 1) {
            this.operand = "0";
        } else {
            this.operand = this.operand.substring(0, this.operand.length() - 1);
        }
    }

    public void clear() {
        this.operand = "0";
    }

    public String getOperand() {
        return this.operand;
    }

    public boolean isEmpty() {
        return this.operand.equals("0");
    }

    public double pop() {
        double res = Double.parseDouble(operand);
        clear();
        return res;
    }


}
