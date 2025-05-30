package org.sxmmer.Task_2;

public class Main {
    public static void main(String[] args) {
        FiguresOperations[] figures = {
                new Circle(5, "Красный", "Чёрный"),
                new Rectangle(4, 7, "Синий", "Белый"),
                new Triangle(3, 4, 5, "Зелёный", "Жёлтый")
        };

        for (FiguresOperations figure : figures) {
            System.out.println("Фигура: " + figure.getName());
            System.out.println("Периметр: " + figure.getPerimeter());
            System.out.println("Площадь: " + figure.getSquare());
            System.out.println("Цвет заливки: " + figure.getFillColor());
            System.out.println("Цвет границы: " + figure.getBorderColor());
            System.out.println();
        }
    }
}