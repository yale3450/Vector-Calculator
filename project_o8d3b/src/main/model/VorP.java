package model;

//Vector or Point//
//The two have similar properties therefore are grouped into one superclass//
public class VorP {
    //Fields
    public double xcord; //X coordinate of a point or a vector
    public double ycord; //Y coordinate of a point or a vector
    public double zcord; //Z coordinate of a point or a vector

    //EFFECTS: returns the difference of two vectors, or the difference of two points
    public static Vector subtract(VorP vp1, VorP vp2) {
        double newX = vp1.getX() - vp2.getX();
        double newY = vp1.getY() - vp2.getY();
        double newZ = vp1.getZ() - vp2.getZ();
        return new Vector(newX, newY, newZ);
    }

    //EFFECTS: Returns X coordinate//
    public double getX() {
        return xcord;
    }

    //EFFECTS: Returns y coordinate//
    public double getY() {
        return ycord;
    }

    //EFFECTS: Returns z coordinate//
    public double getZ() {
        return zcord;
    }

    //EFFECTS: Allows Vector to be displayed as a string//
    public String toString() {
        return xcord + " " + ycord + " " + zcord;
    }
}
