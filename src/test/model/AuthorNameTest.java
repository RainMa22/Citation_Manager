package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorNameTest {
    AuthorName an;

    @BeforeEach
    public void setup() {
        an = new MockAuthorName("abc");
    }

    @Test
    public void testToJson() {
        JSONObject anOut = new JSONObject();
        anOut.put("head", an.getHead());
        anOut.put("tail", an.getTail());
        anOut.put("mode", an.getMode());
        anOut.put("firstName", an.getFirstName());
        anOut.put("middleName", an.getMiddleName());
        anOut.put("lastName", an.getLastName());
        assertEquals(anOut.toString(), an.asJson().toString());
    }


    static class MockAuthorName extends AuthorName {
        public MockAuthorName(String str) {
            super();
            processName(str);
        }

        @Override
        protected void processName(String rawString) {
            setFirstName(String.valueOf(rawString.charAt(0)));
            setMiddleName(String.valueOf(rawString.charAt(1)));
            setLastName(String.valueOf(rawString.charAt(2)));
            setMode(0);
        }

        @Override
        protected String createBody() {
            return null;
        }
    }
}
