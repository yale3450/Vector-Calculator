package model;

//Represents a vector in a 3d space with parameters, x,y,z//
public class Vector extends VorP {

    //EFFECTS: Constructor//
    public Vector(double x, double y, double z) {
        this.xcord = x;
        this.ycord = y;
        this.zcord = z;
    }

    //EFFECTS: returns the sum of 2 vectors
    public static Vector add(Vector v1, Vector v2) {
        double newX = v1.getX() + v2.getX();
        double newY = v1.getY() + v2.getY();
        double newZ = v1.getZ() + v2.getZ();
        return new Vector(newX, newY, newZ);
    }

    //EFFECTS: returns the dot product of two vectors
    public static double dotProduct(Vector v1, Vector v2) {
        return v1.getX() * v2.getX() + v1.getY() * v2.getY() + v1.getZ() * v2.getZ();

    }

    //EFFECTS: returns the cross product of two vectors
    public static Vector crossProduct(Vector v1, Vector v2) {
        double newX = (v1.getY() * v2.getZ()) - (v2.getY() * v1.getZ());
        double newY = (v2.getX() * v1.getZ()) - (v1.getX() * v2.getZ());
        double newZ = (v1.getX() * v2.getY()) - (v1.getY() * v2.getX());
        return new Vector(newX, newY, newZ);
    }

    //EFFECTS: returns the distance
    public double getDistance() {
        return Math.sqrt((xcord * xcord + ycord * ycord + zcord * zcord));
    }


}

