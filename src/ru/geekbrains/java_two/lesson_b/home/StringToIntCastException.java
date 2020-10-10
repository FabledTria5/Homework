package ru.geekbrains.java_two.lesson_b.home;

public class StringToIntCastException extends NumberFormatException {
    public StringToIntCastException(String s) {
        super(s);
    }
}
