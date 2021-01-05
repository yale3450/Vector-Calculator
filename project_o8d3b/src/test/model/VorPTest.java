package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class VorPTest {

    @Test
    public void testAddVectorMidrange() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(2, 3, 4);
        Vector result = Vector.add(v1, v2);
        assertEquals(3, result.getX());
        assertEquals(5, result.getY());
        assertEquals(7, result.getZ());
    }

    @Test
    public void testAddVectorNegative() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -3, -4);
        Vector result = Vector.add(v1, v2);
        assertEquals(-1, result.getX());
        assertEquals(-1, result.getY());
        assertEquals(-1, result.getZ());
    }

    @Test
    public void testSubtractPoint() {
        Point v1 = new Point(1, 2, 3);
        Point v2 = new Point(2, 3, 4);
        Vector result = VorP.subtract(v1, v2);
        assertEquals(-1, result.getX());
        assertEquals(-1, result.getY());
        assertEquals(-1, result.getZ());
    }

    @Test
    public void testSubtractVector() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(2, 3, 4);
        Vector result = Vector.subtract(v1, v2);
        assertEquals(-1, result.getX());
        assertEquals(-1, result.getY());
        assertEquals(-1, result.getZ());
    }


    @Test
    public void testDotProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(2, 3, 4);
        double result = Vector.dotProduct(v1, v2);
        assertEquals(20, result);
    }

    @Test
    public void testCrossProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(2, 3, 4);
        Vector result = Vector.crossProduct(v1, v2);
        assertEquals(-1, result.getX());
        assertEquals(2, result.getY());
        assertEquals(-1, result.getZ());
    }

    @Test
    public void testGetDistance() {
        Vector v1 = new Vector(1, 2, 3);
        double result = v1.getDistance();
        assertEquals(sqrt(14), result);
    }

    @Test
    public void testVorPToString() {
        Vector v1 = new Vector(1, 2, 3);
        assertEquals("1.0 2.0 3.0", v1.toString());
    }
}