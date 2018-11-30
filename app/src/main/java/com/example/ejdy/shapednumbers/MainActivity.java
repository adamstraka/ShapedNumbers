package com.example.ejdy.shapednumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Math.*;

public class MainActivity extends AppCompatActivity {

    public class Number {
        double value;

        public boolean isSquare() {
            if (value <= 0) {
                return false;
            } else {
                if (sqrt(value) % 1 == 0)
                    return true;
                 else
                    return false;
            }
        }

        public boolean isTriangular() {
            if (value <= 0) {
                return false;
            } else {
                if (sqrt(8 * value + 1) % 1 == 0)
                    return true;
                else
                    return false;
            }

        }
    }

    public void buttonPressed (View view){
        EditText number = (EditText) findViewById(R.id.editText);
        String message;

        if (number.getText().toString().isEmpty()) {
            message = "Please enter a number.";
        } else {

            Number num = new Number();
            num.value = Double.parseDouble(number.getText().toString());
            message = number.getText().toString();

            if (num.isSquare() && num.isTriangular()) {
                message += " is triangular and square!";
            } else if (num.isTriangular()) {
                message += " is triangular!";
            } else if (num.isSquare()) {
                message += " is squared!";
            } else {
                message += " is neither triangular or squared!";
            }
        }

        Toast.makeText(this, message , Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
