package ui.VectorCard;

import model.Vector;

import javax.swing.*;
import java.awt.*;

import static java.lang.Double.parseDouble;

public class ArgPanel extends JPanel {

    JTextField xcoord = new JTextField("X Coordinate");
    JTextField ycoord = new JTextField("Y Coordinate");
    JTextField zcoord = new JTextField("Z Coordinate");

    public ArgPanel() {
        setLayout(new GridLayout(4, 1));
        add(new JLabel("Enter Vector"));
        add(xcoord);
        add(ycoord);
        add(zcoord);


    }

    public model.Vector getArg() throws NumberFormatException {
        double cordX = parseDouble(xcoord.getText());
        double cordY = parseDouble(ycoord.getText());
        double cordZ = parseDouble(zcoord.getText());
        return new Vector(cordX, cordY, cordZ);
    }
}
