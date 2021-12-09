package br.feevale.testcalculatorluis;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    ArrayList<String> math = new ArrayList<>();
    Boolean clearDisplay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.txtDisplay);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(v -> {
            if (getString(R.string.display).equals(display.getText().toString())){
                display.setText("");
            }
        });
    }

    private void updateDisplay(String addString) {
        String temp = display.getText().toString();
        int cursorPosition = display.getSelectionStart();
        String leftString = temp.substring(0, cursorPosition);
        String rightString = temp.substring(cursorPosition);

        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(addString);
        } else {
            display.setText(String.format("%s%s%s", leftString, addString, rightString));
        }
        display.setSelection(cursorPosition + 1);
    }

    public void btnZero (View view)     { if (clearDisplay){ display.setText(""); clearDisplay = false; } updateDisplay("0"); }

    public void btnOne (View view)      { if (clearDisplay){ display.setText(""); clearDisplay = false; } updateDisplay("1"); }

    public void btnTwo (View view)      { if (clearDisplay){ display.setText(""); clearDisplay = false; } updateDisplay("2"); }

    public void btnThree (View view)    { if (clearDisplay){ display.setText(""); clearDisplay = false; } updateDisplay("3"); }

    public void btnFour (View view)     { if (clearDisplay){ display.setText(""); clearDisplay = false; } updateDisplay("4"); }

    public void btnFive (View view)     { if (clearDisplay){ display.setText(""); clearDisplay = false; } updateDisplay("5"); }

    public void btnSix (View view)      { if (clearDisplay){ display.setText(""); clearDisplay = false; } updateDisplay("6"); }

    public void btnSeven (View view)    { if (clearDisplay){ display.setText(""); clearDisplay = false; } updateDisplay("7"); }

    public void btnEight (View view)    { if (clearDisplay){ display.setText(""); clearDisplay = false; } updateDisplay("8"); }

    public void btnNine (View view)     { if (clearDisplay){ display.setText(""); clearDisplay = false; } updateDisplay("9"); }

    public void btnComma (View view)    { if (clearDisplay){ display.setText(""); clearDisplay = false; } updateDisplay(","); }

    public void btnMultiply (View view) { if (clearDisplay){ display.setText(""); clearDisplay = false; } updateDisplay("*"); }

    public void btnDivide (View view)   { if (clearDisplay){ display.setText(""); clearDisplay = false; } updateDisplay("/"); }

    public void btnMinus (View view)    { if (clearDisplay){ display.setText(""); clearDisplay = false; } updateDisplay("-"); }

    public void btnPlus (View view)     { if (clearDisplay){ display.setText(""); clearDisplay = false; } updateDisplay("+"); }

    public void clearButton(View view)  { display.setText(""); }

    public void historyButton(View view) {
        Intent i = new Intent(MainActivity.this, History.class);
        i.putExtra("math", math);
        startActivity(i);
    }

    public void btnEqual (View view) {
        String expression = display.getText().toString();
        expression = expression.replaceAll(",", ".");

        Expression exp = new Expression(expression);
        String result = String.valueOf(exp.calculate());
        printHistory(expression, result);

        clearDisplay = true;
        display.setText(result);
        display.setSelection(result.length());
    }

    public void printHistory (String expression, String result) {
        if (expression.contains("+") || expression.contains("-") || expression.contains("/") || expression.contains("*")){
            math.add(expression + " =\n" + result + "\n");
        }
    }
}