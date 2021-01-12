package ui.DistanceCard;

import model.Line;
import model.Operation;
import model.Plane;
import ui.GUI;

import javax.swing.*;
import java.awt.*;
//Panel that holds the argument panels and performs find distance calculations
public class DistancePanel extends JPanel {
    ArgPanel argPanel1 = new ArgPanel();
    ArgPanel argPanel2 = new ArgPanel();
    //Button to perform calculation
    public JButton fdButton = new JButton("Find Distance");

    public DistancePanel(GUI parent) {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        //Adds new argPanels
        JPanel input = new JPanel();
        input.add(argPanel1);
        input.add(new JPanel());
        input.add(argPanel2);
        add(input, BorderLayout.CENTER);

        //adds Find distance button
        fdButton.addActionListener(parent);
        add(new JPanel());
        add(fdButton);
    }

    //Performs calculations
    public double findDistance() {
        String argType = argPanel2.getArgType();
        switch (argType) {
            default:
                return argPanel1.getArg().toPoint((model.Point) argPanel2.getArg());
            case "Line":
                return argPanel1.getArg().toLine((Line) argPanel2.getArg());
            case "Plane":
                return argPanel1.getArg().toPlane((Plane) argPanel2.getArg());
        }
    }

    //Getter, Returns operation
    public Operation getOp(){
        return new Operation(argPanel1.getArg().toString(),argPanel2.getArg().toString(), "Distance to");
    }


}