package model.apa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApaCitationTitleTest {
    ApaCitationTitle major;
    ApaCitationTitle minor;
    ApaCitationTitle inactive;

    @BeforeEach
    public void setup() {
        major = new ApaCitationTitle("asdda", false);
        minor = new ApaCitationTitle("sad", true);
        inactive = new ApaCitationTitle("", true);
    }

    @Test
    public void testConstructor() {
        //title is tested in CitationTitleTest
        assertFalse(major.isAcademicArticle());
        assertTrue(minor.isAcademicArticle());
    }

    @Test
    public void testToStringMajor() {
        assertEquals("<i>asdda</i>. ", major.toString());
    }

    @Test
    public void testToStringMinor() {
        assertEquals("sad. ", minor.toString());
    }

    @Test
    public void testToStringInactive() {
        assertEquals("", inactive.toString());
    }
}
