package ru.stqua.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void canCalculateTriangleArea() {
        var t = new Triangle(3, 4, 5);
        double result = t.triangleArea();
        Assertions.assertEquals(6, result);

    }

    @Test
    void canCalculateTrianglePerimeter() {
        Assertions.assertEquals(12.0, new Triangle(3,4,5).trianglePerimeter());
    }
}
