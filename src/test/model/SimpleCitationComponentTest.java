package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCitationComponentTest {
    SimpleCitationComponent stringSCC;
    SimpleCitationComponent intSCC;
    SimpleCitationComponent inactiveSCC;
    SimpleCitationComponent nullSCC;

    @BeforeEach
    public void setup() {
        stringSCC = new SimpleCitationComponent("ello", "h", ", world!");
        intSCC = new SimpleCitationComponent(0xFFFFFF, "the color is: ", ", which is white.");
        inactiveSCC = new SimpleCitationComponent("", "whatever", "whatever");
        nullSCC = new SimpleCitationComponent(null, "whatever", "whatever");
    }

    @Test
    public void testConstructor() {
        assertEquals("ello", stringSCC.getBody());
        assertEquals("h", stringSCC.getHead());
        assertEquals(", world!", stringSCC.getTail());

        assertEquals(0xFFFFFF, intSCC.getBody());
        assertEquals("the color is: ", intSCC.getHead());
        assertEquals(", which is white.", intSCC.getTail());

        assertEquals(SimpleCitationComponent.INACTIVE, inactiveSCC.getMode());
        assertEquals(SimpleCitationComponent.INACTIVE, nullSCC.getMode());
    }

    @Test
    public void testToString() {
        String stringSCCOut = String.join("ello", "h", ", world!");
        String intSCCOut = String.join(Integer.toString(0xFFFFFF), "the color is: ",
                ", which is white.");

        assertEquals(stringSCCOut, stringSCC.toString());
        assertEquals(intSCCOut, intSCC.toString());
        assertEquals("", inactiveSCC.toString());
        assertEquals("", nullSCC.toString());
    }

    @Test
    public void testStringToJson(){
        JSONObject stringSCCOut = new JSONObject();
        stringSCCOut.put("head","h");
        stringSCCOut.put("body", "ello");
        stringSCCOut.put("tail", ", world!");
        stringSCCOut.put("mode", SimpleCitationComponent.ACTIVE);
        assertEquals(stringSCCOut.toString(),stringSCC.asJson().toString());
    }

    @Test
    public void testIntToJson(){
        JSONObject intSCCOut = new JSONObject();
        intSCCOut.put("head", intSCC.getHead());
        intSCCOut.put("body", intSCC.getBody().toString());
        intSCCOut.put("tail", intSCC.getTail());
        intSCCOut.put("mode", SimpleCitationComponent.ACTIVE);
        assertEquals(intSCCOut.toString(),intSCC.asJson().toString());
    }

    @Test
    public void testInACTIVEToJson(){
        JSONObject inactiveSCCOut = new JSONObject();
        inactiveSCCOut.put("head","whatever");
        inactiveSCCOut.put("body", "");
        inactiveSCCOut.put("tail", "whatever");
        inactiveSCCOut.put("mode", SimpleCitationComponent.INACTIVE);
        assertEquals(inactiveSCCOut.toString(),inactiveSCC.asJson().toString());
        assertEquals(inactiveSCCOut.toString(),nullSCC.asJson().toString());
    }
}
