package ru.geekbrains.java_one.lesson_d.home;

public class Main {
    public static void main(String[] args) {

        // Вывести при помощи методов из пункта 3 ФИО и возраст
        Employee employee = new Employee("Василий Пупкин", 25000, 24);
        System.out.printf("Имя: %s, возраст: %d\n", employee.getName(), employee.getAge());

        // Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Дмитрий Васильев", 40000, getRandomAge());
        employees[1] = new Employee("Эдуард Андреев", 65000, getRandomAge());
        employees[2] = new Employee("МИхаил Козлов", 45000, getRandomAge());
        employees[3] = new Employee("Иван Иванов", 31000, getRandomAge());
        employees[4] = new Employee("Ольга Баринова", 39000, getRandomAge());

        for (Employee human : employees) {
            if (human.getAge() > 40) {
                System.out.println(human);
            }
        }

        increaseSalary(employees);
        System.out.println("Среднее арифметическое зарплаты сотрудников равно: " + getAverageSalary(employees) + ", средний возраст сотрудников равен: " + getAverageAge(employees));
    }

    // Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000
    private static void increaseSalary(Employee[] employees) {
        for (Employee employee: employees) {
            if (employee.getAge() > 45) {
                employee.increaseSalary(5000);
            }
        }
    }

    // Подсчитать средние арифметические зарплаты и возраста
    public static double getAverageSalary(Employee[] employees) {
        double averageSalary = 0;

        for (Employee employee: employees) {
            averageSalary += employee.getSalary();
        }
        return averageSalary / employees.length;
    }

    public static int getAverageAge(Employee[] employees) {
        int averageAge = 0;

        for (Employee employee: employees) {
            averageAge += employee.getAge();
        }
        return averageAge / employees.length;
    }


    private static int getRandomAge() { //Просто чтобы было интереснее
        return (int) (Math.random() * 80);
    }
}
