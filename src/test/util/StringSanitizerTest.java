package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringSanitizerTest {

    @Test
    public void testSanitizeStringLeadingAndTailingSpaces() {
        assertEquals("asd", StringSanitizer.sanitizeString("   asd   "));
    }

    @Test
    public void testSanitizeStringDoubleSpace() {
        assertEquals("pain and suffering", StringSanitizer.sanitizeString("pain  and    suffering"));
    }

    @Test
    public void testRemoveDup() {
        assertEquals("apple.", StringSanitizer.removeDuplicate("apple.................", "."));
        assertEquals("bana", StringSanitizer.removeDuplicate("banana", "na"));
        assertEquals("banana.", StringSanitizer.removeDuplicate("banana.", "."));
    }

    @Test
    public void testRemoveTailing() {
        assertEquals("apple", StringSanitizer.removeTailing("apple......", "."));
        assertEquals("ba", StringSanitizer.removeTailing("banana", "na"));
    }
}
