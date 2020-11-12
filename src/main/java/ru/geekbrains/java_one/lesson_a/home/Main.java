package main.java.ru.geekbrains.java_one.lesson_a.home;

public class Main {
    public static void main(String[] args) {
        System.out.println(positiveOrNegative(15));
        System.out.println(hello("Александр"));
        System.out.println(checkYear(400));
        System.out.println(checkYear(2008));
        System.out.println(checkYear(1997));
    }

    private static double calculate(int a, int b, int c, int d) { //Первый пункт задания
        return a * (b + (c / d));
    }

    private static boolean checkSum(int a, int b) { //Второй пункт задания
        return a + b <= 20 && a + b >= 10;
    }

    private static String positiveOrNegative(int num) { //Третий пункт задания
        if (num >= 0) {
            return "Вы ввели положительное число";
        } else {
            return "Вы ввели отрицательное число";
        }
    }

    private static String hello(String name) { //Четвертый пункт задания
        return "Привет, " + name + "!";
    }

    private static String checkYear(int year) { //Пятый пункт задания
        if (year % 400 == 0 || year % 100 != 0 && year % 4 == 0) {
            return "Этот год является високосным";
        } else {
            return "Этот год не является високосным";
        }
    }
}