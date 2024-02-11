package model.apa;

import model.AuthorName;
import model.AuthorNameList;
import model.CitationComponent;
import util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/*
 * List of AuthorNames under MLA format
 */

public class ApaAuthorNameList extends CitationComponent implements AuthorNameList {
    public static final int ONE_NAME = 0;
    public static final int TWO_NAME = 1;
    public static final int ET_AL = 2;
    private final List<AuthorName> names;

    //Constructor for ApaAuthorNameList
    public ApaAuthorNameList(String rawString) {
        super();
        names = parseString(rawString);
        super.setTail(". ");
    }

    //getter for names
    @Override
    public List<AuthorName> getNames() {
        return names;
    }

    // EFFECTS: returns list of author name by splitting rawString by comma, create new AuthorName by each split String
    //          then add each AuthorName to the List; following the Apa format;
    //          if rawString is empty, return null;
    @Override
    public List<AuthorName> parseString(String rawString) {
        if (rawString == null) {
            return null;
        }
        rawString = StringUtils.sanitizeString(rawString);
        if (rawString.isEmpty()) {
            return null;
        }

        List<AuthorName> result = new ArrayList<>(2);
        setMode(ONE_NAME);
        String[] stringNames = rawString.split(",");
        int target = stringNames.length;
        result.add(new ApaAuthorName(stringNames[0]));
        if (target == 2) {
            setMode(TWO_NAME);
            if (stringNames[1].trim().startsWith("et")) {
                setMode(ET_AL);
            }
            result.add(new ApaAuthorName(stringNames[1]));
        } else if (target > 2) {
            setMode(ET_AL);
            result.add(new ApaAuthorName("et al"));
        }
        return result;
    }

    // EFFECTS: create the citation sentence(excluding period) for Author block with Apa format
    //          if no names stored, returns an empty String
    @Override
    protected String createBody() {
        String out = "";
        switch (mode) {
            case ONE_NAME:
                out = names.get(0).toString();
                break;
            case TWO_NAME:
                out = String.join(", and ", names.get(0).toString(), names.get(1).toString());
                break;
            case ET_AL:
            default:
                out = String.join(", ", names.get(0).toString(), names.get(1).toString());
                break;
        }
        return StringUtils.removeTailing(out, ".");
    }
}
