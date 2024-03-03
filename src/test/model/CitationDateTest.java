package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
    public void testConstructorInvalid() {
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
    public void testConstructorJson() {
        CitationDate[] dates = {invalid, yearOnly, yearAndMonth, yearMonthAndDay};
        for (CitationDate date : dates) {
            assertEquals(new MockCitationDate(date.asJson()).toString(), date.toString());
        }
    }

    @Test
    public void testConstructorBadJson() {
        JSONObject json = yearOnly.asJson();
        json.remove("dateString");
        json.put("dateString", "invalid");
        try {
            new MockCitationDate(json);
            fail();
        } catch (JSONException pass) {
            //expected
        }
    }

    @Test
    public void testToStringNoOutputTemplate() {
        assertEquals("", invalid.toString());
        assertEquals("", yearOnly.toString());
        assertEquals("", yearAndMonth.toString());
        assertEquals("", yearMonthAndDay.toString());
    }

    @Test
    public void testAsJson() {
        CitationDate[] dates = {invalid, yearOnly, yearAndMonth, yearMonthAndDay};
        String[] dateStrings = {"", "2024", "2024-03", "2024-03-26"};
        for (int i = 0; i < dates.length; i++) {
            CitationDate date = dates[i];
            JSONObject json = new JSONObject();
            json.put("head", date.getHead());
            json.put("tail", date.getTail());
            json.put("mode", date.getMode());
            json.put("dateString", dateStrings[i]);
            json.put("outputTemplate", new JSONArray());
            assertEquals(json.toString(), date.asJson().toString());
        }
    }

    static class MockCitationDate extends CitationDate {
        public MockCitationDate(String dateString) {
            super(dateString);
        }

        public MockCitationDate(JSONObject json) {
            super(json);
        }


    }


}
