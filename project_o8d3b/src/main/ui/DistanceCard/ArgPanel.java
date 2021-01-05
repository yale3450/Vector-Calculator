package ui.DistanceCard;

import model.Point;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EventListener;

import static java.lang.Double.parseDouble;

public class ArgPanel extends JPanel implements EventListener, ItemListener {
    String argType = "Point";

    JTextField xcoord = new JTextField("X Coordinate");
    JTextField ycoord = new JTextField("Y Coordinate");
    JTextField zcoord = new JTextField("Z Coordinate");
    JTextField xVec = new JTextField("X Coordinate");
    JTextField yVec = new JTextField("Y Coordinate");
    JTextField zVec = new JTextField("Z Coordinate");
    JTextField xPoint = new JTextField("X Coordinate");
    JTextField yPoint = new JTextField("Y Coordinate");
    JTextField zPoint = new JTextField("Z Coordinate");
    JTextField xNorm = new JTextField("X Coordinate");
    JTextField yNorm = new JTextField("Y Coordinate");
    JTextField zNorm = new JTextField("Z Coordinate");
    JTextField xPlane = new JTextField("X Coordinate");
    JTextField yPlane = new JTextField("Y Coordinate");
    JTextField zPlane = new JTextField("Z Coordinate");
    JPanel cards;

    public ArgPanel() {
        setLayout(new BorderLayout());
        //CB1
        JPanel comboBoxPane1 = new JPanel(); //use FlowLayout
        String comboBoxItems[] = {"Point", "Line", "Plane"};
        JComboBox cb1 = new JComboBox(comboBoxItems);
        cb1.setEditable(false);
        cb1.addItemListener(this);
        comboBoxPane1.add(cb1);
        add(comboBoxPane1, BorderLayout.PAGE_START);

        //card1
        JPanel point = new JPanel(new GridLayout(3, 1));
        point.add(xcoord);
        point.add(ycoord);
        point.add(zcoord);
//card2\
        JPanel line = new JPanel(new GridLayout(4, 2));
        line.add(new JLabel("Enter Point Coordinates"));
        line.add(new JLabel("Enter Vector Coordinates"));
        line.add(xPoint);
        line.add(xVec);
        line.add(yPoint);
        line.add(yVec);
        line.add(zPoint);
        line.add(zVec);

        JPanel plane = new JPanel(new GridLayout(4, 2));
        plane.add(new JLabel("Enter Point Coordinates"));
        plane.add(new JLabel("Enter Normal Coordinates"));
        plane.add(xNorm);
        plane.add(xPlane);
        plane.add(yNorm);
        plane.add(yPlane);
        plane.add(zNorm);
        plane.add(zPlane);

        cards = new JPanel(new CardLayout());
        cards.add(point, "Point");
        cards.add(line, "Line");
        cards.add(plane, "Plane");
        add(cards, BorderLayout.CENTER);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) e.getItem());
        argType = (String) e.getItem();
    }

    public FindDistanceObject getArg() {
        switch (argType) {
            default:
                return new Point(read(xcoord), read(ycoord), read(zcoord));
            case "Line":
                return new Line(new Point(read(xPoint), read(yPoint), read(zPoint)),
                        new Vector(read(xVec), read(yVec), read(zVec)));

            case "Plane":
                return new Plane(new Point(read(xPlane), read(yPlane), read(zPlane)),
                        new Vector(read(xNorm), read(yNorm), read(zNorm)));
        }

    }

    public String getArgType(){ return argType; }

    private double read(JTextField j) {
        return parseDouble(j.getText());
    }


}
