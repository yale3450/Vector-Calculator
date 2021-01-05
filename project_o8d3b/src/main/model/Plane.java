package model;

//Represents a plane in a 3d space, defined by a point and its normal vector//
public class Plane implements FindDistanceObject {
    private Point point; // An arbitrary point on the plane
    private Vector normal; //The vector normal to the plane

    //EFFECTS: Constructor//
    public Plane(model.Point point, model.Vector normal) {
        this.point = point;
        this.normal = normal;
    }


    //EFFECTS: Finds the distance from this plane to a certain point//
    @Override
    public double toPoint(Point p) {
        return p.toPlane(this);
    }

    //EFFECTS: Finds the distance from this plane to a certain line//
    @Override
    public double toLine(Line l) {
        model.Point linePoint = l.getPoint();
        return linePoint.toPlane(this);
    }

    //EFFECTS: Finds the distance from this plane to a certain other plane//
    @Override
    public double toPlane(Plane p) {
        Point planePoint = p.getPoint();
        return planePoint.toPlane(this);
    }

    //EFFECTS: Allows Vector to be displayed as a string//
    public String toString() {
        return "((" + point.toString() + ") + (" + normal.toString() + ")t)";
    }

    //Getters
    public model.Point getPoint() {
        return point;
    }

    public model.Vector getNormal() {
        return normal;
    }
}
