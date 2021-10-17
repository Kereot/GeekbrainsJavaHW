package ru.geekbrains.homework7;

import java.util.Scanner;

public class Plate {
    private int food;
    private int size;

    public Plate(int size, int food) {
        // Границы по объёму тарелки и стартовому количеству еды. Работает и при простом полном создании тарелки в psvm,
        // более актуально, конечно, при добавлении ввода этих параметров из консоли, например.
        if (size < 100) {
            this.size = 100;
        } else if (size > 200) {
            this.size = 200;
        } else this.size = size;
        if (food < 0) {
            this.food = 0;
        } else if (food > this.size) {
            this.food = this.size;
        } else this.food = food;
    }

    public void info() {
        System.out.printf("В миске находится %dг. еды.\n", food);
    }

    public void decreaseFood(int food) {
        if (food <= this.food) {
            this.food -= food;
        } else { // Сейчас это не актуально, в текущем варианте кот не может попытаться съесть больше; на случай добавления / изменения функционала.
            this.food = 0;
            System.out.println("Нельзя забрать то, чего нет; в миске не осталось еды");
        }
    }

    public int getFood() {
        return food;
    }

    public boolean addFood() {
        System.out.println("Наберите 'да' / 'д' / 'yes' / 'y', чтобы добавить еды, или что угодное другое, чтобы уйти и заняться своими делами");
        Scanner sc = new Scanner(System.in);
        String decision = sc.nextLine();
        if (decision.equalsIgnoreCase("да") || decision.equalsIgnoreCase("д") || decision.equalsIgnoreCase("yes") || decision.equalsIgnoreCase("y") || decision.equalsIgnoreCase("у")) {
            System.out.println(
                    "Укажите, сколько граммов еды Вы хотите положить в миску.\n" +
                    "Пожалуйста, введите целое положительное число.\n" +
                    "Помните, в миску не поместится больше " + size + "г. еды"
            );
            int food = sc.nextInt();
            if (food > (size - this.food)) {
                this.food = size;
                System.out.println("Вы очень щедры, но так как в миску помещается не более " + size + "г. еды, Вы убираете лишнее.");
                return true;
            } else if (food <= 0) {
                System.out.println("Вы всё-таки решили не давать еду или даже забрать оставшуюся, но кота баснями не накормишь...");
                return false;
            } else {
                this.food += food;
                System.out.println("Вы добавили " + food + "г. еды в миску.");
                return true;
            }
        } else {
            return false;
        }
    }
}
