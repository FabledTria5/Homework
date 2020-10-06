package ru.geekbrains.java_two.lesson_a.home;

import javax.swing.*;
import java.awt.*;

public class MainCircles extends JFrame {

    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    public static final int BACKGROUND_CHANGE_TIME = 900;

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
        canvas.setBackground(Background.getStartColor());
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        calls += 1;

        if (calls == Integer.MAX_VALUE) {
            calls = Integer.MAX_VALUE % BACKGROUND_CHANGE_TIME;
        } else if (calls % BACKGROUND_CHANGE_TIME == 0) {
            canvas.setBackground(Background.getColor());
        }

        update(canvas, deltaTime);
        render(canvas, g);
    }

    public void addCircle() {
        Sprite[] newSprites = new Sprite[sprites.length + 1];
        System.arraycopy(sprites, 0, newSprites, 0, sprites.length);
        newSprites[newSprites.length - 1] = new Ball();

        sprites = new Sprite[newSprites.length];
        System.arraycopy(newSprites, 0, sprites, 0, sprites.length);
    }

    public void removeCircle(int cX, int cY) {
        for (Sprite sprite : sprites) {
            if (sprite.getLeft() <= cX && sprite.getRight() >= cX && sprite.getTop() <= cY && sprite.getBottom() >= cY) {
                sprite.hide();
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
