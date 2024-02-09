package model.mla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MlaCitationTitleTest {
    MlaCitationTitle major;
    MlaCitationTitle minor;
    MlaCitationTitle inactive;

    @BeforeEach
    public void setup() {
        major = new MlaCitationTitle("asdda", false);
        minor = new MlaCitationTitle("sad", true);
        inactive = new MlaCitationTitle("", true);
    }

    @Test
    public void testConstructor() {
        //title is tested in CitationTitleTest
        assertFalse(major.isMinor());
        assertTrue(minor.isMinor());
    }

    @Test
    public void testToStringMajor() {
        assertEquals("<i>asdda</i>. ", major.toString());
    }

    @Test
    public void testToStringMinor() {
        assertEquals("\"sad.\" ", minor.toString());
    }

    @Test
    public void testToStringInactive() {
        assertEquals("", inactive.toString());
    }
}
