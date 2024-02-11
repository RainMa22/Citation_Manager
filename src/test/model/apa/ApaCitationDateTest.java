package model.apa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApaCitationDateTest {
    ApaCitationDate invalid;
    ApaCitationDate yearOnly;
    ApaCitationDate yearMonth;
    ApaCitationDate yearMonthDay;
    ApaCitationDate academicInvalid;
    ApaCitationDate academicYearOnly;
    ApaCitationDate academicYearMonth;
    ApaCitationDate academicYearMonthDay;

    @BeforeEach
    public void setup() {
        invalid = new ApaCitationDate("my birthday", false);
        yearOnly = new ApaCitationDate("2024", false);
        yearMonth = new ApaCitationDate("2024-03", false);
        yearMonthDay = new ApaCitationDate("2024-03-26", false);

        academicInvalid = new ApaCitationDate("my birthday", true);
        academicYearOnly = new ApaCitationDate("2024", true);
        academicYearMonth = new ApaCitationDate("2024-03", true);
        academicYearMonthDay = new ApaCitationDate("2024-03-26", true);
    }

    @Test
    public void testConstructor() {
        assertEquals(ApaCitationDate.NO_DATE, invalid.getMode());
        assertEquals(ApaCitationDate.YEAR_ONLY, yearOnly.getMode());
        assertEquals(ApaCitationDate.YEAR_AND_MONTH, yearMonth.getMode());
        assertEquals(ApaCitationDate.YEAR_MONTH_AND_DAY, yearMonthDay.getMode());


        assertEquals(ApaCitationDate.NO_DATE, academicInvalid.getMode());
        assertEquals(ApaCitationDate.YEAR_ONLY, academicYearOnly.getMode());
        assertEquals(ApaCitationDate.YEAR_ONLY, academicYearMonth.getMode());
        assertEquals(ApaCitationDate.YEAR_ONLY, academicYearMonthDay.getMode());
    }

    @Test
    public void testToStringInvalid() {
        assertEquals("(n.d.). ", invalid.toString());
    }

    @Test
    public void testToStringAcademic() {
        assertEquals("(2024). ", academicYearOnly.toString());
        assertEquals("(2024). ", academicYearMonth.toString());
        assertEquals("(2024). ", academicYearMonthDay.toString());
    }

    @Test
    public void testToStringYear() {
        assertEquals("(2024). ", yearOnly.toString());
    }

    @Test
    public void testToStringYearMonth() {
        assertEquals("(2024, March). ", yearMonth.toString());
    }

    @Test
    void testToStringYearMonthDay() {
        assertEquals("(2024, March 26). ", yearMonthDay.toString());
    }
}
