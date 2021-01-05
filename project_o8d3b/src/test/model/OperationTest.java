package model;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
    public void testOpType() {
        String arg1 = "(1.0 2.0 3.0) + (5.0 6.0 7.0)t";
        String arg2 = "(1.0 2.0 3.0)";
        Operation result1 = new Operation(arg1, arg2, 1);
        assertEquals("+", result1.getOp());
        Operation result2 = new Operation(arg1, arg2, 2);
        assertEquals("-", result2.getOp());
        Operation result3 = new Operation(arg1, arg2, 3);
        assertEquals("•", result3.getOp());
        Operation result4 = new Operation(arg1, arg2, 4);
        assertEquals("x", result4.getOp());
        Operation result5 = new Operation(arg1, arg2, 5);
        assertEquals("Vector Length", result5.getOp());
        Operation result6 = new Operation(arg1, arg2, 6);
        assertEquals("Distance to", result6.getOp());
    }


    @Test
    public void testOpToString() {
        String arg1 = "((1.0 2.0 3.0) + (5.0 6.0 7.0)t)";
        String arg2 = "(1.0 2.0 3.0)";
        Operation result = new Operation(arg1, arg2, 1);
        assertEquals("((1.0 2.0 3.0) + (5.0 6.0 7.0)t) + (1.0 2.0 3.0)", result.toString());
    }

    @Test
    public void testStringConstructor() {
        Operation op = new Operation("writing", "suck", "tests");
        assertEquals("writing tests suck", op.toString());

    }

    @Test
    public void testGetOp() {
        Operation op = new Operation("writing", "suck", "tests");
        assertEquals("tests", op.getOp());

    }

    @Test
    public void testOpToJason() {
        Operation operation = new Operation("writing", "suck", "tests");
        JSONObject result = operation.toJson();
        String arg1 = result.getString("arg1");
        String arg2 = result.getString("arg2");
        String op = result.getString("op");
        Operation o = new Operation(arg1, arg2, op);
        assertEquals(operation.toString(), o.toString());

    }


}
