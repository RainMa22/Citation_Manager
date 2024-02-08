package model;

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
