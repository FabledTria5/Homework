package ru.geekbrains.java_one.lesson_b.home;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] first = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0}; //Первый пункт
        for (int i = 0; i < first.length; i++) {
            if (first[i] == 0) {
                first[i] = 1;
            } else {
                first[i] = 0;
            }
        }

        System.out.println(Arrays.toString(first));

        int[] second = new int[8]; //Второй пункт
        for (int i = 0, j = 0; i < second.length; i++, j+= 3) {
            second[i] = j;
        }

        System.out.println(Arrays.toString(second));

        int[] third = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; //Третий пункт
        for (int i = 0; i < third.length; i++) {
            if (third[i] < 6) {
                third[i] *= 2;
            }
        }

        System.out.println(Arrays.toString(third));

        int[][] fourth = new int[5][5]; //Четвертый пункт
        for (int i = 0, j = 0; i < fourth.length; i++, j++) {
            fourth[i][j] = 1;
        }

        System.out.println(Arrays.deepToString(fourth).replace("],", "\n"));

        int[] fifth = new int[] {15, 25, 3, 19, -55, -100, 94, 66, 15, 0, 71}; //Пятый пункт
        int max = fifth[0];
        int min = fifth[0];
        for (int value : fifth) {
            if (value > max) {
                max = value;
            } else if (min > value) {
                min = value;
            }
        }

        System.out.println("Max = " + max + ", min = " + min);

        //Проверки результатов выполнения функций для пунктов 6 и 7
        int[] arr = new int[] {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(arr));

        int[] arr2 = new int[] {3, 5, 6, 1};
        System.out.println(Arrays.toString(shift(arr2, -2)));
    }

    private static boolean checkBalance(int[] array) { //Шестой пункт
        int firstPartSum = 0;
        int secondPartSum = 0;
        for (int i = 0; i < array.length; i++) {
            firstPartSum += array[i];
            for (int j = i + 1; j < array.length; j++) {
                secondPartSum += array[j];
            }
            if (firstPartSum == secondPartSum) {
                return true;
            }
            secondPartSum = 0;
        }
        return false;
    }

    private static int[] shift(int[] array, int n) { //Седьмой пункт

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
