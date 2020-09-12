package ru.geekbrains.java_one.lesson_c.home;

import java.util.Random;
import java.util.Scanner;

public class MainClass {

    public static int SIZE;
    public static int DOTS_TO_WIN;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {

        System.out.print("Приветствуем вас в игре крестики-нолики! Выберите размер поля: ");
        SIZE = sc.nextInt();

        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symbol) {
        //По умолчанию перменные счетчики для строк, столбцов и главных диагоналей равны 1, т.к. кол-во проверок в циклах всегда на 1 меньше стоящих в ряд символов
        int row = 1;
        int column = 1;
        int leftMainDia = 1;
        int rightMainDia = 1;

        for (int i = 1; i <= SIZE; i++) {

            //Просматривает таблицу на наличие заданного символа в строках и столбцах
            for (int j = 1; j <= SIZE - 1; j++) {
                row = (map[i - 1][j] == symbol && map[i - 1][j] == map[i - 1][j - 1]) ? row + 1 : row;
                column = (map[j][i - 1] == symbol && map[j][i - 1] == map[j - 1][i - 1]) ? column + 1 : column;
            }

            // Подсчет нужных символов в двух главных диагоналях. В отдельный цикл вынесено из-за сложности с интеграцией с главной переменной цикла
            for (int d = 0; d < SIZE - 1; d++) {
                leftMainDia = (map[d][d] == symbol && map[d][d] == map[d + 1][d + 1]) ? leftMainDia + 1 : leftMainDia;
                rightMainDia = (map[d][SIZE - 1 - d] == symbol && map[d][SIZE - 1 - d] == map[d + 1][SIZE - 2 - d]) ? rightMainDia + 1 : rightMainDia;
            }

            if (SIZE > 3) { //Если размер поля больше 3, то проверяем 4 побочные диагонали, на которых может образоваться линия

                int upSecondaryLeftDia = 0;
                int dwnSecondaryLeftDia = 0;
                int dwnSecondaryRightDia = 0;
                int upSecondaryRightDia = 0;

                for (int k = 0; k < SIZE - 1; k++) {
                    dwnSecondaryLeftDia = (map[k][k + 1] == symbol) ? dwnSecondaryLeftDia + 1 : dwnSecondaryLeftDia;
                    upSecondaryLeftDia = (map[k + 1][k] == symbol) ? upSecondaryLeftDia + 1 : upSecondaryLeftDia;

                    upSecondaryRightDia = (map[k][SIZE - 2 - k] == symbol) ? upSecondaryRightDia + 1 : upSecondaryRightDia;
                    dwnSecondaryRightDia = (map[k + 1][SIZE - 1 - k] == symbol) ? dwnSecondaryRightDia + 1 : dwnSecondaryRightDia;
                }

                // Если найдено нужное кол-во символов в побочной диагонали, возвращаем true
                if (dwnSecondaryLeftDia == DOTS_TO_WIN || upSecondaryLeftDia == DOTS_TO_WIN || dwnSecondaryRightDia == DOTS_TO_WIN || upSecondaryRightDia == DOTS_TO_WIN) return true;
            }

            //Если найдено нужное ко-во символов в строке, столбце или диагонали, выдаем true
            if (row >= DOTS_TO_WIN || column >= DOTS_TO_WIN || leftMainDia >= DOTS_TO_WIN || rightMainDia >= DOTS_TO_WIN) {
                return true;
            } else { //Обнуление переменных для корректной работы следующей итерации цикла
                row = 1;
                column = 1;
                leftMainDia = 1;
                rightMainDia = 1;
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        DOTS_TO_WIN = (SIZE > 3) ? SIZE - 1 : SIZE;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
