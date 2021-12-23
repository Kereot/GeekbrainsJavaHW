package ru.geekbrains.j2hw2;

public class MainApp {
    public static void main(String[] args) {

        String[][] myArray = {
                {"11", "12", "13", "14"},
                {"21", "2x2", "23", "24"},
                {"31", "32", "3o3", "34"},
                {"41", "42", "43", "44"},
        };

        try {
            System.out.println(sumThis(myArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        System.out.println("Show must go on");

    }

    public static int sumThis(String[][] arr) throws MyArraySizeException/*, MyArrayDataException*/ {
        int sum = 0;
        int[][] intArr = new int[4][4];
        if (arr.length != 4) {
            throw new MyArraySizeException("Array should be 4x4");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Array should be 4x4");
            }
            for (int j = 0; j < arr.length; j++) {
                try {
                    intArr[i][j] = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) { // по заданию здесь нужно создать кастомное исключение, однако,
//                  throw new MyArrayDataException("Data in row " + (i + 1) + ", column " + (j + 1) + " is not valid");
//                  со строкой выше программа останавливается на первой ошибке, можно обработать в psvm, но метод всё равно будет пропущен.
                    System.err.println("Data in row " + (i + 1) + ", column " + (j + 1) + " is not valid");
//                  а при системном исключении работает отлично с finally, показывает все ошибки, считает сумму по рабочим "ячейкам".
//                  Ниже, по сути, уже не исключение, хотя название как в задании, а просто метод класса, зато работает, как и вариант выше
//                  MyArrayDataException a = new MyArrayDataException();
//                  a.why(i, j);
//                  В общем, у меня не получилось заменить NFE на своё исключение, чтобы цикл не прерывался и finally отрабатывалось,
//                  правда в задании не сказано про продолжение подсчёта, так что, возможно, вариант с throw new и без finally - верный,
//                  и вспомогательный массив можно было бы не создавать... Но такой вариант так скучно повторяет первое исключение...
                } finally {
                    sum += intArr[i][j];
                }
            }
        }
        return sum;
    }
}

