package ru.geekbrains.java_two.lesson_c.home;

import java.util.ArrayList;

public class Person {

    private static final ArrayList<Person> PERSON_ARRAY_LIST = new ArrayList<>();

    private final String lastName;
    private final ArrayList<String> phones = new ArrayList<>();
    private final ArrayList<String> mails = new ArrayList<>();

    public Person(String lastName, String phone, String eMail) {

        for (Person person : PERSON_ARRAY_LIST) {
            if (person.getLastName().equals(lastName)) {
                this.addNumber(person, person.getPhones());
                this.addMail(person, person.getMails());
            }
        }

        this.lastName = lastName;
        this.phones.add(phone);
        this.mails.add(eMail);
        PERSON_ARRAY_LIST.add(this);
    }

    private void addNumber(Person person, ArrayList<String> numbers) {
        person.phones.addAll(numbers);
    }

    private void addMail(Person person, ArrayList<String> mails) {
        person.mails.addAll(mails);
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public ArrayList<String> getMails() {
        return mails;
    }
}
