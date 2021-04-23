package com.example.calculator;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Calculator {
    private DecimalFormat dF = new DecimalFormat("###.##########");
    public String stringInput;
    public String mainResult;

    private final String SQR = "√";
    private final String MULTIPLY = "×";
    private final String DIVIDE = "÷";

    void startCounting() {
        String res = stringInput;
        double a;
        char ch = res.charAt(res.length() - 1);
        if ((ch >= 48 && ch <= 57) || ch == ')') {  // последний символ число или закрывающая скобка
            while (res.contains(SQR)) {
                res = countStringWithSqrt(res);
            }
            if(!(res.equals("INFINITY") || res.equals("NaN"))) {
                if (res.contains("(")) {
                    res = countForStringWithBracket(res);
                } else {
                    res = countStringBase(res);
                }
            }

            if(res.equals("INFINITY") || res.equals("NaN")) {
                mainResult = res;
            }else {
                a = Double.parseDouble(res);
                mainResult = dF.format(a);
            }
        }
    }

    /** в метод приходит любая строка не содержащая корня, возвращает строку, которая
     является результатом вычисления данной строки.
     */
    private String countForStringWithBracket(String st){
        String resSt = st;
        int numberBracketsOne = countCharacters(st, '(');  // считаем сколько в строке открывающих скобок
        int numberBracketsTwo = countCharacters(st, ')');  // считаем сколько в строке закрывающих скобок
        if(numberBracketsOne > numberBracketsTwo){             // если количество откр и закр скобок не совпадает, то добавляем в конце строки закр скобки
            int a0 = numberBracketsOne - numberBracketsTwo;
            for(int i = 0; i< a0; i++){
                resSt = resSt + ")";
            }
        }
        boolean isExit = false;
        int indEnd =   indEnd = resSt.indexOf(")");  // находим первую закрывающую скобку
        int indBegin = 0;
        while (!isExit){

            // ищем последнюю открывающую скобку индекс которой меньше ind
            String st0 = resSt.substring(0, indEnd);
            indBegin = st0.lastIndexOf("(");
            boolean isExitTwo = false;
            while (!isExitTwo) {
                if (indEnd - indBegin - 2 > 0) {  // если не выполняется, то между скобками один символ, очевидно число
                    String stMid = resSt.substring(indBegin + 2, indEnd); // найденная строка между скобками
                    if (stMid.contains("+") || stMid.contains("-") || stMid.contains(MULTIPLY) || stMid.contains(DIVIDE)) {
                        isExitTwo = true;
                    } else {  // если между скобками было просто отрицательное число, то мы рассматриваем следующую пару скобок
                        indEnd = resSt.indexOf(")", indEnd + 1);
                        indBegin = st0.lastIndexOf("(", indBegin - 1);
                        if(indBegin < 0 && indEnd > 0){
                            st0 = resSt.substring(0, indEnd);
                            indBegin = st0.lastIndexOf("(");
                        }
                    }
                    if(indBegin <= 0){
                        isExitTwo = true;
                    }
                }else {
                    isExitTwo = true;
                }
            }
            if(indEnd >= 0) {
                resSt = countBetweenBrackets(resSt, indBegin, indEnd); // получаем новую строку в которой найденная скобка посчитана и вставленно число на место скобки
            }else{
                resSt = countStringBase(resSt);
            }
            indEnd = resSt.indexOf(")");  // находим снова первую скобку
            if(indEnd < 0){  // если ее нет, выходим из цикла
                isExit = true;
            }
        }

        return  countStringBase(resSt);
    }

    /** в метод приходит строка и индексы а и b для открывающей и закрыв скобки
     необходимо посчитать строку между а и b, вырезать из пришедшей строки кусок со скобками
     поставив вместо него полученный результат
     */
    private String countBetweenBrackets(String st, int a, int b){
        String strBegin = st.substring(0, a);   // копируем часть строки до открывающей скобки
        String strMiddle = st.substring(a+1, b);  // копируем часть строки между открывающей скобкой и закрывающей
        String strEnd = st.substring(b+1);   // копируем часть строки после закрывающей скобки
        String strNewMiddle = countStringBase(strMiddle);  // сткроку которая была в скобках отправляем в метод и считаем
        char ch = strNewMiddle.charAt(0);
        if(ch == '-'&& strBegin.length()>0){
            String st0 = "(" + strNewMiddle + ")";
            strNewMiddle = st0;
        }
        String result = strBegin + strNewMiddle + strEnd;
        return result;
    }

    /** в метод приходит строка содержащая корень. Метод находит первый корень, выделяет часть находящуюся под этим корнем, считает ее
     и возвращает новую строку, подобную изначальной, только вместо корня число - результат вычислений.
     если найденная строка (находящаяся под корнем) содержить еще один (вложенный) корень, то ее отвравляем в этот же метод.
     */
    String countStringWithSqrt(String st) {
        String result = "";  // строка которая будет результатом
        String resSt = st;
        String strMiddle = "";  // строка находящаяся под корнем
        int indexSqr = resSt.indexOf(SQR);  // индекс для первого знака корня
        boolean isExit = false;
        int b1 = 0;                          // счетчик скобок в строке содержащей корень
        char charPostSqr = resSt.charAt(indexSqr + 1);   // символ стоящий после корня
        int indexEnd = indexSqr + 1;                     // индекс для последнего символа в строке под корнем
        String strEnd = "";
        if (charPostSqr == '(') {  // после корня идет открывающая скобка

            while (!isExit) {
                if (resSt.charAt(indexEnd) == '(') {
                    b1++;
                }
                if (resSt.charAt(indexEnd) == ')') {
                    b1--;
                }
                if(b1 == 0){
                    isExit = true;
                    break;
                }
                if (indexEnd + 1 >= resSt.length()) {
                    isExit = true;
                }
                indexEnd++;
            }
            strMiddle = st.substring(indexSqr + 1, indexEnd);    // выделяем строку находящуюся под корнем
            if(strMiddle.contains(SQR)){                         // если данная строка тоже содержит корень, то отправляем ее рекурсивно в этот метод
                strMiddle = countStringWithSqrt(strMiddle);
            }

            if(strMiddle.contains("(")||strMiddle.contains(")")||strMiddle.contains(MULTIPLY)||strMiddle.contains(DIVIDE)||strMiddle.contains("+")||strMiddle.contains("-")) {
                strMiddle = countForStringWithBracket(strMiddle);   // если строка содержит операторы (не является просто числом), считаем ее
            }
            strMiddle = getSqr(strMiddle);   // извлекаем непосредственно корень

            if(strMiddle.equals("NaN")){
                stringInput = "";
                mainResult = "NaN";
                return "NaN";
            }

            if(indexEnd < resSt.length()-1){   // если была строка после корня
                strEnd = st.substring(indexEnd + 1);
            }
        } else {          // после корня идет число
            while (!isExit) {
                if (resSt.charAt(indexEnd) >= '0' && resSt.charAt(indexEnd) <= '9') {
                    indexEnd++;
                }else{
                    isExit = true;
                }

                if ((indexEnd >= resSt.length())) {
                    isExit = true;
                }

            }
            strMiddle = st.substring(indexSqr + 1, indexEnd);
            strMiddle = getSqr(strMiddle);

            if(indexEnd < resSt.length()-1){   // если была строка после корня
                strEnd = st.substring(indexEnd);
            }
        }
        String strBegin = "";
        if(indexSqr > 0){   // если была строка до корня
            strBegin = st.substring(0, indexSqr);
        }

        result = strBegin + strMiddle + strEnd;

        return result;
    }

    /**
     * метод считает квадратный корень из числа, приходящего ввиде строки. Возвращает результат тоже в виде строки.
     */
    String getSqr(String st){
        try {
            Double a = Double.parseDouble(st);
            a = Math.sqrt(a);
            String res = a.toString();
            return res;
        } catch (Exception e) {
            return "NaN";
        }
    }

    /** метод вычисляет значение полученной строки и возвращает ответ в строковом значении.
     * выполняются только операции умножения, деления, сложения и вычитания.
     * порядок действий не определяется скобками.
     */
    private String countStringBase(String st){
        ArrayList<String> list = parseSring(st);
        boolean isExit = false;
        while (!isExit){   // сначала выполняем все операции умножения и деления
            if(list.contains(MULTIPLY) && list.contains(DIVIDE)){  // пример 6*35:15*2
                int idiv = list.indexOf(DIVIDE);
                int imul = list.indexOf(MULTIPLY);
                if(idiv < imul){
                    double a = Double.parseDouble(list.get(idiv-1));
                    double b = Double.parseDouble(list.get(idiv+1));
                    if(b != 0) {
                        double c = div(a, b);
                        String res = String.valueOf(c);
                        list.remove(idiv+1);
                        list.remove(idiv);
                        list.remove(idiv-1);
                        list.add(idiv-1, res);
                    }else{
                        list.removeAll(list);
                        isExit = true;
                        list.add("INFINITY");
                    }
                }else {
                    double a = Double.parseDouble(list.get(imul-1));
                    double b = Double.parseDouble(list.get(imul+1));
                    double c = mul(a, b);
                    String res = String.valueOf(c);
                    list.remove(imul+1);
                    list.remove(imul);
                    list.remove(imul-1);
                    list.add(imul-1, res);
                }
            }else if(list.contains(MULTIPLY)){
                int imul = list.indexOf(MULTIPLY);
                double a = Double.parseDouble(list.get(imul-1));
                double b = Double.parseDouble(list.get(imul+1));
                double c = mul(a, b);
                String res = String.valueOf(c);
                list.remove(imul+1);
                list.remove(imul);
                list.remove(imul-1);
                list.add(imul-1, res);
            }else if(list.contains(DIVIDE)){
                int idiv = list.indexOf(DIVIDE);
                double a = Double.parseDouble(list.get(idiv-1));
                double b = Double.parseDouble(list.get(idiv+1));
                if(b != 0) {
                    double c = div(a, b);
                    String res = String.valueOf(c);
                    list.remove(idiv+1);
                    list.remove(idiv);
                    list.remove(idiv-1);
                    list.add(idiv-1, res);
                }else{
                    list.removeAll(list);
                    isExit = true;
                    list.add("INFINITY");
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
            if(list.contains("-")){
                int i = list.indexOf("-");
                double a = Double.parseDouble(list.get(i-1));
                double b = Double.parseDouble(list.get(i+1));
                double c = sub(a, b);
                String res = String.valueOf(c);
                list.remove(i+1);
                list.remove(i);
                list.remove(i-1);
                list.add(i-1, res);
            }else if(list.contains("+")){
                int i = list.indexOf("+");
                double a = Double.parseDouble(list.get(i-1));
                double b = Double.parseDouble(list.get(i+1));
                double c = add(a, b);
                String res = String.valueOf(c);
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

    /**
     * разбиваем введеную строку на список чисел и операций (без корня)
     */
    private ArrayList<String> parseSring(String st){
        ArrayList<String> list = new ArrayList<>();
        char [] ch = st.toCharArray();
        String s = "";
        char multiplyCh = MULTIPLY.charAt(0);
        char divCh = DIVIDE.charAt(0);

        for(int i = 0; i < ch.length; i++){
            if((ch[i] >= '0' && ch[i] <= '9')|| ch[i] == '.'){ // если символ число, то наращиваем строку
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

    /**
     * Addition operation
     */
    double add(double a, double b) {
        double res = a + b;
        String st = dF.format(res);
        return Double.parseDouble(st);
    }

    /**
     * Subtract operation
     */
    double sub(double a, double b) {
        double res = a - b;
        String st = dF.format(res);
        return Double.parseDouble(st);
    }

    /**
     * Divide operation
     */
    double div(double a, double b) {
        try {
            double res = a / b;
            String st = dF.format(res);
            return Double.parseDouble(st);
        } catch (Exception e) {
            return Double.POSITIVE_INFINITY;
        }
    }

    /**
     * Multiply operation
     */
    double mul(double a, double b) {
        double res = a * b;
        String st = dF.format(res);
        return Double.parseDouble(st);
    }

    // (!!!) метод возвращает колличество символов ch (приходящих в качестве параметра) в строке str
    private int countCharacters(String str, char ch){
        int res = 0;
        char [] chars = str.toCharArray();
        int a = chars.length;
        for(int i = 0; i < a; i++){
            if(chars[i] == ch){
                res ++;
            }
        }
        return res;
    }
}
