package ru.geekbrains.java_two.lesson_e.home;

public class Main {

    private static final int size = 10000000;
    public static final int h = size / 2;

    public static void main(String[] args) {
        System.out.println("Время, затраченное на изменение массива одним потоком равно: " + oneThreadArrayCount() + " миллисекунд");
        try {
            System.out.println("Время, затраченное на изменение массива двумя потоками равно: " + twoThreadArrayCount() + " миллисекунд");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static float oneThreadArrayCount() {
        float[] arr = new float[size];
        fillArray(arr);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
        }

        return (float) (System.currentTimeMillis() - startTime);
    }

    private static double twoThreadArrayCount() throws InterruptedException {
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        fillArray(arr);

        long startTime = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Runnable firstPart = () -> countArrayPart(a1);
        Runnable secondPart = () -> countArrayPart(a2);

        Thread first = new Thread(firstPart, "Count first part");
        Thread second = new Thread(secondPart, "Count second part");

        first.start();
        second.start();
        second.join();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        return (float) (System.currentTimeMillis() - startTime);
    }

    private static void fillArray(float[] arr) {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
    }

    private static void countArrayPart(float[] array) {
        for (int i = 0; i < h; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
        }
    }
}
