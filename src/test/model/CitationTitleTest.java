package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CitationTitleTest {
    CitationTitle ct;

    @BeforeEach
    public void setup() {
        ct = new mockCitationTitle("title");
    }

    @Test
    public void testConstructor() {
        assertEquals("title", ct.getTitle());
    }

    @Test
    public void testConstructorJson() {
        JSONObject json = new JSONObject();
        json.put("head", ct.getHead());
        json.put("tail", ct.getTail());
        json.put("mode", ct.getMode());
        json.put("title", ct.getTitle());
        assertEquals(ct.asJson().toString(), json.toString());
    }

    @Test
    public void testAsJson() {
        JSONObject out = new JSONObject();
        out.put("head", ct.getHead());
        out.put("tail", ct.getTail());
        out.put("mode", ct.getMode());
        out.put("title", ct.getTitle());
        assertEquals(out.toString(), ct.asJson().toString());
    }

    static class mockCitationTitle extends CitationTitle {
        public mockCitationTitle(String title) {
            super(title);
        }

        @Override
        protected String createBody() {
            return null;
        }
    }
}
