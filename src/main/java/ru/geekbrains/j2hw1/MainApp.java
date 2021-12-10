package ru.geekbrains.j2hw1;

public class MainApp {
    public static void main(String[] args) {

        RunJump[] exercises = {
            new Cat ("Barsik"),
            new Cat ("Murzik"),
            new Robot ("R2D2"),
            new Robot ("C3P0"),
            new Human ("Jack"),
            new Human ("Julia")
        };

        Action[] action = {
                new Track (10),
                new Wall (25),
                new Track (110),
                new Wall (15),
                new Track (35),
                new Wall (45)
        };

        for (int i = 0; i < exercises.length; i++) {
            System.out.println();
            exercises[i].ready();
            for (int j = 0; j < action.length; j++) {
                action[j].activity();
                if ((exercises[i].getMax_dist() > action[j].getDist() && action[j].getHeight() == -1) || (exercises[i].getMax_height() > action[j].getHeight() && action[j].getDist() == -1)) {
                    System.out.println("I made it!");
                } else {
                    System.out.println("Nah, I will go rest");
                    break;
                }
            }
        }
    }
}
