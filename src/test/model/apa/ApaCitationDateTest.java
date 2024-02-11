package model.apa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApaCitationDateTest {
    ApaCitationDate invalid;
    ApaCitationDate yearOnly;
    ApaCitationDate yearMonth;
    ApaCitationDate yearMonthDay;

    @BeforeEach
    public void setup() {
        invalid = new ApaCitationDate("my birthday");
        yearOnly = new ApaCitationDate("2024");
        yearMonth = new ApaCitationDate("2024-03");
        yearMonthDay = new ApaCitationDate("2024-03-26");
    }

    @Test
    public void testToStringInvalid() {
        assertEquals("", invalid.toString());
    }

    @Test
    public void testToStringYear() {
        assertEquals("2024, ", yearOnly.toString());
    }

    @Test
    public void testToStringYearMonth() {
        assertEquals("Mar. 2024, ", yearMonth.toString());
    }

    @Test
    void testToStringYearMonthDay() {
        assertEquals("26 Mar. 2024, ", yearMonthDay.toString());
    }
}
