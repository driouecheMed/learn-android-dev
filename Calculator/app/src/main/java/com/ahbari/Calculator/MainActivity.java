package com.ahbari.Calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnModulo, btnC, btnBack, btnCE, btnMutiple, btnDivision, btnAdd , btnSub, btnEqual ;
    private Button btn0, btn1,btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDot ;
    private TextView inNumber, inOperation ;
    private OpStack opStack;
    private boolean readyForNextOp = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inNumber = findViewById(R.id.input_number);
        inOperation = findViewById(R.id.input_operation);
        inNumber.setText("0");
        inOperation.setText("");
        opStack = new OpStack();

        assign(btnModulo, R.id.button_modulo);
        assign(btnC, R.id.button_c);
        assign(btnBack, R.id.button_back);
        assign(btnCE, R.id.button_clear);
        assign(btnMutiple, R.id.button_multiplication);
        assign(btnDivision, R.id.button_division);
        assign(btnAdd, R.id.button_add);
        assign(btnSub, R.id.button_sub);
        assign(btnEqual, R.id.button_equal);
        assign(btn0, R.id.button_0);
        assign(btn1, R.id.button_1);
        assign(btn2, R.id.button_2);
        assign(btn3, R.id.button_3);
        assign(btn4, R.id.button_4);
        assign(btn5, R.id.button_5);
        assign(btn6, R.id.button_6);
        assign(btn7, R.id.button_7);
        assign(btn8, R.id.button_8);
        assign(btn9, R.id.button_9);
        assign(btnDot, R.id.button_dot);
    }

    void assign(Button btn , int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button btn = findViewById(view.getId()) ;
        String inNumberValue = readyForNextOp ? "" : inNumber.getText().toString() ;


        switch (btn.getText().toString()) {
            case "back" :
                if(inNumberValue.length() <= 1){
                    inNumber.setText("0");
                } else {
                    inNumber.setText(inNumberValue.substring(0, inNumberValue.length()-1));
                }
                break;
            case "C" :
                inNumber.setText("0");
                inOperation.setText("");
                opStack.clear();
                break;
            case "CE" :
                inNumber.setText("0");
                break;
            case "+" :
            case "/" :
            case "-" :
            case "*" :
            case "%" :
                inOperation.setText(opStack.getExpretion());
                calcule(btn.getText().toString() , inNumberValue) ;
                break;
            case "=" :
                opStack.pushNumber(inNumberValue);
                inOperation.setText(opStack.getExpretion());
                inNumber.setText(opStack.equal());
                readyForNextOp = true;
                break;
            case ".":
                if(inNumberValue.length() < 8) {
                    inNumber.setText( inNumberValue + btn.getText().toString() );
                }
                readyForNextOp = false;
                break;
            default:
                if(inNumberValue.length() < 8) {
                    String value = inNumberValue.equals("0") ? "" : inNumberValue ;
                    value += btn.getText().toString();
                    inNumber.setText( value );
                    readyForNextOp = false;
                }
                break;
        }
    }

    private void calcule(String newOp, String newNum) {
        opStack.pushNumber(newNum);
        String res = opStack.equal();
        opStack.pushOperation(newOp);
        inNumber.setText(res);
        inOperation.setText(opStack.getExpretion());
        readyForNextOp = true ;
    }
}