package model.apa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApaAuthorNameTest {
    ApaAuthorName noName;
    ApaAuthorName oneName;
    ApaAuthorName twoName;
    ApaAuthorName threeName;
    ApaAuthorName fourname;

    @BeforeEach
    public void setup() {
        noName = new ApaAuthorName("");
        oneName = new ApaAuthorName("Joe");
        twoName = new ApaAuthorName("Stove  Jeebs");
        threeName = new ApaAuthorName("George r. Martin");
    }

    @Test
    public void testConstructorOneName() {
        assertEquals("Joe", oneName.getLastName());
    }

    @Test
    public void testConstructorTwoName() {
        assertEquals('S', twoName.getFirstName());
        assertEquals("Jeebs", twoName.getLastName());
    }

    @Test
    public void testConstructorThreeName() {
        assertEquals('G', threeName.getFirstName());
        assertEquals('R', threeName.getMiddleName());
        assertEquals("Martin", threeName.getLastName());
    }

    @Test
    public void testConstructorFourName() {
        fourname = new ApaAuthorName("A B C D");

        assertEquals('A', fourname.getFirstName());
        assertEquals('B', fourname.getMiddleName());
        assertEquals("D", fourname.getLastName());
    }

    @Test
    public void testToStringOneName() {
        assertEquals("Joe", oneName.toString());
    }

    @Test
    public void testToString() {
        assertEquals("", noName.toString());
        assertEquals("Martin, G. R.", threeName.toString());
        assertEquals("Jeebs, S.", twoName.toString());
    }
}
