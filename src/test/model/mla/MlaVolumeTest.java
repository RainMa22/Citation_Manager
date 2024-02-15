package model.mla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MlaVolumeTest {
    MlaVolume mv;

    @BeforeEach
    public void setup() {
        mv = new MlaVolume(2);
    }

    @Test
    public void testConstructor() {
        assertEquals("vol.", mv.getHead());
        assertEquals(2, mv.getBody());
        assertEquals(", ", mv.getTail());
    }
}
