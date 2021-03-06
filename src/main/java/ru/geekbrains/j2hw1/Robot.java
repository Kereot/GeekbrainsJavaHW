package ru.geekbrains.j2hw1;

public class Robot implements RunJump {
    private String name;
    private int max_dist;
    private int max_height;

    public Robot (String name) {
        this.name = name;
        this.max_dist = (int) (Math.random() * 400) + 100;
        this.max_height = (int) (Math.random() * 100) + 25;
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

    @Override
    public void ready() {
        System.out.println("Beep bop, my model number is " + name + ". I can run at once up to " + max_dist + " m. and jump up to " + max_height + " cm.");
    }

}