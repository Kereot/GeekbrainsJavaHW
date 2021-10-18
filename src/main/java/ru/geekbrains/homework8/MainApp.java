package ru.geekbrains.homework8;

// Задание по ограничению кол-ва попыток (*) оказалось значительно легче сброса, с учётом необходимости обнуления цвета кнопки.
// Как обратиться к конкретной кнопке, если мы их задали сплошным циклом?
// На ум приходит мысль создавать кнопки массивом, тогда у них будет свой индекс.
// Но раз на уроке массив не создавался, захотелось попробовать поработать с тем, что есть.
// В общем, пришлось погуглить различные примеры, покопаться в документации, прежде чем я понял, как добиться правильной работы getComponents().
// Кхм, мне кажется, этому заданию не хватает пары звёздочек :) (или оно не учитывает, что победная кнопка была перекрашена).
// Потом для сравнения я сделал то же самое, но через создание кнопок массивом.
// В итоге, визуально скорость работы (сброса) мне показалась одинаковой. Оставил оба варианта.

public class MainApp {

    public static void main(String[] args) {
        new GameWindow(3); // Кол-во попыток: от 1 до range(10) вкл.

        new AltArrayWindow(3);
    }
}
