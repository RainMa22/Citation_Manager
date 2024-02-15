package model.apa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApaLocationTest {
    ApaLocation location;

    @BeforeEach
    public void setup() {
        location = new ApaLocation("3s");
    }

    @Test
    public void testConstructor() {
        assertEquals("", location.getHead());
        assertEquals("3s", location.getBody());
        assertEquals("", location.getTail());
    }
}
