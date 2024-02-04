package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldTest {
    Field<String> stringField;
    Field<Integer> intField;
    Field<Double> doubleField;

    @BeforeEach
    public void setup() {
        stringField = new Field<>("test with string", "name = %1$s, and data = %2$s");
        intField = new Field<>("test with int", "name = %1$s, and data = %2$d");
        doubleField = new Field<>("test with double", "name = %1$s, and data = %2$f");
    }

    @Test
    public void testConstructor() {
        assertEquals("test with string", stringField.getName());
        assertEquals("name = %1$s, and data = %2$s", stringField.getToStringTemplate());
        assertEquals("test with int", intField.getName());
        assertEquals("name = %1$s, and data = %2$d", intField.getToStringTemplate());
        assertEquals("test with double", doubleField.getName());
        assertEquals("name = %1$s, and data = %2$f", doubleField.getToStringTemplate());
    }
}
