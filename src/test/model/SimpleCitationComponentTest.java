package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCitationComponentTest {
    SimpleCitationComponent stringSCC;
    SimpleCitationComponent intSCC;
    SimpleCitationComponent inactiveSCC;

    @BeforeEach
    public void setup() {
        stringSCC = new SimpleCitationComponent("ello", "h", ", world!");
        intSCC = new SimpleCitationComponent(0xFFFFFF, "the color is: ", ", which is white.");
        inactiveSCC = new SimpleCitationComponent("", "whatever", "whatever");
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
    }

    @Test
    public void testToString() {
        String stringSCCOut = String.join("ello", "h", ", world!");
        String intSCCOut = String.join(Integer.toString(0xFFFFFF), "the color is: ",
                ", which is white.");

        assertEquals(stringSCCOut, stringSCC.toString());
        assertEquals(intSCCOut, intSCC.toString());
        assertEquals("", inactiveSCC.toString());
    }
}
