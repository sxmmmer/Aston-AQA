package org.sxmmer;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1:");
        printThreeWords();
        System.out.println();

        System.out.println("Task 2:");
        checkSumSign();
        System.out.println();

        System.out.println("Task 3:");
        printColor();
        System.out.println();

        System.out.println("Task 4:");
        compareNumbers();
        System.out.println();

        System.out.println("Task 5:");
        twoNumbers(8, 3);
        System.out.println();

        System.out.println("Task 6:");
        intNumber(0);
        System.out.println();

        System.out.println("Task 7:");
        boolNumber(-2);
        System.out.println();

        System.out.println("Task 8:");
        stringNumber("Переданная строка", 3);
        System.out.println();

        System.out.println("Task 9:");
        leapYear(2025);
        System.out.println();

        System.out.println("Task 10:");
        changeNumbers();
        System.out.println();

        System.out.println("Task 11:");
        forArray();
        System.out.println();

        System.out.println("Task 12:");
        numbersLessThanSix();
        System.out.println();

        System.out.println("Task 13:");
        twoDimensionalArr();
        System.out.println();

        System.out.println("Task 14:");
        oneDimensionalArr(5, 7);
        System.out.println();
    }

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(){
        int a = 2;
        int b = 3;
        int sum = a + b;
        if (sum >= 0){
            System.out.println("Сумма положительная");
        } else {
            System.out.printf("Сумма отрицательная");
        }
    }

    public static void printColor(){
        int value = 5;
        if (value <= 0){
            System.out.println("Красный");
        } else if (0 < value & value <= 100){
            System.out.println("Желтый");
        } else if (value > 100){
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers(){
        int a = 43;
        int b = 36;
        if (a >= b){
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean twoNumbers(int a, int b){
        int sum = a + b;
        boolean result = (sum >= 10 && sum <= 20);
        System.out.println(result);
        return result;
    }

    public static void intNumber (int a){
        if (a >= 0){
            System.out.println("Передано положительное число");
        } else {
            System.out.println("Передано отрицательное число");
        }
    }

    public static boolean boolNumber (int a){
        boolean result = (a < 0);
        System.out.println(result);
        return result;
    }

    public static void stringNumber (String str, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    public static boolean leapYear (int a){
        boolean result = (a % 4 == 0 && a % 100 != 0) || (a % 400 ==0);
        System.out.println(result);
        return result;
    }

    public static void changeNumbers(){
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 1){
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void forArray(){
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void numbersLessThanSix(){
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void twoDimensionalArr() {
        int [][] arr = new int [5][5];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if(i == j || i + j == arr.length - 1){
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] oneDimensionalArr(int len, int initialValue){
        int[] arr = new int[len];
        for(int i = 0; i < arr.length; i++){
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
