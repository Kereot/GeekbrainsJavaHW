package ru.geekbrains.homework5;

public class MainApp {

    public static void main(String[] args) {

        Employee[] staffArr = new Employee[5];

        staffArr[0] = new Employee(
                "Виктор Кант",
                "Редактор",
                "kant_v@geekbrains.com",
                "+1 123 98 658",
                69750.25,
                48
        );
        staffArr[1] = new Employee(
                "Карл Габсбург",
                "Директор",
                "boss@geekbrains.com",
                "+1 123 11 110",
                260000.01,
                53
        );
        staffArr[2] = new Employee(
                "Петр Печкин",
                "Секретарь",
                "pechkin@geekbrains.com",
                "+1 123 71 963",
                45000.00,
                22
        );
        staffArr[3] = new Employee(
                "Лев Шульц",
                "Бухгалтер",
                "lion@geekbrains.com",
                "+1 123 55 087",
                75254.50,
                39
        );
        staffArr[4] = new Employee(
                "Игорь Крутой",
                "Менеджер",
                "igorthecool@geekbrains.com",
                "+1 123 99 555",
                45000.00,
                27
        );

        for (int i = 0; i < staffArr.length; i++) {
            if (staffArr[i].getAge() > 40) {
                staffArr[i].showEmployeeInfo();
                System.out.println();
            }
        }
    }
}
