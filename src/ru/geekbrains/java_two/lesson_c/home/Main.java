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

        // Второе задание
        Person sam = new Person("Newman", "+79165456341", "example@mail.com");
        Person tim = new Person("Newman", "+79165454325", "TimNew@mail.com");
        Person bob = new Person("Caster", "+87920657152", "bobCast@gmail.com");

        PhoneBook.addPerson(sam);
        PhoneBook.addPerson(tim);
        PhoneBook.addPerson(bob);

        System.out.println("По фамилии Newman были найдены следующие номера телефонов: \n" + PhoneBook.getPhoneNumber("Newman"));
        System.out.println("По фамилии Newman были найдены следующие адреса электронной почты: \n" + PhoneBook.getMails("Newman"));

        System.out.println();

        System.out.println("По фамилии Caster были найдены следующие номера телефонов: \n" + PhoneBook.getPhoneNumber("Caster"));
        System.out.println("По фамилии Caster были найдены следующие адреса электронной почты: \n" + PhoneBook.getMails("Caster"));
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
