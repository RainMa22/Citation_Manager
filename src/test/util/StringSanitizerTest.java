package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringSanitizerTest {

    @Test
    public void testSanitizeStringLeadingAndTailingSpaces() {
        assertEquals("asd", StringUtils.sanitizeString("   asd   "));
    }

    @Test
    public void testSanitizeStringDoubleSpace() {
        assertEquals("pain and suffering", StringUtils.sanitizeString("pain  and    suffering"));
    }

    @Test
    public void testRemoveDup() {
        assertEquals("apple.", StringUtils.removeDuplicate("apple.................", "."));
        assertEquals("bana", StringUtils.removeDuplicate("banana", "na"));
        assertEquals("banana.", StringUtils.removeDuplicate("banana.", "."));
    }

    @Test
    public void testRemoveTailing() {
        assertEquals("apple", StringUtils.removeTailing("apple......", "."));
        assertEquals("ba", StringUtils.removeTailing("banana", "na"));
    }
}
