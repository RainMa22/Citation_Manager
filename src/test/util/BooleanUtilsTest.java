package util;

import static org.junit.jupiter.api.Assertions.*;
import static util.BooleanUtils.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BooleanUtilsTest {
    BooleanUtils whyDoINeedThis;

    @BeforeEach
    public void setup(){
        whyDoINeedThis = new BooleanUtils();
    }

    @Test
    public void testFromString() {
        assertTrue(fromString("t"));
        assertTrue(fromString("true"));
        assertTrue(fromString("1"));
        assertTrue(fromString("yes"));
        assertTrue(fromString("y"));
        assertFalse(fromString("f"));
        assertFalse(fromString("false"));
        assertFalse(fromString("0"));
        assertFalse(fromString("no"));
        assertFalse(fromString("n"));
        assertNull(fromString("asdsajdkh"));
    }

}
