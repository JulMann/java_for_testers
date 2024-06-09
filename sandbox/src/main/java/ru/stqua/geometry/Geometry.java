package ru.stqua.geometry;

import ru.stqua.geometry.figures.Rectangle;
import ru.stqua.geometry.figures.Square;
import ru.stqua.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square(7.0));
        Square.printSquareArea(new Square(5.0));
        Square.printSquareArea(new Square(3.0));

        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(7.0, 9.0);

        var t = new Triangle(4, 4, 5);
        Triangle.printTriangleArea(t);
        Triangle.printTrianglePerimeter(t);
    }

}
