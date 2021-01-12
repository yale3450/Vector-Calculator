package ui;

import Persistence.JsonReader;
import Persistence.JsonWriter;
import model.History;
import model.Operation;
import model.Vector;
import ui.DistanceCard.DistancePanel;
import ui.VectorCard.ArgPanel;
import ui.VectorCard.OpPanel;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


//The entire GUI is contained within this class
public class GUI implements ActionListener {
    private static final String JSON_STORE = "./project_o8d3b/data/history.json";
    private JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    private JsonReader jsonReader = new JsonReader(JSON_STORE);

    String result;
    History history = new History();
    ArgPanel argPanel1 = new ArgPanel();
    ArgPanel argPanel2 = new ArgPanel();
    OpPanel opPanel = new OpPanel(this);
    DisplayPanel displayPanel = new DisplayPanel(this);
    DistancePanel distancePanel = new DistancePanel(this);


    //Constructor: creates JFrame and adds components
    public GUI() {

        //Frame//
        JFrame frame = new JFrame("3DCalculator");
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.setVisible(true);
        frame.setSize(690, 280);
        frame.setLayout(new FlowLayout());


        JTabbedPane tabbedPane = new JTabbedPane();

        //Vector Card
        JPanel card1 = new JPanel();
        card1.setLayout(new GridLayout(1,3));
        card1.add(argPanel1);
        card1.add(argPanel2);
        card1.add(opPanel);
        //Distance Card
        JPanel card2 = new JPanel();
        card2.add(distancePanel);

        tabbedPane.addTab("Vector Operations", card1);
        tabbedPane.addTab("Find Distance", card2);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.add(displayPanel, BorderLayout.LINE_END);
    }


    //MODIFIES: resultDisplay
    //EFFECTS: displays result
    private void displayResult() {
        displayPanel.resultDisplay.setText(result);
        playSound();
        displayHistory();

    }

    //EFFECTS: plays sound of choice when a button is clicked
    private void playSound() {
        try {
            File file = new File("./project_o8d3b/data/button-3.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //MODIFIES: history 1,2,3
    //EFFECTS: displays 3 lines of history
    private void displayHistory() {
        displayPanel.history1.setText(((history.getHistory()).get(0)).toString());
        displayPanel.history2.setText(((history.getHistory()).get(1)).toString());
        displayPanel.history3.setText(((history.getHistory()).get(2)).toString());
    }


    //Based on JSON serialization demo
    // EFFECTS: saves history to file
    private void saveHistory() {
        try {
            jsonWriter.open();
            jsonWriter.write(history);
            jsonWriter.close();
            System.out.println("Saved history to " + JSON_STORE);
            displayHistory();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    //Based on JSON serialization demo
    // MODIFIES: this
    // EFFECTS: loads history from file
    private void loadHistory() {
        try {
            jsonReader.read(history);
            System.out.println("Loaded History from " + JSON_STORE);
            displayHistory();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }

    }

    //MODIFIES: result, history
    //EFFECTS: Scans for button click and prompts corresponding action
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == distancePanel.fdButton) {
            result = Double.toString(distancePanel.findDistance());
            history.addHistory(distancePanel.getOp());
        } else {
            Vector arg1 = argPanel1.getArg();
            Vector arg2 = argPanel2.getArg();
            if (e.getSource() == opPanel.add) {
                result = (Vector.add(arg1, arg2)).toString();
                history.addHistory(new Operation(arg1.toString(), arg2.toString(), 1));
            } else if (e.getSource() == opPanel.subtract) {
                result = (Vector.subtract(arg1, arg2).toString());
                history.addHistory(new Operation(arg1.toString(), arg2.toString(), 2));
            } else if (e.getSource() == opPanel.dot) {
                result = Double.toString(Vector.dotProduct(arg1, arg2));
                history.addHistory(new Operation(arg1.toString(), arg2.toString(), 3));
            } else if (e.getSource() == opPanel.cross) {
                result = (Vector.crossProduct(arg1, arg2)).toString();
                history.addHistory(new Operation(arg1.toString(), arg2.toString(), 4));
            } else if (e.getSource() == opPanel.length) {
                result = Double.toString(arg1.getDistance());
                history.addHistory(new Operation(arg1.toString(), "", 5));
            } else if (e.getSource() == displayPanel.save) {
                saveHistory();
            } else if (e.getSource() == displayPanel.load) {
                loadHistory();
            }
        }
        displayResult();
    }


}


//

//
