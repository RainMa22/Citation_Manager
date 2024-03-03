package model.mla;

import model.Citation;
import model.InvalidCitationError;
import model.apa.ApaCitation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MlaFullCitationTest {
    MlaFullCitation mlaFullCitation = new MlaFullCitation();

    @BeforeEach
    public void setup() {
        mlaFullCitation = new MlaFullCitation();
    }

    @Test
    public void testConstructor() {
        assertEquals("<center>Work Cited</center>\n", mlaFullCitation.getHead());
    }

    @Test
    public void testConstructorJson() {
        assertEquals(mlaFullCitation.toString(), new MlaFullCitation(mlaFullCitation.asJson()).toString());
        Citation testCitation = new MlaCitation("apple", "book", false, null, null, null, null, null, null, null);
        Citation testCitation2 = new MlaCitation("banana", "book", false, null, null, null, null, null, null, null);
        mlaFullCitation.add(testCitation);
        mlaFullCitation.add(testCitation2);
        assertEquals(mlaFullCitation.toString(), new MlaFullCitation(mlaFullCitation.asJson()).toString());
    }

    @Test
    public void testToStringNoItem() {
        assertEquals("<center>Work Cited</center>\n", mlaFullCitation.toString());
    }

    @Test
    public void testToStringOneItem() {
        Citation testCitation = new MlaCitation("apple", "book", false, null, null, null, null, null, null, null);
        mlaFullCitation.add(testCitation);
        assertEquals(String.join("\n", "<center>Work Cited</center>", testCitation.toString()), mlaFullCitation.toString());
    }

    @Test
    public void testToStringDuplicateAuthor() {
        Citation testCitation = new MlaCitation("apple", "book", false, null, null, null, null, null, null, null);
        Citation testCitation2 = new MlaCitation("apple", "another book", false, null, null, null, null, null, null, null);
        mlaFullCitation.add(testCitation);
        mlaFullCitation.add(testCitation2);
        assertEquals(String.join("\n", "<center>Work Cited</center>",
                testCitation2.toString(),
                testCitation.toString().replaceFirst("apple. ", "---. ")), mlaFullCitation.toString());
    }

    @Test
    public void testToStringMoreThanOneItem() {
        Citation testCitation = new MlaCitation("apple", "book", false, null, null, null, null, null, null, null);
        Citation testCitation2 = new MlaCitation("banana", "book", false, null, null, null, null, null, null, null);
        mlaFullCitation.add(testCitation);
        mlaFullCitation.add(testCitation2);
        assertEquals(String.join("\n", "<center>Work Cited</center>", testCitation.toString(), testCitation2.toString()), mlaFullCitation.toString());
    }

    @Test
    public void testAddInvalid() {
        Citation testCitation = new ApaCitation("apple", "book", false, false, null, null, null, null, null, null, null);
        try {
            mlaFullCitation.add(testCitation);
            fail();
        } catch (InvalidCitationError expected) {
            //expected
        }
    }

}
