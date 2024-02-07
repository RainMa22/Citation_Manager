package model.mla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MlaCitationDateTest {
    MlaCitationDate invalid;
    MlaCitationDate yearOnly;
    MlaCitationDate yearMonth;
    MlaCitationDate yearMonthDay;

    @BeforeEach
    public void setup(){
        invalid = new MlaCitationDate("my birthday");
        yearOnly = new MlaCitationDate("2024");
        yearMonth = new MlaCitationDate("2024-03");
        yearMonthDay = new MlaCitationDate("2024-03-26");
    }
    @Test
    public void testToStringInvalid(){
        assertEquals("", invalid.toString());
    }
    @Test
    public void testToStringYear(){
        assertEquals("2024", yearOnly.toString());
    }

    @Test
    public void testToStringYearMonth(){
        assertEquals("Mar. 2024", yearMonth.toString());
    }

    @Test void testToStringYearMonthDay(){
        assertEquals("26 Mar. 2024", yearMonthDay.toString());
    }
}
