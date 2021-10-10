package ru.geekbrains.homework6.animals;

public abstract class Animals { // Абстрактный, чтобы нельзя было напрямую создать представителя класса.
    protected String name;
    protected String fullName; // Добавил это, чтобы текстовый вывод был более наглядным.
    protected int maxLandDist;
    protected double maxWaterDist;
    private static int countAnimals;

    protected Animals(String name) { // Здесь вообще имеет значение инкапсуляция пока доступно для подклассов? Что ставят обычно?
        this.name = name;
        countAnimals++;
    }

    public static int getCountAnimals() {
        return countAnimals;
    }

    public void runAnimal(int landDist) {
        if (landDist <= 0) {
            System.out.println(fullName + " не понял команды и остался на месте.");
        } else if (landDist > maxLandDist) {
            System.out.println(fullName + " пробежал " + maxLandDist + "м, устал и остановился. " + landDist + "м ему не пробежать за один раз.");
        } else {
            System.out.println(fullName + " пробежал " + landDist + "м и остановился.");
        }
    }

    public void swimAnimal(double waterDist) {
        if (waterDist <= 0) {
            System.out.println(fullName + " не понял команды и остался на месте.");
        } else if (waterDist > maxWaterDist) {
            System.out.println(fullName + " проплыл " + maxWaterDist + "м и вылез на берег, почувствовав усталость. " + waterDist + "м ему не проплыть за один раз.");
        } else {
            System.out.println(fullName + " проплыл " + waterDist + "м и вылез на берег.");
        }
    }
}
