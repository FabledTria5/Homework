package ru.geekbrains.java_two.lesson_a.home;

import java.awt.*;

public class Ball extends Sprite {

    private final Color color;
    private float vX;
    private float vY;

    //Начальные значения для координат, куда будут спрятаны шарики
    private int hiddenX = -5;
    private int hiddenY = -5;

    Ball(int x, int y) {
        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
        color = new Color(
                (int) (Math.random() * 255), // R
                (int) (Math.random() * 255), // G
                (int) (Math.random() * 255)  // B
        );

        //Добавляем разеры шаров, чтобы они точно были спрятаны при любых размерах
        hiddenX -= halfWidth * 2;
        hiddenY -= halfHeight * 2;

        this.x = x;
        this.y = y;

        vX = (Math.random() <= 0.5) ? (float) -(100f + (Math.random() * 200f)) : (float) (100f + (Math.random() * 200f));
        vY = (Math.random() <= 0.5) ? (float) -(100f + (Math.random() * 200f)) : (float) (100f + (Math.random() * 200f));

    }

    @Override
    void update(GameCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;

        if (getLeft() < canvas.getLeft() && getLeft() != hiddenX) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop() && getTop() != hiddenY) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }
    }

    @Override
    void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }

    //Ставим нулевую скорость и перемещаем шарик туда, где его точно не увидят
    @Override
    void hide() {
        vX = 0;
        vY = 0;
        setLeft(hiddenX);
        setTop(hiddenY);
    }
}