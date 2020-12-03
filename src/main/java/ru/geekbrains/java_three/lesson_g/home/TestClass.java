package ru.geekbrains.java_three.lesson_g.home;

import ru.geekbrains.java_three.lesson_g.home.annotations.MyAfterSuite;
import ru.geekbrains.java_three.lesson_g.home.annotations.MyBeforeSuite;
import ru.geekbrains.java_three.lesson_g.home.annotations.MyTest;

public class TestClass {

    @MyBeforeSuite
    public void init() {
        System.out.println("Tests init");
    }

    @MyTest(priority = 1)
    public void test1() {
        System.out.println("Test1 started");
    }

    @MyTest(priority = 5)
    public void test2() {
        System.out.println("Test2 started");
    }

    @MyTest(priority = 3)
    public void test3() {
        System.out.println("Test3 started");
    }

    @MyTest(priority = 4)
    public void test4() {
        System.out.println("Test4 started");
    }

    @MyTest(priority = 7)
    public void test5() {
        System.out.println("Test5 started");
    }

    @MyAfterSuite
    public void testsEnd() {
        System.out.println("All tests finished");
    }

}
