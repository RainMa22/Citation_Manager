package model.apa;

import org.json.JSONObject;
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
        fourname = new ApaAuthorName("A B C D");
    }

    @Test
    public void testConstructorOneName() {
        assertEquals("Joe", oneName.getLastName());
    }

    @Test
    public void testConstructorTwoName() {
        assertEquals("S", twoName.getFirstName());
        assertEquals("Jeebs", twoName.getLastName());
    }

    @Test
    public void testConstructorThreeName() {
        assertEquals("G", threeName.getFirstName());
        assertEquals("R", threeName.getMiddleName());
        assertEquals("Martin", threeName.getLastName());
    }

    @Test
    public void testConstructorFourName() {
        assertEquals("A", fourname.getFirstName());
        assertEquals("B", fourname.getMiddleName());
        assertEquals("D", fourname.getLastName());
    }

    @Test
    public void testConstructorJson() {
        ApaAuthorName[] names = {noName, oneName, twoName, threeName, fourname};
        for (ApaAuthorName name : names) {
            JSONObject json = new JSONObject();
            json.put("head", name.getHead());
            json.put("tail", name.getTail());
            json.put("mode", name.getMode());
            json.put("firstName", name.getFirstName());
            json.put("middleName", name.getMiddleName());
            json.put("lastName", name.getLastName());
            assertEquals(name.asJson().toString(), json.toString());
        }
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
