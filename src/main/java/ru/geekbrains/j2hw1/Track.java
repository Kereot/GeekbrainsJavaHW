package ru.geekbrains.j2hw1;

public class Track implements Action {
    private int dist;
    private int height = -1;

    public Track(int dist) {
        this.dist = Math.max(dist, 1);
    }

    @Override
    public int getDist() {
        return dist;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void activity() {
        System.out.println("Now I will try to run that track of " + dist + " m.");
    }
}


