package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

import static java.util.ArrayList.*;

//A class made to store a list of operations, history can be saved and read as a json file//
public class History implements Writable {
    private ArrayList<Operation> history;

    //Constructor//
    public History() {
        this.history = new ArrayList<>();
    }

    //MODIFIES: history
    //EFFECTS:Adds operations to history//
    public void addHistory(Operation o) {
        this.history.add(0,o);
    }

    //EFFECTS:Returns the list of operations//
    public ArrayList<Operation> getHistory() {
        return history;
    }

    //MODIFIES: HISTORY//
    //EFFECTS: CLEARS HISTORY//
    public void clearHistory() {
        history = new ArrayList<>();
    }

    // EFFECTS: returns operations in history as a JSON array
    public JSONArray opsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Operation o : history) {
            jsonArray.put(o.toJson());
        }
        return jsonArray;
    }

    //EFFECTS: RETURNS HISTORY AS A JSON ARRAY//
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("history", opsToJson());
        return json;
    }


}
