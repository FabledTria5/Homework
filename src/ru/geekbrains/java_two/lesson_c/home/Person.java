package ru.geekbrains.java_two.lesson_c.home;

public class Person {

    private final String lastName;
    private final String phone;
    private final String mail;

    public Person(String lastName, String phone, String eMail) {
        this.lastName = lastName;
        this.phone = phone;
        this.mail = eMail;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhones() {
        return phone;
    }

    public String getMails() {
        return mail;
    }
}
