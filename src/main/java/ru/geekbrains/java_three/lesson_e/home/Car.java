package ru.geekbrains.java_three.lesson_e.home;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private final Race race;
    private final int speed;
    private final String name;

    private static final CyclicBarrier startBarrier;
    private static final CountDownLatch preparationsCountDownLatch;
    private static final CountDownLatch raceCountDownLatch;

    private static final AtomicInteger ai = new AtomicInteger(0);

    static {
        startBarrier = MainClass.startBarrier;
        raceCountDownLatch = MainClass.raceCountDownLatch;
        preparationsCountDownLatch = MainClass.preparationsCountDownLatch;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            preparationsCountDownLatch.countDown();
            System.out.println(this.name + " готов");
            startBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        int place = ai.incrementAndGet();
        if (place == 1) {
            System.out.println(name + " - WIN");
        } else if (place == 2) {
            System.out.println(name + " - second place");
        } else if (place == 3) {
            System.out.println(name + " - third place");
        }
        raceCountDownLatch.countDown();
    }
}
