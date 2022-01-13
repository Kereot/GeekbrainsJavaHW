package ru.geekbrains.j2hw5;

import java.util.Arrays;

public class MainHalf {
    public static void main(String[] args) {
        doubleCore();
    }

    public static void doubleCore() {
        final int SIZE = 10000000;
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        final int HALF = SIZE / 2;
        float[] firstHalfArr = new float[HALF];
        float[] secondHalfArr = new float[HALF];

        Thread t1 = new Thread(() -> {
            System.arraycopy(arr, 0, firstHalfArr, 0, HALF);
            for (int i = 0; i < firstHalfArr.length; i++) {
                firstHalfArr[i] = (float) (firstHalfArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            System.arraycopy(arr, HALF, secondHalfArr, 0, HALF);
            for (int i = 0; i < secondHalfArr.length; i++) {
                secondHalfArr[i] = (float) (secondHalfArr[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f + (i + HALF) / 5) * Math.cos(0.4f + (i + HALF) / 2));
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(firstHalfArr, 0, arr, 0, HALF);
        System.arraycopy(secondHalfArr, 0, arr, HALF, HALF);

        System.out.println("Double thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
