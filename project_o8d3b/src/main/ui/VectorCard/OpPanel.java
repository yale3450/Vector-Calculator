package ui.VectorCard;

import ui.GUI;

import javax.swing.*;
import java.awt.*;

//EFFECTS: Makes operation panel

public class OpPanel extends JPanel  {
    //Components for operation panel
    public JButton add = new JButton("Add");
    public JButton subtract = new JButton("Subtract");
    public JButton dot = new JButton("Dot Product");
    public JButton cross = new JButton("Cross Product");
    public JButton length = new JButton("Find Vector Length");

    public OpPanel(GUI parent) {


        setLayout(new GridLayout(5, 1));
        add(add);
        add(subtract);
        add(dot);
        add(cross);
        add(length);

        add.addActionListener(parent);
        subtract.addActionListener(parent);
        dot.addActionListener(parent);
        cross.addActionListener(parent);
        length.addActionListener(parent);
    }



}
