package ru.geekbrains.java_two.lesson_a.home;

import javax.swing.*;
import java.awt.*;

public class MainCircles extends JFrame {

    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    public static final int BACKGROUND_CHANGE_TIME = 900; //Нужна для подсчета прошедшего времени. Сейчас примерно равно 20 секунд

    private static float calls = 0;

    Sprite[] sprites = new Sprite[10];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainCircles::new);
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        GameCanvas canvas = new GameCanvas(this);
        add(canvas);
        initApplication();
        setTitle("Circles");
        canvas.setBackground(Background.getStartColor()); //Устанавливаем стартовый цвет поля
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2);
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        calls += 1;

        //Если прошло определенное кол-во времени, меняем фон. Если переполнение Int, сбрасываем
        if (calls == Integer.MAX_VALUE) {
            calls = Integer.MAX_VALUE % BACKGROUND_CHANGE_TIME;
        } else if (calls % BACKGROUND_CHANGE_TIME == 0) {
            canvas.setBackground(Background.getColor());
        }

        update(canvas, deltaTime);
        render(canvas, g);
    }

    //Добавляет в массив новый шарик с помощью другого массива
    public void addCircle(int cX, int cY) {
        Sprite[] newSprites = new Sprite[sprites.length + 1];
        System.arraycopy(sprites, 0, newSprites, 0, sprites.length);
        newSprites[newSprites.length - 1] = new Ball(cX, cY);
        sprites = new Sprite[newSprites.length];
        System.arraycopy(newSprites, 0, sprites, 0, sprites.length);
    }

    //Удаляет шарик с экрана
    public void removeCircle(int cX, int cY) {
        for (Sprite sprite : sprites) {
            if (sprite.getLeft() <= cX && sprite.getRight() >= cX && sprite.getTop() <= cY && sprite.getBottom() >= cY) {
                sprite.hide();
                break;
            }
        }
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (Sprite sprite : sprites) {
            sprite.update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (Sprite sprite : sprites) {
            sprite.render(canvas, g);
        }
    }
}
