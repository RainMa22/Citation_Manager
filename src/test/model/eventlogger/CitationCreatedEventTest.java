package model.eventlogger;

import model.Citation;
import model.mla.MlaCitation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CitationCreatedEventTest extends EventTest {
    private CitationCreatedEvent cce;
    private Citation citation;
    private Date t0;
    private String msg;

    @Override
    @BeforeEach
    public void runBefore() {
        super.runBefore();
        citation = new MlaCitation("a", "b", false, "d", 2, "f", "g", "h", "i", "j");
        cce = new CitationCreatedEvent(citation);
        t0 = Calendar.getInstance().getTime();
        msg = String.format("Citation of type %s, and of ID %s created.", citation.getClass(), citation.hashCode());
    }

    @Override
    @Test
    public void testEvent() {
        super.testEvent();
        assertEquals(msg, cce.getDescription());
        assertEquals(t0, cce.getDate());
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        assertEquals(t0.toString() + "\n" + msg, cce.toString());
    }
}
