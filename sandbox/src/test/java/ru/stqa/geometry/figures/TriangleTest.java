package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqua.geometry.figures.Triangle;

public class TriangleTest {
    @Test
    void canCalculateTriangleArea() {
        var t = new Triangle(3.0, 4.0, 5.0);
        double result = t.triangleArea();
        Assertions.assertEquals(6.0, result);

    }

    @Test
    void canCalculateTrianglePerimeter() {
        Assertions.assertEquals(12.0, new Triangle(3.0,4.0,5.0).trianglePerimeter());
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(3.0, -4.0, 5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // OK
        }
    }

    @Test
    void cannotCreateTriangleWhoseSumOfTwoSidesIsLessThanThird() {
        try {
            new Triangle(3.0, 2.0, 5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // OK
        }
    }

    @Test
    void testEquality() {
        var t1 = new Triangle(3.0, 4.0, 5.0);
        var t2 = new Triangle(3.0, 5.0, 4.0);
        var t3 = new Triangle(4.0, 5.0, 3.0);
        var t4 = new Triangle(4.0, 3.0, 5.0);
        var t5 = new Triangle(5.0, 3.0, 4.0);
        var t6 = new Triangle(5.0, 4.0, 3.0);
        Assertions.assertEquals(t1, t2);
        Assertions.assertEquals(t1, t3);
        Assertions.assertEquals(t1, t4);
        Assertions.assertEquals(t1, t5);
        Assertions.assertEquals(t1, t6);
        Assertions.assertEquals(t2, t3);
        Assertions.assertEquals(t2, t4);
        Assertions.assertEquals(t2, t5);
        Assertions.assertEquals(t2, t6);
        Assertions.assertEquals(t3, t4);
        Assertions.assertEquals(t3, t5);
        Assertions.assertEquals(t3, t6);
        Assertions.assertEquals(t4, t5);
        Assertions.assertEquals(t4, t6);
        Assertions.assertEquals(t5, t6);
    }
}
