package ru.geekbrains.java_one.lesson_b.home;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Результат выполнения первого пункта
        int[] first = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(changeValues(first)));

        // Результат выполнения втогоро пункта
        int[] second = new int[8];
        System.out.println(Arrays.toString(fillArray(second)));

        // Результат выполнения третьего пункта
        int[] third = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(doubleNumbers(third)));

        // Результат выполнения четвертого пункта
        int[] fourth = new int[] {15, 25, 3, 19, -55, -100, 94, 66, 15, 0, 71};
        System.out.println("Максимальное значение равно " + findMax(fourth) + ", минимальное значение равно " + findMin(fourth));

        // Результат выполнения пятого пункта
        int[][] fifth = new int[5][5];
        System.out.println(Arrays.deepToString(fillDiagonal(fifth)).replace("],", "\n"));

        // Результат выполнения шестого пункта
        int[] sixth = new int[] {10, 1, 2, 3, 4};
        System.out.println(checkBalance(sixth));

        // Результат выполнения седьмого пункта
        int[] seventh = new int[] {3, 5, 6, 1};
        System.out.println(Arrays.toString(shift(seventh, -2)));
    }

//  1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//  С помощью цикла и условия заменить 0 на 1, 1 на 0;
    private static int[] changeValues(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        return array;
    }

//  2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 1 4 7 10 13 16 19 22;
    private static int[] fillArray(int[] array) {
        for (int i = 0, j = 1; i < array.length; i++, j+= 3) {
            array[i] = j;
        }
        return array;
    }

//  3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
    private static int[] doubleNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

//  4. Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
    private static int findMin(int[] array) {
        int min = array[0];
        for (int value: array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    private static int findMax(int[] array) {
        int max = array[0];
        for (int value: array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

//  5. Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
//  заполнить его диагональные элементы единицами, используя цикл(ы);
    private static int[][] fillDiagonal(int[][] array) {
        for (int i = 0, j = 0; i < array.length; i++, j++) {
            array[i][j] = 1;
        }
        return array;
    }

//  6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
//  если в массиве есть место, в котором сумма левой и правой части массива равны.
    private static boolean checkBalance(int[] array) {
        int firstPartSum = 0;
        int sum = 0;

        for (int value: array) {
            sum += value;
        }

        for (int i = 0; i < array.length; i++) {
            firstPartSum += array[i];
            if (firstPartSum == sum - firstPartSum) {
                return true;
            }
        }
        return false;
    }

//  7. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
//  при этом метод должен сместить все элементымассива на n позиций.
    private static int[] shift(int[] array, int n) {
        if (n > 0) { //Если передано положительное число, производим сдвиг вправо
            int lastElement;

            for (int i = 0; i < n; i++) {
                lastElement = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = lastElement;
            }
        } else { //Если передано отрицательное число, сдвигаем влево
            int firstElement;

            for (int i = 0; i < Math.abs(n); i ++) {
                firstElement = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = firstElement;
            }
        }
        return array;
    }
}
