package ru.geekbrains.java_three.lesson_d.home;

public class Main {

    private final Object monitor = new Object();
    private volatile char currentSymbol = 'A';

    public static void main(String[] args) throws InterruptedException {

//        Main m = new Main();
//
//        Thread tA = new Thread(m::printA);
//        Thread tB = new Thread(m::printB);
//        Thread tC = new Thread(m::printC);
//
//        tA.start();
//        tB.start();
//        tC.start();

        MFU mfu = new MFU();

        Thread user1 = new Thread(mfu::fax);
        Thread user2 = new Thread(mfu::print);
        Thread user3 = new Thread(mfu::scan);

        user1.start();
        user2.start();
        user3.start();


    }

    public void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentSymbol != 'A') {
                        monitor.wait();
                    }
                    System.out.print("A");
                    currentSymbol = 'B';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentSymbol != 'B') {
                        monitor.wait();
                    }
                    System.out.print(currentSymbol);
                    currentSymbol = 'C';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentSymbol != 'C') {
                        monitor.wait();
                    }
                    System.out.print(currentSymbol);
                    currentSymbol = 'A';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
