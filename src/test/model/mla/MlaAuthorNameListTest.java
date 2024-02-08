package model.mla;

import model.AuthorName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MlaAuthorNameListTest {
    MlaAuthorNameList manl1;
    MlaAuthorNameList manl2;
    MlaAuthorNameList manl3;
    MlaAuthorNameList manl4;
    MlaAuthorNameList manl5;

    @BeforeEach
    public void setup() {
        manl1 = new MlaAuthorNameList("Stove Jeebs, Steve Jobs, Stovo Nouveau Jebs");
        manl2 = new MlaAuthorNameList("Gregor middleName Kiczales, George R. R. Martin");
        manl3 = new MlaAuthorNameList("Stove Jeebs, et al.");
        manl4 = new MlaAuthorNameList("Four Three");
        manl5 = new MlaAuthorNameList("");
    }

    @Test
    public void testConstructorThreeItems() {
        List<AuthorName> ans = manl1.getNames();
        assertEquals("Jeebs, Stove", ans.get(0).toString());
        assertEquals("et al", ans.get(1).toString());
    }

    @Test
    public void testConstructorTwoItems() {
        List<AuthorName> ans = manl2.getNames();
        assertEquals("Kiczales, Gregor M.", ans.get(0).toString());
        assertEquals("George R. Martin", ans.get(1).toString());
    }

    @Test
    public void testConstructorOneItem() {
        List<AuthorName> ans = manl4.getNames();
        assertEquals("Three, Four", ans.get(0).toString());
    }

    @Test
    public void testConstructorNoItem() {
        assertEquals(MlaAuthorName.INACTIVE, manl5.getMode());
    }

    @Test
    public void TestToStringThreeItems() {
        assertEquals("Jeebs, Stove, et al.", manl1.toString());
    }

    @Test
    public void TestToStringTwoItems() {
        assertEquals("Kiczales, Gregor M., and George R. Martin.", manl2.toString());
    }

    @Test
    public void TestToStringOneItem() {
        assertEquals("Three, Four.", manl4.toString());
    }

    @Test
    public void TestToStringPlantedNoItem() {
        assertEquals("", manl5.toString());
    }

    @Test
    public void TestToStringPlantedEtAl() {
        assertEquals("Jeebs, Stove, et al.", manl3.toString());
    }
}
