package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorNameListTest {
    AuthorNameList anl;

    @BeforeEach
    public void setup() {
        anl = new MockAuthorNameList("abc");
    }

    @Test
    public void testToJson(){
        JSONObject anlOut = new JSONObject();
        anlOut.put("head", anl.getHead());
        anlOut.put("tail", anl.getTail());
        anlOut.put("mode", anl.getMode());
        anlOut.put("names", new JSONArray(anl.getNames()));
        assertEquals(anlOut.toString(), anl.asJson().toString());
    }


    static class MockAuthorNameList extends AuthorNameList{
        public MockAuthorNameList(String str) {
            super();
            names = parseString(str);
        }

        @Override
        protected List<AuthorName> parseString(String rawString) {
            List<AuthorName> out = new ArrayList<>();
            String[] nameStrings = rawString.split(",");
            for(String nameString: nameStrings){
                out.add(new AuthorNameTest.MockAuthorName(nameString));
            }
            return out;
        }

        @Override
        protected String createBody() {
            return null;
        }

    }
}
