package Persistence;

import model.History;
import model.Operation;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public void read(History h) throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        loadHistory(h, jsonObject);
    }


    // MODIFIES: history
    // EFFECTS: parses operations from history and adds them to current history
    private void loadHistory(History h, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("history");
        for (Object json : jsonArray) {
            JSONObject nextOp = (JSONObject) json;
            addOp(h, nextOp);
        }
    }


    // MODIFIES: history
    // EFFECTS: parses operations from JSON object and adds it to history
    private void addOp(History h, JSONObject jsonObject) {
        String arg1 = jsonObject.getString("arg1");
        String arg2 = jsonObject.getString("arg2");
        String op = jsonObject.getString("op");
        Operation o = new Operation(arg1, arg2, op);
        h.addHistory(o);
    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }


}
