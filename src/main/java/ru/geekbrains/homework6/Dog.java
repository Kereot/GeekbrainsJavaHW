package ru.geekbrains.homework6;

public class Dog extends Animals {
    private static int countDogs;

    public Dog(String name) {
        super(name);
        this.maxLandDist = 500;
        this.maxWaterDist = 10.00;
        fullName = "Пёс " + name;
        countDogs++;
    }

    public static int getCountDogs() {
        return countDogs;
    }
}