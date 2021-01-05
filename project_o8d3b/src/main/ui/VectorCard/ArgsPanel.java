package ui.VectorCard;

import model.Vector;

import javax.swing.*;
import java.awt.*;

import static java.lang.Double.parseDouble;

public class ArgsPanel extends JPanel{

    JTextField xcoord1 = new JTextField("X Coordinate");
    JTextField ycoord1 = new JTextField("Y Coordinate");
    JTextField zcoord1 = new JTextField("Z Coordinate");
    JTextField xcoord2 = new JTextField("X Coordinate");
    JTextField ycoord2 = new JTextField("Y Coordinate");
    JTextField zcoord2 = new JTextField("Z Coordinate");
    //EFFECTS: Makes the argument panel
    public ArgsPanel() {
        setLayout(new GridLayout(1, 2));
        JPanel argPanel1 = new JPanel(new GridLayout(4, 1));
        argPanel1.add(new JLabel("Enter First Vector"));
        argPanel1.add(xcoord1);
        argPanel1.add(ycoord1);
        argPanel1.add(zcoord1);
        JPanel argPanel2 = new JPanel(new GridLayout(4, 1));
        argPanel2.add(new JLabel("Enter Second Vector"));
        argPanel2.add(xcoord2);
        argPanel2.add(ycoord2);
        argPanel2.add(zcoord2);
        add(argPanel1);
        add(argPanel2);
    }
    public model.Vector getArg1() throws NumberFormatException {
        double cordX = parseDouble(xcoord1.getText());
        double cordY = parseDouble(ycoord1.getText());
        double cordZ = parseDouble(zcoord1.getText());
        return new Vector(cordX, cordY, cordZ);
    }

    //EFFECTS: gets vector from user input
    public model.Vector getArg2() throws NumberFormatException {
        double cordX = parseDouble(xcoord2.getText());
        double cordY = parseDouble(ycoord2.getText());
        double cordZ = parseDouble(zcoord2.getText());
        return new Vector(cordX, cordY, cordZ);
    }

}
