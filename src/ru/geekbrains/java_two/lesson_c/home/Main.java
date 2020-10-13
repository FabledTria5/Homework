package ru.geekbrains.java_two.lesson_c.home;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Main {

    public static void main(String[] args) {
        // Первое задание
        String[] text = "ночь улица фонарь аптека бессмысленный и тусклый свет и повторится всё как встарь ночь ледяная рябь канала аптека улица фонарь".split(" ");

        System.out.println("Текст состоит из следующих слов: " + getWords(text));
        System.out.println();

        System.out.println("Слова из текста встречаются такое кол-во раз: " + countWords(text));
        System.out.println();

        Person sam = new Person("Newman", "+79165456341", "example@mail.com");
        Person tim = new Person("Newman", "+79165454325", "example5@mail.com");

        PhoneBook.addPerson(sam);
        PhoneBook.addPerson(tim);

        System.out.println(PhoneBook.getPhoneNumber("Newman"));
    }

    // Возвращает уникальные слова в тексте
    private static LinkedHashSet<String> getWords(String[] text) {
        return new LinkedHashSet<>(Arrays.asList(text));
    }

    // Возвращает кол-во вхождений строк в строке
    private static HashMap<String, Integer> countWords(String[] text) {
        LinkedHashMap<String, Integer> dictionary = new LinkedHashMap<>();

        for (String word : text) {
            if (dictionary.containsKey(word)) {
                dictionary.put(word, dictionary.get(word) + 1);
            } else {
                dictionary.put(word, 1);
            }
        }
        return dictionary;
    }
}
