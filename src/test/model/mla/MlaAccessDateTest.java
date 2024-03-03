package model.mla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MlaAccessDateTest {
    MlaAccessDate invalid;
    MlaAccessDate yearOnly;
    MlaAccessDate yearMonth;
    MlaAccessDate yearMonthDay;

    @BeforeEach
    public void setup() {
        invalid = new MlaAccessDate("my birthday");
        yearOnly = new MlaAccessDate("2024");
        yearMonth = new MlaAccessDate("2024-03");
        yearMonthDay = new MlaAccessDate("2024-03-26");
    }

    @Test
    public void testConstructorJson() {
        MlaAccessDate[] dates = {invalid, yearOnly, yearMonth, yearMonthDay};
        for (MlaAccessDate date : dates) {
            assertEquals(date.toString(), new MlaAccessDate(date.asJson()).toString());
        }
    }

    @Test
    public void testToStringInvalid() {
        assertEquals("", invalid.toString());
    }

    @Test
    public void testToStringYear() {
        assertEquals("Accessed 2024. ", yearOnly.toString());
    }

    @Test
    public void testToStringYearMonth() {
        assertEquals("Accessed Mar. 2024. ", yearMonth.toString());
    }

    @Test
    void testToStringYearMonthDay() {
        assertEquals("Accessed 26 Mar. 2024. ", yearMonthDay.toString());
    }
}
