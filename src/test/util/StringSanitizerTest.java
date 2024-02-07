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
        assertEquals("apple.", StringSanitizer.removeDupTailing("apple.................", "."));
        assertEquals("bana", StringSanitizer.removeDupTailing("banana", "na"));
        assertEquals("banana.", StringSanitizer.removeDupTailing("banana.", "."));
    }
}
