package ru.geekbrains.java_three.lesson_a.home;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static final Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
    private static final String[] strArray = {"Apple", "Orange", "Banana"};
    private static final Double[] doubleArray = {1.0, 2.5, 3.7, 4.2};

    public static void main(String[] args) {
        arraySwipe();
        createArrayList();
        fruits();
    }

    // Первое задание
    private static void arraySwipe() {
        System.out.println("Изначальный массив: " + Arrays.toString(intArray));
        System.out.println("Изначальный массив: " + Arrays.toString(strArray));
        System.out.println("Изначальный массив: " + Arrays.toString(doubleArray));

        swipeElements(intArray, 0 ,3);
        swipeElements(strArray, 0 ,2);
        swipeElements(doubleArray, 1 ,3);

        System.out.println();

        System.out.println("Массив после отработки метода: " + Arrays.toString(intArray));
        System.out.println("Массив после отработки метода: " + Arrays.toString(strArray));
        System.out.println("Массив после отработки метода: " + Arrays.toString(doubleArray));

        System.out.println();
    }

    private static <T> void swipeElements(T[] arr, int firstIndex, int secondIndex) {
        try {
            T mem = arr[firstIndex];
            arr[firstIndex] = arr[secondIndex];
            arr[secondIndex] = mem;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    // Второе задание
    private static void createArrayList() {
        System.out.println(Arrays.toString(intArray) + " является массивом: " + intArray.getClass());
        System.out.println(getArrayList(intArray) + " является экземпляром: " + getArrayList(intArray).getClass());

        System.out.println();

        System.out.println(Arrays.toString(strArray) + " является массивом: " + strArray.getClass());
        System.out.println(getArrayList(strArray) + " является экземпляром: " + getArrayList(strArray).getClass());

        System.out.println();
    }

    private static <T> ArrayList<T> getArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    // Третье задание
    private static void fruits() {
        Box<Apple> appleBox = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Apple> secondAppleBox = new Box<>(new Apple());
        Box<Orange> orangeBox = new Box<>(new Orange(), new Orange());

        System.out.println("Вес первой коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));
        orangeBox.addFruit(new Orange());

        System.out.println(appleBox.compare(orangeBox));
        appleBox.dropToAnotherBox(secondAppleBox);
    }
}
