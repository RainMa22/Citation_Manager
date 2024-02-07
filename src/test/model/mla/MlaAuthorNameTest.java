package model.mla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MlaAuthorNameTest {
    MlaAuthorName oneName;
    MlaAuthorName twoName;
    MlaAuthorName threeName;
    MlaAuthorName fourname;

    @BeforeEach
    public void setup(){
        oneName = new MlaAuthorName("Joe", true);
        twoName = new MlaAuthorName("Stove  Jeebs", true);
        threeName = new MlaAuthorName("George r. Martin", false);
    }
    @Test
    public void testConstructorOneName(){
        assertEquals("Joe", oneName.getFirstName());
        assertTrue(oneName.isInverted());
    }
    @Test
    public void testConstructorTwoName(){
        assertEquals("Stove", twoName.getFirstName());
        assertEquals("Jeebs", twoName.getLastName());
        assertTrue(twoName.isInverted());
    }
    @Test
    public void testConstructorThreeName(){
        assertEquals("George", threeName.getFirstName());
        assertEquals('R', threeName.getMiddleName());
        assertEquals("Martin", threeName.getLastName());
        assertFalse(threeName.isInverted());
    }
    @Test
    public void testConstructorFourName(){
        fourname = new MlaAuthorName("A B C D", false);

        assertEquals("A", fourname.getFirstName());
        assertEquals('B', fourname.getMiddleName());
        assertEquals("D", fourname.getLastName());
    }
    @Test
    public void testToStringOneName(){
        assertEquals("Joe", oneName.toString());
    }
    @Test
    public void testToStringInverted(){
        threeName.setInverted(true);

        assertEquals("Martin, George R.", threeName.toString());
        assertEquals("Jeebs, Stove", twoName.toString());
    }
    @Test
    public void testToStringNormal(){
        twoName.setInverted(false);

        assertEquals("Stove Jeebs", twoName.toString());
        assertEquals("George R. Martin", threeName.toString());
    }
}
