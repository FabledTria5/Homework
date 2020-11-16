package ru.geekbrains.java_one.lesson_e.home;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Mike",  4);
        Cat cat1 = new Cat("Clara", 5);

        makeAnimalRun(dog1, 550);
        makeAnimalRun(cat1, 250);

        System.out.println();

        makeAnimalSwim(dog1, 5);
        makeAnimalSwim(cat1, 15);

        System.out.println();

        makeAnimalJump(dog1, 2);
        makeAnimalJump(cat1, 3);
    }

    private static void makeAnimalJump(Animal animal, int height) {
        if (animal.jump(height)) {
            System.out.println(animal.animalType + " прыгнул на " + height + " метра");
        } else {
            System.out.println(animal.animalType + " не может прыгнуть на " + height + " метра");
        }
    }

    private static void makeAnimalSwim(Animal animal, int distance) {
        if (animal.swim(distance)) {
            System.out.println(animal.animalType + " проплыл " + distance + " метров");
        } else {
            System.out.println(animal.animalType + " не может проплыть " + distance + " метров");
        }
    }

    private static void makeAnimalRun(Animal animal, int distance) {
        if (animal.run(distance)) {
            System.out.println(animal.animalType + " пробежал  " + distance + " метров");
        } else {
            System.out.println(animal.animalType + " не может пробежать " + distance + " метров");
        }
    }
}
