package model.mla;

import model.AuthorName;
import model.InvalidFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MlaAuthorNameListTest {
    MlaAuthorNameList manl1;
    MlaAuthorNameList manl2;

    @BeforeEach
    public void setup() {
        try {
            manl1 = new MlaAuthorNameList("Stove Jeebs, Steve Jobs, Stovo Nouveau Jebs");
            manl2 = new MlaAuthorNameList("Gregor middleName Kiczales, George R. Martin");
        } catch (InvalidFormatException ife) {
            fail(ife);
        }
    }

    @Test
    public void testConstructorThreeItems() {
        List<AuthorName> ans = manl1.getNames();
        assertEquals("Jeebs, Stove", ans.get(0).toString());
        assertEquals("et al", ans.get(1).toString());
    }

    @Test
    public void testConstructorTwoItems() {
        MlaAuthorName an1;
        MlaAuthorName an2;
        try {
            an1 = new MlaAuthorName("Gregor middleName Kiczales", true);
            an2 = new MlaAuthorName("George R. Martin", false);
            AuthorName[] loan = new AuthorName[]{an1, an2};
            List<AuthorName> ans = manl2.getNames();
            for (int i = 0; i < 2; i++) {
                assertEquals(loan[i].toString(), ans.get(i).toString());
            }
        } catch (InvalidFormatException ife) {
            fail(ife);
        }
    }

    public void TestToStringThreeItems() {
        assertEquals("Jeebs, Stove, et al.", manl1.toString());
        assertEquals("Kiczales, Gregor M., and George R. Martin", manl2.toString());
    }
}
