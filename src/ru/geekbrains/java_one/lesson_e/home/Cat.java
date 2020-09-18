package ru.geekbrains.java_one.lesson_e.home;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
        double defaultRunDistance = 200;
        double defaultJumpHeight = 2;

        animalType = "Котик";
        runDistance = defaultRunDistance;
        jumpHeight = defaultJumpHeight;

        runDistance = (Math.random() > 0.5) ? defaultRunDistance + 100 : defaultRunDistance - 100;
        jumpHeight = (Math.random() > 0.5) ? defaultJumpHeight + 1 : defaultJumpHeight - 0.5;
    }

    @Override
    boolean swim(int distance) {
        return false;
    }

}
