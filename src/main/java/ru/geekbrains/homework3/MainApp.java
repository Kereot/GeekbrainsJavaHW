package ru.geekbrains.homework3;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        swapBinary();
        numerateHundred();
        doubleSome(6);
        matrixArr(6);
        System.out.println(Arrays.toString(returnArr(5, 3)));
        minMax();
        System.out.println(sumArray(new int[] {2, 2, 2, 1, 2, 2, 9, 12, 10, 1}));
        System.out.println(Arrays.toString(cycleArr(new int[] {1, 5, 7, -3, 2, 9, 11}, -10)));
    }

    public static void swapBinary() {
    int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
        if (arr[i] == 1) {
            arr[i] = 0;
        } else {
            arr[i] = 1;
        }
    }
        System.out.println(Arrays.toString(arr));
    }

    public static void numerateHundred() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(arr[0] + ", " + arr[1] + ", ... , " + arr [98] + ", " + arr[99]);
    }

    public static void doubleSome(int num) {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < num) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void matrixArr(int sq) {
        int[][] arr = new int[sq][sq]; // так как по условию массив квадратный
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j || i == (arr[i].length - j - 1)) { // arr[i].length и arr.length, я так понимаю, в квадратном массиве будут работать одинаково
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] returnArr(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }

    public static void minMax() {
        int[] arr = {10, 12, 9, -7, 0, -9, 27, 11, 10, 21, -3};
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= min) {
                min = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                max = arr[i];
            }
        }
        System.out.println("MIN = " + min + "; MAX = " + max);
    }

    public static boolean sumArray(int[] arr) {
        int left = arr[0];
        int right = arr[arr.length - 1];
// Вообще не очень понял из задания конкретно какая проверка должна быть;
// данному коду достаточно суммы с одной стороны для сравнения с другой стороной,
// т.е. со второй стороны он сначала сравнит с первым значением.
// Если с обеих сторон сравнивать только суммы, то можно немного упростить, записав с left и right
// сразу суммы двух первых (для left) и двух последних (для right) значений из массива
// и соответствующим образом изменив начальные итерации циклов for;
// тогда не нужна будет дополнительная проверка (после ||) в первом условии for-j цикла.
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < (arr.length - i); j++) {
                if (left != right || (arr[0] == arr[arr.length -1] && i == 1)) {
                    right += arr[arr.length - 1 - j];
                    }
                if (left == right) {
                    System.out.println(left + " " + right);
                    return true;
                }
            }
            left += arr[i];
            right = arr[arr.length - 1];
        }
        System.out.println(left + " " + right);
        return false;
    }

    public static int[] cycleArr(int[] arr, int n) {
        if (n % arr.length == 0) {
            return arr;
        } else if (Math.abs(n) > arr.length) {
            n %= arr.length;
        }
        int a, b;
        if (n < 0) {
            a = arr[arr.length - 1];
            for (int i = 0; i > n; i--) {
                for (int j = arr.length - 1; j >= 0; j--) {
                    if (j == 0) {
                        arr[arr.length - 1] = a;
                    } else {
                        b = arr[j - 1];
                        arr[j - 1] = a;
                        a = b;
                    }
                }
            }
        } else {
            a = arr[0];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (j == arr.length - 1) {
                        arr[0] = a;
                    } else {
                        b = arr[j + 1];
                        arr[j + 1] = a;
                        a = b;
                    }
                }
            }
        }
        return arr;
    }
}