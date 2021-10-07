package ru.geekbrains.homework4;

// Карта здесь не перевёрнута, как было в примере на уроке:
// мне показалось, как то привычнее в стандартном варианте;
// текст для ходов написан соответствующим образом.
// Ниже выполнение задания по пунктам 1 - 3*. Пункт 4*** (бот) не реализовывался.

import java.util.Random;
import java.util.Scanner;

public class MainApp {
    private static Scanner scanner;
    private static Random random;

    private static char[][] map;

    private static final int SIZE = 5;
    private static final int STOP = 4;

    private static final char MAP_BLANK = '_';
    private static final char MAP_X = 'X';
    private static final char MAP_0 = '0';


    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        random = new Random();
        initMap();
        printMap();
        while (true) {
            playerTurn();
            printMap();
            if(checkWinLinear(MAP_X) || checkWinDiagonal(MAP_X)) {
                System.out.println("Игра окончена: Вы победили!");
                break;
            }
            if(isMapFull()) {
                System.out.println("Игра окончена: ничья!");
                break;
            }
            aiTurn();
            printMap();
            if(checkWinLinear(MAP_0) || checkWinDiagonal(MAP_0)) {
                System.out.println("Игра окончена: Вы проиграли!");
                break;
            }
            if(isMapFull()) {
                System.out.println("Игра окончена: ничья!");
                break;
            }
        }
    }

    public static boolean checkWinLinear(char el) {
        int hor = 0;
        int ver = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] != el) {
                    hor = 0;
                } else {
                    hor++;
                    if (hor == STOP) {
                        return true;
                    }
                    if (j == SIZE - 1) hor = 0;
                }
                if (map[j][i] != el) {
                    ver = 0;
                } else {
                    ver++;
                    if (ver == STOP) {
                        return true;
                    }
                    if (j == SIZE - 1) ver = 0;
                }
            }
        }
        return false;
    }

    public static boolean checkWinDiagonal(char el) {
        int dia1 = 0;
        int dia2 = 0;
        for (int i = -SIZE + 1; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((j - i >= 0) && (j - i < SIZE)) {
                    if (map[j][j - i] != el) {
                        dia1 = 0;
                    } else dia1++;
                    if (map[SIZE + i - 1 - j][j] != el) {
                        dia2 = 0;
                    } else dia2++;
                }
                if (dia1 == STOP || dia2 == STOP) {
                    return true;
                }
            }
            dia1 = 0;
            dia2 = 0;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == MAP_BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isMoveValid(x, y));
        map[x][y] = MAP_0;
        System.out.println("Бот походил по горизонтали: " + (x + 1) + ", по вертикали: " + (y + 1));
    }


    public static void playerTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты: цифру по горизонтали, затем цифру по вертикали");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isMoveValid(x, y));
        map[x][y] = MAP_X;
    }

    public static boolean isMoveValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        if (map[x][y] != MAP_BLANK) {
            return false;
        }
        return true;
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+ 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = MAP_BLANK;
            }
        }
    }
}