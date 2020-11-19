package ru.geekbrains.java_three.lesson_c.home;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Reader {

    private static final int pageSize = 1800;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int pageNum = 1;
        do {
            openPage(pageNum);
            pageNum = SCANNER.nextInt();
        } while (pageNum > 0);
        System.out.println("Exit");
    }

    private static void openPage(int page) {
        if (page <= 0) return;

        System.out.println("You are now reading page " + page);
        try (RandomAccessFile raf = new RandomAccessFile("example/book.txt", "r")) {
            raf.seek(page * pageSize - pageSize);
            byte[] b = new byte[pageSize];
            raf.read(b);
            System.out.println(new String(b, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
