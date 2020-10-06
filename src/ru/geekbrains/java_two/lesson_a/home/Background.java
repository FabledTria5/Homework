package ru.geekbrains.java_two.lesson_a.home;

import java.awt.*;

public class Background {

    private static final Color startColor = Color.LIGHT_GRAY; //Начальный цвет поля

    //Массив с заготовленными цветами. Можно было и рандомно, но очень часто выпадали темные цвета
    private static final Color[] colors = {Color.decode("#ADFF2F"),
            Color.decode("#FFA07A"),
            Color.decode("#FFA500"),
            Color.decode("#00FFFF"),
            Color.decode("#DAA520"),
            Color.decode("#66CDAA"),
            Color.decode("#EEE8AA")
    };

    //Возвращает случайный цвет из массива
    public static Color getColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    //Получаем стартовый цвет
    public static Color getStartColor() {
        return startColor;
    }

}
