package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateCriteriaTest {
    DateCriteria dc;

    @BeforeEach
    public void setUp() {
        dc = new DateCriteria();
    }

    @Test
    public void testIsSatisfiedBy() {
        assertTrue(dc.isSatisfiedBy("2024"));
        assertTrue(dc.isSatisfiedBy("2024-01"));
        assertTrue(dc.isSatisfiedBy("2024-01-21"));
        assertFalse(dc.isSatisfiedBy("random date"));
        assertFalse(dc.isSatisfiedBy("20"));
        assertFalse(dc.isSatisfiedBy("2"));
        assertFalse(dc.isSatisfiedBy("222"));
    }
}
