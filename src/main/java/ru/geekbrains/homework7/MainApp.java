package ru.geekbrains.homework7;

// Во втором задании было указано, что кот может покушать "15-20". Наверно, это просто пример,
// но мне показалось интересным добавить вариативность в их "аппетиты".
// В третьем задании указано создать boolean переменную сытости. Но это ведь то же самое, что сделано на уроке, только наоборот (голод);
// возможно это задание "не знало", что функционал был добавлен во время урока?
// Также в шестом задании было указано сделать метод добавления еды, но не сказано, как его применять.
// Поэтому обычный сеттер мне показался скучным, в итоге сделал метод на повторные кормёжки, пока все коты не наедятся.
// В итоге по этой программе сначала все коты (т.к. изначально все голодные) по очереди идут есть.
// Т.к. потребность в еде разная, а едят только полными порциями (по условиям задания), может сложиться ситуация,
// что следующему по очереди удастся поесть, когда предыдущий останется голодным. В этом нет ничего страшного.
// Когда каждый кот один раз попробовал поесть, пользователю будет предложено доложить еду в тарелку через консоль.
// Если он откажется, или будет введено неверное значение по количеству еды, программа завершится.
// В противном случае голодные коты опять попробуют поесть. И снова запустится предложение добавить еды, если ещё остались голодные коты.

public class MainApp {

    public static void main(String[] args) {
        Cat[] cat = new Cat[5];

        cat[0] = new Cat("Рыжик");
        cat[1] = new Cat("Барсик");
        cat[2] = new Cat("Шустрик");
        cat[3] = new Cat("Портик");
        cat[4] = new Cat("Тортик");

        Plate plate = new Plate(150, 50); // Возможный размер: 100 - 200 вкл.; кол-во еды: 0 - размер вкл.

        int totalFoodShortage = 0;
        boolean checkFoodShortage = false;

        plate.info();

        do {
            for (int i = 0; i < cat.length; i++) {
                cat[i].eat(plate);
                cat[i].info();
                System.out.println();
                totalFoodShortage += cat[i].getFoodShortage();
            } // Я сначала этот цикл вывел в отдельный метод здесь же, но конструкция по общему количеству кода мне показалась более громоздкой, а используется то один раз.
            if (totalFoodShortage != 0) {
                System.out.println(
                "Все голодные коты подошли к миске, но не все поели. Кто-то так и остался голодным!\n" +
                "Всего не хватает " + (totalFoodShortage - plate.getFood()) + "г. еды. Хотите добавить еды в миску?"
                );
                plate.info();
                totalFoodShortage = 0;

                if (plate.addFood()) {
                System.out.println("Голодные коты почуяли еду и устремились к миске.");
                } else break;
            } else checkFoodShortage = true;
        } while (!checkFoodShortage);

        if (checkFoodShortage) {
            System.out.println("Все коты сыты, ура! Можно пойти заняться своими делами.");
        } else {
            System.out.println("У Вас есть более срочные дела, чем искать ещё еды котам. Вы уходите.");
        }
        for (int i = 0; i < cat.length; i++) {
            cat[i].lightInfo();
        }
    }
}