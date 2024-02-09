package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DummyCriteriaTest {
    DummyCriteria dummy;

    @BeforeEach
    public void setup() {
        dummy = new DummyCriteria();
    }

    @Test
    public void testIsSatisfiedBy() {
        assertTrue(dummy.isSatisfiedBy("kfjjkhaufhaiu"));
    }
}
