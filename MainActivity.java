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
                                // без этого указания не получится их использовать

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
        if (firstNumber.getVisibility() == View.VISIBLE && secondNumber.getVisibility() == View.VISIBLE)
        {
            
        }
    }

    private void perehod() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}
