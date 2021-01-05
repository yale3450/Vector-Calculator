package model;

import static java.lang.Math.abs;

//Represents a line in a 3d space in parametric form, represented by its direction vector and a point on the line//
public class Line implements FindDistanceObject {
    private Point point;//An arbitrary point on the line
    private Vector vector;//The direction vector of the line

    //Constructor//
    public Line(model.Point point, model.Vector vector) {
        this.point = point;
        this.vector = vector;
    }

    //EFFECTS:Finds the distance from this line to a given point
    @Override
    public double toPoint(model.Point p) {
        return p.toLine(this);
    }

    //EFFECTS:Finds the distance from this line to another given line
    @SuppressWarnings("checkstyle:WhitespaceAround")
    @Override
    public double toLine(Line l) {
        Vector l1 = this.getVector();
        Vector l2 = l.getVector();
        Point p1 = this.getPoint();
        Point p2 = l.getPoint();
        Vector normal = Vector.crossProduct(l1, l2);
        return Vector.dotProduct(normal, VorP.subtract(p1, p2)) / normal.getDistance();

    }

    //EFFECTS:Finds the distance from this line to a given plane
    @Override
    public double toPlane(Plane p) {
        return p.toLine(this);
    }

    public model.Point getPoint() {
        return point;
    }

    public model.Vector getVector() {
        return vector;
    }

    public String toString() {
        return "((" + point.toString() + ") + (" + vector.toString() + ")t)";
    }


}