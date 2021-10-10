package ru.geekbrains.homework6.animals;

public class Dog extends Animals {
    private static int countDogs;

    public Dog(String name) {
        super(name);
        maxLandDist = 500;
        maxWaterDist = 10.00;
        fullName = "Пёс " + name;
        countDogs++;
    }

    public static int getCountDogs() {
        return countDogs;
    }
}