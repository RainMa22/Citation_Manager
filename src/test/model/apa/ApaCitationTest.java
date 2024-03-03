package model.apa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ApaCitationTest {

    ApaCitation citationFull;
    ApaCitation citationFullList;
    ApaCitation citationMajorWork;
    ApaCitation citationMajorWorkList;
    ApaCitation citationOmitALot;
    ApaCitation citationOmitALotList;

    @BeforeEach
    public void setup() {
        citationFull = new ApaCitation("Gregor Kiczales, John Irwin, John Lamping, Jean-Marc Loingtier, " +
                "Cristina Videria Lopes, Chris Maeda, and Anurag Mendhekar",
                "Aspect-oriented programming", true, false, "ACM Computing Surveys",
                28, "4es", "1996-12-01",
                "Association for Computing Machinery",
                "https://doi.org/10.1145/242224.242420", "2024-02-07");
        citationFullList = new ApaCitation(Arrays.asList("Gregor Kiczales, John Irwin, John Lamping, Jean-Marc Loingtier, " +
                        "Cristina Videria Lopes, Chris Maeda, and Anurag Mendhekar",
                "Aspect-oriented programming", "true", "false", "ACM Computing Surveys",
                "28", "4es", "1996-12-01",
                "Association for Computing Machinery",
                "https://doi.org/10.1145/242224.242420", "2024-02-07"));
        citationMajorWork = new ApaCitation("John Steinbeck", "Of mice and men", false, false,
                null, null, null, "1937", "Covici Friede",
                "Indigo Books & Music", "2024-02-08");
        citationMajorWorkList = new ApaCitation(Arrays.asList("John Steinbeck", "Of mice and men", "false", "false",
                null, null, null, "1937", "Covici Friede",
                "Indigo Books & Music", "2024-02-08"));
        citationOmitALot = new ApaCitation(null, "Hello World!", false,
                true, null, null, null, null, null, "www.google.com",
                "2024-02-08");
        citationOmitALotList = new ApaCitation(Arrays.asList(null, "Hello World!", "false",
                "true", null, null, null, null, null, "www.google.com",
                "2024-02-08"));
    }

    @Test
    public void testConstructor() {
        assertTrue(citationFull.isAcademicWork());
        assertEquals(new ApaAuthorNameList("Gregor Kiczales, John Irwin, John Lamping, Jean-Marc Loingtier, " +
                        "Cristina Videria Lopes, Chris Maeda, and Anurag Mendhekar").toString(),
                citationFull.getAuthorNames().toString());
        assertEquals("Aspect-oriented programming", citationFull.getTitle().getTitle());
        assertEquals("ACM Computing Surveys", citationFull.getCollection().getTitle());
        assertEquals(28, citationFull.getVolume().getBody());
        assertEquals("4es", citationFull.getIssueName().getBody());
        assertEquals(new ApaCitationDate("1996-12-01", true).toString(), citationFull.getPubDate().toString());
        assertEquals("Association for Computing Machinery", citationFull.getPublisher().getBody());
        assertEquals("https://doi.org/10.1145/242224.242420", citationFull.getLocation().getBody());
        assertEquals(new ApaAccessDate("2024-02-07").toString(), citationFull.getAccessDate().toString());

        assertFalse(citationMajorWork.isAcademicWork());
        assertEquals("Steinbeck, J. ", citationMajorWork.getAuthorNames().toString());
        assertEquals("Of mice and men", citationMajorWork.getTitle().getTitle());
        assertEquals("", citationMajorWork.getCollection().toString());
        assertEquals("", citationMajorWork.getVolume().toString());
        assertEquals("", citationMajorWork.getIssueName().toString());
        assertEquals("(1937). ", citationMajorWork.getPubDate().toString());
        assertEquals("Covici Friede", citationMajorWork.getPublisher().getBody());
        assertEquals("Indigo Books & Music", citationMajorWork.getLocation().getBody());
        assertEquals(new ApaAccessDate("2024-02-08").toString(), citationMajorWork.getAccessDate().toString());

        assertFalse(citationOmitALot.isAcademicWork());
        assertEquals("", citationOmitALot.getAuthorNames().toString());
        assertEquals("Hello World!", citationOmitALot.getTitle().getTitle());
        assertEquals("", citationOmitALot.getCollection().toString());
        assertEquals("", citationOmitALot.getVolume().toString());
        assertEquals("", citationOmitALot.getIssueName().toString());
        assertEquals("(n.d.). ", citationOmitALot.getPubDate().toString());
        assertEquals("", citationOmitALot.getPublisher().toString());
        assertEquals("www.google.com", citationOmitALot.getLocation().getBody());
        assertEquals(new ApaAccessDate("2024-02-08").toString(), citationOmitALot.getAccessDate().toString());
    }

    @Test
    public void testConstructorJson() {
        ApaCitation[] citations = {citationFull, citationFullList, citationOmitALot, citationOmitALotList,
                citationMajorWork, citationMajorWorkList};

        for (ApaCitation citation : citations) {
            assertEquals(citation.toString(), new ApaCitation(citation.asJson()).toString());
        }
    }

    @Test
    public void TestConstructorFromListNormal() {
        assertTrue(citationFullList.isAcademicWork());
        assertEquals(new ApaAuthorNameList("Gregor Kiczales, John Irwin, John Lamping, " +
                        "Jean-Marc Loingtier, Cristina Videria Lopes, Chris Maeda, and Anurag Mendhekar").toString(),
                citationFullList.getAuthorNames().toString());
        assertEquals("Aspect-oriented programming", citationFullList.getTitle().getTitle());
        assertEquals("ACM Computing Surveys", citationFullList.getCollection().getTitle());
        assertEquals(28, citationFullList.getVolume().getBody());
        assertEquals("4es", citationFullList.getIssueName().getBody());
        assertEquals(new ApaCitationDate("1996-12-01", true).toString(), citationFullList.getPubDate().toString());
        assertEquals("Association for Computing Machinery", citationFullList.getPublisher().getBody());
        assertEquals("https://doi.org/10.1145/242224.242420", citationFullList.getLocation().getBody());
        assertEquals(new ApaAccessDate("2024-02-07").toString(), citationFullList.getAccessDate().toString());

        assertFalse(citationMajorWorkList.isAcademicWork());
        assertEquals("Steinbeck, J. ", citationMajorWorkList.getAuthorNames().toString());
        assertEquals("Of mice and men", citationMajorWorkList.getTitle().getTitle());
        assertEquals("", citationMajorWorkList.getCollection().toString());
        assertEquals("", citationMajorWorkList.getVolume().toString());
        assertEquals("", citationMajorWorkList.getIssueName().toString());
        assertEquals("(1937). ", citationMajorWorkList.getPubDate().toString());
        assertEquals("Covici Friede", citationMajorWorkList.getPublisher().getBody());
        assertEquals("Indigo Books & Music", citationMajorWorkList.getLocation().getBody());
        assertEquals(new ApaAccessDate("2024-02-08").toString(), citationMajorWorkList.getAccessDate().toString());

        assertFalse(citationOmitALotList.isAcademicWork());
        assertEquals("", citationOmitALotList.getAuthorNames().toString());
        assertEquals("Hello World!", citationOmitALotList.getTitle().getTitle());
        assertEquals("", citationOmitALotList.getCollection().toString());
        assertEquals("", citationOmitALotList.getVolume().toString());
        assertEquals("", citationOmitALotList.getIssueName().toString());
        assertEquals("(n.d.). ", citationOmitALotList.getPubDate().toString());
        assertEquals("", citationOmitALotList.getPublisher().toString());
        assertEquals("www.google.com", citationOmitALotList.getLocation().getBody());
        assertEquals(new ApaAccessDate("2024-02-08").toString(), citationOmitALotList.getAccessDate().toString());
    }

    @Test
    public void TestConstructorFromListException() {
        try {
            ApaCitation badCitation = new ApaCitation(new ArrayList<String>());
            fail();
        } catch (IllegalArgumentException ie){
            //continue
        }
    }

    @Test
    public void testToString() {
        assertEquals("Kiczales, G., Irwin, J., Lamping, J., Loingtier, J., Lopes, C. V., Maeda, C., " +
                "& Mendhekar, A. A. (1996). Aspect-oriented programming. <i>ACM Computing Surveys</i>, 28(4es). " +
                "https://doi.org/10.1145/242224.242420", citationFull.toString());
        assertEquals("Steinbeck, J. (1937). <i>Of mice and men</i>. " +
                "Covici Friede, Indigo Books & Music", citationMajorWork.toString());
        assertEquals("(n.d.). <i>Hello World!</i>. Retrieved February 08, 2024, from www.google.com", citationOmitALot.toString());
    }

    @Test
    public void testToStringFromList() {
        assertEquals("Kiczales, G., Irwin, J., Lamping, J., Loingtier, J., Lopes, C. V., Maeda, C., " +
                "& Mendhekar, A. A. (1996). Aspect-oriented programming. <i>ACM Computing Surveys</i>, 28(4es). " +
                "https://doi.org/10.1145/242224.242420", citationFullList.toString());
        assertEquals("Steinbeck, J. (1937). <i>Of mice and men</i>. " +
                "Covici Friede, Indigo Books & Music", citationMajorWorkList.toString());
        assertEquals("(n.d.). <i>Hello World!</i>. Retrieved February 08, 2024, from www.google.com",
                citationOmitALotList.toString());
    }
}
