package br.feevale.testcalculatorluis;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

public class History extends AppCompatActivity {

    TextView displayHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        displayHistory = findViewById(R.id.txtDisplayHistory);
        displayHistory.setMovementMethod(new ScrollingMovementMethod());

        Intent i = getIntent();
        ArrayList<String> mathList = (ArrayList<String>) i.getSerializableExtra("math");

        String math = mathList.toString().replace("[","").replace("]", "").replace(",", "\n");
        displayHistory.setText(math);
    }

    public void backButton(View view){
        finish();
    }
}