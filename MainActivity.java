package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText; // импорт виджетов для их использования, какие есть на форме - те и писать, лишние не надо
import android.widget.TextView; // без этого указания не получится их использовать
import android.app.AlertDialog; // это нужно для уведомления
import android.content.DialogInterface; // и это тоже

public class MainActivity extends AppCompatActivity {

    // всё что ниже - объявление элементов для использования и указание как они будут называться
    // если на форме несколько одинаковых элементов (например кнопок), всё равно нужно объявить все
    // например, если на форме 2 кнопки, нужно написать Private button button1 и Private button button2,
    // где первые 2 слова обозначают сам элемент, а третье - его название (здесь необязательно точно такое же,
    // какое и айди в activity_main.xml) f
    //
    private EditText firstNumber;
    private EditText secondNumber;
    private EditText thirdnumber;
    private EditText fourthnumber;
    private Button button;
    private Button button2;
    private TextView textView; // добавил 

    @Override //эти строчки должны появиться автоматически, но если их не будет - копипируйте
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // R.layout.activity_main - название места, из которого берутся все элементы, если у вас будет другое название - меняется только последнюю строчку, которая activity_main

        // Инициализация виджетов
        firstNumber = findViewById(R.id.edittext1); // указывание названия на определенный элемент, чтобы избежать путаницы
        secondNumber = findViewById(R.id.edittext2); // здесь secondNumber - из верхних строчек, где изначально указывалось название
        thirdnumber = findViewById(R.id.edittext3); // дальше после знака = указывается какой именно это будет элемент, здесь уже нужно указывать айди из activity_main.xml
        fourthnumber = findViewById(R.id.edittext4); // например, если кнопка была обозначена как android:id="@+id/kapopa", то и в скобках нужно будет его указать
        button = findViewById(R.id.button1); // пример: button = findViewById(R.id.kapopa)
        button2 = findViewById(R.id.button2); // findViewById и R.id. ОБЯЗАТЕЛЬНЫ, после последней точки уже указывать свой айди
        textView = findViewById(R.id.textview); // тоже добавил
        button2.setOnClickListener(new View.OnClickListener() { // здесь указывается обработчик события, прям как в шарпе
            @Override                                           // это уже можно просто скопировать и вставить себе
            public void onClick(View v) { perehod(); } // строчка { perehod(); } обозначает типа название класса для
});                                                    // будущего использования, нужно будет perehod поменять на любое своё
        // Установить обработчик нажатия на кнопку
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skritie();
            }
        });
    }

    private void skritie() {  // здесь уже применяется сам класс, который был назван выше, и дальше всё что ниже - сам код
                              // нужный код можно наклянчить у чатгпт или гемини (лучше гемини, она лучше кодит - gemini.google.com,
                              // но все равно нужен будет впн и авторизация через гугл аккаунт)
                              // чтоб попросить нормальный код, например для расчета двух значений из двух полей для ввода, лучше написать примерно чето такое:
                              // Android Studio Java: у меня в проекте есть 3 EditText'a и 1 button, мне нужно чтобы по нажатию кнопки происходило складывание -- или умножение, или вычитание -- введенных пользователем чисел,
                              // и ответ присваивался в третий EditText
        String firstNumberText = firstNumber.getText().toString(); // объявление переменных для их использования
        String secondNumberText = secondNumber.getText().toString(); // этой тоже

        if (!firstNumberText.isEmpty() && !secondNumberText.isEmpty()) { // проверка полей на отсутствие текста в них
            double number1 = Double.parseDouble(firstNumberText); // объявление переменной намбер1 и приравнивания пользовательского значения для неё
            double number2 = Double.parseDouble(secondNumberText); // тоже 
            double result = number1 + number2; // результат

            textView.setText("Result: " + result); // установка результата в текствиувиу
        } else { // иначе если поля для ввода пустые, то объявится мистор уведомление
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); 
            builder.setTitle("Ошибка"); // заголовок 
            builder.setMessage("Введите оба значения."); // текст

            // Добавление кнопки OK
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Действие при нажатии на кнопку OK
                    dialog.dismiss(); // Закрыть диалоговое окно
                }
            });

            // Отображение диалогового окна
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    private void perehod() {
        if (thirdnumber.getVisibility() == View.VISIBLE && fourthnumber.getVisibility() == View.VISIBLE) { // для выполнения условия, нада сначала прописать GETVisibility, чтобы жава поняла чо нужно ей сделать
            thirdnumber.setVisibility(View.INVISIBLE);                                                     // потом уже делать SETVisibility, шобы жава установила нужную видимость
            fourthnumber.setVisibility(View.INVISIBLE);
        }
        else {
            thirdnumber.setVisibility(View.VISIBLE);
            fourthnumber.setVisibility(View.VISIBLE); // пример как менять видимость одного и того же элемента, в данном случае два элемента можно скрывать и показывать одним нажатием
                                                      // типа как passwordbox в шарпе
        }
    }
}
