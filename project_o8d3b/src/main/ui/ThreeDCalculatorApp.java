package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//THIS IS BASED ON TELLER APP PROVIDED IN LECTURE
//3D calculator application
public class ThreeDCalculatorApp {

    private Scanner input = new Scanner(System.in);
    private int objectType = 0;
    private int operationType = 0;
    private History history = new History();
    private JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    private JsonReader jsonReader = new JsonReader(JSON_STORE);
    private static final String JSON_STORE = "./data/history.json";

    // EFFECTS: runs the 3d calculator application
    public ThreeDCalculatorApp() {
        runThreeDCalculator();
    }


    // MODIFIES: this
    // EFFECTS: processes user input
    private void runThreeDCalculator() {
        boolean keepGoing = true;
        int command;

        while (keepGoing) {
            displayMenu();
            command = input.nextInt();

            if (command == 10) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from menu using the number:");
        System.out.println("\t1. Add");
        System.out.println("\t2. Subtract");
        System.out.println("\t3. Dot Product");
        System.out.println("\t4. Cross Product");
        System.out.println("\t5. Find Vector Length");
        System.out.println("\t6. Find Distance Between Two Objects");
        System.out.println("\t7. Show History");
        System.out.println("\t8. Save History");
        System.out.println("\t9. Load History");
        System.out.println("\t10. Quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(int command) {
        if (command > 0 && command < 6) {
            operationType = command;
            vectorOperation();
        } else if (command == 6) {
            operationType = command;
            distanceOperation();
        } else if (command == 7) {
            printHistory();
        } else if (command == 8) {
            saveHistory();
        } else if (command == 9) {
            loadHistory();
        } else {
            System.out.println("Selection not valid...");
        }
    }


    private void printHistory() {
        int index = 0;
        while (index < history.getHistory().size()) {
            for (Operation op : history.getHistory()) {
                System.out.println(op);
                index++;
            }
        }
    }

    //
    // EFFECTS: Chooses vector operation types
    private void vectorOperation() {
        Vector v1 = getVector();
        if (operationType == 5) {
            System.out.printf("Length: %.10f\n", v1.getDistance());
            Operation operation = new Operation(v1.toString(), "", operationType);
            history.addHistory(operation);
        } else {
            Vector v2 = getVector();
            if (operationType == 1) {
                System.out.println(Vector.add(v1, v2));
            } else if (operationType == 2) {
                System.out.println(Vector.subtract(v1, v2));
            } else if (operationType == 3) {
                System.out.printf("Dot Product: %.10f\n", Vector.dotProduct(v1, v2));
            } else if (operationType == 4) {
                System.out.println(Vector.crossProduct(v1, v2));
            }
            Operation operation = new Operation(v1.toString(), v2.toString(), operationType);
            history.addHistory(operation);
        }
    }

    //EFFECTS: Chooses distance operation type
    private void distanceOperation() {
        double result = 0;
        objectTypeMenu();
        if (objectType == 1) {
            Point argOne = getPoint();
            FindDistanceObject argTwo = getSecondArg();
            result = argTwo.toPoint(argOne);
            Operation operation = new Operation(argOne.toString(), argTwo.toString(), operationType);
            history.addHistory(operation);
        } else if (objectType == 2) {
            Line argOne = getLine();
            FindDistanceObject argTwo = getSecondArg();
            result = argTwo.toLine(argOne);
            Operation operation = new Operation(argOne.toString(), argTwo.toString(), operationType);
            history.addHistory(operation);
        } else if (objectType == 3) {
            Plane argOne = getPlane();
            FindDistanceObject argTwo = getSecondArg();
            result = argTwo.toPlane(argOne);
            Operation operation = new Operation(argOne.toString(), argTwo.toString(), operationType);
            history.addHistory(operation);
        }
        System.out.printf("Distance: %.10f\n", result);
    }

    //MODIFIES: objectType
    //EFFECTS: Displays object type menu
    private void objectTypeMenu() {
        System.out.println("\nChoose Object Type and input the number");
        System.out.println("\n1.Point");
        System.out.println("\n2.Line");
        System.out.println("\n3.Plane");
        objectType = input.nextInt();

    }

    //MODIFIES: OBJECT TYPE
    //EFFECTS: Chooses second argument for distance operations
    private FindDistanceObject getSecondArg() {
        FindDistanceObject secondArg = null;
        System.out.println("\nChoose the second object Type and input the number");
        System.out.println("\n1.Point");
        System.out.println("\n2.Line");
        System.out.println("\n3.Plane");
        objectType = input.nextInt();
        if (objectType == 1) {
            secondArg = getPoint();
        }
        if (objectType == 2) {
            secondArg = getLine();
        }
        if (objectType == 3) {
            secondArg = getPlane();
        }
        return secondArg;

    }

    //EFFECTS: gets vector from user input
    private Vector getVector() {
        System.out.println("\n Enter X Coordinate");
        double cordX = input.nextInt();
        System.out.println("\n Enter Y Coordinate");
        double cordY = input.nextInt();
        System.out.println("\n Enter Z Coordinate");
        double cordZ = input.nextInt();
        return new Vector(cordX, cordY, cordZ);
    }

    //EFFECTS: gets point from user input
    private Point getPoint() {
        System.out.println("\n Enter X Coordinate");
        double cordX = input.nextInt();
        System.out.println("\n Enter Y Coordinate");
        double cordY = input.nextInt();
        System.out.println("\n Enter Z Coordinate");
        double cordZ = input.nextInt();
        return new Point(cordX, cordY, cordZ);
    }

    //EFFECTS: gets line from user input
    private Line getLine() {
        System.out.println("\n Enter X Coordinate of a point on the line");
        double cordX = input.nextInt();
        System.out.println("\n Enter Y Coordinate of a point on the line");
        double cordY = input.nextInt();
        System.out.println("\n Enter Z Coordinate of a point on the line");
        double cordZ = input.nextInt();
        System.out.println("\n Enter X value of the line's direction vector");
        double vecX = input.nextInt();
        System.out.println("\n Enter Y value of the line's direction vector");
        double vecY = input.nextInt();
        System.out.println("\n Enter Z value of the line's direction vector");
        double vecZ = input.nextInt();
        Point p = new Point(cordX, cordY, cordZ);
        Vector vector = new Vector(vecX, vecY, vecZ);
        return new Line(p, vector);
    }

    //EFFECTS: gets plane from user input
    private Plane getPlane() {
        System.out.println("\n Enter X Coordinate of a point on the plane");
        double cordX = input.nextInt();
        System.out.println("\n Enter Y Coordinate of a point on the plane");
        double cordY = input.nextInt();
        System.out.println("\n Enter Z Coordinate of a point on the plane");
        double cordZ = input.nextInt();
        System.out.println("\n Enter X value of the plane's normal vector");
        double vecX = input.nextInt();
        System.out.println("\n Enter Y value of the plane's normal vector");
        double vecY = input.nextInt();
        System.out.println("\n Enter Z value of the plane's normal vector");
        double vecZ = input.nextInt();
        Point p = new Point(cordX, cordY, cordZ);
        Vector vector = new Vector(vecX, vecY, vecZ);
        return new Plane(p, vector);
    }

    //Based on JSON serialization demo
    // EFFECTS: saves history to file
    private void saveHistory() {
        try {
            jsonWriter.open();
            jsonWriter.write(history);
            jsonWriter.close();
            System.out.println("Saved history to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads history from file
    private void loadHistory() {
        try {
            jsonReader.read(history);
            System.out.println("Loaded History from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}



