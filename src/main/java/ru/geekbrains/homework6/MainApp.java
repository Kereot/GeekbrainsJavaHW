package ru.geekbrains.homework6;

import ru.geekbrains.homework6.animals.Animals;
import ru.geekbrains.homework6.animals.Cat;
import ru.geekbrains.homework6.animals.Dog;

public class MainApp {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Рыжик"); // Создал несколько, чтобы было что считать в последнем задании.
        Cat cat2 = new Cat("Когтик");
        Cat cat3 = new Cat("Быстрик");
        Cat cat4 = new Cat("Мотя");
        Dog dog1 = new Dog("Барбос");
        Dog dog2 = new Dog("Шарик");
        Dog dog3 = new Dog("Фуксик");
        Dog dog4 = new Dog("Кокс");
        Dog dog5 = new Dog("Брасик");
        Dog dog6 = new Dog("Пётр");

        cat1.runAnimal(-5);
        cat2.runAnimal(85);
        cat3.runAnimal(450);
        cat4.swimAnimal(5);
        dog1.runAnimal(0);
        dog2.runAnimal(205);
        dog3.runAnimal(550);
        dog4.swimAnimal(0);
        dog5.swimAnimal(5.05);
        dog6.swimAnimal(20.21);

        System.out.println(
                // Я так понимаю, в каждом классе эти методы можно назвать одинаково,
                // и вызов будет отличаться только первой частью до точки.
                // Причём в текущем варианте можно вызвать getCountAnimals() через подкласс.
                // Как обычно делают в таких случаях?
                "Всего животных задействовано: " + Animals.getCountAnimals() + ", из них:" +
                        "\n- котов: " + Cat.getCountCats() + ";" +
                        "\n- псов: " + Dog.getCountDogs() + "."
        );
    }
}
