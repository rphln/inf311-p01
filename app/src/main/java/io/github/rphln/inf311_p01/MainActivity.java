package io.github.rphln.inf311_p01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSimpleCalculator(View view) {
        Intent it = new Intent(getBaseContext(), SimpleCalc.class);
        startActivity(it);
    }

    public void onCompleteCalculator(View view) {
        Intent it = new Intent(getBaseContext(), CompleteCalc.class);
        startActivity(it);
    }
}