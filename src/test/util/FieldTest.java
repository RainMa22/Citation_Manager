package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Field;

import static org.junit.jupiter.api.Assertions.*;

public class FieldTest {
    Field<String> stringField;
    Field<Integer> intField;
    Field<Double> doubleField;

    @BeforeEach
    public void setup() {
        stringField = new Field<>("test with string", "name = %1$s, and data = %2$s", true);
        intField = new Field<>("test with int", "name = %1$s, and data = %2$d", false);
        doubleField = new Field<>("test with double", "name = %1$s, and data = %2$.1f", true);
    }

    @Test
    public void testConstructor() {
        assertEquals("test with string", stringField.getName());
        assertEquals("name = %1$s, and data = %2$s", stringField.getToStringTemplate());
        assertTrue(stringField.isOptional());

        assertEquals("test with int", intField.getName());
        assertEquals("name = %1$s, and data = %2$d", intField.getToStringTemplate());
        assertFalse(intField.isOptional());

        assertEquals("test with double", doubleField.getName());
        assertEquals("name = %1$s, and data = %2$.1f", doubleField.getToStringTemplate());
        assertTrue(doubleField.isOptional());
    }
    @Test
    public void testToStringDefined(){
        stringField.setInfo("information");
        assertEquals("name = test with string, and data = information", stringField.toString());

        intField.setInfo(0);
        assertEquals("name = test with int, and data = 0", intField.toString());

        doubleField.setInfo(0.5d);//set to 1/2 to avoid floating point error
        assertEquals("name = test with double, and data = 0.5", doubleField.toString());
    }
    @Test
    public void testToStringUndefined(){
        assertEquals("", stringField.toString());
        assertEquals("", intField.toString());
        assertEquals("", doubleField.toString());
    }
}
