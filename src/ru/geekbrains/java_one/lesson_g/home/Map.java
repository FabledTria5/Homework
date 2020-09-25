package ru.geekbrains.java_one.lesson_g.home;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {

    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;

    public Map() {
        //Установка цвета карты
        setBackground(new Color(0x0a, 0x4f, 0xb0));
    }

    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("mode: %d, size: %d, win: %d", gameMode, fieldSizeX, fieldSizeY);
    }

}
