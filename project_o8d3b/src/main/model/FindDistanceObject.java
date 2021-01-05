package model;

//Interface for all objects that can be used as argument in find distance functions//
public interface FindDistanceObject {
    double toPoint(Point p);

    double toLine(Line l);

    double toPlane(Plane p);

}
