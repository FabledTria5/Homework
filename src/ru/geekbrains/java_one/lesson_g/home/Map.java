package ru.geekbrains.java_one.lesson_g.home;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {

    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;

    private static final int SIZE = 70;

    public Map() {
        //Установка цвета карты
        setBackground(new Color(0x0a, 0x4f, 0xb0));
    }

    public void startNewGame(int gameMode, int fieldSize, int winLength) {
        drawField(fieldSize);
    }

    private void drawField(int fieldSize) {
        for (int i = 0, coordinateY = calculateXPadding(fieldSize * SIZE); i < fieldSize; i++, coordinateY+=SIZE) {
            for (int j = 0, coordinateX = calculateYPadding(fieldSize * SIZE); j < fieldSize; j++, coordinateX+=SIZE) {
                drawRectangle(coordinateX, coordinateY);
            }
        }
    }

    private void drawRectangle(int x, int y) {
        Graphics g = getGraphics();
        g.drawRect(x, y, SIZE, SIZE);
    }

    private int calculateXPadding(int fieldWidth) {
        return 0;
    }

    private int calculateYPadding(int fieldHeight) {
        return 0;
    }
}
