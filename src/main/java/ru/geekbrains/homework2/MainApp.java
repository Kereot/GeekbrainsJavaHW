package ru.geekbrains.homework2;

public class MainApp {

    public static void main(String[] args) {
        System.out.println(checkSum(1, 15));
        checkSign(5);
        System.out.println(booleanSign(10));
        printString("Привет!", 3);
        System.out.println(tellYear(2020));
    }

    public static boolean checkSum(int a, int b) {
        return (a + b >= 10 && a + b <= 20);
    }

    public static void checkSign(int a) {
        if (a >= 0) {
            System.out.println("Число положительное (" + a + ")");
        } else {
            System.out.println("Число отрицательное (" + a + ")");
        }
    }

    public static boolean booleanSign(int a) {
        return (a >=0);
    }

    public static void printString(String text, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(text);
        }
    }

    public static boolean tellYear(int a) {
        return (a % 400 == 0 || (a % 4 == 0 && a % 100 != 0));
    }
}
