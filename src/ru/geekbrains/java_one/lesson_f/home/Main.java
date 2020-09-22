package ru.geekbrains.java_one.lesson_f.home;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static final String[] dictionary = {"Кот ", "Собака ", "Дрога ", "Дом ", "Небо ", " Солнце ", "Самолет ", "\n", "Море ", "Природа ", "Программа ", "Музей "};

    private static final Scanner scanner = new Scanner(System.in);
    private static Scanner fileScanner;

    public static void main(String[] args) {
        createFiles(2, 200);
        unitFiles();

        if (isWordInFile("file1.txt", "Небо ")) {
            System.out.println("Искомое слово присутствует в файле");
        } else {
            System.out.println("Файл не содержит искомого слова");
        }

        if (isWordInDirectory(".", "Солнце")) {
            System.out.println("Искомое слово присутствует в каталоге");
        } else {
            System.out.println("Файлы в каталоге не содержат искомого слова");
        }


    }

    // Создать 2 текстовых файла, примерно по 50-100 символов в каждом
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

    // Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
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
                fileScanner = new Scanner(new FileInputStream(file));

                while (fileScanner.hasNextLine()) {
                    ps.print(fileScanner.nextLine() + "\n");
                }

                fileScanner.close();
                ps.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    // Написать метод, который проверяет присутствует ли указанное пользователем слово в файле
    private static boolean isWordInFile(String fileName, String word) {

        try {

            fileScanner = new Scanner(new FileInputStream(fileName));

            while (fileScanner.hasNext()) {
                if (fileScanner.nextLine().toLowerCase().contains(word.toLowerCase())) return true;
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Написать метод, проверяющий, есть ли указанное слово в папке
    private static boolean isWordInDirectory(String directoryName, String word) {
        File directory = new File(directoryName);
        File[] filesInDir = directory.listFiles();

        if (filesInDir == null) return false;

        for (File file : filesInDir) {
            if (file.isFile() && isWordInFile(file.getName(), word)) {
                return true;
            }
        }

        return false;
    }
}
