package io.github.rphln.inf311_p01;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompleteCalc extends AppCompatActivity {
    // TODO: Decouple display from the calculation.

    protected static Pattern pattern = Pattern.compile("^(\\d+(?:\\.\\d+)?)(\\x{00D7}|\\x{00F7}|\\x{2212}|\\x{002B})(\\d+(?:\\.\\d+)?)$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_calc);
    }

    public void clear(View view) {
        final EditText visor = findViewById(R.id.visor);
        visor.setText("");
    }

    public void backspace(View view) {
        final EditText visor = findViewById(R.id.visor);

        final String current = visor.getText().toString();
        final int length = current.length();

        if (length == 0) {
            return;
        }

        visor.setText(current.substring(0, length - 1));
    }

    // TODO: Return `Optional<Double>`.
    protected Double evaluate(String expression) {

        final Matcher matcher = pattern.matcher(expression);

        if (matcher.find() == false) {
            return null;
        }

        final double firstOperandValue = Double.parseDouble(matcher.group(1));
        final double secondOperandValue = Double.parseDouble(matcher.group(3));

        switch (matcher.group(2)) {
            case "\u00D7": // ×
                return firstOperandValue * secondOperandValue;
            case "\u00F7": // ÷
                return firstOperandValue / secondOperandValue;
            case "\u2212": // −
                return firstOperandValue - secondOperandValue;
            case "\u002B": // +
                return firstOperandValue + secondOperandValue;
            default:
                throw new IllegalStateException("Unreachable");
        }
    }

    public void equal(View view) {
        final EditText visor = findViewById(R.id.visor);
        final Double result = evaluate(visor.getText().toString());

        if (result == null) {
            Toast toast = Toast.makeText(getApplicationContext(), R.string.operation_invalid, Toast.LENGTH_SHORT);
            toast.show();

            return;
        }

        visor.setText(Util.formatNumber(result));
    }

    // TODO: Decouple display from the calculation.
    public void appendOperator(View view) {
        final EditText visor = findViewById(R.id.visor);
        final Double result = evaluate(visor.getText().toString());

        if (result != null) {
            visor.setText(Util.formatNumber(result));
        }

        visor.append(view.getTag().toString());
    }

    public void appendNumber(View view) {
        final EditText visor = findViewById(R.id.visor);
        visor.append(view.getTag().toString());
    }
}