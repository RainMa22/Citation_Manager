package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringSanitizerTest {

    @Test
    public void testSanitizeStringLeadingAndTailingSpaces(){
        assertEquals("asd", StringSanitizer.sanitizeString("   asd   "));
    }

    @Test
    public void testSanitizeStringDoubleSpace(){
        assertEquals("pain and suffering", StringSanitizer.sanitizeString("pain  and    suffering"));
    }
    @Test
    public void testRemoveDupTailing(){
        assertEquals("apple.", StringSanitizer.removeDuplicate("apple.................", "."));
        assertEquals("bana", StringSanitizer.removeDuplicate("banana", "na"));
        assertEquals("banana.", StringSanitizer.removeDuplicate("banana.", "."));
    }
}
