package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String stringInput = ""; // строка вводимая пользователем

    private final String sqr = "√";
    private final String multiply = "×";
    private final String div = "÷";

    private TextView textView_line_input; // для вывода и отображения вводимой пользователем информации

    private Toast toastLimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_line_input = (TextView) findViewById(R.id.textView_line_input);

        ImageView img_one = (ImageView) findViewById(R.id.number_one);
        img_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("1");
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView img_two = (ImageView) findViewById(R.id.number_two);
        img_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("2");
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView img_three = (ImageView) findViewById(R.id.number_three);
        img_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("3");
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView img_four = (ImageView) findViewById(R.id.number_four);
        img_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("4");
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView img_five = (ImageView) findViewById(R.id.number_five);
        img_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("5");
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView img_six = (ImageView) findViewById(R.id.number_six);
        img_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("6");
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView img_seven = (ImageView) findViewById(R.id.number_seven);
        img_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("7");
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView img_eight = (ImageView) findViewById(R.id.number_eight);
        img_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("8");
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView img_zero = (ImageView) findViewById(R.id.number_zero);
        img_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("0");
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView img_nine = (ImageView) findViewById(R.id.number_nine);
        img_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("9");
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView img_point = (ImageView) findViewById(R.id.point);
        img_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addPoint();
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView img_plus = (ImageView) findViewById(R.id.plus);
        img_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addOperation("+");
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView img_minus = (ImageView) findViewById(R.id.minus);
        img_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addOperation("-");
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView img_multiply = (ImageView) findViewById(R.id.multiply);
        img_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addOperation(multiply);
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView img_divide = (ImageView) findViewById(R.id.divide);
        img_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addOperation(div);
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView erase = (ImageView) findViewById(R.id.erase);
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    stringDelNum();
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        ImageView clear = (ImageView) findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    stringInput = "";
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        // добавляем скобки "(" или ")"
        ImageView parentheses = (ImageView) findViewById(R.id.parentheses);
        parentheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addBracket();
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        // добавляем скобки корень
        ImageView square_root = (ImageView) findViewById(R.id.square_root);
        square_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addSqrt();
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });

        // добавляем скобки корень
        ImageView sign = (ImageView) findViewById(R.id.sign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addSignBeforeNumber();
                    textView_line_input.setText(stringInput);
                }catch (Exception e){

                }
            }
        });
    }


    private double sum(double a, double b){
        return a + b;
    }

    private double min(double a, double b){
        return a - b;
    }

    private double div(double a, double b){
        return a/b;
    }

    private  double mult(double a, double b){
        return a*b;
    }

    // метод добавляет символ к вводимой пользователем строке из цифр и операторов
    private void newResultString(String st){
        stringInput = stringInput + st;
    }

    // метод добавляет в строку число.
    // ограничиваем ввод числа 15 знаков, если больше вывести предупреждение.
    // если последний символ был ")", то перед добавлением числа добавить знак умножения
    private void addNumber(String st){
        if(isLastCharacterNumber()){
            String lastNumber = lastNumber();
            if(lastNumber.length() < 15){
                newResultString(st);
            }else{
                // вывести сообщение что превышена максимальная длинна для числа
                toastLimit = Toast.makeText(getBaseContext(), R.string.number_limit,
                        Toast.LENGTH_SHORT);
                toastLimit.show();
            }
        }else if(isLastCharacterBracket2()){
            newResultString(multiply + st);  // если последний символ закрывающая скобка, то добавляем с умножением
        }else{
            newResultString(st);
        }
    }

    // метод добавляет знак для числа
    // если строка пустая, или стоит оператор (любой), или открывающая скобка то добавить "(-"
    // есили последний символ число, то перед числом проверяем наличие конструкции "(-", если ее нет, то добавить, если есть то убрать это
    // если последний символ закрывающая скобка, то добавить "х(-"
    private void addSignBeforeNumber(){
        int a = stringInput.length();
        if(a == 0 || isLastCharacterSqrt() || isLastCharacterBracket1()){
            newResultString("(-");
        }else if (isLastCharacterOperator()){   // если последний символ "+", "х", "-", или ":", то если не "-" добавляем "(-",
                                                // если же последний минус, проверяем предпоследний. Если он "(", то удаляем последние два символа
                                                // если нет, то добавляем "(-"
            try {
                char a1 = stringInput.charAt(a - 1);
                char a2 = stringInput.charAt(a - 2);
                if (a1 == 45 && a2 == 40) {                   // 45 == "-" 40 == "("
                    stringDelNum();         // т.е. если последние символы были "(-", то просто удаляем их.
                    stringDelNum();
                } else {
                    newResultString("(-");
                }
            }catch (Exception e){}

        }else if(isLastCharacterNumber()){
            String lastNumber = lastNumber();
            if(lastNumber.length() == stringInput.length()){   // если вся строка это одно число, просто добавляем перед ним "(-"
                stringInput = "(-" + lastNumber;
            }else{
                for(int i = 0; i < lastNumber.length(); i++){  // удаляем из строки stringInput последнее число
                    stringDelNum();
                }
                a = stringInput.length();
                try {
                    char a1 = stringInput.charAt(a - 1);
                    char a2 = stringInput.charAt(a - 2);
                    if (a1 == 45 && a2 == 40) {                   // 45 == "-" 40 == "("
                        stringDelNum();         // т.е. если последние символы были "(-", то просто удаляем их.
                        stringDelNum();
                        newResultString(lastNumber);
                    } else {
                        newResultString("(-" + lastNumber);
                    }
                }catch (Exception e){}
            }
        }else if(isLastCharacterBracket2()){
            newResultString(multiply + "(-");
        }

    }

    // метод для добавления в строку операций +, -, *, ÷
    // если до этого не было в строке ни одного символа, то ничего не делать.
    // если последний символ был число, то добавить символ, если последний символ оператор действия
    // то заменить его на новый оператор действия
    // если последний символ ( то ничего не делать, если ) добавить символ
    private void addOperation(String st){
        int a = stringInput.length();
        if(a != 0){
            if(isLastCharacterNumber() || isLastCharacterBracket2()){
                newResultString(st);                             // если последний символ цифра или ")" добавляем операцию
            }else if(isLastCharacterOperator()){                 // если последний символ оператор +, -, :, *
                stringDelNum();                                  // удаляем его
                newResultString(st);                             // заменяем на новый символ
            }
        }
    }

    // метод добавляет конень в строку. если строка пустая добавляем корень.
    // если последний символ опетарор, добавляем корень
    // если последний символ число или ")" добавляем "х√("
    private void addSqrt(){
        int a = stringInput.length();
        if(a == 0 || isLastCharacterOperator() || isLastCharacterBracket1()){
            newResultString(sqr + "(");
        }else if(isLastCharacterNumber() || isLastCharacterBracket2()){
            newResultString(multiply + sqr + "(");
        }
    }

    // метод для добавления скобок в строку
    // если строка пустая, то добавить "("
    // если последний символ оператор +, -, ÷, *, то добавить "("
    // если последний символ цифра и до этого не было скобок, или колличество открывающих равно колличеству закрывающих то добавить "х("
    // если последний символ цифра и до этого была скобка, то добавить ")"
    private void addBracket(){
        int a = stringInput.length();
        char b1 = '(';
        char b2 = ')';
        if(a == 0 || isLastCharacterOperator()|| isLastCharacterBracket1()|| isLastCharacterSqrt()){  // если не было символов или последний символ оператор или последний символ "("или последний символ корень
            newResultString("(");
        }else if(isLastCharacterNumber()){
            if((countCharacters(b1) - countCharacters(b2)) == 0){   // если скобок не было или количество открывающих == количеству закрывающих
                newResultString(multiply + "(");
            }else if(countCharacters(b1) > countCharacters(b2)){
                newResultString(")");                               // если открывающих больше чем закрывающих и последняя цифра
            }
        }else if(isLastCharacterBracket2()){
            if(countCharacters(b1) > countCharacters(b2)){
                newResultString(")");
            }
        }
    }

    // метод для добавления точки в строку, для ввода дробного числа
    // если в строке нет символов, то ввести "0."
    // если последний символ оператор, то ввести "0."
    // если последний символ "(", то ввести "0."
    // если последний символ ")", то ввести "х0." (умножение на 0. )
    // если последний символ цифра, то добавить "."
    // если последний символ "." ничего не делаем
    private void addPoint(){
        int a = stringInput.length();
        if(a == 0 || isLastCharacterOperator() || isLastCharacterBracket1()){
            newResultString("0.");
        }else if(isLastCharacterBracket2()){
            newResultString(multiply + "0.");
        }else if(isLastCharacterNumber()){
            if(!isMoreOnePoint()) {  // проверяем, не была ли добавлена точка раньше
                newResultString(".");
            }
        }
    }

    // метод проверяет является ли последний символ операцией "+", "-", "÷", "*" у строки stringInput
    // если последний символ один из данных операторов то возвращает true иначе false
    // 43 == "+"; 45 == "-";
    private boolean isLastCharacterOperator(){
        boolean res = false;
        char multCr = multiply.charAt(0);
        char divCh = div.charAt(0);
        if(stringInput.length() != 0) {
            char ch = stringInput.charAt(stringInput.length() - 1);
            if (ch == 43 || ch == 45 || ch == divCh || ch == multCr) {
                res = true;
            }
        }
        return res;
    }

    // метод проверяет является ли последний символ операцией "√" у строки stringInput
    // если последний символ корень то возвращает true иначе false
    private boolean isLastCharacterSqrt(){
        boolean res = false;
        char sqrCr = sqr.charAt(0);
        if(stringInput.length() != 0) {
            char ch = stringInput.charAt(stringInput.length() - 1);
            if (ch == sqrCr) {
                res = true;
            }
        }
        return res;
    }

    // метод проверяет является ли последний символ скобкой "(" у строки stringInput
    // если последний символ скобка возвращает true иначе false
    private boolean isLastCharacterBracket1(){
        boolean res = false;
        if(stringInput.length() != 0) {
            char ch = stringInput.charAt(stringInput.length() - 1);
            if (ch == 40) {
                res = true;
            }
        }
        return res;
    }

    // метод проверяет является ли последний символ скобкой ")" у строки stringInput
    // если последний символ скобка возвращает true иначе false
    private boolean isLastCharacterBracket2(){
        boolean res = false;
        if(stringInput.length() != 0) {
            char ch = stringInput.charAt(stringInput.length() - 1);
            if (ch == 41) {
                res = true;
            }
        }
        return res;
    }

    // метод проверяет является ли последний символ цифрой от 0 до 9 у строки stringInput
    // если последний символ цифра возвращает true иначе false
    private boolean isLastCharacterNumber(){
        boolean res = false;
        if(stringInput.length() != 0) {
            char ch = stringInput.charAt(stringInput.length() - 1);
            if (ch >= 48 && ch <= 57) {
                res = true;
            }
        }
        return res;
    }

    // метод удаляет последний символ из строки
    private void stringDelNum(){
        int a = (stringInput.length()) - 1;
        if(a >= 0) {
            String st = new StringBuilder(stringInput).deleteCharAt(a).toString();
            stringInput = st;
        }
    }

    // метод проверяет на наличие у числа более чем одной "." Если точек нет вернет false (то что нужно)
    // если же точка к текущему числу уже была добавлена, то вернет true
    private boolean isMoreOnePoint() {
        boolean res = false;
        char[] chars = stringInput.toCharArray();
        int i = chars.length - 2;  // будем рассматривать с предпоследнего символа
        boolean isExit = false;
        char multCr = multiply.charAt(0);
        char divCr = div.charAt(0);

        while (!isExit) {
            if (i >= 0) {
                if (chars[i] == 46) {  //  если символ "."
                    res = true;
                    isExit = true;
                    // если символ один из операторов +, -, ÷, х.
                } else if (chars[i] == 43 || chars[i] == 45 || chars[i] == divCr || chars[i] == multCr) {
                    isExit = true;
                }
                i--;
            } else {
                isExit = true;
            }
        }

        return res;
    }

    // метод возвращает строку - последнее число из строки stringInput
    private String lastNumber(){
        String st1 = "";
        char [] chars = stringInput.toCharArray();
        int a = chars.length;
        boolean isExit = false;
        char ch;
        if(isLastCharacterNumber()) {
            while (!isExit) {
                if (a > 0) {
                    ch = chars[a - 1];
                    if ((ch >= 48 && ch <= 57) || ch == 46) {
                        st1 = st1 + ch;
                    } else {
                        isExit = true;
                    }
                    a--;
                } else {
                    isExit = true;
                }
            }
        }
        String res = new StringBuilder(st1).reverse().toString();

        return res;
    }

    // метод возвращает колличество символов ch (приходящих в качестве параметра) в строке stringInput
    private int countCharacters(char ch){
        int res = 0;
        char [] chars = stringInput.toCharArray();
        int a = chars.length;
        for(int i = 0; i < a; i++){
            if(chars[i] == ch){
                res ++;
            }
        }
        return res;
    }
}