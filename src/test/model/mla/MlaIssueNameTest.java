package model.mla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MlaIssueNameTest {
    MlaIssueName issueName;

    @BeforeEach
    public void setup() {
        issueName = new MlaIssueName("3s");
    }

    @Test
    public void testConstructor() {
        assertEquals("", issueName.getHead());
        assertEquals("3s", issueName.getBody());
        assertEquals(", ", issueName.getTail());
    }
}
