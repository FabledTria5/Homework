package ru.geekbrains.java_two.lesson_c.home;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PhoneBook {

    private static final LinkedHashMap<String, Person> phoneBook = new LinkedHashMap<>();

    public static void addPerson(Person person) {
        phoneBook.put(person.getLastName(), person);
    }

    public static ArrayList<String> getPhoneNumber(String personLastName) {
        return phoneBook.get(personLastName).getPhones();
    }

    public static ArrayList<String> getMails(String personLastName) {
        return phoneBook.get(personLastName).getMails();
    }

}
