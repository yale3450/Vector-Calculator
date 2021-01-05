package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoryTest {

    @Test
    public void testAddHistory() {
        History result = new History();
        Operation op = new Operation("((1.0 2.0 3.0) + (5.0 6.0 7.0)t)", "(1.0 2.0 3.0)", 1);
        result.addHistory(op);
        ArrayList<Operation> compare = new ArrayList<>();
        compare.add(op);
        assertEquals(compare, result.getHistory());
    }


    @Test
    public void testClearHistory(){
        History result = new History();
        Operation op = new Operation("((1.0 2.0 3.0) + (5.0 6.0 7.0)t)", "(1.0 2.0 3.0)", 1);
        result.addHistory(op);
        result.clearHistory();
        assertEquals(0, result.getHistory().size());
    }

    @Test
    public void testJsonOpsToJson(){
        JSONArray jsonArray = new JSONArray();
        Operation op = new Operation("writing", "suck", "tests");
        jsonArray.put(op.toJson());

        History history = new History();
        history.addHistory(op);

        assertEquals(jsonArray.toString(), history.opsToJson().toString());
    }

    @Test
    public void testToJson(){
        History history = new History();
        JSONObject json = new JSONObject();
        json.put("history", history.opsToJson());

        assertEquals(json.toString(),history.toJson().toString());
    }




}
