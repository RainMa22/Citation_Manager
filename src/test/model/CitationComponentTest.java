package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CitationComponentTest {
    CitationComponent comp1;
    CitationComponent comp2;

    @BeforeEach
    public void setup() {
        comp1 = new MockComponent("a", "b", "c");
        comp2 = new MockComponent();
    }

    @Test
    public void testConstructor() {
        assertEquals(CitationComponent.INACTIVE, comp2.getMode());
        assertEquals("", comp2.getHead());
        assertEquals("", comp2.getTail());
    }

    @Test
    public void testAsJson() {
        JSONObject json = new JSONObject();
        json.put("head", "a");
        json.put("tail", "c");
        json.put("body", "b");
        json.put("mode", 1);
        assertEquals(json.toString(), comp1.asJson().toString());
    }

    @Test
    public void testFromJson() {
        assertEquals(comp1.toString(), new MockComponent(comp1.asJson()).toString());
    }

    @Test
    public void testToString() {
        assertEquals("abc", comp1.toString());
    }

    static class MockComponent extends CitationComponent {
        private final String body;

        public MockComponent() {
            super();
            body = "";
        }

        public MockComponent(JSONObject json) {
            super(json);
            body = json.getString("body");
        }

        public MockComponent(String head, String body, String tail) {
            super();
            mode = 1;
            setHead(head);
            setTail(tail);
            this.body = body;
        }

        @Override
        protected String createBody() {
            return body;
        }

        @Override
        public JSONObject asJson() {
            JSONObject out = super.asJson();
            out.put("body", body);
            return out;
        }
    }
}
