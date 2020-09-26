package ru.geekbrains.java_one.lesson_g.home;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {

    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;

    private static final int SIZE = 70;

    public Map() {
        //Установка цвета карты
        setBackground(Color.lightGray);
    }

    public void startNewGame(int gameMode, int fieldSize, int winLength) {
        clearField();
        drawField(fieldSize);
    }

    private void drawField(int fieldSize) {
        for (int i = 0, coordinateY = calculateYPadding(fieldSize * SIZE); i < fieldSize; i++, coordinateY += SIZE) {
            for (int j = 0, coordinateX = calculateXPadding(fieldSize * SIZE); j < fieldSize; j++, coordinateX += SIZE) {
                drawRectangle(coordinateX, coordinateY);
            }
        }
    }

    private void clearField() {
        Graphics g = getGraphics();
        g.drawRect(0, 0, 1300, 1300);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 1300, 1300);
    }

    private void drawRectangle(int x, int y) {
        Graphics g = getGraphics();
        g.drawRect(x, y, SIZE, SIZE);
    }

    private int calculateXPadding(int fieldWidth) {
        return GameWindow.WIN_WIDTH / 2 - fieldWidth / 2;
    }

    private int calculateYPadding(int fieldHeight) {
        return GameWindow.WIN_HEIGHT / 2 - fieldHeight / 2;
    }
}
