package ru.geekbrains.j2hw5;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        oneCore();
    }

    public static void oneCore() {
        final int SIZE = 10000000;
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
