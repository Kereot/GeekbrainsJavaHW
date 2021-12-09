package ru.geekbrains.homework6.animals;

public class Cat extends Animals {
    private static int countCats;

    public Cat(String name) {
        super(name);
        maxLandDist = 200;
        fullName = "Кот " + name;
        countCats++;
    }

    public static int getCountCats() {
        return countCats;
    }

    @Override
    public void swimAnimal(double waterDist) {
        System.out.println(fullName + " отказался заходить в воду. " + waterDist + "м? - кот даже не слушал, в воду он не пойдёт!");
    }
}
