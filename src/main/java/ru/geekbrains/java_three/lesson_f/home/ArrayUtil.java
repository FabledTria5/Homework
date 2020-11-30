package ru.geekbrains.java_three.lesson_f.home;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayUtil {

    public int[] getAfterFour(int[] array) {

        ArrayList<Integer> integerArrayList =  new ArrayList<>();

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != 4) {
                integerArrayList.add(array[i]);
            } else {
                break;
            }
        }
        if (integerArrayList.size() == array.length) throw new RuntimeException("Incorrect array! Array must contain '4'");

        Collections.reverse(integerArrayList);
        return Ints.toArray(integerArrayList);
    }

    public boolean checkArray(int[] array) {
        boolean hasOnes = false;
        boolean hasTwos = false;
        for (int number : array) {
            if (number == 1) {
                hasOnes = true;
            } else if (number == 4) {
                hasTwos = true;
            } else if (hasOnes && hasTwos) {
                break;
            }
        }
        return hasOnes && hasTwos;
    }
}
