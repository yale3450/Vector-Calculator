package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class FindDistanceObjectTest {
    @Test
    public void testPointToPoint() {
        Point p1 = new Point(1, 2, 3);
        Point p2 = new Point(2, 3, 4);
        double result = p1.toPoint(p2);
        assertEquals(sqrt(3), result);
    }

    @Test
    public void testPointToLine() {
        Point p1 = new Point(1, 2, 3);
        Point p2 = new Point(2, 3, 4);
        Vector v1 = new Vector(3, 4, 5);
        Line l1 = new Line(p2, v1);
        double result = p1.toLine(l1);
        assertEquals(sqrt(0.12), result, 0.0000000000000001);
    }

    @Test
    public void testLineToPoint() {
        Point p1 = new Point(1, 2, 3);
        Point p2 = new Point(2, 3, 4);
        Vector v1 = new Vector(3, 4, 5);
        Line l1 = new Line(p2, v1);
        double result = l1.toPoint(p1);
        assertEquals(sqrt(0.12), result, 0.0000000000000001);
    }

    @Test
    public void testPointToPlane() {
        Point p1 = new Point(1, 2, 3);
        Point p2 = new Point(2, 3, 4);
        Vector v1 = new Vector(3, 4, 5);
        Plane pl1 = new Plane(p2, v1);
        double result = p1.toPlane(pl1);
        assertEquals(sqrt(2.88), result, 0.0000000000000001);
    }

    @Test
    public void testPlaneToPoint() {
        Point p1 = new Point(1, 2, 3);
        Point p2 = new Point(2, 3, 4);
        Vector v1 = new Vector(3, 4, 5);
        Plane pl1 = new Plane(p2, v1);
        double result = pl1.toPoint(p1);
        assertEquals(sqrt(2.88), result, 0.0000000000000001);
    }

    @Test
    public void testLineToPlane() {
        Point p1 = new Point(1, 2, 3);
        Vector v1 = new Vector(5, 6, 7);
        Point p2 = new Point(2, 3, 4);
        Vector v2 = new Vector(3, 4, 5);
        Plane pl1 = new Plane(p1, v1);
        Line l1 = new Line(p2, v2);
        double result = l1.toPlane(pl1);
        assertEquals(18 / sqrt(110), result, 0.0000000000000001);
    }

    @Test
    public void testPlaneToLine() {
        Point p1 = new Point(1, 2, 3);
        Vector v1 = new Vector(5, 6, 7);
        Point p2 = new Point(2, 3, 4);
        Vector v2 = new Vector(3, 4, 5);
        Plane pl1 = new Plane(p1, v1);
        Line l1 = new Line(p2, v2);
        double result = pl1.toLine(l1);
        assertEquals(18 / sqrt(110), result, 0.0000000000000001);
    }

    @Test
    public void testLineToLIne() {
        Point p1 = new Point(1, 2, 3);
        Vector v1 = new Vector(5, 6, 7);
        Point p2 = new Point(2, 3, 4);
        Vector v2 = new Vector(3, 4, 5);
        Line l1 = new Line(p1, v1);
        Line l2 = new Line(p2, v2);
        double result = l1.toLine(l2);
        assertEquals(0, result);
    }

    @Test
    public void testPlaneToPlane() {
        Point p1 = new Point(1, 2, 3);
        Vector v1 = new Vector(5, 6, 7);
        Point p2 = new Point(2, 3, 4);
        Vector v2 = new Vector(3, 4, 5);
        Plane pl1 = new Plane(p1, v1);
        Plane pl2 = new Plane(p2, v2);
        double result = pl1.toPlane(pl2);
        assertEquals(18 / sqrt(110), result);
    }


    @Test
    public void testPlaneToString() {
        Point p1 = new Point(1, 2, 3);
        Vector v1 = new Vector(5, 6, 7);
        Plane pl1 = new Plane(p1, v1);
        assertEquals("((1.0 2.0 3.0) + (5.0 6.0 7.0)t)", pl1.toString());
    }

    @Test
    public void testLineToString() {
        Point p1 = new Point(1, 2, 3);
        Vector v1 = new Vector(5, 6, 7);
        Line l1 = new Line(p1, v1);
        assertEquals("((1.0 2.0 3.0) + (5.0 6.0 7.0)t)", l1.toString());
    }

}