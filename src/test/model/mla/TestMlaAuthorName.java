package model.mla;

import model.InvalidFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestMlaAuthorName {
    MlaAuthorName twoName;
    MlaAuthorName threeName;
    MlaAuthorName fourname;
    @BeforeEach
    public void setup(){
        try{
            twoName = new MlaAuthorName("Stove Jeebs", true);
            threeName = new MlaAuthorName("George r. Martin", false);
        } catch (InvalidFormatException ife){
            fail(ife);
        }
    }
    @Test
    public void testConstructorTwoName(){
        assertEquals("Stove", twoName.getFirstName());
        assertNull(twoName.getMiddleName());
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
        MlaAuthorName fourname = null;
        ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();
        PrintStream stdout = System.out;

        System.setOut(new PrintStream(outputCaptor));
        try {
            fourname = new MlaAuthorName("A B C D", false);
            assertFalse(fourname.isInverted());
        } catch (InvalidFormatException ife){
            fail(ife);
        }

        System.setOut(stdout);

        assertEquals("A", fourname.getFirstName());
        assertEquals('B', fourname.getMiddleName());
        assertEquals("D", fourname.getLastName());
        assertNotNull(outputCaptor.toString().trim());
    }
    @Test
    public void testToStringInverted(){
        assertEquals("Jeebs, Stove", twoName.toString());
    }
    @Test
    public void testToStringNormal(){
        assertEquals("George R. Martin", threeName.toString());
    }
}
