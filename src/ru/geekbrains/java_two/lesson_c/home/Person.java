package ru.geekbrains.java_two.lesson_c.home;

import java.util.ArrayList;

public class Person {

    private static final ArrayList<Person> PERSON_ARRAY_LIST = new ArrayList<>(); // Здесь хранятся все уникальные пользователи
    private static Person PERSON_TO_DELETE;  //Здесь хранится пользователь, который будет удален при создании однофамильца

    private final String lastName;
    private final ArrayList<String> phones = new ArrayList<>();
    private final ArrayList<String> mails = new ArrayList<>();

    public Person(String lastName, String phone, String eMail) {

        for (Person person : PERSON_ARRAY_LIST) {
            if (person.getLastName().equals(lastName)) {
                PERSON_TO_DELETE = person;
                this.phones.addAll(person.getPhones());
                this.mails.addAll(person.getMails());
                break;
            }
        }

        PERSON_ARRAY_LIST.remove(PERSON_TO_DELETE);

        this.lastName = lastName;
        this.phones.add(phone);
        this.mails.add(eMail);
        PERSON_ARRAY_LIST.add(this);
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
