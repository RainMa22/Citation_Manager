package model.apa;

import model.AuthorName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApaAuthorNameListTest {
    ApaAuthorNameList oneName;
    ApaAuthorNameList twoNames;
    ApaAuthorNameList threeNames;
    ApaAuthorNameList twentyOneNames;
    ApaAuthorNameList inActive;

    @BeforeEach
    public void setup() {
        oneName = new ApaAuthorNameList("Four Three");
        twoNames = new ApaAuthorNameList("Gregor middleName Kiczales, George R. R. Martin");
        threeNames = new ApaAuthorNameList("Apple Banana, Cat Dog, Edgar Frank");
        inActive = new ApaAuthorNameList("");
        twentyOneNames = new ApaAuthorNameList("Juan One, Timmy Two, Trista Three," +
                "Frank Four, Fiona Five, Steven Six, Sophia Seven, Edgar Eight, Nina Nine, Trent Ten, " +
                "Eliza Eleven, Thomas Twelve, Teresa Thirteen, Finn Fourteen, Foster Fifteen, Sonia Sixteen," +
                "Soders Seventeen, Elijah Eighteen, Noelle Nineteen, Tammy Twenty, Trevor Twenty-one ");
    }

    @Test
    public void testConstructorOneItems() {
        List<AuthorName> ans = oneName.getNames();
        assertEquals("Three, F.", ans.get(0).toString());
    }

    @Test
    public void testConstructorTwoItems() {
        List<AuthorName> ans = twoNames.getNames();
        assertEquals("Kiczales, G. M.", ans.get(0).toString());
        assertEquals("Martin, G. R.", ans.get(1).toString());
    }

    @Test
    public void testConstructorOneItem() {
        List<AuthorName> ans = oneName.getNames();
        assertEquals("Three, F.", ans.get(0).toString());
    }

    @Test
    public void testConstructorNoItem() {
        assertEquals(ApaAuthorName.INACTIVE, inActive.getMode());
    }

    @Test
    public void TestToStringThreeItems() {
        assertEquals("Banana, A., Dog, C., & Frank, E. ", threeNames.toString());
    }

    @Test
    public void TestToStringTwoItems() {
        assertEquals("Kiczales, G. M., & Martin, G. R. ", twoNames.toString());
    }

    @Test
    public void TestToStringOneItem() {
        assertEquals("Three, F. ", oneName.toString());
    }

    @Test
    public void TestToStringPlantedNoItem() {
        assertEquals("", inActive.toString());
        inActive.setMode(ApaAuthorNameList.INACTIVE);
        assertEquals("", inActive.toString());
    }

    @Test
    public void TestToStringTwentyOneNames() {
        assertEquals("One, J., Two, T., Three, T., Four, F., Five, F., Six, S., Seven, S., Eight, E., Nine, N.," +
                        " Ten, T., Eleven, E., Twelve, T., Thirteen, T., Fourteen, F., Fifteen, F., Sixteen, S.," +
                        " Seventeen, S., Eighteen, E., Nineteen, N., ... Twenty-one, T. ",
                twentyOneNames.toString());
    }
}
