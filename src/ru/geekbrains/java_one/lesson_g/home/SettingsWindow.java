package ru.geekbrains.java_one.lesson_g.home;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Field size is: ";
    private static final String WIN_LENGTH_PREFIX = "Win length is: ";

    private final GameWindow gameWindow;

    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider slideWinLen;
    private JSlider slideFieldSize;

    public SettingsWindow(GameWindow gameWindow) {
        //Объект gameWindow для позиционирования окна
        this.gameWindow = gameWindow;

        //Установка размера окна и его позиция в центре основного игрового
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) (gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2);
        int posY = (int) (gameWindowBounds.getCenterY() - WINDOW_WIDTH / 2);
        setLocation(posX, posY);
        setResizable(false);

        //Заголовок окна
        setTitle("Creating new game");

        //Layout окна
        setLayout(new GridLayout(10, 1));

        //Методы для расположения элементов в окне
        addGameModeControls();
        addFieldControls();

        //Кнопка для отправки данных в gameWindow
        JButton btnStartGame = new JButton("Start a game");
        btnStartGame.addActionListener(action -> collectDataFromControlsAndStartGame());
        add(btnStartGame);
    }

    //Добавляет две radioButton
    private void addGameModeControls() {
        add(new JLabel("Choose game mode:"));
        humVSAI = new JRadioButton("Human vs AI", true);
        humVShum = new JRadioButton("Human VS human");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVShum);
        gameMode.add(humVSAI);
        add(humVSAI);
        add(humVShum);
    }

    private void addFieldControls() {
        //Создание надписей и слайдеров для выбора размера поля и длины выигрышной последовательности
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);

        //Слушатели событий на слайдерах
        slideFieldSize.addChangeListener(changeEvent -> {
            int currentValue = slideFieldSize.getValue();
            lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
            slideWinLen.setMaximum(currentValue);
        });

        slideWinLen.addChangeListener(changeEvent -> lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue()));

        //Добавление элементов на поле
        add(new JLabel("Choose field size:"));
        add(lbFieldSize);
        add(slideFieldSize);
        add(new JLabel("Choose win length"));
        add(lbWinLength);
        add(slideWinLen);
    }

    //Собирает данные из слайдеров и radioButton и отправляет в метод основного окна
    private void collectDataFromControlsAndStartGame() {
        int gameMode;

        if (humVSAI.isSelected()) {
            gameMode = Map.MODE_HVA;
        } else if (humVShum.isSelected()) {
            gameMode = Map.MODE_HVH;
        } else {
            throw new RuntimeException("Unexpected game mode!");
        }

        int fieldSize = slideFieldSize.getValue();
        int winLen = slideWinLen.getValue();

        gameWindow.acceptSettings(gameMode, fieldSize, fieldSize, winLen);

        setVisible(false);
    }

}
