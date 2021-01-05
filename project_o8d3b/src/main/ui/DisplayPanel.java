package ui;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    public JTextField resultDisplay = new JTextField();
    public JTextField history1 = new JTextField();
    public JTextField history2 = new JTextField();
    public JTextField history3 = new JTextField();
    public JButton save = new JButton("Save");
    public JButton load = new JButton("load");

    public DisplayPanel(GUI parent) {
        setLayout(new GridLayout(5, 1));
        JPanel historyActions = new JPanel(new GridLayout(1, 2));
        save.addActionListener(parent);
        load.addActionListener(parent);
        historyActions.add(save);
        historyActions.add(load);

        resultDisplay.setEditable(false);

        history1.setEditable(false);
        history2.setEditable(false);
        history3.setEditable(false);
        add(resultDisplay);
        add(historyActions);
        add(history1);
        add(history2);
        add(history3);

    }


}
