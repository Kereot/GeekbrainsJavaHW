package ru.geekbrains.specialhm3addition;

// Это добавление к ДЗ по 3-му уроку, озвученное на 4-ом или 5-ом занятии:
// сделать заполнение диагоналей квадратного двумерного массива одинарным циклом.
// Таким образом, печать пришлось вывести в отдельный метод.

public class MainApp {
    public static int[][] arr;

    public static void main(String[] args) {
        matrixArr(5);
        printArray();
    }

    public static void matrixArr(int sq) {
        arr = new int[sq][sq];
        for (int i = 0; i < sq; i++) {
            arr[i][i] = 1;
            arr[i][sq - i - 1] = 1;
        }
    }

    public static void printArray() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}