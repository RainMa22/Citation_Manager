package model.mla;

import model.InvalidFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMlaAuthorName {
    MlaAuthorName twoName;
    MlaAuthorName threeName;
    @BeforeEach
    public void setup(){
        try{
            twoName = new MlaAuthorName("Stove Jeebs", true);
            threeName = new MlaAuthorName("George r. Martin", false);
        } catch (InvalidFormatException ignored){
            fail();
        }
    }
    @Test
    public void testConstructorTwoName(){
        assertEquals("Stove", twoName.getFirstName());
        assertNull(twoName.getMiddleName());
        assertEquals("Jeebs", twoName.getLastName());
    }
    @Test
    public void testConstructorThreeName(){
        assertEquals("George", threeName.getFirstName());
        assertEquals('R', threeName.getMiddleName());
        assertEquals("Martin", threeName.getLastName());
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
