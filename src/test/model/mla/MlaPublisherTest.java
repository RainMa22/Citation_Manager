package model.mla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MlaPublisherTest {
    MlaPublisher publisher;

    @BeforeEach
    public void setup() {
        publisher = new MlaPublisher("3s");
    }

    @Test
    public void testConstructor() {
        assertEquals("", publisher.getHead());
        assertEquals("3s", publisher.getBody());
        assertEquals(", ", publisher.getTail());
    }
}
