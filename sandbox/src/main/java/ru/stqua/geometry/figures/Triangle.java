package ru.stqua.geometry.figures;

public record Triangle(double a, double b, double c) {

    public static void printTriangleArea(Triangle t) {
        String text = String.format("Площадь треугольника со сторонами %f, %f и %f = %f", t.a, t.b, t.c, t.triangleArea());
        System.out.println(text);
    }

    public static void printTrianglePerimeter(Triangle t) {
        String text = String.format("Периметр треугольника со сторонами %f, %f и %f = %f", t.a, t.b, t.c, t.trianglePerimeter());
        System.out.println(text);
    }

    public double trianglePerimeter() {
        return this.a + this.b + this.c;
    }

    public double triangleArea() {
        double p = 0.5 * trianglePerimeter();
        return Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
    }

}
