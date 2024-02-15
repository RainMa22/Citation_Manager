package model.mla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MlaLocationTest {
    MlaLocation location;

    @BeforeEach
    public void setup() {
        location = new MlaLocation("3s");
    }

    @Test
    public void testConstructor() {
        assertEquals("", location.getHead());
        assertEquals("3s", location.getBody());
        assertEquals(". ", location.getTail());
    }
}
