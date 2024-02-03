package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final String TAG = "MY_TAG";
    Button button, button2;
    TextView text1;
    TextView text_err;
    TextView editTextText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        // устанавливаем обработчик на кнопку "Начать в потоке"
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1= (TextView) findViewById(R.id.textView3);
                editTextText2 = (TextView) findViewById(R.id.editTextText2);

                String n1 = text1.getText().toString();
                String n2 = editTextText2.getText().toString();
                if (Integer.parseInt(n1) < Integer.parseInt(n2)) {
                    text_err = (TextView) findViewById(R.id.textView6);
                    text_err.setText("На счету недостаточно средств");
                } else {
                    text1.setText(Integer.toString(Integer.parseInt(n1) - Integer.parseInt(n2)));
                }

            }
        });

        // устанавливаем обработчик на кнопку "Начать не в потоке"
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1= (TextView) findViewById(R.id.textView3);
                editTextText2 = (TextView) findViewById(R.id.editTextText2);

                String n1 = text1.getText().toString();
                String n2 = editTextText2.getText().toString();
                text1.setText(Integer.toString(Integer.parseInt(n1) + Integer.parseInt(n2)));
            }
        });
    }
}