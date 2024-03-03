package model.apa;

import model.Citation;
import model.InvalidCitationError;
import model.mla.MlaCitation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ApaFullCitationTest {
    ApaFullCitation apaFullCitation = new ApaFullCitation();

    @BeforeEach
    public void setup() {
        apaFullCitation = new ApaFullCitation();
    }

    @Test
    public void testConstructor() {
        assertEquals("<center>References</center>\n", apaFullCitation.getHead());
    }

    @Test
    public void testConstructorJson() {
        assertEquals(apaFullCitation.toString(), new ApaFullCitation(apaFullCitation.asJson()).toString());
        Citation testCitation = new ApaCitation("apple", "book", false, false,
                null, null, null, null, null, null, null);
        Citation testCitation2 = new ApaCitation("banana", "book", false, false,
                null, null, null, null, null, null, null);
        apaFullCitation.add(testCitation);
        apaFullCitation.add(testCitation2);
        assertEquals(apaFullCitation.toString(), new ApaFullCitation(apaFullCitation.asJson()).toString());

    }

    @Test
    public void testToStringNoItem() {
        assertEquals("<center>References</center>\n", apaFullCitation.toString());
    }

    @Test
    public void testToStringOneItem() {
        Citation testCitation = new ApaCitation("apple", "book", false, false,
                null, null, null, null, null, null, null);
        apaFullCitation.add(testCitation);
        assertEquals(String.join("\n", "<center>References</center>", testCitation.toString()),
                apaFullCitation.toString());
    }

    @Test
    public void testToStringMoreThanOneItem() {
        Citation testCitation = new ApaCitation("apple", "book", false, false,
                null, null, null, null, null, null, null);
        Citation testCitation2 = new ApaCitation("banana", "book", false, false,
                null, null, null, null, null, null, null);
        apaFullCitation.add(testCitation);
        apaFullCitation.add(testCitation2);
        assertEquals(String.join("\n", "<center>References</center>", testCitation.toString(),
                testCitation2.toString()), apaFullCitation.toString());
    }

    @Test
    public void testAddInvalid() {
        Citation testCitation = new MlaCitation("apple", "book", false, null,
                null, null, null, null, null, null);
        try {
            apaFullCitation.add(testCitation);
            fail();
        } catch (InvalidCitationError expected) {
            //expected
        }
    }

}
