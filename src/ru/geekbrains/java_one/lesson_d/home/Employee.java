package ru.geekbrains.java_one.lesson_d.home;

public class Employee {

    private final String name;
    private final int employeeId;

    private int salary;
    private int age;

    private static int _id = 0;

    public Employee(String name, int salary, int age) {
        this.employeeId = _id++;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Информация о работнике: " +
                "имя='" + name + '\'' +
                ", зарплата=" + salary +
                ", возраст=" + age +
                ", _id=" + employeeId +
                '}';
    }

    public void increaseSalary(int salary) {
        this.salary += salary;
    }
}
