package ru.geekbrains.java_three.lesson_h.home;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[7][5];
        spiral(arr);
        for (int[] element : arr) {
            System.out.println(Arrays.toString(element));
        }
    }

    private static void spiral(int[][] array) {
        int num = 1;
        int i = 0;
        int j = 0;

        int arrayHeight = array.length, arrayWidth = array[0].length;

        int wall = 0;

        while (num <= arrayHeight * arrayWidth) {
            array[i][j] = num;
            if (i == wall && j < arrayWidth - wall - 1) {
                ++j;
            } else if (j == arrayWidth - wall - 1 && i < arrayHeight - wall - 1) {
                ++i;
            } else if (i == arrayHeight - wall - 1 && j > wall) {
                --j;
            } else {
                --i;
            }

            if ((i == wall + 1) && (j == wall) && (wall != arrayWidth - wall - 1)) {
                ++wall;
            }
            ++num;
        }
    }
}
