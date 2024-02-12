package model.apa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApaAccessDateTest {
    ApaAccessDate invalid;
    ApaAccessDate yearOnly;
    ApaAccessDate yearMonth;
    ApaAccessDate yearMonthDay;

    @BeforeEach
    public void setup() {
        invalid = new ApaAccessDate("my birthday");
        yearOnly = new ApaAccessDate("2024");
        yearMonth = new ApaAccessDate("2024-03");
        yearMonthDay = new ApaAccessDate("2024-03-26");
    }

    @Test
    public void testToStringInvalid() {
        assertEquals("", invalid.toString());
    }

    @Test
    public void testToStringYear() {
        assertEquals("Retrieved 2024, from ", yearOnly.toString());
    }

    @Test
    public void testToStringYearMonth() {
        assertEquals("Retrieved March 2024, from ", yearMonth.toString());
    }

    @Test
    void testToStringYearMonthDay() {
        assertEquals("Retrieved March 26, 2024, from ", yearMonthDay.toString());
    }
}
