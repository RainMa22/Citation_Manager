package model;

import model.apa.ApaCitation;
import model.eventlogger.CitationAddedEvent;
import model.eventlogger.CitationRemovedEvent;
import model.eventlogger.Event;
import model.eventlogger.EventLog;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FullCitationTest {
    FullCitation mfc;

    @BeforeEach
    public void setup() {
        mfc = new MockFullCitation();
    }

    @Test
    public void testConstructor() {
        assertEquals(MockFullCitation.ACTIVE, mfc.getMode());
        assertEquals(0, mfc.getCitations().size());
    }

    @Test
    public void testAddOneItem() {
        Citation testCitation = new ApaCitation("apple", "book", false, false,
                null, null, null, null, null, null, null);
        mfc.add(testCitation);
        assertEquals(1, mfc.getCitations().size());
        assertEquals(testCitation, mfc.getCitations().first());
        assertEquals(testCitation, mfc.getCitations().last());
    }

    @Test
    public void testRemove() {
        Citation testCitation = new ApaCitation("apple", "book", false, false,
                null, null, null, null, null, null, null);
        mfc.add(testCitation);
        assertEquals(1, mfc.getCitations().size());
        assertEquals(testCitation, mfc.getCitations().first());
        assertEquals(testCitation, mfc.getCitations().last());
        mfc.remove(testCitation);
        assertEquals(0, mfc.getCitations().size());
    }

    @Test
    public void testLogAddition() {
        Citation testCitation = new ApaCitation("apple", "book", false, false,
                null, null, null, null, null, null, null);
        mfc.add(testCitation);
        CitationAddedEvent addedEvent = mfc.logAddition(testCitation);
        assertNotNull(addedEvent);
        for (Event event: EventLog.getInstance()) {
            if (event.equals(addedEvent)){
                return;
            }
        }
        fail();
    }

    @Test
    public void testLogRemoval() {
        Citation testCitation = new ApaCitation("apple", "book", false, false,
                null, null, null, null, null, null, null);
        CitationRemovedEvent removedEvent = mfc.logRemoval(testCitation);
        assertNotNull(removedEvent);
        for (Event event: EventLog.getInstance()) {
            if (event.equals(removedEvent)){
                return;
            }
        }
        fail();
    }

    @Test
    public void testAddMoreThanOneItem() {
        Citation testCitation = new ApaCitation("apple", "book", false, false,
                null, null, null, null, null, null, null);
        Citation testCitation2 = new ApaCitation("banana", "book", false, false,
                null, null, null, null, null, null, null);
        mfc.add(testCitation);
        mfc.add(testCitation2);
        assertEquals(2, mfc.getCitations().size());
        assertEquals(testCitation, mfc.getCitations().first());
        assertEquals(testCitation2, mfc.getCitations().last());
    }

    @Test
    public void testAddDuplicateItem() {
        Citation testCitation = new ApaCitation("apple", "book", false, false,
                null, null, null, null, null, null, null);
        mfc.add(testCitation);
        mfc.add(testCitation);
        assertEquals(1, mfc.getCitations().size());
        assertEquals(testCitation, mfc.getCitations().first());
        assertEquals(testCitation, mfc.getCitations().last());
    }

    @Test
    public void testToJson(){
        Citation testCitation = new ApaCitation("apple", "book", false, false,
                null, null, null, null, null, null, null);
        mfc.add(testCitation);
        JSONObject out = new JSONObject();
        out.put("head", mfc.getHead());
        out.put("tail", mfc.getTail());
        out.put("mode", mfc.getMode());
        out.put("format", mfc.getFormat());
        out.put("citations", new JSONArray(mfc.getCitations().stream().map(Citation::asJson).toArray()));
        assertEquals(out.toString(), mfc.asJson().toString());
    }

    static class MockFullCitation extends FullCitation {
        @Override
        protected String createBody() {
            return null;
        }

        @Override
        public String getFormat() {
            return "funni format";
        }
    }
}
