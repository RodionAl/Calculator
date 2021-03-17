package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.example.calculator.R.*;

public class MainActivity extends AppCompatActivity {
    private String stringInput = ""; // строка вводимая пользователем

    private final String sqr = "√";
    private final String multiply = "×";
    private final String div = "÷";
    private final String colorOperator = "#8D54F1";
    private String mainResult = "";  // строка итогового результата.

    private long backPrassedTime;

    private TextView textView_line_input; // для вывода и отображения вводимой пользователем информации
    private TextView textView_line_preview;  // для вывода и отображения предварительного результата;
    private ScrollView scrollView;

    private Toast toastLimit;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        textView_line_input = (TextView) findViewById(id.textView_line_input);
        textView_line_preview = (TextView)findViewById(id.textView2);
        scrollView = (ScrollView) findViewById(id.scrollView1);


        ImageView img_one = (ImageView) findViewById(id.number_one);
        img_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("1");
                }catch (Exception e){ }
            }
        });

        ImageView img_two = (ImageView) findViewById(id.number_two);
        img_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("2");
                }catch (Exception e){ }
            }
        });

        ImageView img_three = (ImageView) findViewById(id.number_three);
        img_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("3");
                }catch (Exception e){ }
            }
        });

        ImageView img_four = (ImageView) findViewById(id.number_four);
        img_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("4");
                }catch (Exception e){ }
            }
        });

        ImageView img_five = (ImageView) findViewById(id.number_five);
        img_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("5");
                }catch (Exception e){}
            }
        });

        ImageView img_six = (ImageView) findViewById(id.number_six);
        img_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("6");
                }catch (Exception e){}
            }
        });

        ImageView img_seven = (ImageView) findViewById(id.number_seven);
        img_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("7");
                }catch (Exception e){ }
            }
        });

        ImageView img_eight = (ImageView) findViewById(id.number_eight);
        img_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("8");
                }catch (Exception e){ }
            }
        });

        ImageView img_zero = (ImageView) findViewById(id.number_zero);
        img_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("0");
                }catch (Exception e){  }
            }
        });

        ImageView img_nine = (ImageView) findViewById(id.number_nine);
        img_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addNumber("9");
                }catch (Exception e){ }
            }
        });

        ImageView img_point = (ImageView) findViewById(id.point);
        img_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addPoint();
                }catch (Exception e){ }
            }
        });

        ImageView img_plus = (ImageView) findViewById(id.plus);
        img_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addOperation("+");
                }catch (Exception e){ }
            }
        });

        ImageView img_minus = (ImageView) findViewById(id.minus);
        img_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addOperation("-");
                }catch (Exception e){ }
            }
        });

        ImageView img_multiply = (ImageView) findViewById(id.multiply);
        img_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addOperation(multiply);
                }catch (Exception e){}
            }
        });

        ImageView img_divide = (ImageView) findViewById(id.divide);
        img_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addOperation(div);
                }catch (Exception e){ }
            }
        });

        ImageView erase = (ImageView) findViewById(id.erase);
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    stringDelNum();
                    printLineOnDisplay();
                }catch (Exception e){ }
            }
        });

        ImageView clear = (ImageView) findViewById(id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    stringInput = "";
                    printLineOnDisplay();
                }catch (Exception e){ }
            }
        });

        // добавляем скобки "(" или ")"
        ImageView parentheses = (ImageView) findViewById(id.parentheses);
        parentheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addBracket();
                }catch (Exception e){ }
            }
        });

        // добавляем скобки корень
        ImageView square_root = (ImageView) findViewById(id.square_root);
        square_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addSqrt();
                }catch (Exception e){ }
            }
        });

        // добавляем скобки корень
        ImageView sign = (ImageView) findViewById(id.sign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addSignBeforeNumber();
                }catch (Exception e){ }
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
                toastLimit = Toast.makeText(getBaseContext(), string.number_limit,
                        Toast.LENGTH_SHORT);
                toastLimit.show();
            }
        }else if(isLastCharacterBracket2()){
            newResultString(multiply + st);  // если последний символ закрывающая скобка, то добавляем с умножением

        }else{
            newResultString(st);

        }
       printLineOnDisplay();
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
        printLineOnDisplay();
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
        printLineOnDisplay();
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
        printLineOnDisplay();
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
        printLineOnDisplay();
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
        printLineOnDisplay();
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


    // системная кнопка назад
    @Override
    public void onBackPressed() {
        if(backPrassedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else {
            backToast = Toast.makeText(getBaseContext(), string.exit,
                    Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPrassedTime = System.currentTimeMillis();
    }

    // выводим добавленные символы на экран
    private void printLineOnDisplay(){
        if(stringInput.length() > 15){   // если строка большая, то уменьшить размер выводимого шрифта
            textView_line_input.setTextSize(30);
        }else {
            textView_line_input.setTextSize(40);
        }

        ArrayList<Integer> list = arrayIndexAllOperator(); // получаем список всех порядковых индексов всех не чисел

        SpannableString text = new SpannableString(stringInput);  // расскрасим все элементы не являющиеся числами в фиолетовый
        if(list.size() > 0){
            int a;
            for(int i = 0; i < list.size(); i++) {
                a = list.get(i);
                text.setSpan(new ForegroundColorSpan(Color.parseColor(colorOperator)), a, a + 1, 0);
            }
        }
        textView_line_input.setText(text, TextView.BufferType.SPANNABLE);
//        scrollView.fullScroll(View.FOCUS_DOWN);
        scrollView.pageScroll(View.FOCUS_DOWN);   // для автоматической прокрутке во время ввода строки
        startCounting(); // считаем строку
    }

    // метод возвращает список состоящий из чисел, которые являются порядковыми индексами элементов в строке stringInput
    // собирает все кроме чисел (точка тоже часть числа и не входит)
    // "(" == 40 ; ")" == 41;
    private ArrayList<Integer> arrayIndexAllOperator(){
        ArrayList<Integer> list = new ArrayList<>();
        int l = stringInput.length();
        char [] chars = stringInput.toCharArray();
        char ch;
        char multCr = multiply.charAt(0);
        char divCh = div.charAt(0);
        char sqrCh = sqr.charAt(0);
            for(int i = 0; i < l; i++){
                ch = chars[i];
                if(ch == 40 || ch == 41 || ch == 43 || ch == 45 || ch == divCh || ch == multCr || ch == sqrCh){
                    list.add(i);
                }
            }

        return list;
    }

    // здесь будет вся логика управления вычислениями, будут последовательно вызываться разные методы считающие результат
    private void startCounting(){
        String res = "";
        double a;
        DecimalFormat dF = new DecimalFormat( "###.###" );
        if(isLastCharacterNumber()|| isLastCharacterBracket2()){
            res = countStringBase(stringInput);
            if(res.length()<15){
                a = Double.parseDouble(res);
                mainResult = dF.format(a);
                textView_line_preview.setTextSize(25);
            }else {
                mainResult = res;
                textView_line_preview.setTextSize(20);
            }
           
            textView_line_preview.setText(mainResult);
        }
        if(isLastCharacterOperator()||isLastCharacterBracket1()||isLastCharacterSqrt()){
            textView_line_preview.setText("");
        }
        if(stringInput.length()<1){
            textView_line_preview.setTextSize(25);
            textView_line_preview.setText(stringInput);
        }
    }


    // метод вычисляет значение полученной строки и возвращает ответ в строковом значении.
    // выполняются только операции умножения, деления, сложения и вычитания.
    // порядок действий не определяется скобками.
    private String countStringBase(String st){
        ArrayList<String> list = parseSring(st);
        boolean isExit = false;
        while (!isExit){   // сначала выполняем все операции умножения и деления
            if(list.contains(multiply) && list.contains(div)){  // пример 6*35:15*2
                int idiv = list.indexOf(div);
                int imul = list.indexOf(multiply);
                if(idiv < imul){
                    double a = Double.parseDouble(list.get(idiv-1));
                    double b = Double.parseDouble(list.get(idiv+1));
                    if(b != 0) {
                        double c = div(a, b);
                        String res = "" + c;
                        list.remove(idiv+1);
                        list.remove(idiv);
                        list.remove(idiv-1);
                        list.add(idiv-1, res);
                    }else{
                        list.removeAll(list);
                        isExit = true;
                        list.add("");
                    }
                }else {
                    double a = Double.parseDouble(list.get(imul-1));
                    double b = Double.parseDouble(list.get(imul+1));
                    double c = mult(a, b);
                    String res = "" + c;
                    list.remove(imul+1);
                    list.remove(imul);
                    list.remove(imul-1);
                    list.add(imul-1, res);
                }
            }else if(list.contains(multiply)){
                int imul = list.indexOf(multiply);
                double a = Double.parseDouble(list.get(imul-1));
                double b = Double.parseDouble(list.get(imul+1));
                double c = mult(a, b);
                String res = "" + c;
                list.remove(imul+1);
                list.remove(imul);
                list.remove(imul-1);
                list.add(imul-1, res);
            }else if(list.contains(div)){
                int idiv = list.indexOf(div);
                double a = Double.parseDouble(list.get(idiv-1));
                double b = Double.parseDouble(list.get(idiv+1));
                if(b != 0) {
                    double c = div(a, b);
                    String res = "" + c;
                    list.remove(idiv+1);
                    list.remove(idiv);
                    list.remove(idiv-1);
                    list.add(idiv-1, res);
                }else{
                    list.removeAll(list);
                    isExit = true;
                    list.add("");
                }
            }else {
                isExit = true;
            }

            if(list.size() <= 1){
                isExit = true;
            }
        }
        isExit = false;
        while (!isExit){  // здесь выполняем операции сложения и вычитания.
            if(list.contains("+")){
                int i = list.indexOf("+");
                double a = Double.parseDouble(list.get(i-1));
                double b = Double.parseDouble(list.get(i+1));
                double c = sum(a, b);
                String res = "" + c;
                list.remove(i+1);
                list.remove(i);
                list.remove(i-1);
                list.add(i-1, res);
            }else if(list.contains("-")){
                int i = list.indexOf("-");
                double a = Double.parseDouble(list.get(i-1));
                double b = Double.parseDouble(list.get(i+1));
                double c = min(a, b);
                String res = "" + c;
                list.remove(i+1);
                list.remove(i);
                list.remove(i-1);
                list.add(i-1, res);
            }else {
                isExit = true;
            }

            if(list.size() <= 1){
                isExit = true;
            }
        }
        String res = list.get(0);
        return res;
    }

    // разбиваем введеную строку на список чисел и операций (без корня)
    private ArrayList<String> parseSring(String st){
        ArrayList<String> list = new ArrayList<>();
        char [] ch = st.toCharArray();
        String s = "";
        char multiplyCh = multiply.charAt(0);
        char divCh = div.charAt(0);

        for(int i = 0; i < ch.length; i++){
            if((ch[i] >= '0' && ch[i] <= '9')){ // если символ число, то наращиваем строку
                s = s + ch[i];
            }else if (ch[i] == '-'){            // если символ минус, то проверяем это оператор минус или знак числа
                if(s.length() < 1) {            // если строка пустая, то значит это знак числа и просто начинаем наращивать строку
                    s = s + ch[i];
                }else{                          // если строка не пустая, то это не может быть знак, значит это оператор
                    list.add(s);                // добавляем то что было в список
                    s = "" + ch[i];             // присваеваем строке оператор минус
                    list.add(s);                // добавляем с список
                    s = "";                     // обновляем строку
                }
            }else if(ch[i] == '+' || ch[i] == multiplyCh || ch[i] == divCh){   // если символ один из: "+", "×", "÷"
                list.add(s);                // добавляем то что было в список
                s = "" + ch[i];             // присваеваем строке оператор минус
                list.add(s);                // добавляем с список
                s = "";                     // обновляем строку
            }
        }
        if(s != ""){           //если последний символ в строке был числом (или знаком скобки), то последнее число не было добавлено в список
            list.add(s);       // добавляем его
            s = "";
        }
        return list;
    }

}