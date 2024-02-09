package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CitationDateTest {

    CitationDate yearOnly;
    CitationDate yearAndMonth;
    CitationDate yearMonthAndDay;
    CitationDate invalid;

    @BeforeEach
    public void setup() {
        invalid = new MockCitationDate("My birthday!");
        yearOnly = new MockCitationDate("2024");
        yearAndMonth = new MockCitationDate("2024-03");
        yearMonthAndDay = new MockCitationDate("2024-03-26");
    }

    @Test
    public void testConstructorInvalid(){
        assertEquals(CitationDate.INACTIVE, invalid.getMode());
    }

    @Test
    public void testConstructorYearOnly() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");

        assertEquals(CitationDate.YEAR_ONLY, yearOnly.getMode());
        try {
            assertEquals(formatter.parse("2024"), yearOnly.getDate());
        } catch (ParseException pe) {
            fail(pe);
        }
    }

    @Test
    public void testConstructorYearAndMonth() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");

        assertEquals(CitationDate.YEAR_AND_MONTH, yearAndMonth.getMode());
        try {
            assertEquals(formatter.parse("2024-03"), yearAndMonth.getDate());
        } catch (ParseException pe) {
            fail(pe);
        }
    }

    @Test
    public void testConstructorYearMonthDay() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        assertEquals(CitationDate.YEAR_MONTH_AND_DAY, yearMonthAndDay.getMode());
        try {
            assertEquals(formatter.parse("2024-03-26"), yearMonthAndDay.getDate());
        } catch (ParseException pe) {
            fail(pe);
        }
    }

    @Test
    public void testToStringNoOutputTemplate(){
        assertEquals("", invalid.toString());
        assertEquals("", yearOnly.toString());
        assertEquals("", yearAndMonth.toString());
        assertEquals("", yearMonthAndDay.toString());
    }

    static class MockCitationDate extends CitationDate {
        public MockCitationDate(String dateString) {
            super(dateString);
        }

    }


}
