package ru.geekbrains.java_one.lesson_e.home;

public abstract class Animal {

    protected String animalType;

    protected String name;
    protected int age;

    protected double runDistance;
    protected double swimDistance;
    protected double jumpHeight;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    boolean run(int distance) {
        return distance <= runDistance;
    }

    boolean swim(int distance) {
        return distance <= swimDistance;
    }

    boolean jump(int height) {
        return height <= jumpHeight;
    }
}
