package ru.geekbrains.j2hw1;

public class Cat implements RunJump {
    private String name;
    private int max_dist;
    private int max_height;

    public Cat (String name) {
        this.name = name;
        this.max_dist = (int) (Math.random() * 15) + 5;
        this.max_height = (int) (Math.random() * 50) + 100;
    }

    public String getName() {
        return name;
    }

    public int getMax_dist() {
        return max_dist;
    }

    public int getMax_height() {
        return max_height;
    }

    public void ready() {
        System.out.println("I'm a cat, my name is " + name + ". I can run at once up to " + max_dist + " m. and jump up to " + max_height + " cm.");
    }

}
