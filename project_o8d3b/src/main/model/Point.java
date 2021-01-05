package model;

import static java.lang.Math.abs;

//Represents a point in a 3d space with coordinates x, y, z//
public class Point extends VorP implements FindDistanceObject {

    //Constructor//
    public Point(double x, double y, double z) {
        this.xcord = x;
        this.ycord = y;
        this.zcord = z;
    }

    //EFFECTS:Finds the distance from this point to a given point
    @Override
    public double toPoint(Point point) {
        Vector vector = subtract(this, point);
        return vector.getDistance();
    }

    //EFFECTS: Finds the distance from this point to a given line
    @Override
    public double toLine(Line line) {
        Vector lineDir = line.getVector();
        Vector vector = subtract(this, line.getPoint());
        Vector normal = Vector.crossProduct(vector, lineDir);
        return abs(normal.getDistance()) / lineDir.getDistance();

    }

    //EFFECTS: Finds the distance from this point to a given plane
    @Override
    public double toPlane(Plane plane) {
        Vector normal = plane.getNormal();
        Vector vector = subtract(this, plane.getPoint());
        double proj = Vector.dotProduct(vector, normal);
        return abs(proj) / normal.getDistance();

    }


}
