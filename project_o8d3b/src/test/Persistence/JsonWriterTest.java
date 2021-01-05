package Persistence;

import model.History;
import model.Operation;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//  Code based on json serialization demo on edx
class JsonWriterTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testWriterEmptyHistory() {
        try {
            History history = new History();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(history);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            reader.read(history);
            assertEquals((new ArrayList<Operation>()), history.getHistory());
            assertEquals(0, history.getHistory().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterHistory() {
        try {
            History history = new History();
            Operation op = new Operation("1", "1", "+");
            history.addHistory(op);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralHistory.json");
            writer.open();
            writer.write(history);
            writer.close();
            history.clearHistory();

            JsonReader reader = new JsonReader("./data/testWriterGeneralHistory.json");
            reader.read(history);
            List<Operation> ops = history.getHistory();
            assertEquals(1, ops.size());
            assertEquals("1 + 1", history.getHistory().get(0).toString());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}


