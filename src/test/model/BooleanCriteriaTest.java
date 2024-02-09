package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooleanCriteriaTest {
    BooleanCriteria bc;

    @BeforeEach
    public void setup(){
        bc = new BooleanCriteria();
    }

    @Test
    public void testIsSatisfiedByNormalBoolean(){
        assertTrue(bc.isSatisfiedBy("t"));
        assertTrue(bc.isSatisfiedBy("true"));
        assertTrue(bc.isSatisfiedBy("1"));
        assertTrue(bc.isSatisfiedBy("yes"));
        assertTrue(bc.isSatisfiedBy("y"));
        assertTrue(bc.isSatisfiedBy("f"));
        assertTrue(bc.isSatisfiedBy("false"));
        assertTrue(bc.isSatisfiedBy("0"));
        assertTrue(bc.isSatisfiedBy("no"));
        assertTrue(bc.isSatisfiedBy("n"));
    }

    @Test
    public void testIsSatisfiedByBadBooleans(){
        assertFalse(bc.isSatisfiedBy("ahaha"));
        assertFalse(bc.isSatisfiedBy("I donno"));
    }


}
