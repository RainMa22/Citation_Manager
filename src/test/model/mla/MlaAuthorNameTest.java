package model.mla;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MlaAuthorNameTest {
    MlaAuthorName noName;
    MlaAuthorName oneName;
    MlaAuthorName twoName;
    MlaAuthorName threeName;
    MlaAuthorName fourName;

    @BeforeEach
    public void setup() {
        noName = new MlaAuthorName("", true);
        oneName = new MlaAuthorName("Joe", true);
        twoName = new MlaAuthorName("Stove  Jeebs", true);
        threeName = new MlaAuthorName("George r. Martin", false);
        fourName = new MlaAuthorName("A B C D", false);
    }

    @Test
    public void testConstructorJson() {
        MlaAuthorName[] names = {noName, oneName, twoName, threeName, fourName};
        for (MlaAuthorName name : names) {
            assertEquals(name.toString(), new MlaAuthorName(name.asJson()).toString());
        }
    }

    @Test
    public void testConstructorOneName() {
        assertEquals("Joe", oneName.getFirstName());
        assertTrue(oneName.isInverted());
    }

    @Test
    public void testConstructorTwoName() {
        assertEquals("Stove", twoName.getFirstName());
        assertEquals("Jeebs", twoName.getLastName());
        assertTrue(twoName.isInverted());
    }

    @Test
    public void testConstructorThreeName() {
        assertEquals("George", threeName.getFirstName());
        assertEquals("R", threeName.getMiddleName());
        assertEquals("Martin", threeName.getLastName());
        assertFalse(threeName.isInverted());
    }

    @Test
    public void testConstructorFourName() {
        assertEquals("A", fourName.getFirstName());
        assertEquals("B", fourName.getMiddleName());
        assertEquals("D", fourName.getLastName());
    }

    @Test
    public void testToStringOneName() {
        assertEquals("Joe", oneName.toString());
    }

    @Test
    public void testToStringInverted() {
        threeName.setInverted(true);
        assertEquals("", noName.toString());
        assertEquals("Martin, George R.", threeName.toString());
        assertEquals("Jeebs, Stove", twoName.toString());
    }

    @Test
    public void testToStringNormal() {
        twoName.setInverted(false);

        assertEquals("Stove Jeebs", twoName.toString());
        assertEquals("George R. Martin", threeName.toString());
    }

    @Test
    public void testAsJson() {
        MlaAuthorName[] names = {noName, oneName, twoName, threeName, fourName};
        for (MlaAuthorName name : names) {
            JSONObject out = new JSONObject();
            out.put("head", name.getHead());
            out.put("tail", name.getTail());
            out.put("mode", name.getMode());
            out.put("firstName", name.getFirstName());
            out.put("middleName", name.getMiddleName());
            out.put("lastName", name.getLastName());
            out.put("inverted", name.isInverted());
            assertEquals(out.toString(), name.asJson().toString());
        }
    }

}
