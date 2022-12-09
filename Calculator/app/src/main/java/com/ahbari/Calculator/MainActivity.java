package com.ahbari.Calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.ahbari.Calculator.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ActivityMainBinding binding;
    private CalculatorViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);

        viewModel.getNumberToDisplay().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.inputNumberTv.setText(s);
            }
        });

        viewModel.getExpressionToDisplay().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.operationTv.setText(s);
            }
        });

        binding.button0.setOnClickListener(this);
        binding.button1.setOnClickListener(this);
        binding.button2.setOnClickListener(this);
        binding.button3.setOnClickListener(this);
        binding.button4.setOnClickListener(this);
        binding.button5.setOnClickListener(this);
        binding.button6.setOnClickListener(this);
        binding.button7.setOnClickListener(this);
        binding.button8.setOnClickListener(this);
        binding.button9.setOnClickListener(this);
        binding.buttonAdd.setOnClickListener(this);
        binding.buttonBack.setOnClickListener(this);
        binding.buttonC.setOnClickListener(this);
        binding.buttonSub.setOnClickListener(this);
        binding.buttonMultiplication.setOnClickListener(this);
        binding.buttonModulo.setOnClickListener(this);
        binding.buttonEqual.setOnClickListener(this);
        binding.buttonDot.setOnClickListener(this);
        binding.buttonDivision.setOnClickListener(this);
        binding.buttonClear.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Button btn = (Button) findViewById(view.getId()) ;

        switch (btn.getText().toString()) {
            case "back" :
                viewModel.back();
                break;
            case "C" :
                viewModel.clearAll();
                break;
            case "CE" :
                viewModel.clearInput();
                break;
            case "=" :
                viewModel.equal();
                break;
            case "+" :
            case "-" :
            case "*" :
            case "/" :
            case "%" :
                viewModel.setOperation(btn.getText().toString());
                break;
            default:
                viewModel.addDigit(btn.getText().toString());
                break;
        }

    }

}