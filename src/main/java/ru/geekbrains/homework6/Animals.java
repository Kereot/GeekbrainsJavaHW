package ru.geekbrains.homework6;

public abstract class Animals {
    protected String name;
    protected String fullName;
    protected int maxLandDist;
    protected double maxWaterDist;
    protected static int countAnimals;

    public Animals(String name) {
        this.name = name;
        countAnimals++;
    }

    public static int getCountAnimals() {
        return countAnimals;
    }

    protected void runAnimal(int landDist) {
        if (landDist <= 0) {
            System.out.println(fullName + " не понял команды и остался на месте.");
        } else if (landDist > maxLandDist) {
            System.out.println(fullName + " пробежал " + maxLandDist + "м, устал и остановился. " + landDist + "м ему не пробежать за один раз.");
        } else {
            System.out.println(fullName + " пробежал " + landDist + "м.");
        }
    }

    protected void swimAnimal(double waterDist) {
        if (waterDist <= 0) {
            System.out.println(fullName + " не понял команды и остался на месте.");
        } else if (waterDist > maxWaterDist) {
            System.out.println(fullName + " проплыл " + maxWaterDist + "м и вылез на берег, почувствовав усталость. " + waterDist + "м ему не проплыть за один раз.");
        } else {
            System.out.println(fullName + " проплыл " + waterDist + "м и вылез на берег.");
        }
    }
}
