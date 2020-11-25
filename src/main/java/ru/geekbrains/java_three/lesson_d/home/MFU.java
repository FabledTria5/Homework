package ru.geekbrains.java_three.lesson_d.home;

public class MFU {

    private final Object monitor = new Object();
    private volatile String state = "free";

    public void scan() {
        synchronized (monitor) {
            try {
                while (!state.equals("free") || state.equals("faxing") || state.equals("scanning")) {
                    monitor.wait();
                }
                state = "scanning";
                System.out.println(state);
                monitor.wait(500);
                state = "free";
                monitor.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void fax() {
        synchronized (monitor) {
            try {
                while (!state.equals("free") || state.equals("printing") || state.equals("scanning") || state.equals("faxing")) {
                    monitor.wait();
                }
                state = "faxing";
                System.out.println(state);
                monitor.wait(500);
                state = "free";
                monitor.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void print() {
        synchronized (monitor) {
            try {
                while (!state.equals("free") || state.equals("faxing") || state.equals("printing")) {
                    monitor.wait();
                }
                state = "printing";
                System.out.println(state);
                monitor.wait(500);
                state = "free";
                monitor.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
