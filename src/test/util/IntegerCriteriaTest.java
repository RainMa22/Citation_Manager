package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegerCriteriaTest {
    IntegerCriteria noBounds;
    IntegerCriteria yesBounds;

    @BeforeEach
    public void setup(){
        noBounds = new IntegerCriteria();
        yesBounds = new IntegerCriteria(0, 5);
    }

    @Test
    public void testIsSatisfiedByNormalNum(){
        assertTrue(noBounds.isSatisfiedBy("3"));
        assertFalse(yesBounds.isSatisfiedBy("9999"));
        assertFalse(yesBounds.isSatisfiedBy("-9999"));
        assertFalse(yesBounds.isSatisfiedBy("-2"));
    }

    @Test
    public void testIsSarisfiedByEdgeCases(){
        assertTrue(noBounds.isSatisfiedBy(Integer.toString(Integer.MAX_VALUE)));
        assertTrue(noBounds.isSatisfiedBy(Integer.toString(Integer.MIN_VALUE)));
        assertTrue(yesBounds.isSatisfiedBy("0"));
        assertTrue(yesBounds.isSatisfiedBy("5"));
    }


}
