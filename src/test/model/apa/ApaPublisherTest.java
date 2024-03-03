package model.apa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApaPublisherTest {
    ApaPublisher publisher;

    @BeforeEach
    public void setup() {
        publisher = new ApaPublisher("3s");
    }

    @Test
    public void testConstructor() {
        assertEquals("", publisher.getHead());
        assertEquals("3s", publisher.getBody());
        assertEquals(", ", publisher.getTail());
    }

    @Test
    public void testConstructorJson() {
        assertEquals(publisher.toString(), new ApaLocation(publisher.asJson()).toString());
    }
}
