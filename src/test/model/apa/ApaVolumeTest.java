package model.apa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApaVolumeTest {
    ApaVolume mv;

    @BeforeEach
    public void setup() {
        mv = new ApaVolume(2);
    }

    @Test
    public void testConstructor() {
        assertEquals("", mv.getHead());
        assertEquals(2, mv.getBody());
        assertEquals("", mv.getTail());
    }
}
