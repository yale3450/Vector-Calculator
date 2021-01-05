package model;

import org.json.JSONObject;
import persistence.Writable;

//A set of thee strings containing the two arguments and operation//
public class Operation implements Writable {
    private String arg1;
    private String arg2;
    private String op;


    // Constructor: produces the operation in string form depending on the operation type
    public Operation(String arg1, String arg2, int opType) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        if (opType == 1) {
            this.op = "+";
        } else if (opType == 2) {
            this.op = "-";
        } else if (opType == 3) {
            op = "•";
        } else if (opType == 4) {
            op = "x";
        } else if (opType == 5) {
            op = "Vector Length";
        } else if (opType == 6) {
            op = "Distance to";
        }
    }

    //Constructor using string arguments
    public Operation(String arg1, String arg2, String op) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.op = op;
    }

    //EFFECTS: returns operation
    public String getOp() {
        return op;
    }


    //EFFECTS: Allows operation to be displayed as a string//
    public String toString() {
        return arg1 + " " + op + " " + arg2;
    }

    //EFFECTS: returns operation as a json object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("arg1", arg1);
        json.put("arg2", arg2);
        json.put("op", op);
        return json;
    }

}
