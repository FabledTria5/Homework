package ru.geekbrains.java_three.lesson_g.home;

import ru.geekbrains.java_three.lesson_g.home.annotations.MyAfterSuite;
import ru.geekbrains.java_three.lesson_g.home.annotations.MyBeforeSuite;
import ru.geekbrains.java_three.lesson_g.home.annotations.MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            start("ru.geekbrains.java_three.lesson_g.home.TestClass");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void start(String className) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class targetClass = Class.forName(className);
        doTests(targetClass);
    }

    private static void start(Class targetClass) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        doTests(targetClass);
    }

    private static void doTests(Class targetClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Method methodBefore = null;
        Method methodAfter = null;
        Map<Method, Integer> methodIntegerMap = new HashMap<>();
        Object testClassObject = targetClass.getDeclaredConstructor().newInstance();
        Method[] methods = targetClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyBeforeSuite.class)) {
                if (methodBefore == null) {
                    methodBefore = method;
                } else {
                    throw new RuntimeException("Found second MyBeforeSuite annotation");
                }
            }
            if (method.isAnnotationPresent(MyTest.class)) {
                methodIntegerMap.put(method, method.getAnnotation(MyTest.class).priority());
            }
            if (method.isAnnotationPresent(MyAfterSuite.class)) {
                if (methodAfter == null) {
                    methodAfter = method;
                } else {
                    throw new RuntimeException("Found second MyAfterSuite annotation");
                }
            }
        }

        methodBefore.invoke(testClassObject);

        methodIntegerMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(it -> {
                    try {
                        it.getKey().invoke(testClassObject);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });

        methodAfter.invoke(testClassObject);

    }
}
