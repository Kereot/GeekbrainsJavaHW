package ru.geekbrains.j2hw1;

public class Wall implements Action {
    private int height;
    private int dist = -1;

    public Wall(int height) {
        this.height = Math.max(height, 10);
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getDist() {
        return dist;
    }

    @Override
    public void activity() {
        System.out.println("Now I will try to jump over that wall of " + height + " cm.");
    }
}