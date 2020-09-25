package ru.geekbrains.java_one.lesson_g.home;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    public static final int WIN_WIDTH = 507;
    public static final int WIN_HEIGHT = 555;
    public static final int WIN_POSX = 650;
    public static final int WIN_POSY = 250;

    private final Map map;

    public GameWindow() throws HeadlessException {
        //Поведение при закрытии окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Установка размеров окна
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POSX, WIN_POSY);

        //Заголовок окна
        setTitle("TicTacToe");

        //Создание кнопок
        JButton btnStart = new JButton("Start");
        JButton btnStop = new JButton("Stop");

        //Панель, на которой будут размещены конпки
        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 2));
        panelBottom.add(btnStart);
        panelBottom.add(btnStop);

        //Объекты карты и окна настроек
        map = new Map();
        SettingsWindow settings = new SettingsWindow(this);

        //Слушатели нажатий на кнопки. Так как уже встречал лябда выражения, решил применить их здесь для более компактного кода
        btnStart.addActionListener(actionEvent -> settings.setVisible(true));
        btnStop.addActionListener(actionEvent -> System.exit(0));

        //Добавляем карту и панель на экран и делаем окно видимым
        add(map, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void acceptSettings(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        //Пограничный метод, который собирает данные из окна настроек и начинает игру
        map.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLength);
    }
}
