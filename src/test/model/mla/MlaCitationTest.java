package model.mla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MlaCitationTest {

    MlaCitation citationFull;
    MlaCitation citationMajorWork;
    MlaCitation citationOmitALot;

    @BeforeEach
    public void setup() {
        citationFull = new MlaCitation("Gregor Kiczales, John Lamping, Anurag Mendhekar",
                "Aspect-Oriented Programming", true, "ACM Computing Surveys",
                28, "4es", "1996-12-01",
                "Association for Computing Machinery",
                "10.1145/242224.242420", "2024-02-07");
        citationMajorWork = new MlaCitation("John Steinbeck", "Of Mice and Men", false,
                null, null, null, "1937", "Covici Friede",
                "Indigo Books & Music", "2024-02-08");
        citationOmitALot = new MlaCitation(null, "Hello World!", false,
                null, null, null, null, null, "www.google.com",
                "2024-02-08");
    }

    @Test
    public void testConstructor() {
        assertTrue(citationFull.isMinorWork());
        assertEquals(new MlaAuthorNameList("Gregor Kiczales, John Lamping, Anurag Mendhekar").toString(),
                citationFull.getAuthorNames().toString());
        assertEquals("Aspect-Oriented Programming", citationFull.getTitle().getTitle());
        assertEquals("ACM Computing Surveys", citationFull.getCollection().getTitle());
        assertEquals(28, citationFull.getVolume().getBody());
        assertEquals("4es", citationFull.getIssueName().getBody());
        assertEquals(new MlaCitationDate("1996-12-01").toString(), citationFull.getPubDate().toString());
        assertEquals("Association for Computing Machinery", citationFull.getPublisher().getBody());
        assertEquals("10.1145/242224.242420", citationFull.getLocation().getBody());
        assertEquals(new MlaAccessDate("2024-02-07").toString(), citationFull.getAccessDate().toString());

        assertFalse(citationMajorWork.isMinorWork());
        assertEquals("Steinbeck, John. ", citationMajorWork.getAuthorNames().toString());
        assertEquals("Of Mice and Men", citationMajorWork.getTitle().getTitle());
        assertEquals("", citationMajorWork.getCollection().toString());
        assertEquals("", citationMajorWork.getVolume().toString());
        assertEquals("", citationMajorWork.getIssueName().toString());
        assertEquals("1937, ", citationMajorWork.getPubDate().toString());
        assertEquals("Covici Friede", citationMajorWork.getPublisher().getBody());
        assertEquals("Indigo Books & Music", citationMajorWork.getLocation().getBody());
        assertEquals(new MlaAccessDate("2024-02-08").toString(), citationMajorWork.getAccessDate().toString());

        assertFalse(citationOmitALot.isMinorWork());
        assertEquals("", citationOmitALot.getAuthorNames().toString());
        assertEquals("Hello World!", citationOmitALot.getTitle().getTitle());
        assertEquals("", citationOmitALot.getCollection().toString());
        assertEquals("", citationOmitALot.getVolume().toString());
        assertEquals("", citationOmitALot.getIssueName().toString());
        assertEquals("", citationOmitALot.getPubDate().toString());
        assertEquals("", citationOmitALot.getPublisher().toString());
        assertEquals("www.google.com", citationOmitALot.getLocation().getBody());
        assertEquals(new MlaAccessDate("2024-02-08").toString(), citationOmitALot.getAccessDate().toString());
    }

    @Test
    public void testToString() {
        assertEquals("Kiczales, Gregor, et al. \"Aspect-Oriented Programming.\" <i>ACM Computing Surveys</i>, " +
                "vol.28, 4es, 01 Dec. 1996, Association for Computing Machinery, 10.1145/242224.242420. " +
                "Accessed 07 Feb. 2024.", citationFull.toString());
        assertEquals("Steinbeck, John. <i>Of Mice and Men</i>. " +
                "1937, Covici Friede, Indigo Books & Music. " +
                "Accessed 08 Feb. 2024.", citationMajorWork.toString());
    }
}
