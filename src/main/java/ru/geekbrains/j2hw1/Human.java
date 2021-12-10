package ru.geekbrains.j2hw1;

public class Human implements RunJump {
    private String name;
    private int max_dist;
    private int max_height;

    public Human (String name) {
        this.name = name;
        this.max_dist = (int) (Math.random() * 50) + 50;
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
        System.out.println("Hello, my name is " + name + ". I can run at once up to " + max_dist + " m. and jump up to " + max_height + " cm.");
    }

//    @Override
//    public void run(Track track) {
//        System.out.println(name + " attempted to run " + track.getDist() + " m.");
//        System.out.println("At once they can probably run " + max_dist + " m.");
//    }
//
//    @Override
//    public void jump (Wall wall) {
//        System.out.println(name + " attempted to jump up " + wall.getHeight() + " cm.");
//        System.out.println("At best they can jump up to " + max_dist + " cm.");
//    }

}