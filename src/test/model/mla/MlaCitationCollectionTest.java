package model.mla;

import model.apa.ApaCitationCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MlaCitationCollectionTest {
    MlaCitationCollection major;

    @BeforeEach
    public void setup() {
        major = new MlaCitationCollection("asdda");
    }

    @Test
    public void testToStringMajor() {
        assertEquals("<i>asdda</i>, ", major.toString());
    }

    @Test
    public void testConstructorJson() {
        assertEquals(major.toString(), new ApaCitationCollection(major.asJson()).toString());
    }
}
