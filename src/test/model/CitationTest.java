package model;


import model.eventlogger.CitationCreatedEvent;
import model.eventlogger.Event;
import model.eventlogger.EventLog;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CitationTest {

    protected Citation c1;

    @BeforeEach
    public void setup() {
        c1 = new MockCitation("abc", "def", "ghi", 22, "jkl", "mno",
                "pqr", "stu", "vwxyz");
    }

    @Test
    public void testConstructor() {
        List<String> params = Arrays.asList("abc", "def", "ghi", "22", "jkl", "mno", "pqr", "stu", "vwxyz");
        assertTrue(params.containsAll(c1.getUserInput()));
        assertTrue(new JSONArray(params).similar(new JSONArray(c1.getUserInput())));
    }

    @Test
    public void testLogCreation() {
        CitationCreatedEvent createdEvent = c1.logCreation();
        assertNotNull(createdEvent);
        boolean containsEvent = false;
        for (Event event : EventLog.getInstance()) {
            containsEvent = (event.equals(createdEvent));
            if (containsEvent) {
                break;
            }
        }
        assertTrue(containsEvent);
    }


    @Test
    public void testAsJson() {
        JSONObject out = new JSONObject();

        out.put("head", c1.getHead());
        out.put("tail", c1.getTail());
        out.put("mode", c1.getMode());
        String[] keys = ("authorNames, title, collection, volume, "
                + "issueName, pubDate, publisher, accessDate, location").split(", ");
        CitationComponent[] components = {c1.getAuthorNames(), c1.getTitle(), c1.getCollection(), c1.getVolume(),
                c1.getIssueName(), c1.getPubDate(), c1.getPublisher(), c1.getAccessDate(), c1.getLocation()};
        for (int i = 0; i < keys.length; i++) {
            out.put(keys[i], components[i].asJson());
        }
        out.put("param", new JSONArray(c1.getUserInput()));
        assertTrue(out.similar(c1.asJson()));
    }


    static class MockCitation extends Citation {
        public MockCitation(String authorNames, String title, String collection, Integer volume, String issueName,
                            String pubDate, String publisher, String accessDate, String location) {
            userInput = Arrays.asList(authorNames, title, collection, String.valueOf(volume), issueName, pubDate, publisher,
                    accessDate, location);
            setAuthorNames(new AuthorNameListTest.MockAuthorNameList(authorNames));
            setTitle(new CitationTitleTest.mockCitationTitle(title));
            setCollection(new CitationTitleTest.mockCitationTitle(collection));
            setVolume(new SimpleCitationComponent(volume, "", ""));
            setIssueName(new SimpleCitationComponent(issueName, "", ""));
            setPubDate(new CitationDateTest.MockCitationDate(pubDate));
            setPublisher(new SimpleCitationComponent(publisher, "", ""));
            setAccessDate(new CitationDateTest.MockCitationDate(accessDate));
            setLocation(new SimpleCitationComponent(location, "", ""));
        }

        @Override
        protected String createBody() {
            return null;
        }
    }
}
