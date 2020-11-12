package main.java.ru.geekbrains.java_one.lesson_e.home;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
        double defaultRunDistance = 500;
        double defaultJumpHeight = 0.5;
        double defaultSwimDistance = 10;

        animalType = "Песик";
        runDistance = defaultRunDistance;
        jumpHeight = defaultJumpHeight;
        swimDistance = defaultSwimDistance;

        runDistance = (Math.random() > 0.5) ? defaultRunDistance + 100 : defaultRunDistance - 100;
        jumpHeight = (Math.random() > 0.5) ? defaultJumpHeight + 2 : defaultJumpHeight - 0.2;
        swimDistance = (Math.random() > 0.5) ? defaultSwimDistance + 10 : defaultSwimDistance - 5;
    }
}
