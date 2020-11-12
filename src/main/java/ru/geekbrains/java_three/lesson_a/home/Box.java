package main.java.ru.geekbrains.java_three.lesson_a.home;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits;

    public Box(T... fruits) {
        this.fruits = new ArrayList<T>(Arrays.asList(fruits));
    }

    public void addFruit(T fruit) {
        this.fruits.add(fruit);
    }

    public float getWeight() {
        if (this.fruits.size() == 0) return 0;
        return this.fruits.get(0).getWeight() * this.fruits.size();
    }

    public boolean compare(Box<?> anotherBox) {
        return this.getWeight() == anotherBox.getWeight();
    }

    public void dropToAnotherBox(Box<T> anotherBox) {
        anotherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }
}
