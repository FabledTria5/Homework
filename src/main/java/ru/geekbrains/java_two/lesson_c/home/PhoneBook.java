package ru.geekbrains.java_two.lesson_c.home;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PhoneBook {

    private static final LinkedHashMap<String, ArrayList<Person>> phoneBook = new LinkedHashMap<>();

    public static void addPerson(Person person) {
        if (!phoneBook.containsKey(person.getLastName())) {
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(person);
            phoneBook.put(person.getLastName(), persons);
        } else {
            phoneBook.get(person.getLastName()).add(person);
        }
    }

    public static ArrayList<String> getPhoneNumber(String personLastName) {
        ArrayList<String> phones = new ArrayList<>();
        for (Person person : phoneBook.get(personLastName)) {
            phones.add(person.getPhones());
        }
        return phones;
    }

    public static ArrayList<String> getMails(String personLastName) {
        ArrayList<String> mails = new ArrayList<>();
        for (Person person : phoneBook.get(personLastName)) {
            mails.add(person.getMails());
        }
        return mails;
    }

}
