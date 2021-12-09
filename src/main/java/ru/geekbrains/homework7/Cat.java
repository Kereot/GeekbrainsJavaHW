package ru.geekbrains.homework7;

public class Cat {
    private String name;
    private int appetite;
    private boolean isHungry;
    private int foodShortage;



    public Cat(String name) {
        this.name = name;
        this.appetite = (int) (Math.random() * 15) + 15; // У котов каждый раз разная потребность в еде. Так интереснее :)
        this.isHungry = true;
    }

    public int getFoodShortage() {
        return foodShortage;
    }

    public void info() {
        if (isHungry) {
            System.out.println("Кот " + name + " голоден; кстати, обычно ему надо " + appetite + "г. еды.");
        } else System.out.println("Кот " + name + " сыт; кстати, обычно ему надо " + appetite + "г. еды.");
    }

    public void lightInfo() {
        if (isHungry) {
            System.out.println("Кот " + name + " голоден.");
        } else System.out.println("Кот " + name + " сыт.");
    }

    public void eat(Plate plate) {
        if (isHungry) {
            if (plate.getFood() < appetite) {
                foodShortage = appetite; // Эта переменная позволяет просто считать нужное количество еды для оставшегося голодным кота, а в дальнейшем и общее количество еды, которой не хватает.
                System.out.println(
                        "Недостаточно еды в миске, кот " + name + " требует полную порцию!\n" +
                                "Этому коту нужно доложить в миску ещё " + (appetite - plate.getFood()) + "г. еды."
                );
            } else {
                plate.decreaseFood(appetite);
                isHungry = false;
                foodShortage = 0;
                System.out.println("Кот " + name + " поел из миски.");
            }
        }
    }


}
