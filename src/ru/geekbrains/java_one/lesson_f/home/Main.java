package ru.geekbrains.java_one.lesson_f.home;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final String[] dictionary = {"Кот ", "Собака ", "Дрога ", "Дом ", "Небо ", " Солнце ", "Самолет ", "Море ", "Природа ", "Программа ", "Музей "};

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createFiles(2, 200);
        unitFiles();
    }

    private static void createFiles(int quantity, int symbols) {
        for (int i = 0; i < quantity; i++) {
            try {
                FileOutputStream fos = new FileOutputStream("file" + (i + 1) + ".txt", true);

                fos.write(("Начало " + (i + 1) + " файла: ").getBytes());

                String word;

                for (int j = 0; j < 10; j++) {
                    word = dictionary[(int) (Math.random() * dictionary.length)];
                    fos.write(word.getBytes());
                }

                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void unitFiles() {
        System.out.print("Сколько файлов вы хотите объединить? ");
        int num = scanner.nextInt();
        String[] files = new String[num];

        scanner.nextLine();

        for (int i = 0; i < num; i++) {
            System.out.println("Введите название " + (i + 1) + "-го файла: ");
            files[i] = scanner.nextLine();
        }

        for (String file : files) {
            try {
                StringBuilder sb = new StringBuilder();
                PrintStream ps = new PrintStream(new FileOutputStream("file" + (files.length + 1) + ".txt", true));
                Scanner fileScanner = new Scanner(new FileInputStream(file));

                while (fileScanner.hasNextLine()) {
                    sb.append(fileScanner.nextLine());
                }

                ps.println(sb);
                ps.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
