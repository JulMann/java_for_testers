package ru.stqua.geometry.figures;

public record Square(double side) {

    public Square {
        if (side < 0) {
            throw new IllegalArgumentException("Сторона квадрата должна быть неотрицательной");
        }
    }

    public static void printSquareArea(Square s) {
        String text = String.format("Площадь квадрата со стороной %f = %f", s.side, s.area());
        System.out.println(text);
    }

    public double area() {      
        return this.side * this.side;
    }

    public double perimeter() {
        return 4 * this.side;
    }
}
