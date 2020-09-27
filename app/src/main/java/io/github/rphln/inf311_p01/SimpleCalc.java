package io.github.rphln.inf311_p01;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class SimpleCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calc);
    }

    public void onOperationClick(View view) {
        final EditText firstOperand = findViewById(R.id.firstOperand);
        final EditText secondOperand = findViewById(R.id.secondOperand);

        final TextView resultView = findViewById(R.id.result);

        double firstOperandValue = Double.parseDouble(firstOperand.getText().toString());
        double secondOperandValue = Double.parseDouble(secondOperand.getText().toString());

        final Double result;

        switch (view.getTag().toString()) {
            case "add":
                result = firstOperandValue + secondOperandValue;
                break;
            case "subtract":
                result = firstOperandValue - secondOperandValue;
                break;
            case "multiply":
                result = firstOperandValue * secondOperandValue;
                break;
            case "divide":
                result = firstOperandValue / secondOperandValue;
                break;
            default:
                throw new IllegalStateException("Unreachable");
        }

        resultView.setText(String.format(getResources().getString(R.string.result), Util.formatNumber(result)));
    }
}