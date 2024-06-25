package com.yourpackage.main;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumber;
    private EditText secondNumber;
    private EditText resultEditText;
    private Button addButton;
    private Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация виджетов
        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        resultEditText = findViewById(R.id.resultEditText);
        addButton = findViewById(R.id.addButton);
        mySpinner = findViewById(R.id.mySpinner);

        // Настройка Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

        // Установить обработчик нажатия на кнопку Add
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumbers();
            }
        });
    }

    private void addNumbers() {
        String firstNumberText = firstNumber.getText().toString();
        String secondNumberText = secondNumber.getText().toString();

        if (!firstNumberText.isEmpty() && !secondNumberText.isEmpty()) {
            double number1 = Double.parseDouble(firstNumberText);
            double number2 = Double.parseDouble(secondNumberText);
            double result = number1 + number2;

            // Проверка выбранного элемента в Spinner
            String selectedItem = mySpinner.getSelectedItem().toString();
            if (selectedItem.equals("элемент")) {
                result += 50;
            }

            resultEditText.setText(String.valueOf(result));
        } else {
            resultEditText.setText("Please enter both numbers");
        }
    }
}
