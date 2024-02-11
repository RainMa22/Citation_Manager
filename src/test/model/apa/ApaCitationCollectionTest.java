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
    public void testToStringMajor() {
        assertEquals("<i>asdda</i>, ", major.toString());
    }
}
