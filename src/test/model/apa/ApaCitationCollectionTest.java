package model.apa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApaCitationCollectionTest {
    ApaCitationCollection major;

    @BeforeEach
    public void setup() {
        major = new ApaCitationCollection("asdda");
    }

    @Test
    public void testConstructor() {
        assertEquals("asdda", major.getTitle());
    }

    @Test
    public void testConstructorJson() {
        assertEquals(major.toString(), new ApaCitationCollection(major.asJson()).toString());
    }

    @Test
    public void testToString() {
        assertEquals("<i>asdda</i>, ", major.toString());
    }
}
