package model.eventlogger;

import model.Citation;
import model.FullCitation;
import model.mla.MlaCitation;
import model.mla.MlaFullCitation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CitationAddedEventTest extends EventTest {
    private CitationAddedEvent cae;
    private Date t0;
    private String msg;

    @Override
    @BeforeEach
    public void runBefore() {
        super.runBefore();
        Citation citation = new MlaCitation("a", "b", false, "d", 2, "f", "g", "h", "i", "j");
        FullCitation fullCitation = new MlaFullCitation();

        cae = new CitationAddedEvent(fullCitation, citation);

        t0 = Calendar.getInstance().getTime();
        msg = String.format("Citation of type %s(ID %s) is added to %s(ID %s)", citation.getClass(),
                citation.hashCode(), fullCitation.getClass(), fullCitation.hashCode());
    }

    @Override
    @Test
    public void testEvent() {
        super.testEvent();
        assertEquals(msg, cae.getDescription());
        assertEquals(t0, cae.getDate());
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        assertEquals(t0.toString() + "\n" + msg, cae.toString());
    }
}
