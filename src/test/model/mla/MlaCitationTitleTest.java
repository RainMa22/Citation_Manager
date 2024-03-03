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
    public void testConstructorJson() {
        MlaCitationTitle[] titles = {major, minor, inactive};
        for (MlaCitationTitle title : titles) {
            assertEquals(title.toString(), new MlaCitationTitle(title.asJson()).toString());
        }
    }

    @Test
    public void testSetMode() {
        MlaCitationTitle[] titles = {major, minor, inactive};
        for (MlaCitationTitle title : titles) {
            title.setMode(MlaCitationTitle.MINOR);
            assertEquals("\"", title.getHead());
            assertEquals(".\" ", title.getTail());

            title.setMode(MlaCitationTitle.INACTIVE);
            assertEquals("\"", title.getHead());
            assertEquals(".\" ", title.getTail());

            title.setMode(MlaCitationTitle.MAJOR);
            assertEquals("<i>", title.getHead());
            assertEquals("</i>. ", title.getTail());

            title.setMode(MlaCitationTitle.INACTIVE);
            assertEquals("<i>", title.getHead());
            assertEquals("</i>. ", title.getTail());
        }
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
