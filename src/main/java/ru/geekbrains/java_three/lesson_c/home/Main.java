package ru.geekbrains.java_three.lesson_c.home;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        firstTask();
        secondTask();
    }

    // Первое задание
    private static void firstTask() {
        try (FileInputStream fis = new FileInputStream(new File("example/first_task.txt"))) {

            byte[] bytes = fis.readAllBytes();
            System.out.println(Arrays.toString(bytes));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Второе задание
    private static void secondTask() {

        try {
            ArrayList<InputStream> all = new ArrayList<>();
            all.add(new FileInputStream(new File("example/1.txt")));
            all.add(new FileInputStream(new File("example/2.txt")));
            all.add(new FileInputStream(new File("example/3.txt")));
            all.add(new FileInputStream(new File("example/4.txt")));
            all.add(new FileInputStream(new File("example/5.txt")));

            SequenceInputStream seq = new SequenceInputStream(Collections.enumeration(all));
            FileOutputStream fos = new FileOutputStream(new File("example/result.txt"));

            fos.write(seq.readAllBytes());

            fos.close();
            seq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
