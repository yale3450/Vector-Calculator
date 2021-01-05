package Persistence;


import model.History;
import model.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;


import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {
    History history;

    @BeforeEach
    void init() {
        history = new History();
    }

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            reader.read(history);
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyHistory() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyHistory.json");
        try {
            reader.read(history);
            assertEquals(0, history.getHistory().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        try {
            JsonReader reader = new JsonReader("./data/testWriterGeneralHistory.json");
            reader.read(history);
            List<Operation> ops = history.getHistory();
            assertEquals(1, ops.size());
            assertEquals("1 + 1", history.getHistory().get(0).toString());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}